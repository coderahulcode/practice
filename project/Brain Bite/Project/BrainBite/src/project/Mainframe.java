package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Mainframe extends DbcPassword implements ActionListener{


	JTextField txtuserid=new JTextField(15);
	JPasswordField txtPassword=new JPasswordField(15);

	String[] sr=new String[10];
	String a[]=new String[10];
	String b[]=new String[10];
	String c[]=new String[10];
	String d[]=new String[10];
	String cans[]=new String[10];
	int ar[]=new int[10];
	String sql;
	int i=0;
	String[] logType={"Admin","User"};
	JComboBox<String> combo=new JComboBox<String>(logType);

	Mainframe(){


		JFrame frame=new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setTitle("Welcome to Brain Bite");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		//frame.setResizable(false);
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,2));
		JLabel lblUserid=new JLabel("Userid");
		JLabel lblPassword = new JLabel("Password");
		JLabel lblUserType=new JLabel("Type");
		JButton log=new JButton("Login");
		JButton btnSignUp=new JButton("Sign Up");
		JButton demo=new JButton("Demo");
		//	log.addActionListener(this);
		//JButton cancel=new JButton("Cancel");
		p.add(lblUserid);
		p. add(txtuserid);
		p. add(lblPassword);
		p.add(txtPassword);
		p.add(lblUserType);
		p.add(combo);
		p.add(log);
		p.add(btnSignUp);

		frame.add(p);
		frame.add(demo);
		//frame.add(cancel);
		//cancel.addActionListener(this);
		frame.setBounds(200,250,500,300);
		log.addActionListener(this);
		btnSignUp.addActionListener(this);
		demo.addActionListener(this);
	}

	String query;
	ResultSet rs;
	public void actionPerformed(ActionEvent a) {

		if(a.getActionCommand().equals("Login")&&combo.getSelectedItem().equals("User")){
			query="select userid,password from UserLogin where userid="+txtuserid.getText()+" and password='"+ txtPassword.getText()+"'";
			System.out.println(query);
			try {
				//Statement stmt = DbcPassword.getStatement();

				System.out.println(stmt);
				rs=stmt.executeQuery(query);


				System.out.println("\nUserID       Password");
				if(rs.next())
				{
					System.out.print(rs.getInt("userid"));
					System.out.print("        ");
					System.out.print(rs.getString("password"));
					System.out.println("Correct");
					MenuFr menf=new MenuFr();
				}
				//if(rs.getString("userid").equals(null) && rs.getString("password").equals(null))
				/*if(rs.next()){                         
						 System.out.println("Incorrect");
						 }*/
				
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Exception occur");
			}       
		}
		else{
			System.out.println(" Incorrect");
		JOptionPane.showMessageDialog(null,"Invalid"+" Userid and Password.....");}
			
			if(a.getActionCommand().equals("Login")&&combo.getSelectedItem().equals("Admin")){
				query="select adminid,password from adminLogin where adminid='"+txtuserid.getText()+"' and password='"+ txtPassword.getText()+"'";
				System.out.println(query);
				try {
					
					
					ResultSet rs=stmt.executeQuery(query);
					System.out.println(rs);
					if(rs.next())
					{
						System.out.println("Prince");
						 AdminPanel adminPanel=new AdminPanel();
						System.out.print(rs.getString("adminid"));
						System.out.print("        ");
						System.out.print(rs.getString("password"));
						System.out.println("\nCorrect");
						
					}
					/*else{
						System.out.println(" Incorrect");
						JOptionPane.showMessageDialog(null,"Admin "+" does not exist !!!!");
					}*/
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		 if(a.getActionCommand().equals("Sign Up")){
			new UserInformation();
		}
		
		if(a.getActionCommand().equals("Demo")){
			QuestionFrameDemo demo=new QuestionFrameDemo();


		}

	}




	public static void main(String[] args) throws SQLException {

		driverManager();
		getConnection();
		getStatement();

		Mainframe mdi=new Mainframe();

	}

}
