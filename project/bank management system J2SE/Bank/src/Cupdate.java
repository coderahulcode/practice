import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.util.StringTokenizer;
public class Cupdate  extends JFrame implements ActionListener
{
Point p;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    Font f1,f2,f3;
     JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    Choice jc;
    TextArea jta;
    JButton b;
    String accno,name;
  Cupdate(String accno,String string, String string0, String string1, String fname, String dob, String gender, String state, String address, String email, long pno, String wname, String waccno, long wpno) 
  {
      super("Update Customer Data");
         setVisible(true);
        setLayout(null);
        setSize(650,720);
        this.setResizable(false);
        p=new Point(300,0);
        this.setLocation(p);
       this.accno=accno;
       
        
        
       
        
       
        
        l1=new JLabel("UPDATE CUDTOMER DATA");
        l2=new JLabel("First Name");
        l3=new JLabel("Last Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("Date Of Birth (dd/mm/yyyy)");
        l6=new JLabel("Gender");
        l7=new JLabel("State");
        l8=new JLabel("Full-Address");
        l9=new JLabel("EMail-ID");
        l10=new JLabel("Phone Number");
        l11=new JLabel("WITNESS INFORMATION");
        l12=new JLabel("Witness Account Number");
        l13=new JLabel("Witness Name");
        l14=new JLabel("Witness Phone Number");
         b=new JButton("Update Data");
        tf1=new JTextField(25);
        tf2=new JTextField(25);
        tf3=new JTextField(25);
        tf4=new JTextField(25);
        tf5=new JTextField(25);
        rb1=new JRadioButton("Male");
        rb1.setSelected(true);
        rb2=new JRadioButton("Female");
        bg=new ButtonGroup();
        tf6=new JTextField(25);
        jc=new Choice();
        jc.add("Punjab");
        jc.add("Gujrat");
        jc.add("Jammu&Kasmeer");
        jc.add("Madhaya Pardesh");
        jc.add("Uttar Pardesh");
        jc.add("Maharastra");
         jta=new TextArea(20,40);
        tf7=new JTextField(25);
        tf8=new JTextField(25);
        tf9=new JTextField(25);
        tf10=new JTextField(25); 
      
        
        
       
        
        
        
        
        
        
        
        
         l1.setBounds(200,10,400,50);
       
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

        l9.setBounds(30,410,100,30);
         tf6.setBounds(250,410, 150,25);
        

        l10.setBounds(30,450,100,30);
        tf7.setBounds(250,450,150,25);
        l11.setBounds(70,495,350,30);
        tf8.setBounds(250,540,150,25);
        l12.setBounds(30, 540, 200, 30);
        tf9.setBounds(250,580,150,25);
        //b.setBounds(130, 580, 130, 40);
        l13.setBounds(30,580, 150,30);
        tf10.setBounds(250, 620, 150, 25);
        l14.setBounds(30,620,150,30);
        
        
         b.setBounds(130,650, 130, 40);
        
        f1=new Font("Times New Roman",Font.BOLD,24);
        f2=new Font("Times New Roman",Font.PLAIN,16);
        f3=new Font("Times New Roman",Font.PLAIN,18);
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
        l11.setFont(f3);
        l12.setFont(f2);
         l13.setFont(f2);
          l14.setFont(f2);
        add(l1);
        add(l2);
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
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);
        add(tf9);
        add(rb1);
        add(rb2);
        add(jc);
        add(jta);
        add(b);
        bg.add(rb1);
        bg.add(rb2);
        
         add(tf10);
       
        add(l13);
        add(l14);
         tf1.setText(string);
        tf2.setText(string0);
        tf3.setText(string1);
        tf4.setText(fname);
        tf5.setText(dob);
        if(rb1.getText().equals(gender))
            rb1.setSelected(true);
        else
            rb2.setSelected(true);
        
         b.addActionListener(this);
         jc.select(state);
         jta.setText(address);
         tf6.setText(email);
         tf7.setText(Long.toString(pno));
         tf8.setText(waccno);
         tf9.setText(wname);
         tf10.setText(Long.toString(wpno));
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
    Cupdate()
    {
         super("Update Customer Data");
       
    }
  

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        int wa=0;
        
        
        
        
        String email,name,middle,last,fname,dob,gender,state,address,date,wname,waccno,code;
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
        email=tf6.getText();
        try
        {
        pno=Long.parseLong(tf7.getText());  
        }
        catch(Exception ex)
        {
            n=1;
        }
        
        wname=tf9.getText();
        waccno=tf8.getText();
        try
        {
        wpno=Long.parseLong(tf10.getText());  
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
       else if((tf10.getText().length())!=10||n1==1)
    {
        JOptionPane.showMessageDialog(this,"Invalid Witness Phone Number");
    }
       else if((tf6.getText().indexOf('@'))==-1||tf6.getText().indexOf('.',tf6.getText().indexOf('@'))==-1)
    {
        JOptionPane.showMessageDialog(this,"Fill E-Mail ID Properly\n\n\tEg:  rahul.mahajan1994@yahoo.com");
    }
        else if((tf7.getText().length())!=10||n==1)
    {
        JOptionPane.showMessageDialog(this,"Invalid Phone Number");
    }
        
        
        
        
        else
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
     
             System.out.println("crahul");
             while(rs.next())
             {
                 if(rs.getString("accno").equals(waccno))
                 {
                     System.out.println("rahul");
                     wa=1;
                    
                 }
             }
            
         }
        catch(Exception ex)
        {
            
        }
        if(wa==1)
            
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
             if(wa==1)
             {
         while(rs.next())
         {
          System.out.println("rahul");
          if(rs.getString("accno").equals(accno))
          {
              
              System.out.println("crahul1");
              name=tf1.getText().concat(" "+tf2.getText());
              name=name.concat(" "+tf3.getText());
              rs.updateString("name",name);
              rs.updateString("fname",tf4.getText());
              rs.updateString("dob", tf5.getText());
           
                  rs.updateString("gender", gender);
                  rs.updateString("state", jc.getSelectedItem());
                  rs.updateString("address",jta.getText());
                  rs.updateString("email", tf6.getText());
                 
                  rs.updateLong("pno", pno);
                  rs.updateString("witnessaccno", tf8.getText());
                  rs.updateString("witnessname",tf9.getText());
                 
                  rs.updateLong("witnesspno",wpno);
                  rs.updateRow();
                  System.out.println("Crahulfinal");
                  JOptionPane.showMessageDialog(this,"Data Update Successfully");
                  this.dispose();
          }
      }
      }
             else
                 JOptionPane.showMessageDialog(this, "Invalid Witness Account Number");
        }
        catch(Exception ex)
        {
            
        }
        
        }
    }
}
