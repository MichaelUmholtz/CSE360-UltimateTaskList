package taskList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ChangePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField OldName;
	private JTextField NewName;

	/**
	 * Create the panel.
	 */
	public ChangePanel(TaskList TaskList) {
		setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblInsertNameOf = new JLabel("Insert Name of Task To Change");
		lblInsertNameOf.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblInsertNameOf);
		
		OldName = new JTextField();
		OldName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(OldName);
		OldName.setColumns(10);
		
		JLabel lblInsertNewName = new JLabel("Insert New Name");
		lblInsertNewName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblInsertNewName);
		
		NewName = new JTextField();
		NewName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(NewName);
		NewName.setColumns(10);
		
		JLabel ErrorLabel = new JLabel("");
		ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ErrorLabel.setForeground(Color.RED);
		add(ErrorLabel);
		
		JButton ChangeTask = new JButton("Change Task");
		ChangeTask.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ChangeTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String OldNameToChange = null;
				if(OldName.getText()!= null)
						 OldNameToChange = OldName.getText();
				
				String NewNameToChange = null;
				if(NewName.getText()!= null)
						 NewNameToChange = NewName.getText();
				
				boolean Completed = TaskList.changeTask(OldNameToChange, NewNameToChange);
				
				if(Completed == true) {
					ErrorLabel.setText("Name successfully changed.");
					repaint();
				}else {
					ErrorLabel.setText("Name not found/changed.");
					repaint();
				}
				
			}
		});
		add(ChangeTask);

	}

}
