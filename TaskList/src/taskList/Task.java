// Jonathan Jordan, Ryan Cost, Jacob Mumme, Michael Umholtz 
// # 1206921998, 
// Group Assignment
// Task list and functions associated with requirements for Team project.



package taskList;

/**
	 * @desc
	 
	 Getters and setters for task list.
	 
	 * @param
	 String name, description, priority, due_date, status.
	 
	 * @return
	 
	 * 
	 * */
	 
public class Task 
{
	
	private String name, description;
	private int priority, due_date, status;

/**
	 * @desc
	 
	 Allows user to set the name of a task.
	 
	 * @param
	 
	 String name2
	 
	 * @return
	 
	 name2
	 
	 * 
	 * */
	 
	public void setName(String name2) 
	{
		this.name = name2;
	}

/**
	 * @desc
	 
	 Allows user to set description of a task.
	 
	 * @param
	 
	 String description2
	 
	 * @return
	 
	 description2
	 
	 * 
	 * */
	 
	public void setDescription(String description2) 
	{
		this.description = description2;
	}

/**
	 * @desc
	 
	 Allows user to set the priority for a task.
	 
	 * @param
	 
	 int priority2
	 
	 * @return
	 
	 priority2
	 
	 * 
	 * */
	 
	public void setPriority(int priority2) 
	{
		this.priority = priority2;
	}

/**
	 * @desc
	 
	 Allows user to set a due date for a task.
	 
	 * @param
	 
	 int due_date2
	 
	 * @return
	 
	 due_date2
	 
	 * 
	 * */
	 
	public void setDueDate(int due_date2) 
	{
		this.due_date = due_date2;
	}

/**
	 * @desc
	 
	 Allows user to set the status for a task.
	 
	 * @param
	 
	 int status2
	 
	 * @return
	 
	 status2
	 
	 * 
	 * */
	 
	public void setStatus(int status2) 
	{
		this.status = status2;
	}
	
	
	// getters
	
	/**
	 * @desc
	 
	 Allows program to get the name of a task from user entry.
	 
	 * @param
	 
	 
	 * @return
	 
	Returns user entry for name.
	 
	 * 
	 * */
	 
	public String getName() 
	{
		return this.name;
	}
/**
	 * @desc
	 
	 Allows program to get the description of a task from user entry.
	 
	 * @param
	 
	 * @return
	 
	 Returns user entry for description
	 
	 * 
	 * */
	 
	public String getDescription() 
	{
		return this.description;
	}
/**
	 * @desc
	 
	 Allows program to get priority of a task from user entry.
	 
	 * @param
	 
	 * @return
	 
	 Returns user entry for priority.
	 
	 * 
	 * */
	 
	public int getPriority() 
	{
		return this.priority;
	}
/**
	 * @desc
	 
	 Allows program to get the due date of a task from user entry.
	 
	 * @param
	 
	 * @return
	 
	 Returns user entry for due date
	 
	 * 
	 * */
	 
	public int getDueDate() 
	{
		return this.due_date;
	}
/**
	 * @desc
	 
	 Allows program to get status of a task from user entry.
	 
	 * @param
	 
	 * @return
	 
	 Returns user entry for status of a task.
	 * 
	 * */
	 
	public int getStatus() 
	{
		return this.status;
	}

}