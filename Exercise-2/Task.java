public class Task {
    private String description; // Description of the task
    private String startTime; // Start time of the task
    private String endTime; // End time of the task
    private String priority; // Priority of the task (High, Medium, Low)
    private boolean isCompleted; // Status of the task

    // Constructor to initialize a new task
    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false; // Task is initially not completed
    }

    // Getter for task description
    public String getDescription() {
        return description;
    }

    // Setter for task description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for start time
    public String getStartTime() {
        return startTime;
    }

    // Setter for start time
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    // Getter for end time
    public String getEndTime() {
        return endTime;
    }

    // Setter for end time
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    // Getter for task priority
    public String getPriority() {
        return priority;
    }

    // Setter for task priority
    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Method to check if the task is completed
    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // String representation of the task
    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]" + (isCompleted ? " (Completed)" : "");
    }
}
