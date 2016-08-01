package project;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class AddAdmin extends JFrame implements ActionListener{

	JLabel jlAdmin,jlPass,jlCnfPass;
	JTextField txtadmin;
	JPasswordField txtPass,txtCnfPass;
	JButton btOk=new JButton("OK");
	JButton btCancel=new JButton("Cancel");
	JPanel p=new JPanel();

	AddAdmin(){
		
		setVisible(true);
		setLayout(new FlowLayout());
		p.setLayout(new GridLayout(4,2));
		jlAdmin=new JLabel("Admin id");
		jlPass=new JLabel("Password");
		jlCnfPass=new JLabel("Confirm Password");
		txtadmin=new JTextField(20);
		txtPass=new JPasswordField(20);
		txtCnfPass=new JPasswordField(20);
		p.add(jlAdmin);
		p.add(txtadmin);
		p.add(jlPass);
		p.add(txtPass);
		p.add(jlCnfPass);
		p.add(txtCnfPass);
		p.add(btOk);
		p.add(btCancel);
		add(p);
		pack();
		setLocation(300,300);
		btOk.addActionListener(this);
	}
	
	public static void main(String[] args) throws SQLException {
		DbcPassword.driverManager();
		DbcPassword.getConnection();
		DbcPassword.getStatement();
		AddAdmin add=new AddAdmin();

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getActionCommand().equals("OK")){
			
			String que="Insert into adminlogin values('"+txtadmin.getText()+"','"+txtCnfPass.getText()+"')";
			try {
				System.out.println(que);
				int row=DbcPassword.stmt.executeUpdate(que);
				if(row==1){
					System.out.println("row inserted");
					
				}
				else 
					System.out.println("row is not inserted");	
				JOptionPane.showMessageDialog(null,"Admin "+" Inserted !!!");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
