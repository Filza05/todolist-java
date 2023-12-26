
package todolisttest;

import java.io.IOException;
import java.util.Scanner;

//This code creates a new text file for a new task so that one text file contains one task.
//Different methods are then done on those text files or tasks 


public class ToDoListTest {

   
    public static void main(String[] args) throws IOException 
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Welcome to your Todo Manager!\n\nPlease Enter Your Name: ");
        String name=input.nextLine();
        System.out.println("Hello " + name + "!");
        
        int choice;
        
        do
        {
            System.out.println("Please choose an option: \n");
            System.out.println("1. Insert a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Update a task");
            System.out.println("4. Search a task");
            System.out.println("5. List all tasks");
            System.out.println("6. Mark a task as done");
            System.out.println("7. Exit");
            choice = input.nextInt();
            
            int ID;
            ToDoList task = new ToDoList();
            
            switch (choice)
            {
                case 1:
              
                    System.out.println("Enter the task Number (e.g 1,2 etc): ");
                    ID = input.nextInt();
                    
                    System.out.println("Enter the date:");
                    task.setDate(input.nextLine());
                    task.setDate(input.nextLine()); // Adding second call. My compiler is skipping the first input call somehow.
                    
                    System.out.println("\nEnter the time:");
                    task.setTime(input.nextLine());
                    
                    System.out.println("\nEnter the task subject:");
                    task.setSubject(input.nextLine());
                    
                    System.out.println("\nEnter the task description:");
                    task.setDescription(input.nextLine());
                    
                    System.out.println("\nEnter the location:");
                    task.setLocation(input.nextLine());
                    
                    System.out.println("\nEnter the task deadline:");
                    task.setDeadline(input.nextLine());
                    
                    task.InsertTask(ID, task.getDate(), task.getTime(), task.getSubject(), task.getDescription(), task.getLocation(), task.getDeadline());
                    System.out.println("Press ENTER to continue...");
                    input.nextLine();// Adding second call. My compiler is skipping the first input call somehow.  
                    break;
                    
                case 2:
                    
                    System.out.println("Enter the task number to delete the task:");
                    ID = input.nextInt();
                    task.removeTask(ID);
                    System.out.println("Press ENTER to continue...");
                    input.nextLine();
                    input.nextLine();// Adding second call. My compiler is skipping the first input call somehow.  
                    break;
                    
                case 3:
                        
                    System.out.println("Enter the task number (e.g 1,2 etc): ");
                    ID = input.nextInt();
                    
                    System.out.println("Enter the date:");
                    task.setDate(input.nextLine());
                    task.setDate(input.nextLine()); // Adding second call. My compiler is skipping the first input call somehow.     
                    
                    System.out.println("\nEnter the time:");
                    task.setTime(input.nextLine());
                    
                    System.out.println("\nEnter the task subject:");
                    task.setSubject(input.nextLine());
                    
                    System.out.println("\nEnter the task description:");
                    task.setDescription(input.nextLine());
                    
                    System.out.println("\nEnter the location:");
                    task.setLocation(input.nextLine());
                    
                    System.out.println("\nEnter the task deadline:");
                    task.setDeadline(input.nextLine());
                    
                    task.updateTask(ID, task.getDate(), task.getTime(), task.getSubject(), task.getDescription(), task.getLocation(), task.getDeadline());
                    break;
                    
                case 4:
                    
                    System.out.println("Enter the task number:");
                    ID = input.nextInt();
                    task.searchTask(ID);
                    System.out.println("\nHit ENTER to continue...\n");
                    input.nextLine(); 
                    input.nextLine(); // Adding second call. My compiler is skipping the first input call somehow.     
                    break;
                    
                case 5:
                   
                    System.out.println("ALL THE TASKS YOU HAVE ENTERED SO FAR:\n");
                    task.displayAll();
                    System.out.println("\nHit ENTER to continue...\n");
                    input.nextLine();
                    input.nextLine(); // Adding second call. My compiler is skipping the first input call somehow.     
                    break;
                    
                    
                case 6:
                    System.out.println("Enter the task number:");
                    ID = input.nextInt();
                    task.markAsDone(ID);
                    System.out.println("\nHit ENTER to continue...\n");
                    input.nextLine();
                    input.nextLine(); // Adding second call. My compiler is skipping the first input call somehow.     
                    break;
                    
                default:
                    System.out.println("Invalid Choice, hit ENTER to try again...");
                    input.nextLine();
                    input.nextLine(); // Adding second call. My compiler is skipping the first input call somehow. 
                    
            }
        }while(choice!=7);
        
    }
    
}
