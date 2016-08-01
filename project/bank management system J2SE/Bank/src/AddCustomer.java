import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.util.StringTokenizer;
public class AddCustomer extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    Font f1,f2,f3;
    Point p;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    Choice jc;
    TextArea jta;
    JButton b;
    Date d;
    String email,name,middle,last,fname,dob,gender,state,address,pno,date,wname,waccno,wpno;
    AddCustomer()
    {
        super("New Customer");
        setVisible(true);
        setLayout(null);
        setSize(650,720);
        this.setResizable(false);
        p=new Point(300,0);
        this.setLocation(p);
        d=new Date();
        jc=new Choice();
        jta=new TextArea(20,40);
         b=new JButton("Submit");
        jc.add("Punjab");
       
      
        //jta.setFocusable(false);
        jc.add("Gujrat");
        jc.add("Jammu&Kasmeer");
        jc.add("Madhaya Pardesh");
        jc.add("Uttar Pardesh");
        jc.add("Maharastra");
       
        l1=new JLabel("NEW CUSTOMER");
        l2=new JLabel("First Name");
        l3=new JLabel("Last Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("Date Of Birth (dd/mm/yyyy)");
        l6=new JLabel("Gender");
        l7=new JLabel("State");
        l8=new JLabel("Full Address");
        l9=new JLabel("EMail-ID");
        l10=new JLabel("Phone Number");
        l11=new JLabel("Current Date-Time");
        l12=new JLabel("WITNESS INFORMATION");
        l13=new JLabel("Name");
        l14=new JLabel("Account Number");
        l15=new JLabel("Phone Number");
        tf1=new JTextField(25);
        tf2=new JTextField(25);
        tf3=new JTextField(25);
        tf4=new JTextField(25);
        tf5=new JTextField(25);
        rb1=new JRadioButton("Male");
                rb2=new JRadioButton("Female");
        bg=new ButtonGroup();
        tf7=new JTextField(25);
        tf8=new JTextField(25);
        tf9=new JTextField(25);
        tf10=new JTextField(25);
        tf11=new JTextField(25);
        tf12=new JTextField(25);
        tf13=new JTextField(25);
        tf14=new JTextField(25);
        f1=new Font("Times New Roman",Font.BOLD,24);
        f2=new Font("Times New Roman",Font.PLAIN,16);
        f3=new Font("Times New Roman",Font.PLAIN,20);
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
        l12.setFont(f3);
        l13.setFont(f2);
        l14.setFont(f2);
        l15.setFont(f2);
        l1.setBounds(250,10,300,50);
       
        l2.setBounds(30,80,100,30);
        tf1.setBounds(250,80,150,25);
        tf2.setBounds(430,80,150,25);
        l3.setBounds(30,120,100,30);
        tf3.setBounds(250,120,150,25);
        l4.setBounds(30,160,100,30);
        tf4.setBounds(250,160,150,25);
        l5.setBounds(30,200,200,30);
                tf5.setBounds(250,200,150,25);

        l6.setBounds(30,240,100,30);
               rb1.setBounds(250,240,100,25);
        rb2.setBounds(350,240,100,25);
        l7.setBounds(30,280,100,30);
                jc.setBounds(250,290,150,25);

        l8.setBounds(30,320,100,30);
                jta.setBounds(250,320,150,70);

        l9.setBounds(30,400,100,30);
                tf9.setBounds(250,400,150,25);

        l10.setBounds(30,440,100,30);
                tf10.setBounds(250,440,150,25);

        l11.setBounds(30,480,150,30);
        tf11.setBounds(250,480,150,25);
        l12.setBounds(100, 505, 300, 40);
        l13.setBounds(30,540,100,30);
        tf12.setBounds(250,540,150,25);
        l14.setBounds(30,580,150,30);
        tf13.setBounds(250,580,150,25);
        l15.setBounds(30,620,100,30);
        tf14.setBounds(250,620,150,25);
        b.setBounds(130, 650, 130, 40);
        //add(b1);
        add(l2);
        add(tf1);
        add(tf2);
        add(l1);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(l15);
        add(tf3);
        add(tf4);
        add(tf5);
        add(rb1);
        add(rb2);
        add(jc);
        add(jta);
        add(tf9);
        add(tf10);
        add(tf11);
        add(tf12);
        add(tf13);
        add(tf14);
        bg.add(rb1);
        bg.add(rb2);
        add(b);
        tf11.setText(d.toLocaleString());
        
        tf11.setFocusable(false);
         rb1.setSelected(true);
         b.addActionListener(this);
        try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");}
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       
        String email,name,middle,last,fname,dob,gender,state,address,date,wname,waccno,accno,code;
        long pno=0,wpno=0,df=0;int d=0,m=0,y=0;
        int f=1,a,n=0,n1=0,z=0;
        name=tf1.getText();
        middle=tf2.getText();
        last=tf3.getText();
        fname=tf4.getText();
        dob=tf5.getText();
        try
        {
        StringTokenizer st=new StringTokenizer(dob,"/");
        int stk=st.countTokens();
        for(int k=0;k<stk;k++)
        {
            String s1=st.nextToken();
            if(k==0)
            d=Integer.parseInt(s1);
            else if(k==1)
             m=Integer.parseInt(s1);   
            else if(k==2)
             y=Integer.parseInt(s1);  
            else
            {
                df=1;
                break;
        }
            System.out.println(s1);
        }
        }
        catch(Exception exe)
        {
            df=1;
        }
        
        if((d>31)||(m>12)||(y<1800)||(df==1))
                {
                     JOptionPane.showMessageDialog(this,"Invalid Date of Birth");
                }
       
        
        
        
        
        if(rb1.isSelected())
            gender="MALE";
        else
            gender="FEMALE";
        
        state=jc.getSelectedItem();
        address=jta.getText();
        email=tf9.getText();
        try
        {
        pno=Long.parseLong(tf10.getText());  
        }
        catch(Exception ex)
        {
            n=1;
        }
        date=tf11.getText();
        wname=tf12.getText();
        waccno=tf13.getText();
        try
        {
        wpno=Long.parseLong(tf14.getText());  
        }
        catch(Exception ex)
        {
            n1=1;
        }

        if(name.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Name Properly");
        else if(last.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Middle Name Properly");
        else if(fname.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Father Name Properly");
        else if(address.equals(""))
         JOptionPane.showMessageDialog(this,"Fill Address Properly");       
        
        else if(email.equals(""))
            JOptionPane.showMessageDialog(this,"Fill E-Mail ID Properly");
       
       else if(wname.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Witness Name Properly");
       else if(waccno.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Witness Account no Properly");
       else if((tf14.getText().length())!=10||n1==1)
    {
        JOptionPane.showMessageDialog(this,"Invalid Witness Phone Number");
    }
       else if((tf9.getText().indexOf('@'))==-1||tf9.getText().indexOf('.',tf9.getText().indexOf('@'))==-1)
    {
        JOptionPane.showMessageDialog(this,"Fill E-Mail ID Properly\n\n\tEg:  rahul.mahajan1994@yahoo.com");
    }
        else if((tf10.getText().length())!=10||n==1)
    {
        JOptionPane.showMessageDialog(this,"Invalid Phone Number");
    }
       else
       {
        name=name.concat(" "+middle);
        name=name.concat(" "+last);
        
   
        
        
        
        
        
        int c1;
        
        
        c1=(int)(1+9999*Math.random());
        code=Integer.toString(c1);
        a=(int)(1+9999*Math.random());
       
        
        String s,s1;
        s="10026565";
        s1=Integer.toString(a);
        accno=s.concat(s1);  
          System.out.println("ACCNO="+accno);
          
        if(f==1)
        {
         try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from customer");
      System.out.println("Resultset created");
      
      while(rs.next())
      {
          if(rs.getString("accno").equals(waccno))
          {
              z=1;
          }
          if(rs.getString("accno").equals(accno))
          {
          a=(int)(1+9999*Math.random()); 
           s1=Integer.toString(a);
           accno=s.concat(s1);  
          }
      }
      if(z==1)
      {
      rs.moveToInsertRow();
      rs.updateString("accno", accno);
      rs.updateString("name", name);
      rs.updateString("fname",fname);
      rs.updateString("dob",dob);
      rs.updateString("gender", gender);
      rs.updateString("state",state);
      rs.updateString("address",address);
      rs.updateString("email",email);
      rs.updateLong("pno", pno);
      rs.updateString("date",date);
      rs.updateString("code",code);
      rs.updateString("witnessname",wname);
      rs.updateString("witnessaccno",waccno);
      rs.updateLong("witnesspno",wpno );
      rs.insertRow();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Witness Account Number Not Found");
      }}
      catch(Exception ex1)
         {
             System.out.println(ex1.getMessage());
         }
      
      }
      
         
         
         if(z==1)
         {
       try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");
      ResultSet rs1 = stmt.executeQuery("select * from transaction");
      System.out.println("Resultset created");
         
      
      
      
      
      rs1.moveToInsertRow();
      rs1.updateString("accno", accno);
      rs1.updateString("date",date);
      rs1.updateString("transaction","Open Account");
      rs1.updateString("by", "Cash");
      rs1.updateInt("amount", 1000);
      rs1.updateInt("balance", 1000);
      rs1.insertRow();
      
      
      
      
      
      Congratulation c=new Congratulation(name,accno,code);
      this.dispose();
         }
         catch(Exception ex)
         {
             
         }
        }
        else
      {
          
      }
       }
       }
    }

   