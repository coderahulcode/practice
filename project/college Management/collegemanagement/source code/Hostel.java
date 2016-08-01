package collegemanagement;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Hostel extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    Hostel()
    {
        setVisible(true);
        setTitle("TOOLS");
        setResizable(false);
        setLayout(null);
        setSize(300,220);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        b1 = new JButton("SEARH ROOM");
        b2 = new JButton("ALLOCATE ROOM");
        b3 = new JButton("UNALLOCATE ROOM");
        
        b1.setBounds(15,15,150,40);
        b2.setBounds(15,70,150,40);
        b3.setBounds(15,125,150,40);
        
        add(b1);
        add(b2);
        add(b3);
        
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource()==b1)
            {
                class A11 extends JFrame implements ActionListener
            {
                JLabel lb1;
                JTextField tf1;
                JButton bt1;
                A11()
                {
                    setVisible(true);
                    setTitle("SEARCH ROOM");
                    setResizable(false);
                    setLayout(null);
                    setSize(200,200);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER ROOM NO:");
                    tf1 = new JTextField(25);
                    bt1 = new JButton("SEARCH");
                    
                    lb1.setBounds(15,15,150,20);
                    tf1.setBounds(15,45,150,23);
                    bt1.setBounds(15,80,100,30);
                    
                    add(lb1);
                    add(tf1);
                    add(bt1);
                    
                    bt1.addActionListener(this);
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt1)
                    {
                        long x = Long.parseLong(tf1.getText()); 
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from hostel where rno ="+x);
                            
                            if(rs.next())
                            {
                                long y = rs.getLong("regno");
                                JOptionPane.showMessageDialog(this,"THE ROOM IS ALLOCATED TO REG. NO "+y);
                                this.dispose();
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"THE ROOM IS NOT ALLOCATED!!");
                                this.dispose();

                            }
                            
                            
                            
                        }
                        
                        catch(Exception e1)
                        {
                           JOptionPane.showMessageDialog(this,"INVALID ROOM NUMBER!!");
                        }
                    }
                    
                }
                
            }
            
            A11 a31 = new A11();
            a31.setBounds(200,200,200,200);
            }
            else if(e.getSource()==b2)
            {
                
                
                class A21 extends JFrame implements ActionListener 
              {
                JLabel lb1,lb2;
                JTextField tf1,tf2;
                JButton bt1;
                A21()
                {
                    setVisible(true);
                    setTitle("ALLOCATE ROOM");
                    setResizable(false);
                    setLayout(null);
                    setSize(230,230);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER ROOM NO:");
                    lb2 = new JLabel("ENTER STUDENT REG. NO:");
                    tf2 = new JTextField(25);
                    tf1 = new JTextField(25);
                    bt1 = new JButton("ALLOCATE");
                    
                    lb1.setBounds(15,15,170,20);
                    tf1.setBounds(15,45,170,23);
                    lb2.setBounds(15,80,170,20);
                    tf2.setBounds(15,110,170,23);
                    bt1.setBounds(15,150,100,30);
                    
                    add(lb1);
                    add(tf1);
                    add(lb2);
                    add(tf2);
                    add(bt1);
                    
                    bt1.addActionListener(this);
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt1)
                    {
                        int flag = 0;
                        
                        if(tf2.getText().trim().length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST BE OF 10 DIGITS!!");
                            flag =1;
                        }
                        
                        
                        
                        if(flag==0)
                        {
                             
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from hostel");   
                            
                            rs.moveToInsertRow();
                            try
                            {
                                rs.updateLong("rno", Long.parseLong(tf1.getText().trim()));
                            }
                            catch(NumberFormatException aew1)
                            {
                                JOptionPane.showMessageDialog(this,"INVALID ROOM NUMBER!!");
                            }
                            
                            try
                            {
                                rs.updateLong("regno", Long.parseLong(tf2.getText().trim()));
                            }
                            catch(NumberFormatException aew2)
                            {
                                JOptionPane.showMessageDialog(this,"INVALID REGISTRATION NUMBER!!");
                            }
                            
                            
                            
                            
                            rs.updateString("status","ALLOCATED");
                            rs.insertRow();
                            
                            JOptionPane.showMessageDialog(this,"ROOM ALLOCATED!!!");
                            this.dispose();                            
                            
                        }
                        catch(Exception e1)
                        {
                            JOptionPane.showMessageDialog(this,"PLEASE ENTER VALID DATA!!");
                        }
                        }
                        
                        
                       
                    }
                    
                }
                
            }
            
            A21 a41 = new A21();
            a41.setBounds(200,200,230,230);
                
                
            }
            else if(e.getSource()==b3)
            {
                
                class A31 extends JFrame implements ActionListener 
            {
                JLabel lb1,lb2;
                JTextField tf1,tf2;
                JButton bt1;
                A31()
                {
                    setVisible(true);
                    setTitle("UNALLOCATE ROOM");
                    setResizable(false);
                    setLayout(null);
                    setSize(230,230);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER ROOM NO:");
                    lb2 = new JLabel("ENTER STUDENT REG. NO:");
                    tf2 = new JTextField(25);
                    tf1 = new JTextField(25);
                    bt1 = new JButton("UNALLOCATE");
                    
                    lb1.setBounds(15,15,170,20);
                    tf1.setBounds(15,45,170,23);
                    lb2.setBounds(15,80,170,20);
                    tf2.setBounds(15,110,170,23);
                    bt1.setBounds(15,150,130,30);
                    
                    add(lb1);
                    add(tf1);
                    add(lb2);
                    add(tf2);
                    add(bt1);
                    
                    bt1.addActionListener(this);
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt1)
                    {
                        
                        try
                            
                        {
                            long x,y;
                        x = Long.parseLong(tf1.getText());
                        y = Long.parseLong(tf2.getText());
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from hostel where rno ="+x);   
                            
                            if(rs.next())
                            {
                                rs.deleteRow();
                            }
                            
                            JOptionPane.showMessageDialog(this,"ROOM UNALLOCATED!!!");
                            this.dispose();                            
                            
                        }
                        catch(Exception e1)
                        {
                            //e1.printStackTrace();
                            JOptionPane.showMessageDialog(this,"PLEASE ENTER VALID REGISTRATION AND ROOM NUMBER!!!");
                        }
                    }
                    
                }
                
            }
            
            A31 a51 = new A31();
            a51.setBounds(200,200,230,230);
                
                
                
            }
    }
    
}
