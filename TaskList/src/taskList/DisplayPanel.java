package taskList;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;

public class DisplayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DisplayPanel(TaskList TaskList) {
		
		ArrayList<Task> ListToDisplay = new ArrayList<Task>(TaskList.getTaskList());
		Object[] List = ListToDisplay.toArray();
		
		String[][] tableLists = new String[List.length][5];
		
		for(int i = 0; i < List.length; i++) {
			Task Display = (Task) List[i];
			tableLists[i][0] = "" + Display.getPriority();
			tableLists[i][1] = "" + Display.getName();
			tableLists[i][2] = "" + Display.getStatus();
			tableLists[i][3] = "" + Display.getDueDate();
			tableLists[i][4] = "" + Display.getDescription();
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(tableLists,
			new String[] {
				"Task Priority", "Task Name", "Status", "Due Date", "Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

}
