package project;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AdminPanel extends JFrame implements ActionListener{

	JLabel lblComnt;
	JButton ques,users,admin;
	AdminPanel(){
		setTitle("Admin Panel");
		setSize(280,150);
		setLocation(300,300);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		lblComnt=new JLabel("Hello Admin....");
		ques=new JButton("Questions");
		//users=new JButton("Users");
		admin=new JButton("Admin");
		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		p.add(ques);
		//p.add(users);
		p.add(admin);
		p1.add(lblComnt);
		
		add(p1);
		add(p);
		}
	public static void main(String[] args) {
		AdminPanel  adp=new AdminPanel();
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Questions")){
			
			BriefQuestion br=new BriefQuestion();
		}
if (a.getActionCommand().equals("Admin")){
			
			AdminQueries d=new AdminQueries();
		}
	}

}
