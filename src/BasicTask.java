public class BasicTask extends Task {
    public  BasicTask(String title, String description, String creatorName) {
        super(title, description, creatorName);
    }

    @Override
    public String getDetails() {
        return "Task Title: " + getTitle() + ", Description: " + getDescription() + ", Creator Name: " + getCreatorName();
    }
}
