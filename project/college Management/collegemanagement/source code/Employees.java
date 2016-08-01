
package collegemanagement;


import java.awt.event.*;
import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.table.AbstractTableModel;


class Employees extends JFrame implements ActionListener
{

    JButton b1,b2,b3,b4;
    JTable jt1;
    JScrollPane sp1;
    Employees.TableModel1 tm1;
    
    Employees()
    {
    setVisible(true);
    setTitle("EMPLOYEES");
    setResizable(false);
    setLayout(null);
    setSize(600,520);
    setBounds(200,200,600,520);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        tm1 = new Employees.TableModel1();
        jt1 = new JTable(tm1);
        sp1 = new JScrollPane(jt1);
        b1 = new JButton("ADD EMPLOYEE");
        b2 = new JButton("UPDATE EMPLOYEE INFO");
        b3 = new JButton("DELETE EMPLOYEE");
        b4 = new JButton("REFRESH EMPLOYEE LIST");
        
    

      
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
           
           ResultSet rs = stmt.executeQuery("select * from employees");
           System.out.println("Resultset created");
           
           long eid;
           String name;
           String trade;
           String quali;
           String desi;
           
           while(rs.next())
           {
               eid = rs.getLong("eid");
               name = rs.getString("name");
               trade = rs.getString("trade");
               quali = rs.getString("quali");
               desi = rs.getString("desi");
               
               al.add(new Employees.Employee(name,eid,trade,quali,desi));
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

                JLabel lb1,lb2,lb3,lb4,lb5;
                JTextField tf1,tf2,tf3,tf4,tf5;
                JButton bt5;
                JComboBox c3,c5;
                
                
                A1()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(400,350);
                     setBounds(200,200,400,350);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("ADD RECORD");
                
                     lb1 = new JLabel("NAME:");
                     lb2 = new JLabel("EMPLOYEE ID:");
                     lb3 = new JLabel("DEPARTMENT:");
                     lb4 = new JLabel("QUALIFICATION:");
                     lb5 = new JLabel("DESIGNATION:");

                     tf1 = new JTextField(25);
                     tf2 = new JTextField(25);
                     tf3 = new JTextField(25);
                     tf4 = new JTextField(25);
                     tf5 = new JTextField(25);
                     
                     bt5 = new JButton("ADD");
                     c3 = new JComboBox();
                     c5 = new JComboBox();
                     
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                         "IT" , "MECHANICAL","ELECTRICAL","WORKSHOP","HOSTEL","LIBRARY"};
                     
                     String s22[] = {"LECTURER" , "SEN. LECTURER" , "HOD", "LAB INSTRUCTOR",
                         "LIBRARIAN" , "HOSTEL WARDEN","WORKSHOP SUPDT.","WORKSHOP INSTRUCTOR"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c3.addItem(s11[i]);
                         c5.addItem(s22[i]);
                     }
                     
                     c3.setEditable(false);
                     c5.setEditable(false);
                     
        
                    lb1.setBounds(15,15,130,30);
                    lb2.setBounds(15,50,130,30);
                    lb3.setBounds(15,85,130,30);
                    lb4.setBounds(15,120,130,30);
                    lb5.setBounds(15,155,130,30);
                    
                    tf1.setBounds(190,22,170,23);
                    tf2.setBounds(190,57,170,23);
                    //tf3.setBounds(150,92,120,23);
                    c3.setBounds(190,92,170,23);
                    tf4.setBounds(190,127,170,23);
                    c5.setBounds(190,162,170,23);
                    //tf5.setBounds(150,162,120,23);
                    bt5.setBounds(190,197,150,40);
        
                    add(lb1);
                    add(lb2);
                    add(lb3);
                    add(lb4);
                    add(lb5);

                    add(tf1);
                    add(tf2);
                    //add(tf3);
                    add(tf4);
                    //add(tf5);
                    add(c3);
                    add(c5);
                    add(bt5);
        
                    bt5.addActionListener(this);
                     
                    
                     
            
                     
                     
                     
                     
                     
                }
                
                  
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==bt5)
                    {
                        
                        String v1,v2,v3,v4,v5;
                        
                        v1 = tf1.getText().toUpperCase().trim();
                        v2 = tf2.getText().trim().toUpperCase();
                        v3 = c3.getSelectedItem().toString().toUpperCase();
                        v4 = tf4.getText().toUpperCase();
                        v5 = c5.getSelectedItem().toString().toUpperCase();
                        
                        int flag = 0;
                        
                        if(v1.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELD SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        if(v2.length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"EMPLOYEE ID SHOULD BE OF 10 DIGITS!!");
                            flag = 1;
                        }
                        
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"EMPLOYEE NAME SHOULD ONLY CONTAIN VALID CHARACTERS!!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        for(int i=0;i<v4.length();i++)
                        {
                            if(v4.charAt(i)<65 || v4.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"QUALIFICATION SHOULD NOT CONTAIN NUMERICAL DIGITS!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        long x;
                        
                        try
                        {
                            x = Long.parseLong(v2);
                        }
                        catch(NumberFormatException ad)
                        {
                            flag = 1;
                            JOptionPane.showMessageDialog(this,"EMPLOYEE ID MUST CONTAIN VALID ALPHABETS!!");
                        }
                        if(flag ==0)
                        {
                            
                            
                        try
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                           ResultSet rs = 
                           stmt.executeQuery("select * from employees where eid="+Long.parseLong(v2));
                           
                           if(rs.next())
                           {
                               JOptionPane.showMessageDialog(this,"ROW ALREADY EXISTS!!!");
                           }
                               
                           else    
                           {              
                           rs.moveToInsertRow();
                           
                           
                           rs.updateLong("eid", Long.parseLong(v2));
                                                
                           rs.updateString("name", v1);
                           rs.updateString("trade", v3);
                           rs.updateString("quali", v4);
                           rs.updateString("desi",v5);
                           rs.insertRow();
                           
                          
                                                     
                           JOptionPane.showMessageDialog(this,"ROW INSERTED SUCCESSFULLY!!!");
                           
                           }
                           
                           
                
                
                
                
                
                
                    }
                     catch(Exception ae1)
                    {
                           JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!");
                           
                    }
                        
                    try 
                    {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   
                           ResultSet rs = 
                           stmt.executeQuery("select * from employees where eid="+Long.parseLong(v2));   
                           
                           while(rs.next())
                           {
                               long eid = rs.getLong("eid");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String quali = rs.getString("quali");
                               String desi = rs.getString("desi");
               
                               al.add(new Employees.Employee(name,eid,trade,quali,desi));
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!");
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

                JLabel lb1,lb2,lb3,lb4,lb5;
                JTextField tf1,tfi,tf3,tf4,tf5;
                JButton btu;
                JComboBox c3,c5;
                A2()
                {
                     setVisible(true);
                     setLayout(null);
                     setSize(450,400);
                     setBounds(200,200,450,400);
                     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                     setResizable(false);
                     setTitle("UPDATE RECORD");
                
                     lb1 = new JLabel("NAME:");
                     lb2 = new JLabel("EMPLOYEE ID:");
                     lb3 = new JLabel("DEPARTMENT:");
                     lb4 = new JLabel("QUALIFICATION:");
                     lb5 = new JLabel("DESIGNATION:");
                     c3 = new JComboBox();
                     c5 = new JComboBox();
                     
                     tf1 = new JTextField(25);
                     tfi = new JTextField(25);
                     tf3 = new JTextField(25);
                     tf4 = new JTextField(25);
                     tf5 = new JTextField(25);
        
                     btu = new JButton("UPDATE");
        
                     
                     String s11[] = {"CIVIL" , "COMPUTER" , 
                         "IT" , "MECHANICAL","ELECTRICAL","WORKSHOP","HOSTEL","LIBRARY"};
                     
                     String s22[] = {"LECTURER" , "SEN. LECTURER" , "HOD", "LAB INSTRUCTOR",
                         "LIBRARIAN" , "HOSTEL WARDEN","WORKSHOP SUPDT.","WORKSHOP INSTRUCTOR"};
                     
                     for(int i=0;i<s11.length;i++)
                     {
                         c3.addItem(s11[i]);
                         c5.addItem(s22[i]);
                     }
                     
                     c3.setEditable(false);
                     c5.setEditable(false);
                     
                     
                    lb1.setBounds(15,15,130,30);
                    lb2.setBounds(15,50,130,30);
                    lb3.setBounds(15,85,130,30);
                    lb4.setBounds(15,120,130,30);
                    lb5.setBounds(15,155,130,30);
                    
                    tf1.setBounds(190,22,170,23);
                    tfi.setBounds(190,57,170,23);
                    //tf3.setBounds(150,92,120,23);
                    c3.setBounds(190,92,170,23);
                    tf4.setBounds(190,127,170,23);
                    c5.setBounds(190,162,170,23);
                    //tf5.setBounds(150,162,120,23);
                    btu.setBounds(190,197,150,40);
        
                    add(lb1);
                    add(lb2);
                    add(lb3);
                    add(lb4);
                    add(lb5);

                    add(tf1);
                    add(tfi);
                    //add(tf3);
                    add(tf4);
                    //add(tf5);
                    add(c3);
                    add(c5);

                    add(btu);
        
                    btu.addActionListener(this);
                     
                    
               
                long u1; String u2,u3 ,u4,u5;
                
                u1 = al.get(r).eid;
                u2 = al.get(r).name;
                u3 = al.get(r).trade;
                u4 = al.get(r).quali;
                u5 = al.get(r).desi;
                
                
                
                     
                     tfi.setText(u1+"");
                     tf1.setText(u2);
                     c3.setSelectedItem(u3);
                     tf4.setText(u4);
                     c5.setSelectedItem(u5);
                     
                     
                     
                     
                }
                
                
                
                             
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==btu)
                    {
                        
                        String v1,v2,v3,v4,v5;
                        
                        
                        v1 = tf1.getText().toUpperCase().trim();
                        v2 = tfi.getText().trim().toUpperCase();
                        v3 = c3.getSelectedItem().toString().toUpperCase();
                        v4 = tf4.getText().toUpperCase();
                        v5 = c5.getSelectedItem().toString().toUpperCase();
                        
                        int flag = 0;
                        
                        if(v1.equals(""))
                        {
                            JOptionPane.showMessageDialog(this,"NAME FIELD SHOULD NOT BE LEFT BLANK!!");
                            flag =1;
                        }
                        
                        if(v2.length()!=10)
                        {
                            JOptionPane.showMessageDialog(this,"EMPLOYEE ID SHOULD BE OF 10 DIGITS!!");
                            flag = 1;
                        }
                        
                        
                        for(int i=0;i<v1.length();i++)
                        {
                            if(v1.charAt(i)<65 || v1.charAt(i)>90 )
                            {
                                JOptionPane.showMessageDialog(this,"EMPLOYEE NAME SHOULD ONLY CONTAIN VALID CHARACTERS!!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        for(int i=0;i<v4.length();i++)
                        {
                            if(v4.charAt(i)<65 || v4.charAt(i)>122 )
                            {
                                JOptionPane.showMessageDialog(this,"QUALIFICATION SHOULD NOT CONTAIN NUMERICAL DIGITS!!");
                                flag = 1;
                                break;
                                
                            }
                        }
                        
                        long x;
                        
                        try
                        {
                            x = Long.parseLong(v2);
                        }
                        catch(NumberFormatException ad)
                        {
                            flag = 1;
                            JOptionPane.showMessageDialog(this,"EMPLOYEE ID MUST CONTAIN VALID ALPHABETS!!");
                        }
                        
                        
                        
                        if(flag ==0)
                        {
                            try
                                
                    {
                            x = al.get(r).eid;
                           
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = 
                           DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","root");
                           Statement stmt = 
                           conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);    
                           ResultSet rs = 
                           stmt.executeQuery("select * from employees where eid="+x);
                           
                           if(rs.next())
                           {
                                       
                           rs.updateLong("eid", Long.parseLong(v2));
                           rs.updateString("name", v1);
                           rs.updateString("trade", v3);
                           rs.updateString("quali", v4);
                           rs.updateString("desi",v5);
                           rs.updateRow();
                           tm1.fireTableDataChanged();
                          
                           
                           JOptionPane.showMessageDialog(this,"ROW UPDATED SUCCESSFULLY!!!");
                           this.dispose();
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
                           stmt.executeQuery("select * from employees where eid="+Long.parseLong(v2));   
                           
                           while(rs.next())
                           {
                               long eid = rs.getLong("eid");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String quali = rs.getString("quali");
                               String desi = rs.getString("desi");
                               al.add(new Employee(name,eid,trade,quali,desi));
                               al.remove(r);
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                        ae2.printStackTrace();
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
                long x1=al.get(r).eid;
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
                           stmt.executeQuery("select * from employees where eid="+x1);
                           
                           while(rs.next())
                           {
                               rs.deleteRow();
                               tm1.fireTableDataChanged();
                               break;
                           }
                           
                           
                           
                           
                           
                    }
                catch(Exception ae1)
                {
                    JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
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
                           stmt.executeQuery("select * from employees");   
                           
                           while(rs.next())
                           {
                               long eid = rs.getLong("eid");
                               String name = rs.getString("name");
                               String trade = rs.getString("trade");
                               String quali = rs.getString("quali");
                               String desi = rs.getString("desi");
                               
                               
                               al.removeAll(al);
                               tm1.fireTableDataChanged();
                           }
                    }
                    catch(Exception ae2)
                    {
                        ae2.printStackTrace();
                        JOptionPane.showMessageDialog(this,"PLEASE ENTER THE VALID DATA!!!");
                    }
        }
    }
    
    ArrayList<Employees.Employee> al = new ArrayList<>();
        
    class TableModel1 extends AbstractTableModel
    {
        String title[] = {"NAME ","EMPLOYEE ID","DEPARTMENT","QUALIFICATION","DESIGNATION"}; 

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
                return al.get(rowIndex).eid;
            else if(columnIndex==2)
                return al.get(rowIndex).trade;
            else if(columnIndex==3)
                    return al.get(rowIndex).quali;
            else
                return al.get(rowIndex).desi;
                
                
                
            
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }
        
    }
    
    
    class Employee
    {
        String name;
        long eid;
        String trade;
        String quali;
        String desi;
        
        Employee(String n, long e, String t,String q,String d)
        {
            name =n;
            eid = e;
            trade = t;
            quali  = q;
            desi = d;
        }
    }
   
    
}
