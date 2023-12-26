
package todolisttest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;


public class ToDoList {
    private String date,time,subject,description,location,deadline;

    
     public void setDate (String date)
    {
        this.date=date;
    }
    
     public String getDate ()
    {
        return this.date;
    }
     
     public void setTime (String time)
    {
        this.time=time;
    }
      
     public String getTime ()
    {
        return this.time;
    }
       
     public void setSubject (String sub)
    {
        this.subject=sub;
    }
      
     public String getSubject ()
    {
        return this.subject;
    }
          
     public void setDescription (String desc)
    {
        this.description=desc;
    }
        
     public String getDescription ()
    {
        return this.description;
    }  
         
     public void setLocation (String loc)
    {
        this.location=loc;
    }
         
     public String getLocation ()
    {
        return this.location;
    } 
        
     public void setDeadline (String ddl)
    {
        this.deadline=ddl;
    }
         
     public String getDeadline ()
    {
        return this.deadline;
    } 
 
    public void InsertTask (int ID, String dt,String tm, String sub,String desc, String loc, String ddl) throws IOException
    {       
        try ( //To insert a task in a text file
                PrintWriter output = new PrintWriter(new File ("Task" + ID + ".txt"))) {
            output.println("Task number:"+ ID + "\tDate:"+ dt +"\tTime:" + tm + "\tSubject:" + sub + "\tDescription:" + desc + "\tLocation:" + loc + "\tDeadline:" + ddl + "\n");
            System.out.println("Task SuccessFully Added!");
        } 
        catch (Exception e)
        {
            System.out.println("An unexpected Error Ocurred");
        }
        
    }
    
    public void updateTask (int ID,String dt,String tm, String sub,String desc, String loc, String ddl) throws FileNotFoundException, IOException
    {
        try
        {
        //To overwrite the previous content in the text file of the mentioned task
        FileWriter writer = new FileWriter("Task" + ID +  ".txt", false);
        writer.write("Task number:"+ ID + "\tDate:"+ dt + "\tTime:" + tm + "\tSubject:" + sub + "\tDescription:" + desc + "\tLocation:" + loc + "\tDeadline:" + ddl + "\n");
        writer.close();
        System.out.println("Task:"+ ID +" successfully updated to your ToDo List!");
        }
        catch (Exception e)
        {
            System.out.println("Task not Found! You must have not entered it or you have already removed it. Try Again."); 
        }
    }
    
    public void removeTask (int ID) throws IOException
    {
        try
        {
        File Tasks = new File ("Task" + ID + ".txt");
        
        //To close the text file if it is open somewhere, otherwise it won't be removed
        FileReader fread = new FileReader(Tasks);
        BufferedReader br = new BufferedReader(fread);
        br.close();
        
        if (Tasks.delete()) {
            System.out.println("Task " + ID + " successfully removed.");
        }
        }
        
        catch(Exception e)
        {
            System.out.println("Task not Found! You must have not entered it or you have already removed it. Try Again.");
        }
    }
    
    public void searchTask(int ID) throws FileNotFoundException, IOException
    {
        try
        {
            Scanner fileIn = new Scanner(new File("Task" + ID + ".txt"));
            String task = fileIn.nextLine();
            System.out.println(task);  
            fileIn.close();
        }
        catch(Exception e)
        {
            System.out.println("Task not Found! You must have not entered it or you have already removed it. Try Again.");
        }
       
    }
    
    public void displayAll() throws FileNotFoundException, IOException
    {
        String projectDirectory = System.getProperty("user.dir");

            File directoryPath = new File(projectDirectory);
		//To List text files only
		File[] files=directoryPath.listFiles(new FilenameFilter() {
			@Override
                       
			public boolean accept(File dir, String name) 
                        {
				return name.endsWith(".txt");
                         /*filtering only the text files so that if a task file is removed when
                        removing a task from todolist, only the text files are
                        retrieved and printed, so all tasks are printed as they are.*/
			}
		});
                            
                            for (File file : files) {
                            Scanner input = new Scanner(new File("" + file.getName()));
                            String task = input.nextLine();
                            System.out.println(task);
                            input.close();
		}
    }
    
    
    public void markAsDone(int ID) throws IOException
    {
        if (new File ("Task" + ID + ".txt").exists())
        {
            FileWriter writer = new FileWriter("Task" + ID +".txt", false);
            writer.write("Task" + ID + " was marked as done!.");
            writer.close();
            System.out.println("Task "+ ID + " is now marked as done!");
        }
        else 
        {
            System.out.println("Task " + ID +" Does not exist. Try Again!");
        }
    }

}

 
    
    































































