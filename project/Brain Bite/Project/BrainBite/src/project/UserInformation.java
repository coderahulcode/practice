package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserInformation extends DbcPassword implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String ge="male";
	//String ge,ge1;
	JFrame jf=new JFrame();
	JLabel firstname=new JLabel("First Name");
	JTextField txtFirstName=new JTextField(10);
	JLabel middlename=new JLabel("Middle Name");
	JTextField txtMiddleName=new JTextField(10);
//	JLabel optional=new JLabel("(optional)");
	JLabel lastname=new JLabel("Last Name");
	JTextField txtLastName=new JTextField(10);
	JLabel dOB=new JLabel("Date Of Birth");
	JTextField txtDOB=new JTextField(10);
	JLabel qualification=new JLabel("Qualification");
	String[] education={"10th","+2","Diploma","Under Graduate","Post Graduate"};
	JComboBox<String> combo=new JComboBox<String>(education);
	JLabel gender=new JLabel("Gender");
	JRadioButton rdbtmale=new JRadioButton("Male",true);
	
	JRadioButton rdbtfemale=new JRadioButton("Female");
	ButtonGroup btgender=new ButtonGroup();
	
	JTextArea txtArea=new JTextArea(3,13);
	
	JLabel lblpincode=new JLabel("Pincode");
	JTextField txtPincode=new JTextField(10);
	JLabel lblEmail=new JLabel("email id");
	JTextField txtEmail=new JTextField(12);
	JLabel lblcontact=new JLabel("Contact NO.");
	JTextField txtcontact=new JTextField(12);
	JButton submit=new JButton("Submit");
	JButton cancel=new JButton("Cancel");
	
	JPanel p3=new JPanel();
	JPanel p2=new JPanel();
	
	UserInformation(){
		
	   
          
		//setBounds(200,200,280,450);
        jf.setTitle("Sign Up");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout());

		//frame1.setResizable(false);
		
		
		JPanel p=new JPanel();
	p.setLayout(new GridLayout(5,2));
		
		
		btgender.add(rdbtmale);
		btgender.add(rdbtfemale);
		JLabel address=new JLabel("Address");
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
	
		p3.setLayout(new GridLayout(5,5));
		 p2.setLayout(new GridLayout(1,3));
		p.add(firstname);
		p.add(txtFirstName);
		p.add(middlename);
		p.add(txtMiddleName);
		//	add(optional);
		p.add(lastname);
		p.add(txtLastName);
		p.add(dOB);
		p.add(txtDOB);
		p.add(qualification);
		p.add(combo);
		jf.add(BorderLayout.NORTH,p);
		
       
		p2.add(gender);
		
		p2.add(rdbtmale);
		p2.add(rdbtfemale);
		//p2.add(btgender);
		jf.add(BorderLayout.CENTER,p2);
		
		p3.add(address);
		p3.add(txtArea);
		p3.add(lblpincode);
		p3.add(txtPincode);
		p3.add(lblEmail);
		p3.add(txtEmail);
		p3.add(lblcontact);
		p3.add(txtcontact);
		p3.add(submit);
		p3.add(cancel);
		jf.add(BorderLayout.SOUTH,p3);
		
		jf.pack();
		
		cancel.addActionListener(this);
		submit.addActionListener(this);
		
	/*(	rdbtmale.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent e){
            ge=(e.getStateChange()==1?"checked":"unchecked");		 
		}	
		});
		
		System.out.println(ge);
		
		rdbtfemale.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent e){
           ge1=(e.getStateChange()==1?"checked":"unchecked");			 
		}	
		});
		System.out.println(ge1);*/
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("Cancel")){
			System.exit(0);
		}
		if(ae.getActionCommand().equals("Submit")){
		
			
			//System.out.println(rdbtmale.getName() + "\t" + rdbtfemale.getName());
			
			
		
		try {
			new UserPassword(txtFirstName.getText(),txtMiddleName.getText(),txtLastName.getText(),txtDOB.getText(),
					combo.getSelectedItem().toString(),rdbtfemale.getLabel().toString(),
					txtArea.getText(),txtPincode.getText(),txtEmail.getText(),txtcontact.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
if(ae.getActionCommand().equals("Female")){
		
			
			//System.out.println(rdbtmale.getName() + "\t" + rdbtfemale.getName());
		ge="Female";
}	
	}




	public static void main(String[] args) throws SQLException{ 
	
		/*driverManager();
		getConnection();
		getStatement();*/
		UserInformation frame1=new UserInformation();



	}


}
