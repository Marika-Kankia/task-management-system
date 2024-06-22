import java.time.LocalDateTime;

public class LimitedTimeTask extends Task{
    private LocalDateTime deadline;

    public LimitedTimeTask(String title, String description, String creatorName, LocalDateTime deadline) {
        super(title, description, creatorName);
        this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String getDetails() {
        return "Task Title: " + getTitle() + ", Description: " + getDescription() + ", Creator Name: " + getCreatorName()
                + ", Deadline: " + deadline;
    }
}
