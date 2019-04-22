package taskList;

//Jonathan Jordan, Ryan Cost, Jacob Mumme, Michael Umholtz 
//# 1206921998, 
//#
//# 1210471545,
//#
//Group Assignment
//Task list and functions associated with requirements for Team project.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*; 

/**
	 * @desc 
	 
	 This class makes an array list task_list.  We then create a new task and add it to 
	 the list of tasks and create a name, description, priority level, due date and 
	 status to the new task.  From here we can change priority level, delete the task, 
	 change the task save the task to a file and open the file with the saved data.
	 
	 * @param
	 
	newTask(), changeTask(), delete(), open(), save(), changePriority()
	 
	 * @return
	 
	 * 
	 * */
	 
public class TaskList
{
	
	ArrayList<Task> task_list = new ArrayList<Task>();
	/**
	 * @desc 
	 The function newTask creates a task with required parameters.
	 *@param
	 name, description, priority, due_date, status.
	 * @return
	 True
	 * 
	 * */	
	public boolean newTask(String name, String description, int priority, int due_date, int status)
	{
		boolean is_success = false;
		
		//create new Task object, then add to task_list
		Task temp_task = new Task();
		
		temp_task.setName(name);
		temp_task.setDescription(description);
		temp_task.setPriority(priority);
		temp_task.setDueDate(due_date);
		temp_task.setStatus(status);
		
		
		boolean found = false;
		
		//TODO: Check for duplicates, errors in task creation.
		for(int iterator = 0; iterator < task_list.size() - 1; iterator++)
		{
			if(temp_task.getName().equals(task_list.get(iterator).getName()) || (temp_task.getPriority() == task_list.get(iterator).getPriority()))
			{
				found = true;
			}
		}
		
		if(found)
		{
			return is_success;
		}
		
		task_list.add(temp_task);
		is_success = true;
		
		reorder();
		
		return is_success;
	}
	/**
	 * @desc
	 
	 deleteTask allows you to select and delete the task that you want to remove.
	 
	 * @param
	 
	 String deleteName
	 
	 * @return
	 
	 True
	 
	 * 
	 * */
	public boolean deleteTask(String deleteName)
	{
		boolean is_success = false;
		int index, arraySize;
		
		// record size
		arraySize = task_list.size(); 
		
		//iterate through task_list with for loop to find index to remove
		for(index = 0; index < arraySize - 1; index++ )
		{
			Task currentName = task_list.get(index);
			if(deleteName == currentName.getName())
			{
				task_list.remove(index);
				currentName = null;
				is_success = true;
			}
		}		
		
		//No need to reorder at the end, tasks will already be ordered.
		
		return is_success;
	}
	/**
	 * @desc
	 
	 changeTask takes a task that has already been established and allows you to 
	 set a new name for that task.
	 
	 * @param
	 
	 Task toChange, String newName
	 
	 * @return
	 
	 True
	 
	 * 
	 * */
	public boolean changeTask(String oldName, String newName)
	{
		boolean is_success = false;
		int index, arraySize;
		
		// toFind.name = deleteName;
		arraySize = task_list.size(); 
		//iterate through task_list with for loop to find index to remove
		for(index = 0; index < arraySize - 1; index++ )
		{
			Task currentName = task_list.get(index);
			
			if(oldName ==  currentName.getName())
			{
				currentName.setName(newName);
				
				is_success = true;
				return is_success;
			}
		}
		return is_success;
	}
	/**
	 * @desc
	 
	 changePriority allows you to change the priority of an already established task.
	 
	 * @param
	 
	 int currentP (current priority), int newP (new priority)
	 
	 * @return
	 
	 True
	 
	 * 
	 * */
	public boolean changePriority(int currentP, int newP)
	{
		boolean is_success = false;
		int index, arraySize;
		
		arraySize = task_list.size(); 	

		for(index = 0; index < arraySize - 1; index++ )
		{
			Task currentPriority = task_list.get(index);
			
			if(currentP ==  currentPriority.getPriority())
			{
				currentPriority.setPriority(newP);
				reorder();
				is_success = true;
				return is_success;
			}
		}
		
		reorder();
		
		return is_success;
	}

	/**
	 * @desc 
	 
	 The function newTask reorders the arraylist based upon the priority of the task.
	 
	 *@param
	 
	 
	 * @return
	 
	 Void
	 
	 * */	
	public void reorder()
	{
		int len = task_list.size();
		
		for(int index = 0; index < len - 1; index++)
		{
			int min_index = index;
			for(int sub_index = index + 1; sub_index < len; sub_index++)
			{
				if(task_list.get(sub_index).getPriority() < task_list.get(min_index).getPriority())
				{
					min_index = sub_index;
				}
			}
			
			Collections.swap(task_list, index, min_index);
		}
	}
	

	/**
	 * @desc
	 
	 The save function saves the task and task parameters to a file.
	 
	 * @param
	 
	 String fileName
	 
	 * @return
	 
	 void
	 
	 * 
	 * */    
	public void save(String fileName) throws FileNotFoundException 
 {
 	int index;
 	int arraySize = task_list.size(); 
	    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
	    
	    for (index = 0; index < arraySize; index++)
	    {
	    	Task task = task_list.get(index);
	    	
	        pw.println(task.getName());
	        
	        pw.println(task.getDescription());
	        
	        pw.println(task.getPriority());
	        
	        pw.println(task.getDueDate());
	        
	        pw.println(task.getStatus());
	      
	    }
	    pw.close();
 }
	/**
	 * @desc
	 
	 The function open, opens the file UltimateTaskList.txt, which has the saved data 
	 from a pervious version of saved tasks.
	 
	 * @param
	 
	 String fileName
	 
	 * @return
	 
	 Void 
	 
	 * 
	 * */
	public boolean open(String fileName) throws FileNotFoundException 
	{
		boolean taskCompleted = true;
		
		File file = new File(fileName);
		
		BufferedReader reader = null;
		
		if (fileName != null)
			reader = new BufferedReader(new FileReader(file));
		
		if(fileName == null)
			taskCompleted = false;
			
		
	}
	/**
	 * @desc
	 
	The function print, prints the array list.  It removes all unnecessary characters 
	to make it more readable.
	
	 * @param
	 
	none
	 
	 * @return
	 
	 Void 
	 
	 * 
	 * */
	
	public void print()
	{
	
		String filterExtras = task_list.toString().replace('[',']','{','}'); // check to make sure this works.
		filterExtras = filterExtras.replacereplace('[',']','{','}'); // check to make sure this works in testing
	
		System.out.println(filterExtras); // this should print out the array with the filters
	
		System.out.print(task_list); // prints out array without filters
	
	}
	
	public ArrayList<Task> getTaskList(){
		return task_list;
	}

}