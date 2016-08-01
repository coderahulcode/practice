package project;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdminLogin extends JFrame implements ActionListener {

	JLabel jlLog,jlPass;
	JTextField txtLog,txtPass;
	JButton btLog,btCancel;
	JPanel p=new JPanel();
	  public AdminLogin() {
		
		 
		  setVisible(true);
		  setLayout(new FlowLayout());
		  setTitle("Admin Login");
		   jlLog=new JLabel("Admin id");
		   jlPass=new JLabel("Password");
		   txtLog=new JTextField(20);
		   txtPass=new JTextField(20);
		   btLog=new JButton("Login");
		   btCancel=new JButton("Cancel");
		   p.setLayout(new GridLayout(3,2));
		   p.add(jlLog);
		   p.add(txtLog);
		   p.add(jlPass);
		   p.add(txtPass);
		  p. add(btLog);
		  p. add(btCancel);
		   add(p);
		  
		   pack();
		  // setSize(470,200);
			  setLocation(400,200);
		   btLog.addActionListener(this);
		   
		  
	}
	
	public static void main(String[] args) throws SQLException {
	
		DbcPassword.driverManager();
	    DbcPassword.getConnection();
	    DbcPassword.getStatement();
		AdminLogin ad=new AdminLogin();
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login")){
			
			String que="Select * from adminlog where adminid='"+txtLog.getText()+"'and password='"+txtPass.getText()+"'";
			
			try {
				ResultSet rs=DbcPassword.stmt.executeQuery(que);
				if(rs.next()){
					
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
				}
				else{
					System.out.println("Admin not Exist");
				}
			} catch (SQLException e1) {
				
				//e1.printStackTrace();
			}
		}
		
	}

}
