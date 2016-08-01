package collegemanagement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class CollegeManagement extends JFrame implements ActionListener
{    
    CollegeManagement()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        
        StartPage sp1 = new StartPage();
        
    }
            
      
    public static void main(String[] args)
    {
       
      CollegeManagement cm1 = new CollegeManagement();
             
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
     
    
    JLabel unl,pdl;
    JTextField unt;
    JButton lb,cpb,aub; 
    JPasswordField pdt;



class StartPage extends JFrame implements ActionListener
{
     
     StartPage()
     {
         setLayout(null);
         setVisible(true);
         setTitle("Welcome");
         setSize(600,370);
         setBounds(200,200,600,370);
         setDefaultCloseOperation(EXIT_ON_CLOSE);    
         setResizable(false);
         
         unl = new JLabel("Username:");
         unt = new JTextField(25);
         pdl = new JLabel("Password:");
         pdt = new JPasswordField(25);
         lb = new JButton("Login");
         cpb = new JButton("Change Password");
         aub = new JButton("Add User Account");
         
             
         unl.setBounds(100,100,200,20);
         unt.setBounds(230,100,150,25);
         pdl.setBounds(100,150,200,20);
         pdt.setBounds(230,150,150,25);
         lb.setBounds(230,200,150,20);
         cpb.setBounds(430,150,150,20);
         aub.setBounds(230,250,150,20);

         
         add(unl);
         add(unt);
         add(pdl);
         add(pdt);
         add(lb);
         add(cpb);
         add(aub);

         cpb.addActionListener(this);
         aub.addActionListener(this);
         lb.addActionListener(this);       
         unt.addActionListener(this);
                 

         
         
     }
     
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==cpb)
        {
            ChangePassword cp1 = new ChangePassword();
            cp1.setBounds(200,200,450,280);
        }
        else if(e.getSource()==aub)
        {
            AddUserAccount au1 = new AddUserAccount();
            au1.setBounds(200,200,450,350);
        }
        else if(e.getSource()==unt)
                   
        {
            String x ="";
            if(unt.getText().equals(x))
            {
                cpb.setEnabled(false);
            }
            else
            {
                cpb.setEnabled(true);
            }
        }
        else if(e.getSource()==lb)
        {

            String x = unt.getText();
            String y = pdt.getText();
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = 
                DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                Statement stmt = 
                conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                ResultSet rs = 
                stmt.executeQuery("select * from welcome");
//                ResultSet rs1 = 
//                stmt.executeQuery("select password from welcome");
                int flag =0;  
                while(rs.next())
                {
                    String x1 = rs.getString("username");
                    String y1 = rs.getString("password");
                    
                    if(x.equals(x1))
                    {
                        if(y.equals(y1))
                            
                        {
                               
                                flag = 1;
                                
                        }
                        else
                        {
                                
                                flag = 0;
                        }
                      
                    }
                }
                
                     
                    if(flag ==1)
                    {
                         Home h1 = new Home();
                         h1.setBounds(220,200,480,400);
                         this.setVisible(false);
                         
                         
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Invalid username or password");
                    }
                   
                    
                    
                }
                        
            catch(Exception ae)
                       
            {
               ae.printStackTrace();
         
            }
        }
    }
       
    }


//class FinancialStatus extends JFrame implements ActionListener
//{
//    
//       
//    JButton b1,b2,b3,b4;
//    
//    
//    FinancialStatus()
//    {
//       
//    setVisible(true);
//    setTitle("Financial Status");
//    setResizable(false);
//    setLayout(null);
//    setSize(350,200);
//    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        
//        
//        b1 = new JButton("STAFF SALARIES");
//        b2 = new JButton("STUDENT FEES");
//        b3 = new JButton("MONEY GRANTS");
//        b4 = new JButton("OTHER EXPENSES");
//        
//        b1.setBounds(10,30,140,25);
//        b2.setBounds(160,30,140,25);
//        b3.setBounds(10,100,140,25);
//        b4.setBounds(160,100,140,25);
//
//        
//        
//        add(b1);
//        add(b2);
//        add(b3);
//        add(b4);
//        
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//        b4.addActionListener(this);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getSource()==b1)
//        {
//            A1 a1 = new A1();
//            a1.setTitle("Staff Salaries");
//        }
//        else if(e.getSource()==b2)
//        {
//            A1 a2 = new A1();
//            a2.setTitle("Student Fees");
//        }
//        else if(e.getSource()==b3)
//        {
//            A1 a3 = new A1();
//            a3.setTitle("Money Grants");
//        }
//        else
//        {
//           
//
//        }
//        
//       
//    }
//    
//   
//    }

class A1 extends JFrame
{
    JButton b1,b2,b3,b4;
    JTable jt1;
    JScrollPane sp1;
    A1()
    {
    setVisible(true);
    setResizable(false);
    setLayout(null);
    setSize(600,520);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        
        sp1 = new JScrollPane(jt1);
        b1 = new JButton("ADD");
        b2 = new JButton("UPDATE");
        b3 = new JButton("DELETE");
        b4 = new JButton("REFRESH");
        
    

      
       b1.setBounds(20,400,120,30);
       b2.setBounds(400,400,120,30);
       b3.setBounds(20,450,120,30);
       b4.setBounds(400,450,120,30);
 
       
       sp1.setBounds(20,90,500,300);
       
        
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
        
    }
}

class Home extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6; 
    Home()
    {
    setVisible(true);
    setTitle("HOME");
    setResizable(false);
    setLayout(null);
    setSize(480,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        b1 = new JButton("ADMISSIONS");
        b2 = new JButton("FINANCE");
        b3 = new JButton("EMPLOYEES");
        b4 = new JButton("LIBRARY MANAGEMENT");
        b5 = new JButton("STUDENTS");
        b6 = new JButton("HOSTEL MANAGEMENT"); 
        
        b5.setBounds(30,30,170,50);
       // b2.setBounds(10,60,150,20);
        b4.setBounds(260,30,170,50);
        b1.setBounds(30,110,170,50);
        b6.setBounds(260,110,170,50);
        b3.setBounds(30,190,170,50);

        
        
        add(b1);
       // add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        
        b1.addActionListener(this);
       // b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            Admissions ad1 = new Admissions();
            ad1.setBounds(200,200,600,520);
            
            
        }
        
        else if(e.getSource()==b3)
        {
            Employees e1 = new Employees();
            e1.setBounds(200,200,600,520);
        }
        else if(e.getSource()==b4)
        {
            Library l2 = new Library();
            l2.setBounds(200,200,320,250);
        }
        else if(e.getSource()==b5)
        {
            Students s1 = new Students();
            s1.setBounds(200,200,300,250);
            
        }
        else if(e.getSource()==b6)
        {
            Hostel h1 = new Hostel();
            h1.setBounds(200,200,300,220);
        }
    }

        
    }
}

