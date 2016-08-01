import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
public class Deposite extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3;
    JButton b1;
    Choice jc;
    Point p;
    Date d;
    Font f1,f2;
    Deposite()
    {
        super("Deposite Money");
        setVisible(true);
        setLayout(null);
        setSize(350,300);
        this.setResizable(false);
        p=new Point(400,200);
        this.setLocation(p);
        d=new Date();
        f1=new Font("Times New Roman",Font.BOLD,16);
        f2=new Font("Times New Roman",Font.PLAIN,14);
        l1=new JLabel("DEPOSITE MONEY");
        l2=new JLabel("Account Number");
        l3=new JLabel("Amount In Rupees");
        l4=new JLabel("Deposite By");
        l5=new JLabel("Date And Time");
        t1=new JTextField(25);
        t2=new JTextField(25);
        jc=new Choice();
        jc.add("Cash");
        jc.add("Check");
        t3=new JTextField(25);
        b1=new JButton("Deposite");
        l1.setBounds(100,00,150,50);
        l2.setBounds(30, 60,100,30);
        l3.setBounds(30,100,150,30);
        l4.setBounds(30,140,100,30);
        l5.setBounds(30,190,100,30);
        t1.setBounds(170,60,150,25);
        t2.setBounds(170,100,150,25);
        jc.setBounds(175,150,150,25);
        t3.setBounds(170,190,150,25);
        t3.setText(d.toLocaleString());
        t3.setFocusable(false);
        b1.setBounds(90,225,150,40);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(t1);
        add(t2);
        add(t3);
        add(jc);
        add(b1);
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        b1.setFont(f2);
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
    public static void main(String[] args)
    {
        Deposite d=new Deposite();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("rahul");
       String accno,by,date;
       int amt,bal=0,r=0;
        accno=t1.getText();
        amt=Integer.parseInt(t2.getText());
        by=jc.getSelectedItem();
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
              System.out.println("rahul");
              r=1;
              break;
          }
      }
             System.out.println("rahul1");
         }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        if(r==1)
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
      }
             System.out.println("rahul3");
          rs.moveToInsertRow();
          rs.updateString("accno",accno);
          rs.updateString("date",date);
          rs.updateString("transaction","deposite");
          rs.updateString("by", by);
          rs.updateInt("amount", amt);
          rs.updateInt("balance", (bal+amt));
          rs.insertRow();
          JOptionPane.showMessageDialog(this,"Deposited Successfully\n\n\tBalance = "+(bal+amt));
         this.dispose();
      }
      
         
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        }
        else
        {
             JOptionPane.showMessageDialog(this,"Invalid Account Number");
        }
        
        
    }
}
