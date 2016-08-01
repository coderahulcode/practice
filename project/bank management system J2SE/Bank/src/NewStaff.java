import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.util.StringTokenizer;
public class NewStaff extends JFrame implements ActionListener
{
    Point p;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    Font f1,f2,f3;
     JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    Choice jc;
    TextArea jta;
    JButton b;
    Date d;
    
    
    NewStaff()    

    {
        super("New Staff");
        setVisible(true);
        setLayout(null);
        setSize(650,650);
        this.setResizable(false);
        p=new Point(300,20);
        this.setLocation(p);
         d=new Date();
        
        
        
       
        
       
        
        l1=new JLabel("NEW STAFF");
        l2=new JLabel("First Name");
        l3=new JLabel("Last Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("Date Of Birth (dd/mm/yyyy)");
        l6=new JLabel("Gender");
        l7=new JLabel("Qvalification");
        l8=new JLabel("State");
        l9=new JLabel("Full-Address");
        l10=new JLabel("EMail-ID");
        l11=new JLabel("Phone Number");
        l12=new JLabel("Current Date-time");
         b=new JButton("Submit");
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
       
        tf6.setBounds(250,280, 150,25);
        
        
        l8.setBounds(30,320,100,30);
        jc.setBounds(250,330,150,25);
       

        l9.setBounds(30,380,100,30);
        jta.setBounds(250,380,150,70);

        l10.setBounds(30,465,100,30);
        tf7.setBounds(250,465,150,25);
        l11.setBounds(30,505,150,30);
        tf8.setBounds(250,505,150,25);
        l12.setBounds(30, 540, 150, 30);
        tf9.setBounds(250,540,150,25);
        b.setBounds(130, 580, 130, 40);
        
        
        
        
        
        
        
        f1=new Font("Times New Roman",Font.BOLD,24);
        f2=new Font("Times New Roman",Font.PLAIN,16);
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
        l12.setFont(f2);
        
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
        
        
        
        
         b.addActionListener(this);
         tf9.setText(d.toLocaleString());
        tf9.setFocusable(false);
        try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");}
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args)
    {
    NewStaff ns=new NewStaff();    
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       String email,name,middle,last,fname,dob,gender,state,address,date,qval,empno;
        int a,rahul=0,i1=0,n=0,d=0,m=0,y=0,df=0;
        long pno=0;
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
        qval=tf6.getText();
        email=tf7.getText();
                  
        date=tf9.getText();
           try
        {
        pno=Long.parseLong(tf8.getText());  
        }
        catch(Exception ex)
        {
            n=1;
        }
         if(name.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Name Properly");
        else if(last.equals(""))
            
        JOptionPane.showMessageDialog(this,"Fill Last Name Properly");
        else if((tf7.getText().indexOf('@'))==-1||tf7.getText().indexOf('.',tf7.getText().indexOf('@'))==-1)
    {
        JOptionPane.showMessageDialog(this,"Fill E-Mail ID Properly\n\n\tEg:  rahul.mahajan1994@yahoo.com");
    }
        else if(fname.equals(""))
        JOptionPane.showMessageDialog(this,"Fill Father Name Properly");
      else if(address.equals(""))
         JOptionPane.showMessageDialog(this,"Fill Address Properly");       
      else if(qval.equals(""))
           JOptionPane.showMessageDialog(this,"Fill Qvalification Properly");
      
      else if((tf8.getText().length())!=10||n==1)
    {
        JOptionPane.showMessageDialog(this,"Invalid Phone Number");
    }
        
      else  if(email.equals(""))
     {
        JOptionPane.showMessageDialog(this,"Fill E-Mail ID Properly");
        
            
        }

     
        
        
     else 
     {
         System.out.println("rahul");
         System.out.println("rahul");
        name=name.concat(" "+middle);
        name=name.concat(" "+last);
        int c1;
        c1=(int)(1+9999*Math.random());
        empno=Integer.toString(c1);
       try
         {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");

      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","rahul");
      System.out.println("Connection build");

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      System.out.println("Statement Created");

      ResultSet rs = stmt.executeQuery("select * from staff");
      System.out.println("Resultset created");
             System.out.println("rahul");
      while(rs.next())
      {
          if(rs.getString("empno").equals(empno))
          {
            c1=(int)(1+9999*Math.random());
            empno=Integer.toString(c1);
          }
      }
      
      rs.moveToInsertRow();
      rs.updateString("empno", empno);
      rs.updateString("name", name);
      rs.updateString("fname",fname);
      rs.updateString("dob",dob);
      rs.updateString("gender", gender);
      rs.updateString("state",state);
      rs.updateString("address",address);
      rs.updateString("email",email);
      rs.updateLong("pno", pno);
      rs.updateString("date",date);
      rs.updateString("qval",qval);
      rs.insertRow();
      Congratulation c=new Congratulation(name,empno);
      this.dispose();
         }  
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
     }
    }
}