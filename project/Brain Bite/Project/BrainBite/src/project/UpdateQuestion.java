package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateQuestion extends JFrame implements ActionListener{
	
	JLabel qname,qa,qb,qc,qd,qans;
	JTextArea tqname;
	 JTextField tqa,tqb,tqc,tqd,tqans;
	 JPanel p;
	 JButton bt;
	 String sql;
	 int a=0;
	 ResultSet rs;
	public  UpdateQuestion() {
		//setLayout(200,200);
		//setSize(300,300);
		setVisible(true);
		setTitle("Update Question");
		p=new JPanel();
		p.setLayout(new GridLayout(6,2));
		qname=new JLabel("Question");
		qa=new JLabel("option A");
		qb=new JLabel("option B");
		qc=new JLabel("option c");
		qd=new JLabel("option D");
		qans=new JLabel("correct answer");
		tqname=new JTextArea(3,20);
		tqa=new JTextField(20);
		tqb=new JTextField(20);
		tqc=new JTextField(20);
		tqd=new JTextField(20);
		tqans=new JTextField(20);
		bt=new JButton("Update");
		
		p.add(qname);
		p.add(tqname);
		p.add(qa);
		p.add(tqa);
		p.add(qb);
		p.add(tqb);
		p.add(qc);
		p.add(tqc);
		p.add(qd);
		p.add(tqd);
		p.add(qans);
		p.add(tqans);
		
		add(p);
		setLayout(new FlowLayout());
		add(bt);
		pack();
		bt.addActionListener(this);
	}
	public static void main(String[] args) {
		UpdateQuestion up=new UpdateQuestion();

	}


	@Override
	public void actionPerformed(ActionEvent a) {
if(a.getActionCommand().equals("Update")){
			
			JOptionPane.showMessageDialog(null,"Question "+" Updated....");
		}
		
	}

}
