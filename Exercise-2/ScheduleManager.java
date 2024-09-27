import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private ArrayList<Task> tasks = new ArrayList<>(); // List to store tasks
    private static ScheduleManager instance = null; // Singleton instance

    // Private constructor for singleton pattern
    private ScheduleManager() {}

    // Method to get the singleton instance of ScheduleManager
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Method to add a new task
    public void addTask(Task task) {
        for (Task t : tasks) {
            // Check for overlapping tasks
            if (task.getStartTime().compareTo(t.getEndTime()) < 0 && task.getEndTime().compareTo(t.getStartTime()) > 0) {
                System.out.println("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                return; // Exit if there is a conflict
            }
        }
        tasks.add(task); // Add task to the list
        System.out.println("Task added successfully. No conflicts.");
    }

    // Method to remove a task by description
    public void removeTask(String description) {
        Task toRemove = null;
        for (Task t : tasks) {
            // Find the task with the given description
            if (t.getDescription().equals(description)) {
                toRemove = t;
                break;
            }
        }

        // Remove the task if found
        if (toRemove != null) {
            tasks.remove(toRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    // Method to view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            // Sort tasks by start time
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            for (Task t : tasks) {
                System.out.println(t); // Print each task
            }
        }
    }

    // Method to edit an existing task
    public void editTask(String oldDescription, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        for (Task task : tasks) {
            // Find the task to be edited
            if (task.getDescription().equals(oldDescription)) {
                task.setDescription(newDescription);
                task.setStartTime(newStartTime);
                task.setEndTime(newEndTime);
                task.setPriority(newPriority);
                System.out.println("Task edited successfully.");
                return; // Exit after editing
            }
        }
        System.out.println("Error: Task not found.");
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            // Find the task to mark as completed
            if (task.getDescription().equals(description)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                return; // Exit after marking
            }
        }
        System.out.println("Error: Task not found.");
    }

    // Method to view tasks filtered by priority
    public void viewTasksByPriority(String priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            // Add tasks that match the specified priority
            if (task.getPriority().equalsIgnoreCase(priority)) {
                filteredTasks.add(task);
            }
        }

        if (filteredTasks.isEmpty()) {
            System.out.println("No tasks found with priority: " + priority);
        } else {
            // Sort filtered tasks by start time
            filteredTasks.sort(Comparator.comparing(Task::getStartTime));
            for (Task task : filteredTasks) {
                System.out.println(task); // Print each filtered task
            }
        }
    }
}