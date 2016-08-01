package project;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class QuestionFrameTechnical extends JFrame implements ActionListener {

	int marks;
	JLabel jlQNo,jlQNam;
	JButton btnxt,btfini;
	ButtonGroup btgr=new ButtonGroup();
	JRadioButton ra,rb,rc,rd;
	int no=1;
	int qid;
	 public  QuestionFrameTechnical() {
		 
		
	setSize(300,300);
	setLocation(200,200);
	setVisible(true);
	setLayout(new FlowLayout());
	jlQNo=new JLabel("Q"+no);
	jlQNam=new JLabel("Hello?");
	ra=new JRadioButton("OP1");
	rb=new JRadioButton("OP2");
	rc=new JRadioButton("OP3");
	rd=new JRadioButton("OP4");
	btnxt=new JButton("Next");
//	btfini=new JButton("Finish");
	btgr.add(ra);
	btgr.add(rb);
	btgr.add(rc);
	btgr.add(rd);
	add(jlQNo);
	add(jlQNam);
	add(ra);
	add(rb);
	add(rc);
	add(rd);
	add(btnxt);
	
	
	btnxt.addActionListener(this);
	String sql="Select * from technicalq where qid="+1;
	ResultSet rs;
	try {
		rs=DbcPassword.stmt.executeQuery(sql);
		if(rs.next()){
	   qid=rs.getInt("qid");
		jlQNam.setText(rs.getString("quename"));
		ra.setText(rs.getString("qa"));
		rb.setText(rs.getString("qb"));
		rc.setText(rs.getString("qc"));
		rd.setText(rs.getString("qd"));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Next"))
		{
			try {
				
				ResultSet rs;
				qid++;
				String sql="Select * from technicalq where qid="+qid;
				rs=DbcPassword.stmt.executeQuery(sql);
				if(rs.next()){
			   qid=rs.getInt("qid");
			   jlQNo.setText("Q"+rs.getString("qid"));
				jlQNam.setText(rs.getString("quename"));
				ra.setText(rs.getString("qa"));
				rb.setText(rs.getString("qb"));
				rc.setText(rs.getString("qc"));
				rd.setText(rs.getString("qd"));
				
				}
				else{
					btnxt.setText("Finish");
					JOptionPane.showMessageDialog(this, "Total Questions are: "+(--qid)+"     Correct questions are: 4"+"     Your score is: 6");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public static void main(String[] args) throws SQLException {
		DbcPassword.driverManager();
		DbcPassword.getConnection();
		DbcPassword.getStatement();
		new QuestionFrameTechnical();

	}

}
