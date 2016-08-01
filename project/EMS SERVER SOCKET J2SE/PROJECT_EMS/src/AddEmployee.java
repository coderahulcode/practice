import java.awt.Toolkit;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.swingx.prompt.PromptSupport;

public class AddEmployee extends javax.swing.JFrame {
    Statement stmt;
    ResultSet rs;
    Connection conn;
    String path;
    public AddEmployee() 
    {
        try 
        {
            //##code
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
            System.out.println("connection created");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statement created");
//             ##code ends here
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        initComponents();
        setSize(650,650);
        setTitle("Add Employee");
        tf5.setFocusable(false);
         //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            
            //PlaceHolder
              
            PromptSupport.setPrompt("USERNAME",tf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf1);
            PromptSupport.setPrompt("NAME",tf2);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf2);
            PromptSupport.setPrompt("EMAIL",tf3);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf3);
            PromptSupport.setPrompt("PHONE NUMBER",tf4);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf4);
            PromptSupport.setPrompt("SELECT PHOTO",tf5);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf5);
            
            
            //ends here place holder
            
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE
      
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt2 = new javax.swing.JButton();
        tf5 = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf1 = new javax.swing.JTextField();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lb1.setBackground(new java.awt.Color(102, 102, 102));
        lb1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 0));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("ADD EMPLOYEE");
        lb1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb1.setOpaque(true);
        getContentPane().add(lb1);
        lb1.setBounds(200, 30, 250, 50);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt1.setText("ADD ");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(250, 520, 150, 40);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(null);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt2.setText("Browse");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel1.add(bt2);
        bt2.setBounds(420, 290, 80, 30);
        jPanel1.add(tf5);
        tf5.setBounds(150, 250, 350, 30);

        lb6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setText("Select Photo");
        jPanel1.add(lb6);
        lb6.setBounds(40, 250, 93, 30);

        tf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf4FocusLost(evt);
            }
        });
        jPanel1.add(tf4);
        tf4.setBounds(150, 200, 350, 30);

        tf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf3FocusLost(evt);
            }
        });
        jPanel1.add(tf3);
        tf3.setBounds(150, 150, 350, 30);
        jPanel1.add(tf2);
        tf2.setBounds(150, 100, 350, 30);
        jPanel1.add(tf1);
        tf1.setBounds(150, 50, 350, 29);

        lb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText("Email");
        jPanel1.add(lb4);
        lb4.setBounds(40, 150, 93, 30);

        lb5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText("Phone No.");
        jPanel1.add(lb5);
        lb5.setBounds(40, 200, 93, 30);

        lb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText("Name");
        jPanel1.add(lb3);
        lb3.setBounds(40, 100, 93, 30);

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("Username");
        jPanel1.add(lb2);
        lb2.setBounds(40, 50, 93, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FILL DETAILS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 10, 180, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 130, 530, 360);

        backlabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminback.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(0, 0, 650, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        
        try 
        {
            String emp,n,ph,email,p;
            
            emp=tf1.getText();
            n=tf2.getText();
            email=tf3.getText();
            ph=tf4.getText();
            
            if(emp.equals("")||n.equals("")||email.equals("")||ph.equals("")||tf5.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please Enter All the Details");
                
            }
            else
            {
                rs=stmt.executeQuery("select * from employee where emp_username='"+emp+"'");
                System.out.println("Statement created");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(this,"This Username Already Exists");
                 }
                else
                {
                    //password generation
                    double d=10000+89999*Math.random();
                    p=(int)d+"";
                    //System.out.println("password="+p);
                    
                    //insert new employee
                    rs.moveToInsertRow();
                    rs.updateString("emp_username",emp);
                    rs.updateString("name",n);
                    rs.updateString("password",p);
                    rs.updateString("email",email);
                    rs.updateString("phone",ph);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this,"Employee Added");
                }
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                //to save photo
                try 
                {
                    FileInputStream fis=new FileInputStream(path);
                   File dir=new File(System.getProperty("user.home")+"\\images");
                    if(!dir.exists())
                {
                     dir.mkdir();    
                }
                                 
                   System.out.println(dir.getPath());
                   FileOutputStream fos=new FileOutputStream(dir.getPath()+"\\"+emp+".jpg"); 
                   byte b[]=new byte[10000];
                   while(true)
                   {
                    int r=fis.read(b, 0, 10000);
                    if(r==-1)
                        break;
                    fos.write(b, 0, r);
                   }
                   fos.close();
                   fis.close();
                   System.out.println("image copied");
                } 
                catch (Exception e) 
                {
                  e.printStackTrace();
                }
               
                
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        JFileChooser fc=new JFileChooser();
      // fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));//code to filter images
        fc.setAcceptAllFileFilterUsed(true);
       int r=fc.showOpenDialog(this);
       if(r==JFileChooser.APPROVE_OPTION)
       {
           path=fc.getSelectedFile().getPath();
           tf5.setText(path);
       }
       
    }//GEN-LAST:event_bt2ActionPerformed

    private void tf4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf4FocusLost
       
        System.out.println("in lost");
        if(!tf4.getText().equals(""))
       {
        
        try 
        {
            if(tf4.getText().length()==10)
            {
            long check=Long.parseLong(tf4.getText());
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Enter a valid phone number");
                 tf4.setText("");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            tf4.setText("");
            JOptionPane.showMessageDialog(this, "Enter a valid phone number");
        }
       }
    }//GEN-LAST:event_tf4FocusLost

    private void tf3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf3FocusLost
          String check=tf3.getText();
         
          if(check.lastIndexOf("@")==-1||check.lastIndexOf(".")==-1||check.lastIndexOf("@")>check.lastIndexOf("."))
          {
              JOptionPane.showMessageDialog(this, "Please enter a valid email address");
              tf3.setText("");
          }
          
    }//GEN-LAST:event_tf3FocusLost
     
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
