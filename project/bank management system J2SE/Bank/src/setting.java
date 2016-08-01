import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class setting extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel l1;
    Point p;
   
    Font f1;
    
    setting()
    {
        super("Settings");
         try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());}
        setLayout(null);
        setVisible(true);
        setSize(550,350);
        setResizable(false);
        p=new Point(400,200);
        this.setLocation(p);
        l1=new JLabel();
        Icon ic = null;//=new ImageIcon("E://languages//java//Bank//src//pics//USERS.GIF");
        f1=new Font("Times New Roman",Font.BOLD,20);
        
        
        
        
        
        
        ///////////////JDBC//////////////////
        
        
      try
      {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from bname");
      System.out.println("Resultset created");
      
      rs.next();
    
      l1.setText(rs.getString("name"));
     
      }
               catch(Exception e)
               {
                   System.out.println(e.getMessage());
               }
        ///////////////////////////////////////////////////
        
        
        
        
        
        
        
        
        
        
       
        b1=new JButton("Change");
        b2=new JButton("Admin User");
        
        l1.setBounds(20,20,400,30);
        b1.setBounds(420,20,80,30);
        b2.setBounds(20, 70,170,50);
        add(l1);
        add(b1);
        add(b2);
        l1.setFont(f1);
        b2.setIcon(ic);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
 
    public static void main(String[] args)
    {
       
        setting s=new setting();
         
    }

  
    public void actionPerformed(ActionEvent e) 
    {
        
       
        if(e.getSource()==b1)
        {
            
             String s=JOptionPane.showInputDialog(this,"Enter New Name Of Bank");
            if(s!=null)
            {
            try
      {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from bname");
      System.out.println("Resultset created");
      
      rs.next();
     rs.updateString("name", s);
     rs.updateRow();
      l1.setText(rs.getString("name"));
       new home().jdbc();
      }
               catch(Exception ex)
               {
                   System.out.println(ex.getMessage());
               }
             }
            }
        else
        {
          AllUser au=new AllUser();
          au.AU();
        }
    }
}
