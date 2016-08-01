
package collegemanagement;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Library extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6;
    Library()
    {
        setVisible(true);
        setTitle("TOOLS");
        setResizable(false);
        setLayout(null);
        setSize(320,250);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        b1 = new JButton("SEARCH BOOKS");
        b2 = new JButton("ADD BOOKS");
        b3 = new JButton("ISSUE BOOK");
        b4 = new JButton("VIEW ISSUED BOOKS");
        b5 = new JButton("DELETE BOOKS");
        b6 = new JButton("UNISSUE BOOK");
        
        b1.setBounds(10,20,140,50);
        b5.setBounds(10,90,140,50);
        b6.setBounds(10,160,140,50);
        b2.setBounds(160,20,140,50);
        b3.setBounds(160,90,140,50);
        //b4.setBounds(160,120,140,50);
        
        add(b1);
        add(b2);
        add(b3);
        //add(b4);
        add(b5);
        add(b6);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
                                                
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {

            class A1 extends JFrame implements ActionListener
            {
                JLabel lb1,lb2,lb3;
                JTextField tf1,tf2,tf3;
                JButton bt1;
                
                A1()
                {
                    setVisible(true);
                    setTitle("ADD BOOK");
                    setResizable(false);
                    setLayout(null);
                    setSize(320,300);
                    setBounds(200,200,320,300);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("BOOK NAME:");
                    lb2 = new JLabel("BOOK ID:");
                    lb3 = new JLabel("AUTHOR'S NAME:");
                    
                    tf1 = new JTextField(25);
                    tf2 = new JTextField(25);
                    tf3 = new JTextField(25);
                    
                    bt1 = new JButton("ADD");
                    
                    lb1.setBounds(15,10,100,20);
                    lb2.setBounds(15,70,100,20);
                    lb3.setBounds(15,140,100,20);
                    tf1.setBounds(15,40,150,23);
                    tf2.setBounds(15,100,150,23);
                    tf3.setBounds(15,170,150,23);
                    bt1.setBounds(15,210,100,30);
                    
                    add(lb1);
                    add(lb2);
                    add(lb3);
                    add(tf1);
                    add(tf2);
                    add(tf3);
                    add(bt1);
                    
                    bt1.addActionListener(this);
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt1)
                    {
                        String v1,v2,v3;
                        
                        v1 = tf1.getText().toUpperCase();
                        v2 = tf2.getText().toUpperCase().trim();
                        v3 = tf3.getText().toUpperCase();
                        
                        int flag = 0;
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"BOOK NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
                        }
                        
                        for(int i=0;i<v3.length();i++)
                        {
                            if(v3.charAt(i)<65 || v3.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"AUTHOR'S NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
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
                            stmt.executeQuery("select * from library");   
                            
                            rs.moveToInsertRow();
                            rs.updateString("bname", v1);
                            try
                            {
                                rs.updateLong("bid", Long.parseLong(v2));
                            }
                            catch(NumberFormatException ar1)
                            {
                                JOptionPane.showMessageDialog(this,"BOOK ID SHOULD ONLY BE IN NUMERICS!!");
                            }
                            
                            
                            rs.updateString("author", v3);
                            rs.updateString("status","");
                            rs.updateLong("regno",0);
                            rs.insertRow();
                            
                            JOptionPane.showMessageDialog(this,"BOOK ADDED!!!");
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
            
            A1 a11 = new A1();           
            
        }
        
        
        
        else if(e.getSource()==b5)
        {
            class A2 extends JFrame implements ActionListener 
            {
                JLabel lb1;
                JTextField tf1;
                JButton bt1;
                A2()
                {
                    setVisible(true);
                    setTitle("DELETE BOOK");
                    setResizable(false);
                    setLayout(null);
                    setSize(200,200);
                    setBounds(200,200,200,200);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER BOOK ID:");
                    tf1 = new JTextField(25);
                    bt1 = new JButton("DELETE");
                    
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
                       
                        try
                        {
                             long x = Long.parseLong(tf1.getText());
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from library where bid="+x);   
                            
                            if(rs.next())
                            {
                                rs.deleteRow();
                                JOptionPane.showMessageDialog(this,"BOOK DELETED!!!");
                                this.dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this,"BOOK DOES NOT EXIST!!!");
                            }
                            
                                                        
                            
                        }
                        catch(Exception e1)
                        {
                            JOptionPane.showMessageDialog(this,"INVALID BOOK ID!!");
                        }
                        
                    }
                    
                }
                
            }
            
            A2 a21 = new A2();
        }
        
        else if(e.getSource()==b1)
        {
            class A3 extends JFrame implements ActionListener
            {
                JLabel lb1;
                JTextField tf1;
                JButton bt1;
                A3()
                {
                    setVisible(true);
                    setTitle("SEARCH BOOK");
                    setResizable(false);
                    setLayout(null);
                    setSize(200,200);
                    setBounds(200,200,200,200);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER BOOK ID:");
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
                        
                        try
                        {
                            long x1 = Long.parseLong(tf1.getText());
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from library where bid ="+x1); 
                            
                            
                            if(rs.next())
                            {
                                String a = rs.getString("status");
                                long b = rs.getLong("regno");
                                
                                if(a.trim().equals("ISSUED"))
                                {
                                    JOptionPane.showMessageDialog(this,"THE BOOK IS ISSUED TO A STUDENT WITH "
                                            + "REG. NO. "+b);
                                }
                                else if(!(a.trim().equals("ISSUED")))
                                {
                                    JOptionPane.showMessageDialog(this,"THE BOOK IS AVAILABLE IN THE LIBRARY!!");
                                }
                            }
                            else
                            {
                                    JOptionPane.showMessageDialog(this,"THE BOOK IS NOT AVAILABLE IN THE LIBRARY!!!");

                            }
                            
                            
                                
                                                      
                            
                        }
                        catch(Exception e1)
                        {
                            JOptionPane.showMessageDialog(this,"INVALID BOOK ID!!!");
                            e1.printStackTrace();
                        }
                    }
                    
                }
                
            }
            
            A3 a31 = new A3();
        }
        
        else if(e.getSource()==b3)
        {
            class A4 extends JFrame implements ActionListener 
            {
                JLabel lb1,lb2;
                JTextField tf1,tf2;
                JButton bt1;
                A4()
                {
                    setVisible(true);
                    setTitle("ISSUE BOOK");
                    setResizable(false);
                    setLayout(null);
                    setSize(230,230);
                    setBounds(200,200,230,230);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER BOOK ID:");
                    lb2 = new JLabel("ENTER STUDENT REG. NO:");
                    tf2 = new JTextField(25);
                    tf1 = new JTextField(25);
                    bt1 = new JButton("ISSUE");
                    
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
                        int flag =0;
                        
                        if(tf2.getText().trim().length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST BE OF 10 DIGITS!!");
                            flag =1;
                        }
                        
                        if(flag ==0)
                        {
                            long x,y;
                        x = Long.parseLong(tf1.getText().trim());
                        y = Long.parseLong(tf2.getText().trim());
                        
                        
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from library where bid="+x);   
                            
                            if(rs.next())
                            {
                                rs.updateString("status","ISSUED");
                                try
                                {
                                    rs.updateLong("regno", y);
                                }
                                catch(NumberFormatException ar2)
                                {
                                    JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST NOT CONTAIN ALPHABETS!!");
                                }
                                
                                
                                rs.updateRow();
                            }
                            
                            JOptionPane.showMessageDialog(this,"BOOK ISSUED!!!");
                            this.dispose();                            
                            
                        }
                        catch(Exception e1)
                        {
                            JOptionPane.showMessageDialog(this,"INVALID BOOK ID!!");
                        }
                        }
                        
                        
                    }
                    
                }
                
            }
            
            A4 a41 = new A4();
        }
        
        else if(e.getSource()==b6)
        {
            class A5 extends JFrame implements ActionListener 
            {
                JLabel lb1,lb2;
                JTextField tf1,tf2;
                JButton bt1;
                A5()
                {
                    setVisible(true);
                    setTitle("UNISSUE BOOK");
                    setResizable(false);
                    setLayout(null);
                    setSize(230,230);
                    setBounds(200,200,230,230);
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    lb1 = new JLabel("ENTER BOOK ID:");
                    lb2 = new JLabel("ENTER STUDENT REG. NO:");
                    tf2 = new JTextField(25);
                    tf1 = new JTextField(25);
                    bt1 = new JButton("UNISSUE");
                    
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
                        String v1,v2;
                        
                        v1 = tf1.getText().toUpperCase().trim();
                        v2 = tf2.getText().toUpperCase().trim();
                        
                        int flag = 0;
                        
                        
                        if(v2.length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST BE OF 10 DIGITS!!");
                            flag =1;
                        }
                        
                         long x,y;
                        try
                        {
                            x = Long.parseLong(v1);
                        }
                        catch(NumberFormatException as1)
                        {
                            JOptionPane.showMessageDialog(this,"INVALID BOOK ID!!");
                            flag = 1;
                        }
                        
                        
                        try
                        {
                            y = Long.parseLong(v2);
                        }
                        catch(NumberFormatException as1)
                        {
                            flag =1;
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER SHOULD ONLY CONTAIN NUMERICAL DIGITS!!");
                        }
                        
                        if(flag ==0)
                        {
                            try
                        {
                            x = Long.parseLong(v1);
                            y = Long.parseLong(v2);
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from library where bid="+x);   
                            
                            
                            
                            
                            
                            
                            
                                if(rs.next())
                           
                                {
                                    
                                    long y1 = rs.getLong("regno");
                                    
                                    if(y==y1)
                                    {
                                        rs.updateString("status","");
                                        rs.updateLong("regno",0);
                                        rs.updateRow();
                                        JOptionPane.showMessageDialog(this,"BOOK UNISSUED!!!");
                                        this.dispose();   
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(this,"THE BOOK IS NOT ISSUED TO THE ENTERED REGISTRATION NUMBER!!");
                                    }
                                
                            
                                }
                            
                            
                            
                                
                            
                            
                                                     
                            
                        }
                        catch(Exception e1)
                        {
                            JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!");
                            e1.printStackTrace();
                        }
                        }
                       
                        
                        
                        
                        
                    }
                    
                }
                
            }
            
            A5 a51 = new A5();
        }
    }
    
}
