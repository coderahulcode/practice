package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateAdminPass extends JFrame implements ActionListener {

	JLabel jlAdmin,jlPass,jlCnfPass;
	JTextField txtadmin;
	JPasswordField txtPass,txtCnfPass;
	JButton btOk=new JButton("OK");
	JButton btCancel=new JButton("Cancel");
	JPanel p=new JPanel();
	
	UpdateAdminPass(){
		setTitle("Update Admin Password");
		setVisible(true);
		setLayout(new FlowLayout());
		p.setLayout(new GridLayout(4,2));
		jlAdmin=new JLabel("Old Password");
		jlPass=new JLabel("New Password");
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
	public static void main(String[] args) {
		UpdateAdminPass up=new UpdateAdminPass();

	}
	@Override
	public void actionPerformed(ActionEvent a) {
if(a.getActionCommand().equals("OK")){
			
			JOptionPane.showMessageDialog(null,"Password "+" Updated....");
		}
		
	}

}
