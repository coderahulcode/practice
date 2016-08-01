import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.util.Date;

public class LoginFrame extends JFrame implements ActionListener {
    
    static JFrame frame;
    private String username;
    private String password;
    private static JFrame loginFrame;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel panel3;
    private JButton loginBtn;
    private JButton exitBtn;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    String dialogmessage;
    String dialogs;
    private JLabel nameLbl;
    private JLabel userLbl;
    private JLabel passwordLbl;
    private static JTextField userTxt;
    private static JPasswordField passwordTxt;
    
    public String loginname;
    public String loginpass;
    
    // class Veriables
    clsConnection connect = new clsConnection();
    //Connection variable
    
    Connection conn;
    	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
    
    static Date td 			= new Date();	
    
    public LoginFrame()
    {
    
 	  setForeground(Color.blue);
           setBackground(Color.cyan);
   panel1 = new JPanel();
   panel1.setLayout(null);
   nameLbl = new JLabel("WELCOME TO ADVANCE PAYROLL SYSTEM");
    JLabel l1=new JLabel(new ImageIcon("logo.jpg"));
    JLabel l2=new JLabel(new ImageIcon("images.jpg"));
    nameLbl.setBounds(100,20,400,50);
l1.setBounds(150,80,300,200);

panel1.add(l1);

   panel2 = new JPanel();
   panel2.setLayout(null);
   userLbl = new JLabel("Username :");
   userLbl.setBounds(100,10,100,40);
   userTxt = new JTextField(20);
   userTxt.setBounds(240,10,150,30);
   passwordLbl = new JLabel("Password :");
   passwordLbl.setBounds(100,80,100,40);
   passwordTxt = new JPasswordField(20);
   passwordTxt.setBounds(240,80,150,30);
   panel3 = new JPanel();
   panel3.setLayout(new FlowLayout());
   
   loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));
   
   loginBtn.addActionListener(this);
   exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));
   
           panel3.setForeground(Color.blue);
            panel3.setBackground(Color.cyan);
panel2.setForeground(Color.blue);
            panel2.setBackground(Color.cyan);
panel1.setForeground(Color.blue);
            panel1.setBackground(Color.cyan);
   exitBtn.addActionListener(this);
	panel1.add(nameLbl);
	panel1.setOpaque(true);
    panel2.add(userLbl);
	panel2.add(userTxt);
	panel2.add(passwordLbl);
	panel2.add(passwordTxt);
	panel2.setOpaque(true);
   	panel3.add(loginBtn);
	panel3.add(exitBtn);
	panel3.setOpaque(true);
	frame = new JFrame("PayRoll User Login...");
       frame.setSize(600,500);
        
	Container pane = frame.getContentPane();   
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    //pane.setLayout(new GridLayout(3,1));
	pane.add(panel1);
	pane.add(panel2);
	pane.add(panel3);
	frame.setLocation((screen.width - 500)/2,((screen.height-350)/2));	
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
     


    }
    
       public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source.equals(loginBtn))
        {
           login();
           
        } 
        else if(source.equals(exitBtn))
        {
            		System.exit(0);
        }
    }
        
        public void login()
        {
        	loginname = userTxt.getText().trim();
           	loginpass = passwordTxt.getText().trim();
           
                   
            try {
                conn = connect.setConnection(conn,"","");
            }
            catch(Exception e)
            {
            }
            try{
             	
             
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM Login WHERE USERNAME='" + loginname + 
                        "'AND PASSWORD='"+loginpass+"'";
                ResultSet rs = stmt.executeQuery(query);
                boolean recordfound = rs.next();
                if (recordfound)
                {
                	
                	dialogmessage = "Welcome - " +loginname;
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    userTxt.setText("");
                    passwordTxt.setText("");
                    frame.setVisible(false);
                    frame.dispose();
                    MainMenu menu = new MainMenu(loginname,td);
                  	
                	
                }
                else
                {
                	dialogmessage = "Login Failed!";
                    JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD!",
                            "WARNING!!",JOptionPane.WARNING_MESSAGE);
                    
                    userTxt.setText("");
                    passwordTxt.setText("");
                }
                conn.close();
        }
        catch(Exception ex)
          {
          	JOptionPane.showMessageDialog(null,"GENERAL EXCEPTION", "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
          	}		
    }
    
    
    public static void main(String[] args)
    {
        
        LoginFrame frame1 = new LoginFrame();
		frame1.addNotify();
		frame1.pack();
                     
	
    }
   
    
    
}

