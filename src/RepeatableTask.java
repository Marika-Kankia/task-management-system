public class RepeatableTask extends Task {
    private int repetitions;
    private String repeatSchedule;

    public RepeatableTask(String title, String description, String creatorName, int repetitions, String repeatSchedule) {
        super(title, description, creatorName);
        this.repetitions = repetitions;
        this.repeatSchedule = repeatSchedule;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public String getRepeatSchedule() {
        return repeatSchedule;
    }

    public void setRepeatSchedule(String repeatSchedule) {
        this.repeatSchedule = repeatSchedule;
    }

    @Override
    public String getDetails() {
        return "Task Title: " + getTitle() + ", Description: " + getDescription() + ", Creator Name: " + getCreatorName() +
               ", Repetitions: " + repetitions + ", Repeat Schedule: " + repeatSchedule;
    }
}
