package java_project;

import java.util.Scanner;

public class to_do_list{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[10];
        int taskCount = 0;
        int choice = 0;


        while (choice != 4) {

            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Delete a task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                if (taskCount < 10) {
                    System.out.print("Enter task: ");
                    String newTask = scanner.nextLine();
                    tasks[taskCount] = newTask;
                    taskCount++;
                    System.out.println(" Task added successfully!");
                } else {
                    System.out.println(" List is full! Cannot add more than 10 tasks.");
                }

            } else if (choice == 2) {

                if (taskCount == 0) {
                    System.out.println(" No tasks yet");  
                } else {
                    System.out.println("\n Your tasks:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                                                                            

            } else if (choice == 3) {

                if (taskCount == 0) {
                    System.out.println(" No tasks to delete.");
                } else {
                    System.out.println(" Your tasks:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }

                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;

                    if (deleteIndex >= 0 && deleteIndex < taskCount) {

                        for (int i = deleteIndex; i < taskCount - 1; i++) {
                            tasks[i] = tasks[i + 1];
                        }
                    
                        tasks[taskCount - 1] = null;
                        taskCount--;
                        System.out.println("Task deleted successfully!");

                    } else {
                        System.out.println(" Invalid number! Please enter a valid task number.");
                    }
                }

            } else if (choice == 4) {
                System.out.println("\n See you next time ");

            } else {
                System.out.println("Invalid choice! Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }
}

