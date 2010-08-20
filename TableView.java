import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.Color;
class TableView {
	private static final String REPO_COLUMN_LABEL = "Project Name";
	private static final String BRANCH_COLUMN_LABEL = "Current Branch";
	private static final String STATUS_COLUMN_LABEL = "Status";
	
	private Vector columnNames;
	private GitBot gitBot;

	public DefaultTableModel data;
	public JTable table;
	
	public TableView(GitBot _gitBot)
	{
		gitBot = _gitBot;
		
		columnNames = new Vector();
		columnNames.addElement(REPO_COLUMN_LABEL);
		columnNames.addElement(BRANCH_COLUMN_LABEL);
		columnNames.addElement(STATUS_COLUMN_LABEL);
		
		data = new DefaultTableModel(columnNames, 2);
		
		// http://forums.sun.com/thread.jspa?threadID=427894
		table = new JTable(data){
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		table.setSelectionForeground(Color.BLACK);
		table.setSelectionBackground(Color.ORANGE);
	}
	
	public void clear()
	{
		for(int i=0;i<data.getRowCount();i++){
			data.removeRow(i);
		}
	}
}
