import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CustomerDetail extends JFrame implements ActionListener
{
    //String accno1,name1,fname1,dob1,gender1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    Point p;
    Font f1,f2;
    ArrayList<transaction> al;
    TableModel tm;
    JTable jt;
    JScrollPane sp;
    JButton b;
CustomerDetail(String accno,String name,String fname,String dob,String gender)
{
    super("Account Number : "+accno);
    setVisible(true);
    setLayout(null);
    setSize(600,600);
    this.setResizable(false);
    p=new Point(250,100);
    this.setLocation(p);
    f1=new Font("Times New Roman",Font.BOLD,18);
    f2=new Font("Times New Roman",Font.PLAIN,14);
     al = new ArrayList<transaction>();
     tm = new TableModel();
     jt=new JTable();
     jt.setModel(tm);
     sp=new JScrollPane(jt);
     sp.setBounds(50, 250, 500,270);
     b=new JButton("EXIT");
    b.setBounds(250,530, 100,35);
    
    
    
    
    
    
//    accno1=accno;
//    dob1=dob;
//    fname1=fname;
//    name1=name;
//    gender1=gender;
    l1=new JLabel("TRANSACTIONS");
    l2=new JLabel("Name");
    l3=new JLabel("Account Number");
    l4=new JLabel("Father Name");
    l5=new JLabel("Date Of Birth");
    l6=new JLabel("Gender");
    l7=new JLabel(name);
    l8=new JLabel(accno);
    l9=new JLabel(fname);
    l10=new JLabel(dob);
    l11=new JLabel(gender);
    
    
    
    
    
    
    l1.setFont(f1);
    l2.setFont(f2);
    l3.setFont(f2);
    l4.setFont(f2);
    l5.setFont(f2);
    l6.setFont(f2);
    l7.setFont(f2);
    l8.setFont(f2);
    l9.setFont(f2);
    l10.setFont(f2);
    l11.setFont(f2);
    l1.setBounds(200,0,200,50);
    l2.setBounds(30,60,200,30);
    l3.setBounds(30,100,200,30);
    l4.setBounds(30,140,200,30);
    l5.setBounds(30,180,200,30);
    l6.setBounds(30,220,200,30);
    l7.setBounds(280,60,200,30);
    l8.setBounds(280,100,200,30);
    l9.setBounds(280,140,200,30);
    l10.setBounds(280,180,200,30);
    l11.setBounds(280,220,200,30);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);
    add(l8);
    add(l9);
    add(l10);
    add(l11);
    add(sp);
    add(b);
    b.addActionListener(this);
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
      int bal=0,amt;
      String transaction,by,date;
      while(rs.next())
      {
          if(rs.getString("accno").equals(accno))
          {
          bal= rs.getInt("balance");
          transaction= rs.getString("transaction");
          amt=rs.getInt("amount");
          by=rs.getString("by");
          date=rs.getString("date");
          al.add(new transaction(date,transaction,amt,by,bal));
          tm.fireTableDataChanged();
          }
      }
       }
         catch(Exception ex)
         {
             System.out.println(ex.getMessage());
         }
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

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.dispose();
    }





 class TableModel extends AbstractTableModel
    {
        String title[] = {"DATE AND TIME","TRANSACTION","AMOUNT","BY","BALANCE"};
   

        public String getColumnName(int c)
        {
            return title[c];
        }
        public int getRowCount() 
        {
            return al.size();
        }

        public int getColumnCount()
        {
            return title.length;
        }

        public Object getValueAt(int row, int col) 
        {
            if(col==0)
                return al.get(row).date;
            else if(col==1)
                return al.get(row).transaction;
            else if(col==2)
                 return al.get(row).amount;
            else if(col==3)
                 return al.get(row).by;
            else 
                 return al.get(row).Balance;
           
        }
        
    }
 
 
 
 
 
 
    

}
class transaction
{
    String date;
    String transaction;
    int amount;
    String by;
    int Balance;
    public transaction(String date,String transaction,int amount,String by,int balance)
    {
        this.date=date;
        this.transaction=transaction;
        this.amount=amount;
        this.by=by;
        this.Balance=balance;
        
    }
   }