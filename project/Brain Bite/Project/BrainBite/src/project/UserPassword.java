package project;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPassword extends DbcPassword implements ActionListener{




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int usrid;
	int 	st;
	JTextField txtcnf	=new JTextField(7);
	String fname, mname, lname, dob, quali, gender, address,
	  emailid;
	int pin,number;

	UserPassword (String fname,String mname,String lname,String dob,String quali,String gender,String address,
			String pin ,String emailid,String number) throws SQLException{
		JFrame jf=new JFrame();
		
		this.fname=fname;
		this.mname=mname;
		this.lname=lname;
		this.dob=dob;
		this.quali=quali;
		this.gender=gender;
		this.address=address;
		this.pin=Integer.parseInt(pin);
		this.number=Integer.parseInt(number);
		jf.setLayout(new BorderLayout());
		//jf.setBounds(100,200,280,180);
		jf.setTitle("User Password"); 
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String que;
		ResultSet rs;
		//jf.setResizable(false);
		que="Select Max(userid) from UserLog";
		rs=stmt.executeQuery(que);
		while(rs.next()){
			st=rs.getInt(1);
			System.out.println(st);
		}

		JLabel lbluser=new JLabel(" Your Userid is  "+(++st));
		jf.add(BorderLayout.NORTH,lbluser);

		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,2));


		JLabel lblpswrd	=new JLabel("Enter Password ");
		JLabel cnfps=new JLabel("Confirm Password "); 
		JButton ok=new JButton("OK");
		JTextField pass = new JTextField(7);
		JButton cancel = new JButton("Cancel");
		
		p.add(lblpswrd);
		//lblpswrd.setBounds(100, 200, 10,10);
		p.add(pass);
		p.add(cnfps);
		p.add(txtcnf);
		p.add(ok);
		p.add(cancel);

		jf.add(p);
		ok.addActionListener(this);
		jf.pack();
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("OK")){
			String sql = "INSERT INTO userlog (userid,password) VALUES('" +st+"','"+txtcnf.getText()+"')";
			String sql1 = "INSERT INTO Signup (userid,fName,mName,lName,DOB,Qualification,gender,address,pin,email,contact) VALUES('"+st+"','" +fname+"','"
			+mname+"','"+lname+"','"+dob+"','"+quali+"','"
					+gender+"','"+address+"','"+pin+"','"+emailid+"','"+number+"')";
			
			System.out.println(sql);	
			try {
				int rowsAffected = stmt.executeUpdate(sql);
				int rowsAffected1 = stmt.executeUpdate(sql1);
				if(rowsAffected==1){
					System.out.println("Row inserted");
				}
				else{
					System.out.println("Row not inserted");}
				if(rowsAffected1 ==1){
					System.out.println("Paswrd inserted");
				}
				else{
					System.out.println("Paswrd not inserted");
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	/*public static void main(String[] args) throws SQLException {
		driverManager();
		getConnection();
		getStatement();
		//new DbmsDemo();
		UserPassword up=new UserPassword();
	}*/


}
