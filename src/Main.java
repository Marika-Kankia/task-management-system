import java.time.LocalDateTime;
import java.util.*;

public class Main {
    // List to store all tasks
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        // Main loop for the program
        while (true) {
            System.out.println("\nChoose a command:");
            System.out.println("1. Save Task");
            System.out.println("2. Get All Tasks");
            System.out.println("3. Update Specific Task");
            System.out.println("4. Delete Specific Task");
            System.out.println("5. Get Specific Task");

            // Reading command from user
            int command = -1;
            while (true) {
                System.out.print("Enter command number: ");
                if (scanner.hasNextInt()) {
                    command = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scanner.nextLine(); // Consume invalid input
                }
            }

            // Switch case to handle different commands
            switch (command) {
                case 1:
                    saveTask(scanner, username);
                    break;
                case 2:
                    getAllTasks();
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    getSpecificTask(scanner);
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    // Method to save a task
    private static void saveTask(Scanner scanner, String username) {
        System.out.println("Enter task type (BasicTask/RepeatableTask/LimitedTimeTask): ");
        String type = scanner.nextLine();

        System.out.println("Enter task title: ");
        String title = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        Task task;
        switch (type) {
            case "BasicTask":
                task = new BasicTask(title, description, username);
                break;
            case "RepeatableTask":
                System.out.println("Enter repetitions: ");
                int repetitions = -1;
                while (true) {
                    if (scanner.hasNextInt()) {
                        repetitions = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number for repetitions.");
                        scanner.nextLine(); // Consume invalid input
                    }
                }
                System.out.println("Enter repeat schedule: ");
                String repeatSchedule = scanner.nextLine();
                task = new RepeatableTask(title, description, username, repetitions, repeatSchedule);
                break;
            case "LimitedTimeTask":
                System.out.println("Enter deadline (yyyy-MM-ddTHH:mm): ");
                String deadlineStr = scanner.nextLine();
                LocalDateTime deadline;
                try {
                    deadline = LocalDateTime.parse(deadlineStr);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Task not saved.");
                    return;
                }
                task = new LimitedTimeTask(title, description, username, deadline);
                break;
            default:
                System.out.println("Invalid task type.");
                return;
        }

        tasks.add(task);
        System.out.println("Task saved successfully.");
    }

    // Method to get all tasks
    private static void getAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task.getTitle());
        }
    }

    // Method to update a specific task
    private static void updateTask(Scanner scanner) {
        System.out.println("Enter the title of the task to update: ");
        String title = scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                System.out.println("Enter new description: ");
                String description = scanner.nextLine();
                task.setDescription(description);

                if (task instanceof LimitedTimeTask) {
                    System.out.println("Enter new deadline (yyyy-MM-ddTHH:mm): ");
                    String deadlineStr = scanner.nextLine();
                    LocalDateTime deadline;
                    try {
                        deadline = LocalDateTime.parse(deadlineStr);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Task not updated.");
                        return;
                    }
                    ((LimitedTimeTask) task).setDeadline(deadline);
                } else if (task instanceof RepeatableTask) {
                    System.out.println("Enter new repetitions: ");
                    int repetitions = -1;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            repetitions = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number for repetitions.");
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    System.out.println("Enter new repeat schedule: ");
                    String repeatSchedule = scanner.nextLine();
                    ((RepeatableTask) task).setRepetitions(repetitions);
                    ((RepeatableTask) task).setRepeatSchedule(repeatSchedule);
                }

                System.out.println("Task updated successfully.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Method to delete a specific task
    private static void deleteTask(Scanner scanner) {
        System.out.println("Enter the title of the task to delete: ");
        String title = scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                tasks.remove(task);
                System.out.println("Task deleted successfully.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Method to get details of a specific task
    private static void getSpecificTask(Scanner scanner) {
        System.out.println("Enter the title of the task to get details: ");
        String title = scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                System.out.println(task.getDetails());
                return;
            }
        }

        System.out.println("Task not found.");
    }
}
