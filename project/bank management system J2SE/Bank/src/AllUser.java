import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;



public class AllUser extends JFrame implements ActionListener
{
   public ArrayList<users> al;
    TableModel tm;
    JTable jt;
     JScrollPane sp;
     JLabel l1;
      Font f1;
     Point p;
     JButton b1,b2;
     int c=0,n,e=0;
    AllUser()
            {
              super("USERS");
     
            }
    public void AU()
    {
           
        setVisible(true);
        setLayout(null);
         p=new Point(500,200);
         this.setLocation(p);
        setSize(500,500);
        al = new ArrayList<users>();
        tm = new TableModel();
        jt=new JTable();
         Icon ic=new ImageIcon("E://languages//java//Bank//src//pics//add-user-icon.jpg");
           Icon ic1=new ImageIcon("E://languages//java//Bank//src//pics//add_user.png");
        l1=new JLabel("USERS");
        b1=new JButton("Add New User");
        b2=new JButton("Delete User");
        b2.setIcon(ic1);
        f1=new Font("Times New Roman",Font.BOLD,20);
        l1.setFont(f1);
        l1.setBounds(200,20,100,30);
        b1.setBounds(60, 380,175, 60);
        b2.setBounds(285,380,175,60);
        b1.setIcon(ic);
        add(b1);
        add(b2);
        jt.setModel(tm);
        sp=new JScrollPane(jt);
        sp.setBounds(60, 60, 400,300);
        this.setResizable(false);
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
      int id;
      String name;
      while(rs.next())
      {
          ++n;
          id= rs.getInt("user id");
          name= rs.getString("name");
          al.add(new users(id,name,n));
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
            System.out.println("rahul");}
         add(sp);
         //add(jt);
         jt.setModel(tm);
         add(l1);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        b1.addActionListener(this);
         b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            AddNewUser anu=new AddNewUser();
        }
        else
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

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from users");
      System.out.println("Resultset created");
      users i;
     i=al.get(r);
     int id1=i.id;
     System.out.println(i.id);
      int o=JOptionPane.showConfirmDialog(this,"Are You Sure ,You Want To Delete !!!");
     if(o==JOptionPane.YES_OPTION)
     {
    while(rs.next())
      {
          if(rs.getInt("user id")==id1)
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
    }
     class TableModel extends AbstractTableModel
    {
        String title[] = {"S.No","USER ID","NAME"};
   
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
            {
                
                 
                
               return al.get(row).n;
                
            }
           else if(col==01)
                return al.get(row).id;
            else 
                return al.get(row).name;
           
        }
        
    }
    public static void main(String[] args) 
    {
        AllUser au=new AllUser();
    au.AU();
    }
}
class users
{
    int id;
    String name;
  int n;

    public users(int id, String name,int n)
    {
        this.id = id;
        this.name = name;
        this.n=n;
    }
   }