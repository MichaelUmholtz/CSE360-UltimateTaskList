package taskList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeletePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TaskName;

	/**
	 * Create the panel.
	 */
	public DeletePanel(TaskList TaskList) {
		
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel InstructionDisplay = new JLabel("Insert Name of Task to Delete");
		InstructionDisplay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(InstructionDisplay);
		
		TaskName = new JTextField();
		TaskName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(TaskName);
		TaskName.setColumns(10);
		
		JLabel ErrorDisplayLabel = new JLabel("");
		ErrorDisplayLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ErrorDisplayLabel.setForeground(Color.RED);
		add(ErrorDisplayLabel);
		
		JButton DeleteButton = new JButton("Delete Task");
		DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TaskNameToDelete = null;
				if(TaskName.getText()!="")
					TaskNameToDelete = TaskName.getText();
				
				if(TaskNameToDelete!=null) {
					
					boolean Completed = TaskList.deleteTask(TaskNameToDelete);
					System.out.println("Task to be deleted: " + TaskNameToDelete);
					if(Completed == true) {
	
						String ErrorDisplay = "Task Successfully Deleted";
						ErrorDisplayLabel.setText(ErrorDisplay);
						repaint();
						
					}else {
						
						String ErrorDisplayFail = "Task Not Deleted";
						ErrorDisplayLabel.setText(ErrorDisplayFail);
						repaint();
						
					}
				}
			}
		});
		add(DeleteButton);

	}

}
