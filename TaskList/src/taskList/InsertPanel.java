package taskList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InsertPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TaskNameField;
	private JTextField TaskPriorityField;
	private JTextField TaskDateField;
	private JTextField TaskStatusField;
	private JLabel TaskDescription;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel InsertErrorField;
	private JLabel label_5;
	private JTextField TaskDescriptionField;
	private JButton InsertButton;

	/**
	 * Create the panel.
	 */
	public InsertPanel(TaskList TaskList) {
		setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel TaskName = new JLabel("Task Name");
		TaskName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskName);
		
		TaskNameField = new JTextField();
		TaskNameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskNameField);
		TaskNameField.setColumns(10);
		
		JLabel TaskPriority = new JLabel("Task Priority");
		TaskPriority.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskPriority);
		
		TaskPriorityField = new JTextField();
		TaskPriorityField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskPriorityField);
		TaskPriorityField.setColumns(10);
		
		JLabel DueDate = new JLabel("Due Date (MMDDYYYY)");
		DueDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(DueDate);
		
		TaskDateField = new JTextField();
		TaskDateField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskDateField);
		TaskDateField.setColumns(10);
		
		JLabel TaskStatus = new JLabel("Status");
		TaskStatus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskStatus);
		
		TaskStatusField = new JTextField();
		TaskStatusField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskStatusField);
		TaskStatusField.setColumns(10);
		
		TaskDescription = new JLabel("Description");
		TaskDescription.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskDescription);
		
		TaskDescriptionField = new JTextField();
		TaskDescriptionField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskDescriptionField);
		TaskDescriptionField.setColumns(10);
		
		label_1 = new JLabel("");
		add(label_1);
		
		label_2 = new JLabel("");
		add(label_2);
		
		label_3 = new JLabel("");
		add(label_3);
		
		InsertErrorField = new JLabel("");
		InsertErrorField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		InsertErrorField.setForeground(Color.RED);
		add(InsertErrorField);
		
		label_5 = new JLabel("");
		add(label_5);
		
		InsertButton = new JButton("Insert");
		InsertButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String TaskNameToInsert = null;
				if(TaskNameField.getText()!= null)
						 TaskNameToInsert =TaskNameField.getText();
				
				int TaskPriorityToInsert = -1;
				if(TaskPriorityField.getText()!="")
					try {
					TaskPriorityToInsert = Integer.parseInt(TaskPriorityField.getText());
					}catch(NumberFormatException a) {}
				
				int DueDateToInsert = -1;
				if(TaskDateField.getText()!="")
					try {
					DueDateToInsert = Integer.parseInt(TaskDateField.getText());
					}catch(NumberFormatException a) {}
				
				int StatusToInsert = -1;
				if(TaskStatusField.getText()!="")
					try {
					StatusToInsert = Integer.parseInt(TaskStatusField.getText());
					}catch(NumberFormatException a) {}
				
				String DescriptionToInsert = "";
				if(TaskDescriptionField.getText()!="")
						 DescriptionToInsert =TaskDescriptionField.getText();
				
				String ErrorMessage = "Error, task could not be inserted. Please check ";
				boolean Error = false;
				
				if(TaskNameToInsert == null) {
					ErrorMessage = ErrorMessage + "Task Name, ";
					Error = true;
				}
				if(TaskPriorityToInsert == -1) {
					ErrorMessage = ErrorMessage + "Task Priority, ";
					Error = true;
				}
				if(DueDateToInsert == -1) {
					ErrorMessage = ErrorMessage + "Due Date, ";
					Error = true;
				}
				if(StatusToInsert == -1) {
					ErrorMessage = ErrorMessage + "Task Status, ";
					Error = true;
				}
				if(DescriptionToInsert == null) {
					ErrorMessage = ErrorMessage + "Task Description, ";
					Error = true;
				}
				ErrorMessage = ErrorMessage + "and try again. ";
				
				if(Error == false) {
					boolean Completed = TaskList.newTask(TaskNameToInsert, DescriptionToInsert, TaskPriorityToInsert, DueDateToInsert, StatusToInsert);
					if(Completed == true) {
						ErrorMessage = "Task Successfully Added";
						InsertErrorField.setText(ErrorMessage);
						repaint();
					}
					else {
						ErrorMessage = "Task Not Added";
						InsertErrorField.setText(ErrorMessage);
						repaint();
					}
				}else {
					InsertErrorField.setText(ErrorMessage);
					repaint();
				}
			}
		});
		add(InsertButton);

	}

}
