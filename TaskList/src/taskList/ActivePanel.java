package taskList;
public class ActivePanel {
	private int CurrentActivePanel;
	
	public ActivePanel(){
		CurrentActivePanel = 0;
	}
	
	public int getActivePanel() {
		return CurrentActivePanel;
	}
	
	public void setActivePanel(int NewActivePanel) {
		CurrentActivePanel = NewActivePanel;
	}
}
