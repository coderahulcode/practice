package project;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AboutUs  {

	AboutUs()
	{
	JFrame jf=new JFrame("About Us");
	jf.setBounds(0,0,3000,3000);
	jf.setLayout(new FlowLayout());
	
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel pan=new JPanel();
	JPanel pan1=new JPanel();
	JPanel pan2=new JPanel();
	JPanel pan3=new JPanel();
	JPanel pan4=new JPanel();
	JPanel pan5=new JPanel();
	JPanel pan6=new JPanel();
	JPanel pan7=new JPanel();
	JPanel pan8=new JPanel();
	JPanel pan9=new JPanel();
	JPanel pan0=new JPanel();
	pan6.setLayout(new GridLayout(1,0));
	pan7.setLayout(new GridLayout(1,0));
	
	JLabel jb=new JLabel("This web application provides facility to conduct online quiz.");
	JLabel jb1=new JLabel("It saves time as it allows number of users to give the exam at a time and displays the results as the test gets over Online quiz application has two users i.e.,Administrator and Users.");
			JLabel jb2=new JLabel( "Administrator has a privilege to create,modify and delete the questions.");
			JLabel jb3=new JLabel ("User can register with signup and give the quiz test with his specific id and password.");
			JLabel jb4=new JLabel( "This project is developed in java having Oracle database as backend.");
			JLabel jb5=new JLabel ("This application is developed by 5star Group, Includes ");
			JLabel jb6=new JLabel ("Gagandeep Singh  ");
			JLabel jb7=new JLabel( "Karan Mahajan");
			JLabel jb8=new JLabel( "Priya Kumari");
			JLabel jb9=new JLabel("Avneet Kaur");
			JLabel jb0=new JLabel ("Rajveer Kaur");	
	pan.add(jb);
	pan1.add(jb1);
	pan2.add(jb2);
	pan3.add(jb3);
	pan4.add(jb4);
	pan5.add(jb5);
	pan6.add(jb6);
	pan7.add(jb7);
	pan8.add(jb8);
	pan9.add(jb9);
	pan0.add(jb0);
	jf.add(pan);
	jf.add(pan1);
	jf.add(pan2);
	jf.add(pan3);
	jf.add(pan4);
	jf.add(pan5);
	jf.add(pan6);
	jf.add(pan7);
	jf.add(pan8);
	jf.add(pan9);
	jf.add(pan0);
//jf.pack();
	}
	
	

}
