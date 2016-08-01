import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.TextField.*;
import java.sql.*;
public class ChangePassword extends JFrame implements ActionListener
{
    String name,password,p1,n1;
    JButton b1;
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1;
    JPasswordField tf2,tf3,tf4;
    Font f1;
     Point p;
    ChangePassword()
    {
        super("Change Password");
         //this.setUndecorated(true);
      
        
        setVisible(true);
        setLayout(null);
      
        setSize(400,400);
         this.setResizable(false);
         p=new Point(500,200);
         this.setLocation(p);
        f1=new Font("Times New Roman",Font.BOLD,16);
        b1=new JButton("Change Password");
        l1=new JLabel("CHANGE PASSWORD");
        l1.setFont(f1);
        l2=new JLabel("Enter User-ID");
        l3=new JLabel("Enter Password");
        l4=new JLabel("New Password");
        l5=new JLabel("Confirm Password");
        tf1=new JTextField(25);
        tf2=new JPasswordField(25);
        tf3=new JPasswordField(25);
        tf4=new JPasswordField(25);
        l1.setBounds(100, 10, 190, 40);
        l2.setBounds(30, 60, 150, 25);
        l3.setBounds(30, 125, 150, 25);
        l4.setBounds(30, 185, 150, 25);
        l5.setBounds(30, 245,150,25);
        tf1.setBounds(200,60,150,25);
        tf2.setBounds(200, 125,150,25);
        tf3.setBounds(200,185,150,25);
        tf4.setBounds(200,245,150,25);
        b1.setBounds(110, 300,140,25);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(b1);
      
        b1.addActionListener(this);
      
    try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
            System.out.println("rahul");}                      
  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args)
    {
    ChangePassword cp=new ChangePassword();    
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int f=0,f1=0,f2=0;
      name=tf1.getText();
      password=tf2.getText();
       try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from users");
      System.out.println("Resultset created");
      while(rs.next())
      {
          p1=rs.getString("password");
          n1=rs.getString("user id");
          if(n1.equals(name))
          {
              f=1;
              if(p1.equals(password))
              {
                  f1=1;
                  if(tf3.getText().equals(tf4.getText()))
                  {
                      f2=1;
                      rs.updateString("password", tf4.getText());
                      //rs.updateString("name",tf1.getText());
                      rs.updateRow();
                      JOptionPane.showMessageDialog(this,"Password Change Successfully\n\nNew Password  =  "+tf4.getText());
                      login l=new login();
                      this.dispose();
                      break;
                  }
                 
              }
              
          }
         
      }
      if(f==0)
      {
          JOptionPane.showMessageDialog(this,"Incorrect User   !!!");
      }
      else if(f1==0)
      {
          JOptionPane.showMessageDialog(this,"Incorrect User Password   !!!");
      }
      else if(f2==0)
      {
          JOptionPane.showMessageDialog(this,"New Password And Confirm Passsword Must Be Same   !!!");
      }
      
       }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
      }
}
