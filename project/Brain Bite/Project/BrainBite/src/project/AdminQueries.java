package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminQueries extends JFrame implements ActionListener{

	JLabel lblComnt;
	JButton ques,users,admin,delete;
	JComboBox combo;
	 AdminQueries(){
		
		
			setTitle("Admin Queries");
			
			setVisible(true);
			//setResizable(false);
			setLayout(new FlowLayout());
			lblComnt=new JLabel("Admin Point!!!");
			ques=new JButton("ADD");
			//users=new JButton("VIEW");
			admin=new JButton("UPDATE");
			delete=new JButton("DELETE");
			JPanel p=new JPanel();
			JPanel p1=new JPanel();
			JPanel p2=new JPanel();
			p1.add(lblComnt);
			p.add(ques);
			//p.add(users);
			p.add(admin);
			p.add(delete);
			 
			
			
			add(p1);
			add(p2);
			add(p);
			setSize(360,170);
			setLocation(300,300);
			 
	 }
	public static void main(String[] args) {
		AdminQueries adm=new AdminQueries();

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ADD")){
			
			AddAdmin ad=new AddAdmin();
			
		}

		if (e.getActionCommand().equals("UPDATE")){
			
			
			UpdateAdminPass B=new UpdateAdminPass();
		}
		

		if (e.getActionCommand().equals("DELETE")){
			
			AdminDelete d=new AdminDelete();
			
		}
		
		
		
	}

}
