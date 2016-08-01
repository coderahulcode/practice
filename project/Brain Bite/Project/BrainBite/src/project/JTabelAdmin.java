package project;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;


public class JTabelAdmin extends JFrame{


	
    public JTabelAdmin() {
		
    	setTitle("JTabel");
    	setLocation(300, 300);
    	setVisible(true);
    	setLayout(new FlowLayout());
    	
    	String sql="Select * from adminlog";
    	//try {
			//ResultSet rs=DbcPassword.stmt.executeQuery(sql);
			//while(rs.next()){
				Object[][] adminIdd={{"1","gagan"},{"2","azad"},{"3","prince"}};
						
			//}
			Object[] col1={"adid","adname"};
            JTable tb=new JTable(adminIdd,col1);
    	//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
    	add(tb);
    	pack();
	}	
	public static void main(String[] args) {
		JTabelAdmin 
tbl=new JTabelAdmin();
	}

}
