package taskList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class PrintReport extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PrintReport(TaskList TaskList) {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInsertNameOf = new JLabel("Insert Name of Report");
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
		
		JLabel lblReportCreated = new JLabel("Report Created");
		lblReportCreated.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReportCreated.setForeground(Color.RED);
		add(lblReportCreated);
		
		JButton btnCreateReport = new JButton("Create Report");
		btnCreateReport.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCreateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btnCreateReport);

	}

}
