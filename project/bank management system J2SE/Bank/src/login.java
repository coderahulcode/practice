import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
public class login extends JFrame implements ActionListener
{
    String name,password,p1,n1;
    JLabel l1,l2,l3;
    JButton b1,b2,b3; 
    JTextField tf1;
    JPasswordField tf2;
    Font f1,f2;
    Point p;
   login()
      {
         super("Bank Login");
         this.setUndecorated(true);
         setLayout(null);
         setSize(400,250);
         this.setResizable(false);
         p=new Point(500,200);
         this.setLocation(p);
          Icon ic=new ImageIcon("E://languages//java//Bank//src//pics//login.png");
         f1=new Font("Times New Roman",Font.BOLD,22);
         f2=new Font("Times New Roman",Font.PLAIN,16);
         l1=new JLabel("LOGIN");
         l2=new JLabel("Name");
         l3=new JLabel("Password");
         tf1=new JTextField(25);
         tf2=new JPasswordField(25);
         l1.setFont(f1);
          System.out.println("rahul mahajan");
         l2.setFont(f2);
         l3.setFont(f2);
         b1=new JButton("Login");
         b2=new JButton("Cancel");
         b3=new JButton("Change Password");
         b1.setIcon(ic);
         l1.setBounds(140,15,230,40);
         l2.setBounds(30,80,100,30);
         l3.setBounds(30,130,100,30);
         tf1.setBounds(140,80,100,30);
         tf2.setBounds(140,130,100,30);
         b1.setBounds(50,180,120,40);
         b2.setBounds(190,180,120,40);
         b3.setBounds(250, 130,140,30);
         add(l1);
         add(l2);
         add(l3);
         add(b1);
         add(b2);
         add(tf1);
         add(tf2);
         add(b3);
         b1.addActionListener(this);
         b2.addActionListener(this);  
         b3.addActionListener(this);
           try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");}
           setVisible(true);
        
    }
    public static void main(String[] args)
    {
        login l=new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    if(e.getSource()==b1)
    {
        name=tf1.getText();
        password=tf2.getText();
        
        int f=0,f1=0;
        
        
        
        
        
        
        
        
        
        try
    {
      
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","system");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from users");
      System.out.println("Resultset created");
      while(rs.next())
      {
          p1=rs.getString("password");
          n1=rs.getString("name");
          if(n1.equals(name))
          {
              f=1;
              if(p1.equals(password))
              {
               f1=1;
               JOptionPane.showMessageDialog(this,"Success");
               home h=new home();
               h.fun();
               this.dispose();
               break;
              }
              
          }
         
      }
      if(f==0 || f1==0)
      {
          JOptionPane.showMessageDialog(this,"Incorrect User   !!!");
      }
    
     
      
       }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
         }
    
    
    
    else if(e.getSource()==b2)
    {
        this.dispose();
    }
    else
    {
        this.dispose();
        ChangePassword cp=new ChangePassword();
    }
    }
}