package collegemanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Students extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4;
    Students()
    {
        setVisible(true);
        setTitle("EMPLOYEES");
        setResizable(false);
        setLayout(null);
        setSize(300,250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        b1 = new JButton("ADD STUDENT DATA");
        b2 = new JButton("UPDATE STUDENT DATA");
        b3 = new JButton("VIEW STUDENT DATA");
        b4 = new JButton("DELETE STUDENT DATA");
        
        b1.setBounds(15,15,200,35);
        b3.setBounds(15,70,200,35);
        b2.setBounds(15,125,200,35);
        b4.setBounds(15,180,200,35);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            class A1 extends JFrame implements ActionListener
            {
                JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
                JTextField tf1,tf2,tf3,tf5,tf6,tf8,tf9;
                JButton bt1;
                JTextArea ta7;
                JComboBox c4,c51,c52,c53;
                JScrollPane sp4,sp51,sp52,sp53;
                JPanel p1;
                A1()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(600,600);
                     setBounds(150,150,600,600);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("ADD STUDENT DATA");
                     
                     lb1 = new JLabel("NAME:");
                     lb2 = new JLabel("GUARDIAN'S NAME:");
                     lb3 = new JLabel("REGISTRATION NO:");
                     lb4 = new JLabel("DEPARTMENT:");
                     lb5 = new JLabel("DATE OF BIRTH:");
                     lb6 = new JLabel("GUARDIAN'S CONTACT NO:");
                     lb7 = new JLabel("ADDRESS:");
                     lb8 = new JLabel("EMAIL ADDRESS:");
                     lb9 = new JLabel("CONTACT NO:");
                     
                     tf1 = new JTextField(25);
                     tf2 = new JTextField(25);
                     tf3 = new JTextField(25);
                     c4 = new JComboBox();
                     tf5 = new JTextField(25);
                     tf6 = new JTextField(25);
                     ta7 = new JTextArea(8,1);
                     tf8 = new JTextField(25);
                     tf9 = new JTextField(25);
                     
                     c51 = new JComboBox();
                     c52 = new JComboBox();
                     c53 = new JComboBox();

//                     sp51 = new JScrollPane(c51);
//                     sp52 = new JScrollPane(c52);
//                     sp53 = new JScrollPane(c53);
                     
                     sp4 = new JScrollPane(ta7);
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                           "IT","MECHANICAL","ELECTRICAL"};
                     
                     String s52[] = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY"
                     ,"AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c4.addItem(s11[i]);
                     }
                     
                     for(int i=1;i<=31;i++)
                     {
                         c51.addItem(i+"");
                     }
                      
                     for(int i=0;i<s52.length;i++)
                     {
                         c52.addItem(s52[i]);
                     }
                     
                     for(int i=1900;i<=2010;i++)
                     {
                         c53.addItem(i+"");
                     }
                     
                     
                     c4.setEditable(false);
                     c51.setEditable(false);
                     c52.setEditable(false);
                     c53.setEditable(false);
                     
                     bt1 = new JButton("ADD DATA");
                     
                     lb1.setBounds(20,20,200,30);
                     lb2.setBounds(20,70,200,30);
                     lb3.setBounds(20,120,200,30);
                     lb4.setBounds(20,170,200,30);
                     lb5.setBounds(20,220,200,30);
                     lb6.setBounds(20,270,200,30);
                     lb7.setBounds(20,320,200,30);
                     lb8.setBounds(20,410,200,30);
                     lb9.setBounds(20,460,200,30);
                     tf1.setBounds(250,20,200,30);
                     tf2.setBounds(250,70,200,30);
                     tf3.setBounds(250,120,200,30);
                     c4.setBounds(250,170,200,30);
                     //tf5.setBounds(250,220,200,30);
                     c51.setBounds(250,220,50,30);
                     c52.setBounds(300,220,100,30);
                     c53.setBounds(400,220,70,30);
                     
                     tf6.setBounds(250,270,200,30);
                     sp4.setBounds(250,320,200,70);
                     tf8.setBounds(250,410,200,30);
                     tf9.setBounds(250,460,200,30);
                     bt1.setBounds(250,510,150,50);
                     
                     add(lb1);
                     add(lb2);
                     add(lb3);
                     add(lb4);
                     add(lb5);
                     add(lb6);
                     add(lb7);
                     add(lb8);
                     add(lb9);
                     add(tf1);
                     add(tf2);
                     add(tf3);
                     add(c4);
                     //add(tf5);
                     add(tf6);
                     add(sp4);
                     add(tf8);
                     add(tf9);
                     add(bt1);
                     add(c51);
                     add(c52);
                     add(c53);
                     
                     bt1.addActionListener(this);
                     
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    
                    if(e.getSource()==bt1)
                    {
                        String c1,c2,c3;
                        c1 = c51.getSelectedItem().toString();
                        c2 = c52.getSelectedItem().toString();
                        c3 = c53.getSelectedItem().toString();
                        
                        
                        
                        String v1,v2,v3,v4,v5,v6,v7,v8,v9;
                        
                        v1 = tf1.getText();
                        v2 = tf2.getText();
                        v3 = tf3.getText();
                        v4 = c4.getSelectedItem().toString();
                        v5 = c1+"/"+c2+"/"+c3;
                        v6 = tf6.getText();
                        v7 = ta7.getText();
                        v8 = tf8.getText();
                        v9 = tf9.getText();

                        
                        
                        v1 = v1.toUpperCase().trim();
                        v2 = v2.toUpperCase().trim();
                        v3 = v3.trim().toUpperCase();
                        v4 = v4.toUpperCase().trim();
                        v5 = v5.toUpperCase().trim();
                        v6 = v6.trim().toUpperCase();
                        v7 = v7.toUpperCase().trim();
                        v8 = v8.toUpperCase().trim();
                        v9 = v9.trim().toUpperCase();
                        
                        int flag =0;
                        
                        if(v1.equals("") || v2.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELDS SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
                        }
                        
                        for(int i=0;i<v2.length();i++)
                        {
                            if(v2.charAt(i)<65 || v2.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"GUARDIAN'S NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
                        }
                        int flag1 = 0;
                        for(int i = 0;i<v8.length();i++)
                        {
                            if(v8.charAt(i)==64)
                            {
                                flag1 = 1;
                                break;
                            }
                            
                        }
                        if(flag1==0)
                        {
                            JOptionPane.showMessageDialog(this,"NOT A VALID EMAIL ADDRESS!!");
                            flag =1;
                        }
                        
                        
                        
                        if(v3.length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION MUST BE OF 10 DIGITS!!!");
                            flag=1;
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
                            stmt.executeQuery("select * from students"); 
                            
                            rs.moveToInsertRow();
                            rs.updateString("name",v1);
                            rs.updateString("gname", v2);
                            
                            try{
                                rs.updateLong("regno",Long.parseLong(v3));
                                
                            }
                            catch(NumberFormatException e8)
                            {
                                JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER CANNOT BE IN ALPHABETS!!");
                            }
                            
                            try
                            {
                                rs.updateLong("gcno",Long.parseLong(v6));
                                rs.updateLong("cno",Long.parseLong(v9));
                                
                            }
                            catch(NumberFormatException e9)
                            {
                                JOptionPane.showMessageDialog(this,"CONTACT NUMBER MUST NOT CONTAIN ALPHABETS!!");
                            }
                            
                            rs.updateString("trade",v4);
                            
                            try 
                            {
                                rs.updateString("dob", v5);
                            }
                            catch(NumberFormatException e10)
                            {
                                JOptionPane.showMessageDialog(this,"DATE MUST BE IN PROPER FORMAT: YYYY-MM-DD");
                            }
                            
                            
                            rs.updateString("add",v7);
                            rs.updateString("eadd", v8);
                            
                            rs.insertRow();
                            
                            JOptionPane.showMessageDialog(this,"DATA ADDED DUCCESFULLY!!");
                            this.dispose();
                            
                            
                        
                        }
                        catch(Exception e2)
                        {
                            JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!");
                            e2.printStackTrace();
                        }
                            
                            
                        }
                        
                        
                        
                    }
                    
                    
                    
                    
                   
                    
                }
            }
            A1 a11 = new A1();
        }
        else if(e.getSource()==b2)
        {
            
            
            class A31 extends JFrame implements ActionListener
            {
                
                JLabel lb;
                JTextField tf;
                JButton bt;
                A31()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(350,250);
                     setBounds(200,200,350,250);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("UPDATE STUDENT DATA");
                     
                     lb = new JLabel("ENTER THE REGISTRATION NO. OF THE STUDENT:");
                     tf = new JTextField(25);
                     bt = new JButton("SUBMIT");
                     
                     lb.setBounds(20,20,300,30);
                     tf.setBounds(20,70,200,30);
                     bt.setBounds(20,130,200,30);

                     add(lb);
                     add(tf);
                     add(bt);
                     
                     bt.addActionListener(this);
                     
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    
                    if(e.getSource()==bt)
                    {
                        
                        
               class A3 extends JFrame implements ActionListener
            
               {
                JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
                JTextField tf1,tf2,tf3,tf5,tf6,tf8,tf9;
                JButton bt1;
                JTextArea ta7;
                JComboBox c4,c51,c52,c53;
                JScrollPane sp4;
                A3()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(600,600);
                     setBounds(150,150,600,600);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("UPDATE STUDENT DATA");
                     
                     lb1 = new JLabel("NAME:");
                     lb2 = new JLabel("GUARDIAN'S NAME:");
                     lb3 = new JLabel("REGISTRATION NO.:");
                     lb4 = new JLabel("DEPARTMENT:");
                     lb5 = new JLabel("DATE OF BIRTH:");
                     lb6 = new JLabel("GUARDIAN'S CONTACT NO:");
                     lb7 = new JLabel("ADDRESS:");
                     lb8 = new JLabel("EMAIL ADDRESS:");
                     lb9 = new JLabel("CONTACT NO:");
                     
                     tf1 = new JTextField(25);
                     tf2 = new JTextField(25);
                     tf3 = new JTextField(25);
                     c4 = new JComboBox();
                     tf5 = new JTextField(25);
                     tf6 = new JTextField(25);
                     ta7 = new JTextArea(8,1);
                     tf8 = new JTextField(25);
                     tf9 = new JTextField(25);
                     c51 = new JComboBox();
                     c52 = new JComboBox();
                     c53 = new JComboBox();

                     
                     sp4 = new JScrollPane(ta7);
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                           "IT","MECHANICAL","ELECTRICAL"};
                     
                     String s52[] = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY"
                     ,"AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c4.addItem(s11[i]);
                     }
                     
                     for(int i=1;i<=31;i++)
                     {
                         c51.addItem(i+"");
                     }
                      
                     for(int i=0;i<s52.length;i++)
                     {
                         c52.addItem(s52[i]);
                     }
                     
                     for(int i=1900;i<=2010;i++)
                     {
                         c53.addItem(i+"");
                     }
                     
                     c4.setEditable(false);
                     c51.setEditable(false);
                     c52.setEditable(false);
                     c53.setEditable(false);
                     
                     bt1 = new JButton("UPDATE DATA");
                     
                     
                     
                     lb1.setBounds(20,20,200,30);
                     lb2.setBounds(20,70,200,30);
                     lb3.setBounds(20,120,200,30);
                     lb4.setBounds(20,170,200,30);
                     lb5.setBounds(20,220,200,30);
                     lb6.setBounds(20,270,200,30);
                     lb7.setBounds(20,320,200,30);
                     lb8.setBounds(20,410,200,30);
                     lb9.setBounds(20,460,200,30);
                     tf1.setBounds(250,20,200,30);
                     tf2.setBounds(250,70,200,30);
                     tf3.setBounds(250,120,200,30);
                     c4.setBounds(250,170,200,30);
                     //tf5.setBounds(250,220,200,30);
                     c51.setBounds(250,220,50,30);
                     c52.setBounds(300,220,100,30);
                     c53.setBounds(400,220,70,30);
                     tf6.setBounds(250,270,200,30);
                     sp4.setBounds(250,320,200,70);
                     tf8.setBounds(250,410,200,30);
                     tf9.setBounds(250,460,200,30);
                     bt1.setBounds(250,510,150,50);
                     
                     add(lb1);
                     add(lb2);
                     add(lb3);
                     add(lb4);
                     add(lb5);
                     add(lb6);
                     add(lb7);
                     add(lb8);
                     add(lb9);
                     add(tf1);
                     add(tf2);
                     add(tf3);
                     add(c4);
                     //add(tf5);
                     add(tf6);
                     add(sp4);
                     add(tf8);
                     add(tf9);
                     add(bt1);
                     add(c51);
                     add(c52);
                     add(c53);
                     
                     bt1.addActionListener(this);
                     
                     
                     try
                     {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from students where regno ="+Long.parseLong(tf.getText()));
                            
                            String u1="",u2="",u4="",u5="",u7="",u8="";
                            long u3=0,u6=0,u9=0;
                            
                            if(rs.next())
                            {
                                u1 = rs.getString("name");
                                u2 = rs.getString("gname");
                                u3 = rs.getLong("regno");
                                u4 = rs.getString("trade");
                                u5 = rs.getString("dob");
                                u6 = rs.getLong("gcno");
                                u7 = rs.getString("add");
                                u8 = rs.getString("eadd");
                                u9 = rs.getLong("cno");
                            }
                            else
                            {
                                this.dispose();
                                JOptionPane.showMessageDialog(this,"STUDENT DATA DOES NOT EXIST!!");
                                
                            }
                            
                            tf1.setText(u1);
                            tf2.setText(u2);
                            tf3.setText(u3+"");
                            c4.setSelectedItem(u4);
                            //tf5.setText(u5);
                            String c[] = u5.split("/");
                            c51.setSelectedItem(c[0]);
                            c52.setSelectedItem(c[1]);
                            c53.setSelectedItem(c[2]);
                            
                            tf6.setText(u6+"");
                            ta7.setText(u7);
                            tf8.setText(u8);
                            tf9.setText(u9+"");
                            
                            
                            
                     }
                     catch(Exception ae)
                     {
                         this.dispose();
                         JOptionPane.showMessageDialog(this,"INVALID REGISTRATION NUMBER!!");
                     }
                             
                             
                     
                     
                     
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                   
                    if(e.getSource()==bt1)
                    {
                        
                        
                        String v1,v2,v3,v4,v5,v6,v7,v8,v9;
                        
                        v1 = tf1.getText();
                        v2 = tf2.getText();
                        v3 = tf3.getText();
                        v4 = c4.getSelectedItem().toString();
                        v5 = tf5.getText();
                        v6 = tf6.getText();
                        v7 = ta7.getText();
                        v8 = tf8.getText();
                        v9 = tf9.getText();

                        
                        
                        v1 = v1.toUpperCase().trim();
                        v2 = v2.toUpperCase().trim();
                        v3 = v3.trim().toUpperCase();
                        v4 = v4.toUpperCase().trim();
                        v5 = v5.toUpperCase().trim();
                        v6 = v6.trim().toUpperCase();
                        v7 = v7.toUpperCase().trim();
                        v8 = v8.toUpperCase().trim();
                        v9 = v9.trim().toUpperCase();
                        
                        
                      
                        int flag =0;
                        
                        if(v1.equals("") || v2.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELDS SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
                        }
                        
                        for(int i=0;i<v2.length();i++)
                        {
                            if(v2.charAt(i)<65 || v2.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"GUARDIAN'S NAME SHOULD ONLY CONTAIN VALID ALPHABETS!!");
                                flag =1;
                                break;
                            }
                        }
                        int flag1 = 0;
                        for(int i = 0;i<v8.length();i++)
                        {
                            if(v8.charAt(i)==64)
                            {
                                flag1 = 1;
                                break;
                            }
                            
                        }
                        if(flag1==0)
                        {
                            JOptionPane.showMessageDialog(this,"NOT A VALID EMAIL ADDRESS!!");
                            flag =1;
                        }
                        
                        
                        
                        if(v3.length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION MUST BE OF 10 DIGITS!!!");
                            flag=1;
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
                            stmt.executeQuery("select * from students"); 
                            
                            if(rs.next())
                            {
                                rs.updateString("name",v1);
                                rs.updateString("gname", v2);
                                
                                try
                                {
                                    rs.updateLong("regno",Long.parseLong(v3));
                                }
                                catch(NumberFormatException e5)
                                {
                                    JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER CANNOT BE IN ALPHABETS!!");
                                }
                                
                                try
                                {
                                    rs.updateLong("gcno",Long.parseLong(v6));
                                    rs.updateLong("cno",Long.parseLong(v9));
                                    
                                }
                                catch(NumberFormatException e10)
                                {
                                    JOptionPane.showMessageDialog(this,"CONTACT NUMBER CANNOT CONTAIN ALPHABETS!!");
                                }
                                
                                
                                rs.updateString("trade",v4);
                                rs.updateString("dob", v5);
                                
                                rs.updateString("add",v7);
                                rs.updateString("eadd", v8);
                                
                                rs.updateRow();
                            
                                JOptionPane.showMessageDialog(this,"DATA UPDATED DUCCESFULLY!!");
                                this.dispose();
                            }
                            
                            
                            
                        
                        }
                        catch(Exception e2)
                        {
                            JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!");
                        }
                            
                            
                            
                        }
                        
                        
                        
                        
                        
                        
                        
                        
                    }
                    
                    
                    
                }
            }
            A3 a31 = new A3();
                        
                        
                        
        }
                    
       }
  }
            
            
            
            A31 a3 = new A31();
            a3.setBounds(200,200,350,250);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
        else if(e.getSource()==b3)
        {
            
            class A21 extends JFrame implements ActionListener
            {
                
                JLabel lb;
                JTextField tf;
                JButton bt;
                A21()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(350,250);
                     setBounds(200,200,350,250);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("VIEW STUDENT DATA");
                     
                     lb = new JLabel("ENTER THE REGISTRATION NO. OF THE STUDENT:");
                     tf = new JTextField(25);
                     bt = new JButton("SUBMIT");
                     
                     lb.setBounds(20,20,300,30);
                     tf.setBounds(20,70,200,30);
                     bt.setBounds(20,130,200,30);

                     add(lb);
                     add(tf);
                     add(bt);
                     
                     bt.addActionListener(this);
                     
                }

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    
                    if(e.getSource()==bt)
                    {
                        
                       
                        
                        
                        
                        
               class A2 extends JFrame
            
               {
                JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb11,lb12,lb13,
                        lb14,lb15,lb16,lb17,lb18,lb19;
                JScrollPane sp17;
                
                A2()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(600,600);
                     setBounds(200,200,600,600);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("VIEW STUDENT DATA");
                     
                     lb1 = new JLabel("NAME:");
                     lb2 = new JLabel("GUARDIAN'S NAME:");
                     lb3 = new JLabel("REGISTRATION NO.:");
                     lb4 = new JLabel("DEPARTMENT:");
                     lb5 = new JLabel("DATE OF BIRTH:");
                     lb6 = new JLabel("GUARDIAN'S CONTACT NO:");
                     lb7 = new JLabel("ADDRESS:");
                     lb8 = new JLabel("EMAIL ADDRESS:");
                     lb9 = new JLabel("CONTACT NO:");
                     sp17 = new JScrollPane(lb17);
                     
                     
                     lb11 = new JLabel();
                     lb12 = new JLabel();
                     lb13 = new JLabel();
                     lb14 = new JLabel();
                     lb15 = new JLabel();
                     lb16 = new JLabel();
                     lb17 = new JLabel();
                     lb18 = new JLabel();
                     lb19 = new JLabel();
                     
                     
                     
                     
                     
                     lb1.setBounds(20,20,200,30);
                     lb2.setBounds(20,70,200,30);
                     lb3.setBounds(20,120,200,30);
                     lb4.setBounds(20,170,200,30);
                     lb5.setBounds(20,220,200,30);
                     lb6.setBounds(20,270,200,30);
                     lb7.setBounds(20,340,200,30);
                     lb8.setBounds(20,410,200,30);
                     lb9.setBounds(20,460,200,30);
                     lb11.setBounds(250,20,200,30);
                     lb12.setBounds(250,70,200,30);
                     lb13.setBounds(250,120,200,30);
                     lb14.setBounds(250,170,200,30);
                     lb15.setBounds(250,220,200,30);
                     lb16.setBounds(250,270,200,30);
                     sp17.setBounds(250,320,350,70);
                     lb18.setBounds(250,410,200,30);
                     lb19.setBounds(250,460,200,30);
                     
                     
                     add(lb1);
                     add(lb2);
                     add(lb3);
                     add(lb4);
                     add(lb5);
                     add(lb6);
                     add(lb7);
                     add(lb8);
                     add(lb9);
                     add(lb11);
                     add(lb12);
                     add(lb13);
                     add(lb14);
                     add(lb15);
                     add(lb16);
                     add(sp17);
                     add(lb18);
                     add(lb19);
                     
                     
                     
                     try
                     {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = 
                            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                            Statement stmt = 
                            conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                            ResultSet rs = 
                            stmt.executeQuery("select * from students where regno ="+Long.parseLong(tf.getText().trim()));
                            
                            String u1="",u2="",u4="",u5="",u7="",u8="";
                            long u3=0,u6=0,u9=0;
                            
                            if(rs.next())
                            {
                                u1 = rs.getString("name");
                                u2 = rs.getString("gname");
                                u3 = rs.getLong("regno");
                                u4 = rs.getString("trade");
                                u5 = rs.getString("dob");
                                u6 = rs.getLong("gcno");
                                u7 = rs.getString("add");
                                u8 = rs.getString("eadd");
                                u9 = rs.getLong("cno");
                            }
                            else
                            {
                                this.dispose();
                                JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER DOES NOT EXIST!!");
                                
                            }
                            
                            lb11.setText(u1);
                            lb12.setText(u2);
                            lb13.setText(u3+"");
                            lb14.setText(u4);
                            lb15.setText(u5);
                            lb16.setText(u6+"");
                            lb17.setText(u7);
                            lb18.setText(u8);
                            lb19.setText(u9+"");
                            
                            
                            
                     }
                     catch(Exception ae)
                     {
                         this.dispose();
                         JOptionPane.showMessageDialog(this,"INVALID REGISTRATION NUMBER!!");
                     }
                             
                             
                     
                     
                     
                }

                            

                
            }
            A2 a31 = new A2();
                        
                        
                        
        }
                    
       }
  }
            
      A21 a3 = new A21();    
      a3.setBounds(200,200,350,250);
            
         
        }      
            
        
     
        
        
        else
        {
            class A4 extends JFrame implements ActionListener
            {
                JLabel lb1;
                JTextField tf1;
                JButton bt1;
                A4()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(300,250);
                     setBounds(200,200,350,250);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("DELETE STUDENT DATA");
                     
                     lb1 =new JLabel("REGISTRATION NO. OF THE STUDENT:");
                     tf1 = new JTextField(25);
                     bt1 = new JButton("DELETE");
                     
                     lb1.setBounds(10,15,250,30);
                     tf1.setBounds(10,65,150,30);
                     bt1.setBounds(10,115,100,30);
                     
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
                            stmt.executeQuery("select * from students where regno ="+x); 
                            
                            
                            if(rs.next())
                            {
                                rs.deleteRow();
                                JOptionPane.showMessageDialog(this,"DATA DELETED SUCCESSFULLY!!");
                                this.dispose();
                            }
                            else
                            {
                                
                                JOptionPane.showMessageDialog(this,"REGISTRATION NO. DOES'NT EXIST!!!");
                            }
                            
                            
                            
                            
                        }
                        catch(Exception e2)
                        {
                            JOptionPane.showMessageDialog(this,"INVALID REGISTRATION NUMBER!!");
                        }
                    }
                    
                }
            }
            
            A4 a41 = new A4();
            a41.setBounds(200,200,300,250);
        }
    }
    
}
