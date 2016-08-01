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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddQuestionGK extends JFrame implements ActionListener{

	JLabel qname,qa,qb,qc,qd,qans;
	JTextArea tqname;
	 JTextField tqa,tqb,tqc,tqd,tqans;
	 JPanel p;
	 JButton bt;
	 String sql;
	 int a=0;
	 ResultSet rs;
	public AddQuestionGK() {
		//setLayout(200,200);
		setSize(300,300);
		setVisible(true);
		setTitle("GK Question Panel");
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
		bt=new JButton("Submit");
		
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
	

	@Override
	public void actionPerformed(ActionEvent ee)
	{
		
		if (ee.getSource()==bt) {
			
			String sql1="Select Max(Qid) from gkq";
			
			try {
				ResultSet rs=DbcPassword.stmt.executeQuery(sql1);
				if(rs.next()){
					System.out.println("Execute");
							a=rs.getInt(1);
							
							
				}
				++a;
				System.out.println("Execute="+(a));
				

				 sql="INSERT INTO gkq (qid ,QueName ,qA,qB ,qC ,qd,qAns) VALUES('"+a+"','" +tqname.getText()+"','"
							+tqa.getText()+"','"+tqb.getText()+"','"+tqc.getText()+"','"+tqd.getText()+"','"+tqans.getText()+"')";
							int a=DbcPassword.stmt.executeUpdate(sql);
							if (a==1) {
								System.out.print("insert");
								JOptionPane.showMessageDialog(this, "Question inserted");
								
							}
							
						}
				
	
		
		
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	      }
		}
	public static void main(String[] args) throws SQLException {
		DbcPassword.driverManager();
		DbcPassword.getConnection();
		DbcPassword.getStatement();
      AddQuestionGK gk=new AddQuestionGK();
      
	}

}
