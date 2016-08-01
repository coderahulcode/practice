
package collegemanagement;


import java.awt.event.*;
import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Date;

import javax.swing.table.AbstractTableModel;


class Admissions extends JFrame implements ActionListener
{

    JButton b1,b2,b3,b4;
    JTable jt1;
    JScrollPane sp1;
    Admissions.TableModel1 tm1;
    
    Admissions()
    {
    setVisible(true);
    setTitle("ADMISSIONS");
    setResizable(false);
    setLayout(null);
    setBounds(200,200,600,520);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        tm1 = new Admissions.TableModel1();
        jt1 = new JTable(tm1);
        sp1 = new JScrollPane(jt1);
        b1 = new JButton("ADD NEW ADMISSION");
        b2 = new JButton("UPDATE STUDENT ADMISSION");
        b3 = new JButton("DELETE STUDENT ADMISSION");
        b4 = new JButton("REFRESH STUDENT LIST");
        
    

      
       b1.setBounds(20,400,220,30);
       b2.setBounds(350,400,220,30);
       b3.setBounds(20,450,220,30);
       b4.setBounds(350,450,220,30);
 
       
       sp1.setBounds(20,50,550,320);
       
        
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(sp1);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        try 
       {
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver loaded");
           
           Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
           System.out.println("Connection Build");
           
           Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           System.out.println("Statement Created");
           
           ResultSet rs = stmt.executeQuery("select * from admissions");
           System.out.println("Resultset created");
           
           long regno;
           String name;
           String trade;
           String date;
           
           while(rs.next())
           {
               regno = rs.getLong("regno");
               name = rs.getString("name");
               trade = rs.getString("trade");
               date = rs.getString("date");
               
               al.add(new Admissions.Admission(name,regno,trade,date));
               tm1.fireTableDataChanged();
           }
           
       }
       catch(Exception ae)
       {
           ae.printStackTrace();
       }
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            
            class A1 extends JFrame implements ActionListener
            {

                JLabel lb1,lb2,lb3,lb4;
                JTextField tf1,tf2,tf3,tf4;
                JButton bt5;
                JComboBox c1;
                Date d11;
                
                
                A1()
                {
                     setVisible(true);
                     setLayout(null);
                     setBounds(200,200,400,250);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("ADD RECORD");
                
                     lb1 = new JLabel("NAME OF STUDENT:");
                     lb2 = new JLabel("REGISTRATION NO.:");
                     lb3 = new JLabel("DEPARTMENT:");
                     lb4 = new JLabel("DATE OF ADMISSION:");
                     d11 = new Date();
                     

                     tf1 = new JTextField(25);
                     tf2 = new JTextField(25);
                     tf3 = new JTextField(25);
                     tf4 = new JTextField(25);
                     tf4.setEditable(false);
                     
                     bt5 = new JButton("SUBMIT");
                     c1 = new JComboBox();
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                           "IT","MECHANICAL","ELECTRICAL"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c1.addItem(s11[i]);
                     }
                     
                     c1.setEditable(false);
                     
        
                    lb1.setBounds(10,10,140,30);
                    lb2.setBounds(10,40,140,30);
                    lb3.setBounds(10,70,140,30);
                    lb4.setBounds(10,100,140,30);

                    tf1.setBounds(170,17,150,23);
                    tf2.setBounds(170,47,150,23);
                    //tf3.setBounds(130,77,110,23);
                    tf4.setBounds(170,107,150,23);
                    c1.setBounds(170,77,150,23);
                    bt5.setBounds(200,147,110,30);
        
                    add(lb1);
                    add(lb2);
                    add(lb3);
                    add(lb4);

                    add(tf1);
                    add(tf2);
                    add(tf3);
                    add(tf4);
                    add(c1);
                    add(bt5);
        
                    bt5.addActionListener(this);
                     
                    
                    tf4.setText(d11.toLocaleString()); 
            
                     
                     
                     
                     
                     
                }
                
                  
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt5)
                    {
                        String v1,v2,v3,v4;
                        
                        v1 = tf1.getText().trim();
                        v2 = tf2.getText().trim();
                        v3 = c1.getSelectedItem().toString();
                        v4 = tf4.getText();
                        
                        v1 = v1.toUpperCase();
                        v2 = v2.toUpperCase();
                        v3 = v3.toUpperCase();
                        v4 = v4.toUpperCase();
                        
                        int flag =0;
                        
                        if(v1.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELD SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"NAME SHOULD ONLY CONTAIN VALID CHARACTERS!!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        
                        
                        
                        if((v2.length())!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST BE OF 10 DIGITS!!!");
                            flag =1;
                            
                        }
                        
                        
                        
                        
                        
                                        
                        
                        
                        
                    
                        
                        if (flag==0)
                        {
                            long x = Long.parseLong(tf2.getText());
                        
                        try
                                           
                        {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions where regno="+x);
                           
                           if(rs.next())
                           {
                               JOptionPane.showMessageDialog(this,"ROW ALREADY EXISTS!!!");
                           }
                               
                           else    
                           {              
                           rs.moveToInsertRow();
                           
                           try
                           {
                               rs.updateLong("regno", Long.parseLong(v2));
                           }
                           catch(NumberFormatException ae1)
                           {
                               JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER CANNOT BE IN CHARACTERS!!!");
                           }
                           
                           
                           
                           
                           rs.updateString("name", v1);
                           rs.updateString("trade", v3);
                           rs.updateString("date", v4);
                           rs.insertRow();
                           
                          
                                                     
                           JOptionPane.showMessageDialog(this,"ROW INSERTED SUCCESSFULLY!!!");
                           
                           }
                           
                           
                
                
                
                
                
                
                    }
                     catch(Exception ae1)
                    {
                           JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                           ae1.printStackTrace();
                    }
                        
                    try 
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions where regno="+x);   
                           
                           while(rs.next())
                           {
                               long regno = rs.getLong("regno");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String date = rs.getString("date");
               
                               al.add(new Admission(name,regno,trade,date));
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                        ae2.printStackTrace();
                    }
                    this.dispose();
                        }
                        
                        
                    }
                }
                
            }
            
            A1 a1 = new A1();
            
            
           
          
            
            
            
        }
        
        else if(e.getSource()==b2)
        {
            final int r= jt1.getSelectedRow();
            if(r==-1)
            {
                JOptionPane.showMessageDialog(this,"SELECT ROW FIRST!!!");
            }
            
            else
            {
                class A2 extends JFrame implements ActionListener
            {

                JLabel lb1,lb2,lb3,lb4;
                JTextField tf1,tfi,tf3,tf4;
                JButton btu;
                JComboBox c1;
                A2()
                {
                     setVisible(true);
                     setLayout(null);
                     this.setBounds(200, 200, 400, 300);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("UPDATE RECORD");
                
                     lb1 = new JLabel("NAME OF STUDENT:");
                     lb2 = new JLabel("REGISTRATION NO.:");
                     lb3 = new JLabel("DEPARTMENT:");
                     lb4 = new JLabel("DATE OF ADMISSION:");

                     tf1 = new JTextField(25);
                     tfi = new JTextField(25);
                     tf3 = new JTextField(25);
                     tf4 = new JTextField(25);
        
                     btu = new JButton("UPDATE");
                     
                     c1 = new JComboBox();
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                           "IT","MECHANICAL","ELECTRICAL"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c1.addItem(s11[i]);
                     }
                     
                     c1.setEditable(false);
        
                    lb1.setBounds(10,10,140,30);
                    lb2.setBounds(10,40,140,30);
                    lb3.setBounds(10,70,140,30);
                    lb4.setBounds(10,100,140,30);

                    tf1.setBounds(170,17,150,23);
                    tfi.setBounds(170,47,150,23);
                    
                    tf4.setBounds(170,107,150,23);
                    c1.setBounds(170,77,150,23);
                    

                    btu.setBounds(170,147,110,30);
        
                    add(lb1);
                    add(lb2);
                    add(lb3);
                    add(lb4);

                    add(tf1);
                    add(tfi);
                    add(c1);
                    add(tf4);

                    add(btu);
        
                    btu.addActionListener(this);
                    
                    
                     
                    
               
                long u1; String u2; String u3, u4;
                
                u1 = al.get(r).regno;
                u2 = al.get(r).name;
                u3 = al.get(r).trade;
                u4 = al.get(r).date;
                
                
                     
                     tfi.setText(u1+"");
                     tf1.setText(u2);
                     c1.setSelectedItem(u3);
                     tf4.setText(u4);
                     
                     tf4.setEditable(false);
                     
                     
                }
                
                
                
                             
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==btu)
                    {
                        
                        String v1,v2,v3,v4;
                        
                        v1 = tf1.getText().trim();
                        v2 = tfi.getText().trim();
                        v3 = c1.getSelectedItem().toString();
                        v4 = tf4.getText();
                        
                         v1 = v1.toUpperCase();
                         v2 = v2.toUpperCase();
                        v3 = v3.toUpperCase();
                        v4 = v4.toUpperCase();
                        
                        int flag =0;
                        
                        if(v1.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELD SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"NAME SHOULD ONLY CONTAIN VALID CHARACTERS!!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        
                        
                        
                        if((v2.length())!=10)
                        {
                            JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER MUST BE OF 10 DIGITS!!!");
                            flag =1;
                            
                        }
                        
                        
                        if(flag==0)
                        {
                            long x;
                        x = al.get(r).regno;
                        
                        try
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions where regno ="+x);
                           
                           if(rs.next())
                           {
                                       
                           
                               try
                               {
                                  rs.updateLong("regno", Long.parseLong(v2));

                                                           
                               }
                               catch(NumberFormatException ae1)
                               {
                                   JOptionPane.showMessageDialog(this,"REGISTRATION NUMBER CANNOT BE IN CHARACTERS!!");
                               }
                               
                           rs.updateString("name", v1);
                           rs.updateString("trade", v3);
                           rs.updateString("date", (v4));
                           
                           rs.updateRow();
                           tm1.fireTableDataChanged();
                          
                           
                           JOptionPane.showMessageDialog(this,"ROW UPDATED SUCCESSFULLY!!!");
                           this.dispose();
                           }
                           
                           
                           
                           
                    }
                     catch(Exception ae1)
                    {
                           JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                    }
                        x = Long.parseLong(v2);
                    try 
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions where regno="+x);   
                           
                           while(rs.next())
                           {
                               long regno = rs.getLong("regno");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String date = rs.getString("date");
                               al.add(new Admission(name,regno,trade,date));
                               al.remove(r);
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                    } 
                        }
                        
                        
                        
                           
                        
                    }
                }
                
            }
            
            A2 a2 = new A2();
            }
            
            
            
            
            
           
            
                 
            
        }
        else if(e.getSource()==b3)
        {
            int r = jt1.getSelectedRow();
            if(r==-1)
            {
                JOptionPane.showMessageDialog(this,"SELECT ROW FIRST!!!");
                
            }
            else
            {
               
                int p = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete???",
                        "My Confirm Dialog", JOptionPane.YES_NO_OPTION);
                
                if(p==JOptionPane.YES_OPTION)
                {
                long x1=al.get(r).regno;
                al.remove(r);
                tm1.fireTableDataChanged();
                
                try
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions where regno="+x1);
                           
                           while(rs.next())
                           {
                               rs.deleteRow();
                               tm1.fireTableDataChanged();
                               break;
                           }
                           
                           
                           
                           
                           
                    }
                catch(Exception ae1)
                {
                    ae1.printStackTrace();
                }
                
            }
                
            }
            
        }
        else if(e.getSource()==b4)
        {
            try 
                    {
                        int a = al.size();
                        
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                           ResultSet rs = 
                           stmt.executeQuery("select * from admissions");   
                           
                           while(rs.next())
                           {
                               long regno = rs.getLong("regno");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String date = rs.getString("date");
                               
                               
                               al.removeAll(al);
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        ae2.printStackTrace();
                        //JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                    }
        }
    }
    
    ArrayList<Admissions.Admission> al = new ArrayList<>();
        
    class TableModel1 extends AbstractTableModel
    {
        String title[] = {"NAME OF STUDENT","REGISTRATION NO.","DEPARTMENT","DATE OF ADMISSION"}; 

        @Override
        public int getRowCount() {
            
            return al.size();
        }

        @Override
        public String getColumnName(int n) {
            
            return title[n];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) 
        {
            if(columnIndex==0)
                return al.get(rowIndex).name;
            else if(columnIndex==1)
                return al.get(rowIndex).regno;
            else if(columnIndex==2)
                return al.get(rowIndex).trade;
            else
                return al.get(rowIndex).date;
                
                
                
            
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }
        
    }
    
    
    class Admission
    {
        String name;
        long regno;
        String trade;
        String date;
        
        Admission(String n, long r, String t,String d)
        {
            name =n;
            regno = r;
            trade = t;
            date = d;
        }
    }
   
    
}
