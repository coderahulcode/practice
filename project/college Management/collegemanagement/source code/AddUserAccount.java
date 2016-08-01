
package collegemanagement;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class AddUserAccount extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1,t3;
    JButton b1;
    JPasswordField t2,t4;
    
    AddUserAccount()
    {
       setVisible(true);
       setTitle("Add User Account");
       setResizable(false);
       setLayout(null);
       setSize(450,350);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        l1 = new JLabel("Any Existing Username:");
        l2 = new JLabel("Password:");
        l3 = new JLabel("New Username:");
        l4 = new JLabel("Password:");
        t1 = new JTextField(25);
        t2 = new JPasswordField(25);
        t3 = new JTextField(25);
        t4 = new JPasswordField(25);
        b1 = new JButton("Add User");
        
        l1.setBounds(20,40,200,14);
        l2.setBounds(20,80,200,10);
        l3.setBounds(20,180,200,10);
        l4.setBounds(20,220,200,10);
        t1.setBounds(250,40,150,23);
        t2.setBounds(250,80,150,23);
        t3.setBounds(250,180,150,23);
        t4.setBounds(250,220,150,23);
        b1.setBounds(250,280,150,20);

        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(b1);

        b1.addActionListener(this);  
        
   
    }
  
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                String x = t1.getText();
                String y = t2.getText();
                
                String a = t3.getText();
                String b = t4.getText();
                
                try
                {
                    
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection conn = 
                   DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                   Statement stmt = 
                   conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                   ResultSet rs = 
                   stmt.executeQuery("select * from welcome");
                   
                   int flag=0;
                   while(rs.next())
                   {
                   
                     String x1 = rs.getString("username");
                     String y1 = rs.getString("password");
                   
                     if(x.equals(x1))
                     {
                       if(y.equals(y1))
                       {
                           
                           flag = 2;
                           rs.moveToInsertRow();
                           rs.updateString("username", a);
                           rs.updateString("password", b);
                           rs.insertRow();
                           
                           JOptionPane.showMessageDialog(this,"USER ADDED!!!");
                           this.dispose();
                           break;
                           
                           
                           
                           

                       }
                       else if(!(y.equals(y1)))
                       {
                           flag = 1;
                       }
                          
                     }
                     else if(!(x.equals(x1)))
                     {
                         flag = 1;
                     }           
                                          
                   }
                   
                   if(flag ==1)
                   {
                       JOptionPane.showMessageDialog(this,"Please Enter the Correct Existing Username and Password!");
                   }
                }
                catch(Exception ae)
                {
                    JOptionPane.showMessageDialog(this,"USER ALREADY EXISTS!!!");
                }
            }
            
        }
    }
