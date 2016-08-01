import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
public class Transfer extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1;
    //Choice jc;
    Point p;
    Date d;
    Font f1,f2;
    Date c;
    Transfer()
    {
        super("Transfer Money");
        setVisible(true);
        setLayout(null);
        setSize(350,350);
        this.setResizable(false);
        p=new Point(400,200);
        this.setLocation(p);
        d=new Date();
        f1=new Font("Times New Roman",Font.BOLD,16);
        f2=new Font("Times New Roman",Font.PLAIN,14);
        l1=new JLabel("TRANSFER MONEY");
        l2=new JLabel("From Account Number");
        l3=new JLabel("To Account Number");
        l6=new JLabel("Amount In Rupees");
        l4=new JLabel("Security Code");
        l5=new JLabel("Date And Time");
        t1=new JTextField(25);
        t2=new JTextField(25);
        t5=new JTextField(25);
        t3=new JTextField(25);
        t4=new JTextField(25);
        b1=new JButton("Transfer");
        l1.setBounds(90,00,200,50);
        l2.setBounds(20, 60,150,30);
        l3.setBounds(20,100,150,30);
        l4.setBounds(20,140,150,30);
        l5.setBounds(20,220,150,30);
        l6.setBounds(20,180,150,30);
        t1.setBounds(170,60,150,25);
        t2.setBounds(170,100,150,25);
        t5.setBounds(170,140,150,25);
        t4.setBounds(170,180,150,25);
        t3.setBounds(170,220,150,25);
        t3.setText(d.toLocaleString());
        t3.setFocusable(false);
        b1.setBounds(90,265,150,40);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(t1);
        add(t2);
        add(t3);
        add(t5);
        add(b1);
        add(l6);
        add(t4);   
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        b1.setFont(f2);
        l6.setFont(f2);
        b1.addActionListener(this);
        try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");
        }
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
//    public static void main(String[] args)
//    {
//       Transfer t=new Transfer();
//    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        
         String accno,accno1,date,code;
       int amt,bal=0,r=0,r1=0,bal1=0;
        accno=t1.getText();
        accno1=t2.getText();
        amt=Integer.parseInt(t4.getText());
        
        code=t5.getText();
        date=t3.getText();
        try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");
      ResultSet rs1 = stmt.executeQuery("select * from customer");
      System.out.println("Resultset created");
      while(rs1.next())
      {
          if(rs1.getString("accno").equals(accno))
          {
              System.out.println("rahul0");
              if(rs1.getString("code").equals(code))
              {
              System.out.println("rahul");
              r=1;
             
              }
          }
              if(rs1.getString("accno").equals(accno1))
              {
                  r1=1;
              }
          
      }
             System.out.println("rahul1");
             if(r==0)
                  JOptionPane.showMessageDialog(this,"Incorrect Source Money Account Number or Code");
             else if(r1==0)
                  JOptionPane.showMessageDialog(this,"Incorrect Destination Money Account Number");
         }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        if(r==1&&r1==1)
        {
            try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from transaction");
      System.out.println("Resultset created");
       
     while(rs.next())
      {
          if(rs.getString("accno").equals(accno))
          {
          bal=rs.getInt("balance");
              System.out.println("rahul2");
          }
          if(rs.getString("accno").equals(accno1))
          {
          bal1=rs.getInt("balance");
          System.out.println("rahul2");
          }
      }
     if(bal-amt<1000)
     {
         JOptionPane.showMessageDialog(this,"The balance after Transfer is less than 1000\n\nSo, Transfer is not Successful");
     }
     else
     {
          System.out.println("rahul3");
          rs.moveToInsertRow();
          rs.updateString("accno",accno);
          rs.updateString("date",date);
          rs.updateString("transaction","Withdraw");
          rs.updateString("by", "Transfer");
          rs.updateInt("amount", amt);
          rs.updateInt("balance", (bal-amt));
          rs.insertRow();
          rs.moveToInsertRow();
          rs.updateString("accno",accno1);
          rs.updateString("date",date);
          rs.updateString("transaction","Deposite");
          rs.updateString("by", "Transfer");
          rs.updateInt("amount", amt);
          rs.updateInt("balance", (bal1+amt));
          rs.insertRow();
          JOptionPane.showMessageDialog(this,"Transfer Successfully\n\n\tBalance = "+(bal+amt));
     }
         
      }
      
         
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        }
   
      
    }
