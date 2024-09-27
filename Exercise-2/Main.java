//1. Astronaut Daily Schedule Organizer Programming Exercise


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Input details for a new task
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    String startTime = getValidTime(scanner, "Enter start time (HH:mm): ");
                    String endTime = getValidTime(scanner, "Enter end time (HH:mm): ");
                    System.out.print("Enter priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();
                    Task newTask = new Task(description, startTime, endTime, priority);
                    scheduleManager.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String taskToRemove = scanner.nextLine();
                    scheduleManager.removeTask(taskToRemove);
                    break;
                case 3:
                    scheduleManager.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter the task description to edit: ");
                    String oldDescription = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    String newStartTime = getValidTime(scanner, "Enter new start time (HH:mm): ");
                    String newEndTime = getValidTime(scanner, "Enter new end time (HH:mm): ");
                    System.out.print("Enter new priority (High, Medium, Low): ");
                    String newPriority = scanner.nextLine();
                    scheduleManager.editTask(oldDescription, newDescription, newStartTime, newEndTime, newPriority);
                    break;
                case 5:
                    System.out.print("Enter task description to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    scheduleManager.markTaskAsCompleted(taskToComplete);
                    break;
                case 6:
                    System.out.print("Enter priority (High, Medium, Low): ");
                    String filterPriority = scanner.nextLine();
                    scheduleManager.viewTasksByPriority(filterPriority);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    // Method to validate time input in HH:mm format
    private static String getValidTime(Scanner scanner, String prompt) {
        String time;
        while (true) {
            System.out.print(prompt);
            time = scanner.nextLine();
            if (isValidTime(time)) {
                break; // Valid time entered
            } else {
                System.out.println("Invalid time format. Please enter time in HH:mm format (00:00 to 23:59).");
            }
        }
        return time;
    }

    // Method to check if the time is valid
    private static boolean isValidTime(String time) {
        if (time.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            return true; // Valid HH:mm format
        }
        return false; // Invalid format
    }
}
