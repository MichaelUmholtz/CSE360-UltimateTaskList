package taskList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Save extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Save(TaskList TaskList) {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInsertNameOf = new JLabel("Insert Name of Save File");
		lblInsertNameOf.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblInsertNameOf);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		JLabel lblReportCreated = new JLabel("");
		lblReportCreated.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReportCreated.setForeground(Color.RED);
		add(lblReportCreated);
		
		JButton btnCreateReport = new JButton("Save List");
		btnCreateReport.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCreateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean Completed = true;
				
				try {
					TaskList.save(textField.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					Completed = false;
				}
				
				if(Completed==true) {
					lblReportCreated.setText("File Saved");
					repaint();
				}else {
					lblReportCreated.setText("File Not Saved");
					repaint();
				}
			}
		});
		add(btnCreateReport);

	}

}