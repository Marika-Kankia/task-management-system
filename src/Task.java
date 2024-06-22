public abstract class Task {
    private String title;
    private String description;
    private String creatorName;

    public Task(String title, String description, String creatorName) {
        this.title = title;
        this.description = description;
        this.creatorName = creatorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public abstract String getDetails();

}
