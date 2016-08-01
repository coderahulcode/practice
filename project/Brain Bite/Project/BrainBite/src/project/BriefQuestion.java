package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BriefQuestion extends JFrame implements ActionListener{
	JLabel lblComnt;
	JButton ques,users,admin,delete;
	JComboBox combo;
	BriefQuestion(){
		
		
			setTitle("Questions Queries");
			
			setVisible(true);
			//setResizable(false);
			setLayout(new FlowLayout());
			lblComnt=new JLabel("Question Point!!!");
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
			 JLabel category=new JLabel("                          Select Category");
			 String[] education={"GK","Sports","Technical"};
				 combo=new JComboBox(education);
			    p2.add(category);
			    p2.add(combo);
			
			
			
			add(p1);
			add(p2);
			add(p);
			setSize(360,170);
			setLocation(300,300);
			 combo.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BriefQuestion bq=new BriefQuestion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("ADD")){
			
			AddQuestionGK gk=new AddQuestionGK();
			
		}

		if (e.getActionCommand().equals("UPDATE")){
			UpdateQuestion D=new UpdateQuestion();
			
			
		}

		if (e.getActionCommand().equals("DELETE")){
			
			DeleteQuestion d=new DeleteQuestion();
			
		}
		
		
	}

}
