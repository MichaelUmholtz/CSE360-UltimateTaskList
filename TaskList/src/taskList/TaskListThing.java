package taskList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class TaskListThing {

	private JFrame frmToDoList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskListThing window = new TaskListThing();
					window.frmToDoList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaskListThing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TaskList TaskList = new TaskList();
		
		ActivePanel Current = new ActivePanel();
		
		frmToDoList = new JFrame();
		frmToDoList.setTitle("To Do List Unlimited 2019");
		frmToDoList.setBounds(100, 100, 1500, 600);
		frmToDoList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmToDoList.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel VariablePanel = new JPanel();
		frmToDoList.getContentPane().add(VariablePanel, BorderLayout.CENTER);
		
		JLabel lblWelcomeToTo = new JLabel("Welcome to To Do List Unlimited 2019!");
		lblWelcomeToTo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblWelcomeToTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToTo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		VariablePanel.add(lblWelcomeToTo);
		
		
		JPanel UserControls = new JPanel();
		frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
		JButton Insert = new JButton("Insert");
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Current.getActivePanel() != 0) {
					JPanel InsertPanel = new InsertPanel(TaskList);
					InsertPanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(InsertPanel,BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(1);
			}
		});
		Insert.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(Insert);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 2) {
					JPanel DeletePanel = new DeletePanel(TaskList);
					DeletePanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(DeletePanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(2);
			}
		});
		Delete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(Delete);
		
		JButton ChangeName = new JButton("Change Name");
		ChangeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 3) {
					JPanel ChangePanel = new ChangePanel(TaskList);
					ChangePanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(ChangePanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(3);
			}
		});
		ChangeName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(ChangeName);
		
		JButton ChangePriority = new JButton("Change Priority");
		ChangePriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 4) {
					JPanel ChangePriorityPanel = new ChangePriority(TaskList);
					ChangePriorityPanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(ChangePriorityPanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(4);
			}
		});
		ChangePriority.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(ChangePriority);
		
		JButton Display = new JButton("Display");
		Display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Current.getActivePanel() != 5) {
					JPanel DisplayPanel = new DisplayPanel(TaskList);
					DisplayPanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(DisplayPanel, BorderLayout.SOUTH);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(5);
			}
		});
		Display.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(Display);
		
		JButton PrintReport = new JButton("Print Report");
		PrintReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 6) {
					JPanel PrintReportPanel = new PrintReport(TaskList);
					PrintReportPanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(PrintReportPanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(6);
			}
		});
		PrintReport.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(PrintReport);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 7) {
					JPanel SavePanel = new Save(TaskList);
					SavePanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(SavePanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(7);
			}
		});
		Save.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(Save);
		
		JButton Restore = new JButton("Restore");
		Restore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Current.getActivePanel() != 8) {
					JPanel RestorePanel = new RestorePanel(TaskList);
					RestorePanel.setVisible(true);
					frmToDoList.getContentPane().removeAll();
					frmToDoList.getContentPane().add(UserControls, BorderLayout.NORTH);
					frmToDoList.getContentPane().add(RestorePanel, BorderLayout.CENTER);
					frmToDoList.invalidate();
					frmToDoList.revalidate();
					frmToDoList.repaint();
				}
				Current.setActivePanel(8);
			}
		});
		Restore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UserControls.add(Restore);
		
		JButton Quit = new JButton("Quit");
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TaskList.save("defaultTaskList.txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frmToDoList.dispose();
			}
		});
		Quit.setFont(new Font("Tahoma", Font.BOLD, 30));
		UserControls.add(Quit);
		
	}
}
