public class TaskFactory {
    // Factory method to create a new Task object
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        return new Task(description, startTime, endTime, priority); // Return a new Task instance
    }
}