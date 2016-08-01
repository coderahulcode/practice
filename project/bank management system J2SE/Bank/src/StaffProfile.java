import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;
public class StaffProfile extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
   Point p;
    Font f1,f2;
    ArrayList<sprofile> al;
    TableModel tm;
    JTable jt;
    JScrollPane sp;
    JButton b,b1,b2;
  
    StaffProfile()
    {
     super("Staff Profiles");
    setVisible(true);
    setLayout(null);
    setSize(700,700);
    this.setResizable(false);
    p=new Point(250,20);
    this.setLocation(p);
    f1=new Font("Times New Roman",Font.BOLD,18);
    f2=new Font("Times New Roman",Font.PLAIN,14);
     al = new ArrayList<sprofile>();
     tm = new TableModel();
     jt=new JTable();
 
   

     jt.setModel(tm);
     sp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     
      
     sp.setBounds(50, 250, 600,300);
    
     b=new JButton("EXIT");
     b1=new JButton("UPDATE ROW");
     b2=new JButton("DELETE ROW");
     
    sp.setViewportView(jt);
    l1=new JLabel("STAFF PROFILE");
    l2=new JLabel("Name");
    l3=new JLabel("Account Number");
    l4=new JLabel("Father Name");
    l5=new JLabel("Date Of Birth");
    l6=new JLabel("Gender");
    l7=new JLabel();
    l8=new JLabel();
    l9=new JLabel();
    l10=new JLabel();
    l11=new JLabel();
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
    b1.setBounds(50,560,150,50);
    b2.setBounds(500,560 ,150,50);
    b.setBounds(300, 620, 100,40);
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
    add(b1);
    add(b2);
    b2.addActionListener(this);
    b.addActionListener(this);
    b1.addActionListener(this);
     try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from staff");
      System.out.println("Resultset created");
      String accno,name,fname,dob,gender,state,address,email,date,qval;
      long pno;
      while(rs.next())
      {
          accno= rs.getString("empno");
          name= rs.getString("name");
          fname=rs.getString("fname");
          dob=rs.getString("dob");
          qval=rs.getString("qval");
          gender=rs.getString("gender");
          state=rs.getString("state");
          address=rs.getString("address");
          email=rs.getString("email");
          pno=rs.getLong("pno");
          date=rs.getString("date");
         
          al.add(new sprofile(accno,name,fname,dob,qval,gender,state,address,email,pno,date));
          tm.fireTableDataChanged();
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
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args)
    {
   //new StaffProfile();
        B o=new B();
        o.start();
    
    
        
    }
     
    

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if(e.getSource()==b1)
      {
          int r=jt.getSelectedRow();
          if(r==-1)
               JOptionPane.showMessageDialog(this,"Select The Row First   !!!");
           else
               try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from staff");
      System.out.println("Resultset created");
      sprofile i;
     i=al.get(r);
     String accno=i.accno;
      String name,fname,dob,gender,state,address,email,qval;
      long pno;
     String sn[]=new String[3];
             System.out.println(accno);
    
     while(rs.next())
     {
         System.out.println("rahul1");
         if(rs.getString("empno").equals(accno))
         {
             System.out.println("rahul");
            name=rs.getString("name");
             StringTokenizer s=new StringTokenizer(name);
            int n=s.countTokens();
            for(int j=0;j<n;j++)
            {
                sn[j]=s.nextToken();
                System.out.println(sn[j]);
            }
             System.out.println("rahul3");
            fname=rs.getString("fname");
            dob=rs.getString("dob");
            gender=rs.getString("gender");
            state=rs.getString("state");
             System.out.println("rahul4");
            address=rs.getString("address");
            email=rs.getString("email");
            pno=rs.getLong("pno");
          qval=rs.getString("qval");
             System.out.println("rahulfinal");
          Supdate cu=new Supdate(accno,sn[0],sn[1],sn[2],fname,dob,gender,state,address,email,pno,qval);
         }
     }
         }
          catch(Exception ex)
          {
              
          }
      }
      else if(e.getSource()==b2)
      {
             int j=0;
           int r=jt.getSelectedRow();
           if(r==-1)
               JOptionPane.showMessageDialog(this,"Select The Row First   !!!");
           else
               try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from staff");
      System.out.println("Resultset created");
     sprofile i;
     i=al.get(r);
     String accno=i.accno;
     System.out.println(i.accno);
      int o=JOptionPane.showConfirmDialog(this,"Are You Sure ,You Want To Delete !!!");
     if(o==JOptionPane.YES_OPTION)
     {
    while(rs.next())
      {
          if(rs.getString("empno").equals(accno))
             
          {
              rs.deleteRow();
              
          }
      }
      al.remove(r);
      tm.fireTableDataChanged();
     }
     else
                 System.out.println("rahul");
         
     
      
         }
           catch(Exception ex)
           {
               System.out.println(ex.getMessage());
           }
      }
      else
          this.dispose();
  }

   

  

    

  
    
  
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    class TableModel extends AbstractTableModel
    {
        String title[] = {"EMP NO","NAME","FATHER NAME","DATE OF BIRTH","GENDER","QVALIFICATION","STATE","FULL ADDRESS","EMAIL-ID","PHONE NUMBER","DATE OF OPENING ACCOUNT"};
   

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
                return al.get(row).accno;
            else if(col==1)
                return al.get(row).name;
            else if(col==2)
                 return al.get(row).fname;
            else if(col==3)
                 return al.get(row).dob;
             else if(col==4)
                 return al.get(row).gender;
              else if(col==5)
                 return al.get(row).qval;
               else if(col==6)
                 return al.get(row).state;
                else if(col==7)
                 return al.get(row).address;
                 else if(col==8)
                 return al.get(row).email;
                  else if(col==9)
                 return al.get(row).pno;
                   else
                      return al.get(row).date;
           
           
        }
        
    }
 
}
class sprofile
{
     String accno,name,fname,dob,gender,state,address,email,date,qval;
long pno;
    sprofile(String accno, String name, String fname, String dob, String qval,String gender, String state, String address, String email, long pno, String date) 
    {
      this.accno=accno;
      this.name=name;
      this.fname=fname;
      this.dob=dob;
      this.gender=gender;
      this.state=state;
      this.address=address;
      this.email=email;
      this.pno=pno;
      this.date=date;
      this.qval=qval;
    }
   }
class B extends Thread
{
StaffProfile cp=new StaffProfile();
 sprofile i;
 
    public void run() 
    {
       //cp.dispose(); 
        while(true)
        {
              int r=cp.jt.getSelectedRow();
           if(r==-1)
              continue;
           else
           {
               
     i=cp.al.get(r);
     cp.l7.setText(i.name);
      cp.l8.setText(i.accno);
       cp.l9.setText(i.fname);
        cp.l10.setText(i.dob);
         cp.l11.setText(i.gender);
           }
   
        }
    }
    
}