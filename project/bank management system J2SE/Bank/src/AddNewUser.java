import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
public class AddNewUser extends JFrame implements ActionListener
{
    String n,pw;
    JButton b1;
    JLabel l1,l2,l3,l4;                                                                                                             
    JTextField tf1;
    JPasswordField tf2,tf3;
    Font f1;
     Point p;
    AddNewUser()
    {
         super("Add   New User");
        
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        Icon ic=new ImageIcon("src/pics/add-user-icon.jpg");
       p=new Point(500,200);
         this.setLocation(p);
        setSize(400,320);
        this.setResizable(false);
        f1=new Font("Times New Roman",Font.BOLD,20);
        l1=new JLabel("ADD NEW USER");
        l1.setFont(f1);
        l2=new JLabel("Enter Name");
        l3=new JLabel("Password ");                             
        l4=new JLabel("Confirm Password");
        
        tf1=new JTextField(25);
        tf2=new JPasswordField(25);
        tf3=new JPasswordField(25);
      
        b1=new JButton("Create User");
        l1.setBounds(100, 10, 190, 40);
        l2.setBounds(30, 60, 150, 25);
        l3.setBounds(30, 125, 150, 25);
        l4.setBounds(30, 190, 150, 25);
       
        tf1.setBounds(200,60,150,25);
        tf2.setBounds(200, 125,150,25);
        
        tf3.setBounds(200,190,150,25);
       
        b1.setBounds(110, 235,160,45);
        b1.setIcon(ic);
      
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(tf1);
        add(tf2);
        add(tf3);
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
   

     public void actionPerformed(ActionEvent e)
     {
        
        int f=0;
        n=tf1.getText();
        pw=tf2.getText();
        if(n.equals(""))
        {
            if(pw.equals(""))
           JOptionPane.showMessageDialog(this,"Enter Name And Password Properly  !!!");
            else
           JOptionPane.showMessageDialog(this,"Enter Name Properly   !!!");
        }
        else
        {
            if(pw.equals(""))
            JOptionPane.showMessageDialog(this,"Enter Password Properly   !!!");
            else
            {
              
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
     
         int id=(int) (0+99*Math.random());
         while(rs.next())
         {
             int i=rs.getInt("user id");
             if(id==i)
             {
                 id=(int) (0+99*Math.random());
                 continue;
             }
         }
          rs.next();
          if(tf2.getText().equals(tf3.getText()))
          {
          rs.moveToInsertRow();
          rs.updateString("name",n);
          rs.updateString("password",pw);
          rs.updateInt("user id",id);
          rs.insertRow();
          //new AllUser().al.add(a,n);
          this.dispose();
                       JOptionPane.showMessageDialog(this,n+" user created !!!\nUser Id="+id); 

          }
          
          else
          {
              JOptionPane.showMessageDialog(this,"Password And Confirm Password Are Not Same   !!!"); 
          }
      }
      catch(Exception ex)
      {
          System.out.println(ex.getMessage());
      }}}
    }
}
