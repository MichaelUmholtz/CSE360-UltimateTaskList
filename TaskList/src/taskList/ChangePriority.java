package taskList;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class ChangePriority extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField OldPriority;
	private JTextField NewPriority;
	/**
	 * Create the panel.
	 */
	public ChangePriority(TaskList TaskList) {
setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblInsertPriorityOf = new JLabel("Insert Priority of Task To Change");
		lblInsertPriorityOf.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblInsertPriorityOf);
		
		OldPriority = new JTextField();
		OldPriority.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(OldPriority);
		OldPriority.setColumns(10);
		
		JLabel lblInsertNewPriority = new JLabel("Insert New Priority");
		lblInsertNewPriority.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblInsertNewPriority);
		
		NewPriority = new JTextField();
		NewPriority.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(NewPriority);
		NewPriority.setColumns(10);
		
		JLabel ErrorLabel = new JLabel("");
		ErrorLabel.setForeground(Color.RED);
		add(ErrorLabel);
		
		JButton ChangeTask = new JButton("Change Priority");
		ChangeTask.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ChangeTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean Errors = false;
				
				int OldPriorityToChange = -1;
				if(OldPriority.getText()!="")
					try {
					OldPriorityToChange = Integer.parseInt(OldPriority.getText());
					}catch(NumberFormatException a) {
						ErrorLabel.setText("Error reading priority, please insert an integer number.");
						repaint();
						Errors = true;
					}
				int NewPriorityToChange = -1;
				if(NewPriority.getText()!="")
					try {
					NewPriorityToChange = Integer.parseInt(NewPriority.getText());
					}catch(NumberFormatException a) {
						ErrorLabel.setText("Error reading priority, please insert an integer number.");
						repaint();
						Errors = true;
					}
				if(Errors!=true) {
					
					boolean Completed = TaskList.changePriority(OldPriorityToChange, NewPriorityToChange);
					
					if(Completed == true) {
						ErrorLabel.setText("Priority changed.");
						repaint();
					}else {
						ErrorLabel.setText("Priority not found.");
					}
				}
			}
		});
		add(ChangeTask);
	}

}
