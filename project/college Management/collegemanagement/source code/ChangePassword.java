
package collegemanagement;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



class ChangePassword extends JFrame implements ActionListener
{
    JLabel epl,npl,cnpl,unl,pml;
    JTextField unt;
    JPasswordField ept,npt,cnpt;
    JButton cb;
    
    String a,b,c,d,a1,b1,x,y;
    ChangePassword()
    {
        setLayout(null);
        setTitle("Password Change");
        setVisible(true);
        setResizable(false);
        setSize(450,280);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        epl = new JLabel("Password:");
        npl = new JLabel("New Password:");
        cnpl = new JLabel("Confirm New Password:");
        unl = new JLabel("Existing Username:");
        pml = new JLabel("PASSWORD MATCHED");
        ept = new JPasswordField(25);
        npt = new JPasswordField(25);
        cnpt = new JPasswordField(25);
        unt = new JTextField(25);
        cb = new JButton("Change");
        
        unl.setBounds(30,50,170,10);
        epl.setBounds(30,80,170,10);
        npl.setBounds(30,120,170,10);
        cnpl.setBounds(30,150,170,10);
        pml.setBounds(300,150,170,15);
        unt.setBounds(190,50,100,23);
        ept.setBounds(190,80,100,23);
        npt.setBounds(190,120,100,23);
        cnpt.setBounds(190,150,100,23);
        cb.setBounds(190,200,100,20);

        
        add(epl);
        add(npl);
        add(cnpl);
        add(ept);
        add(npt);
        add(cnpt);
        add(cb);
        add(unt);
        add(unl);
        add(pml);
 
        cb.addActionListener(this);
        
        
        pml.setVisible(false);
        
    
    }

    @Override
    public void actionPerformed(ActionEvent e1) 
    {
       if(e1.getSource()==cb)
       {
            a = unt.getText();
            b = ept.getText();
            c = npt.getText();
            d = cnpt.getText();

           
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = 
                DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                Statement stmt = 
                conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                ResultSet rs = 
                stmt.executeQuery("select * from welcome");
                
                
                int flag = 0;
                while(rs.next())
                {
                   
                     a1 = rs.getString("username");
                     b1 = rs.getString("password");
                    
                    
                    if(a.equals(a1))
                    {
                          flag = 0;
                          if(b.equals(b1))
                          {
                              flag = 0;
                              if(c.equals(d))
                             {
                                 pml.setVisible(true);                                 
                                 flag = 0;
                                 rs.updateString("password",c);
                                 rs.updateRow();
                                 JOptionPane.showMessageDialog(this,"Password Changed!!!");
                                 this.dispose();
                                 break;
                            
                             }
                             else
                             {
                                 JOptionPane.showMessageDialog(this,"New Password not Confirmed!!!");
                             }
                          
                          }
                          else
                          {
                               JOptionPane.showMessageDialog(this,"INCORRECT EXISTING PASSWORD!!!");
                          }
                        
                    }
                    else
                    {
                        flag =1;
                    }
                  
                  
                
               
                
                }
                
               if(flag==1)                   
               {
                    JOptionPane.showMessageDialog(this,"Please Enter the Correct Username!");
               }
                
                
                
           }
           catch(Exception ae)
           {
               JOptionPane.showMessageDialog(this, "AN ERROR OCCURRED!! PLEASE TRY AGAIN");
           }
       }
    }

    

    
}
