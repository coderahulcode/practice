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

public class DeleteQuestion extends JFrame implements ActionListener{

	JLabel lblQid;
JTextField txtQid; 
JButton btDelete,btCancel;
JPanel p=new JPanel();
	DeleteQuestion(){
		
		setTitle("Delete Question");
		
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		p.setLayout(new GridLayout(2,2));
		lblQid=new JLabel("Qid");
		txtQid=new JTextField(20);
		btDelete=new JButton("Delete");
		btCancel=new JButton("Cancel");
		p.add(lblQid);
		p.add(txtQid);
		p.add(btDelete);
		p.add(btCancel);
		add(p);
		//setSize(320,150);
		setLocation(300,300);
		pack();
		btDelete.addActionListener(this);
	}
	public static void main(String[] args) {
		
		DeleteQuestion del=new DeleteQuestion();
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getActionCommand().equals("Delete")){
			
			JOptionPane.showMessageDialog(null,"Question "+" Deleted....");
		}
	}

}
