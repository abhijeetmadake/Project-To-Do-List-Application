import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("To-Do List Application");
        System.out.println("Commands: add, remove, display, exit");

        do {
            System.out.print("Enter command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    addTask(scanner);
                    break;
                case "remove":
                    removeTask(scanner);
                    break;
                case "display":
                    displayTasks();
                    break;
                case "exit":
                    System.out.println("Exiting To-Do List Application...");
                    break;
                default:
                    System.out.println("Invalid command. Please enter add, remove, display, or exit.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask(Scanner scanner) {
        displayTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        System.out.print("Enter task number to remove: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task removed successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
