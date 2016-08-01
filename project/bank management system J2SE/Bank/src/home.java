import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.sql.*;
public class home extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public JLabel l1,l2;
    Font f1;
    Point p;
    Icon ic;
    Container a;
    private Container c;
    home()
   {
        
   }
    public void jdbc()
    {
           try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");
      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","system");
      System.out.println("Connection build");
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");
      ResultSet rs = stmt.executeQuery("select * from bname");
      System.out.println("Resultset created");
      rs.next();
      System.out.println("system");
      l1.setText(rs.getString("name"));
      System.out.println(rs.getString("name"));

         }
       catch(Exception e)
       {
       System.out.println(e.getMessage());
       }
    }
    void fun()
    {
        setVisible(true);
        setLayout(null);
        setSize(900,600);
        p=new Point(300,100);
        c= new Container();
        c.setBackground(Color.red);
        Icon ic = null;//=new ImageIcon("E://languages//java//Bank//src//pics//r.jpg");
        //setResizable(false);
        this.setLocation(p);
        f1=new Font("Times New Roman",Font.BOLD,36);
        l1=new JLabel();
         try
      {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","system");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from bname");
      System.out.println("Resultset created");
      
      rs.next();
    
      l1.setText(rs.getString("name"));
      super.setTitle(rs.getString("name"));
     
      }
               catch(Exception e)
               {
                   System.out.println(e.getMessage());
               }
        l2=new JLabel("",JLabel.CENTER);
        b1=new JButton("Add New Customer");
        b2=new JButton("Add New Staff");
        b3=new JButton("Deposite Money");
        b4=new JButton("Withdraw Money");
        b5=new JButton("Transfer Money");
        b6=new JButton("Banking Profile");
        b7=new JButton("Customer Detail");
        b8=new JButton("Settings");
        b9=new JButton("Exit");
        l1.setFont(f1);
        l1.setBounds(100,20,800,80);
        l2.setIcon(ic);
        ic.equals(l2);
        l2.setBounds(20,120,650,700);
        b1.setBounds(700,120,150,40);
        b2.setBounds(700,170,150,40);
        b3.setBounds(700,220,150,40);
        b4.setBounds(700,270,150,40);
        b5.setBounds(700,320,150,40);
        b6.setBounds(700,370,150,40);
        b7.setBounds(700,420,150,40);
        b8.setBounds(700,470,150,40); 
        b9.setBounds(700,520,150,40);
        add(l1);
        add(l2);
        add(b3);
        add(b1);
        add(b2);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
           try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
            System.out.println("system");}
         setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
   
    public static void main(String[] args) 
    {
        home ho=new home();
        ho.fun();
        
    }
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==b1)
       {
           AddCustomer ac=new AddCustomer();
       }
       else if(e.getSource()==b2)
       {
           NewStaff ns=new NewStaff();
       }
       else if(e.getSource()==b3)
       {
           Deposite d=new Deposite();
       }
       else if(e.getSource()==b4)
       {
           Withdraw w=new Withdraw();
       }
       else if(e.getSource()==b5)
       {
           Transfer t=new Transfer();
       }
       else if(e.getSource()==b6)
       {
           String [] choice={"Customer`s Pofile","Staff`s Profile   "};
           int r=JOptionPane.showOptionDialog(null,"Select The Profile of Bank","Banking Profile",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
           if(r==0)
           {
              A o=new A();
              o.start();
           }
           else if(r==1)
           {
               B o1=new B();
               o1.start();
               //StaffProfile sp=new StaffProfile();
           }
               
       }
       else if(e.getSource()==b7)
       {
           String accno,name="",fname="",dob="",gender="";
           int r=0;
          accno=JOptionPane.showInputDialog(this,"Enter Account Number Of Customer"); 
           try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","system");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");
      ResultSet rs1 = stmt.executeQuery("select * from customer");
      System.out.println("Resultset created");
      while(rs1.next())
      {
          if(rs1.getString("accno").equals(accno))
          {
              System.out.println("system");
             name=rs1.getString("name");
              System.out.println(name);
              dob=rs1.getString("dob");
              System.out.println(dob);
              fname=rs1.getString("fname");
              System.out.println(fname);
               gender=rs1.getString("gender");
              System.out.println(gender);
             r=1;
              break;
          }
      }
            if(r==1)
            {
                CustomerDetail cd=new CustomerDetail(accno,name,fname, dob,gender);
            }
            else if(accno!=null)
            {
                 JOptionPane.showMessageDialog(this,"Incorrect Account Number");
            }
         }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
       }
       else if(e.getSource()==b8)
       {
           String s=JOptionPane.showInputDialog(this,"HI  ADMIN\nEnter Password"); 
           if(s.equals("narender"))
           {
            setting s1=new setting();}
           else
           {
               JOptionPane.showMessageDialog(this,"Incorrect Password");
           }
       }
       else 
       {
           
           System.exit(0);
       }
    }

}