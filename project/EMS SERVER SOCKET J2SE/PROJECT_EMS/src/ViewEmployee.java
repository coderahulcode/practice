import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
//import javax.swing.JOptionPane;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import org.jdesktop.swingx.prompt.PromptSupport;
public class ViewEmployee extends javax.swing.JFrame {

    ArrayList<Employee> al = new ArrayList<>();
      Statement stmt;
      ResultSet rs;
      Connection conn;
     EmployeeTableModel etm;
      String photoPath;//storing the path of original photo of emplyoee
    public ViewEmployee() {

        initComponents();
        panel.setVisible(false);
        getdata();
        setSize(650, 650);
        setTitle("View Employee");
         //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            PromptSupport.setPrompt("USERNAME",tf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf1);
            PromptSupport.setPrompt("NAME",tf2);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf2);
            PromptSupport.setPrompt("PHONE NUMBER",tf3);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf3);
            PromptSupport.setPrompt("EMAIL",tf4);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf4);
            
                
            //PlaceHolder
         tf5.setFocusable(false);
         
        setVisible(true);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE
     
    }
   //function to resize image
     public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
     //till here
    void getdata() {
        al.clear();
        try {
            //##code
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
            System.out.println("connection created");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statement created");
            rs = stmt.executeQuery("select * from employee");
            System.out.println("ResultSet created");
//             ##code ends here

            while (rs.next()) {
                al.add(new Employee(rs.getString("emp_username"), rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("phone")));
                // System.out.println(rs.getString("emp_username")+rs.getString("name")+rs.getString("password")+rs.getString("email")+rs.getString("phone"));
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        etm = new EmployeeTableModel();
        jt.setModel(etm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        bt3 = new javax.swing.JButton();
        tf5 = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        bt4 = new javax.swing.JButton();
        phlabel = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        bt2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        panel.setBackground(new java.awt.Color(102, 102, 102));
        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 2, true));
        panel.setLayout(null);

        lb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 0));
        lb1.setText("EDIT INFORMATION");
        panel.add(lb1);
        lb1.setBounds(90, 10, 190, 30);

        lb5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText("SELECT PHOTO");
        panel.add(lb5);
        lb5.setBounds(10, 170, 80, 44);

        lb4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText("PHONE");
        panel.add(lb4);
        lb4.setBounds(20, 121, 63, 23);

        lb2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("USERNAME");
        panel.add(lb2);
        lb2.setBounds(20, 60, 63, 23);

        lb3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText("NAME");
        panel.add(lb3);
        lb3.setBounds(20, 90, 50, 20);
        panel.add(tf1);
        tf1.setBounds(90, 60, 240, 20);

        tf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf4FocusLost(evt);
            }
        });
        panel.add(tf4);
        tf4.setBounds(90, 150, 240, 20);
        panel.add(tf2);
        tf2.setBounds(90, 90, 240, 20);

        tf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf3FocusLost(evt);
            }
        });
        panel.add(tf3);
        tf3.setBounds(90, 120, 240, 20);

        bt3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt3.setText("UPDATE");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        panel.add(bt3);
        bt3.setBounds(140, 210, 110, 30);
        panel.add(tf5);
        tf5.setBounds(90, 180, 240, 20);

        lb6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setText("EMAIL");
        panel.add(lb6);
        lb6.setBounds(20, 140, 63, 44);

        bt4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt4.setText("Browse");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        panel.add(bt4);
        bt4.setBounds(350, 180, 80, 20);
        panel.add(phlabel);
        phlabel.setBounds(340, 20, 100, 110);

        getContentPane().add(panel);
        panel.setBounds(100, 120, 450, 250);

        sp.setBackground(new java.awt.Color(51, 51, 51));
        sp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMPLOYEE DIRECTORY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 51))); // NOI18N
        sp.setForeground(new java.awt.Color(255, 255, 51));

        jt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jt.setGridColor(new java.awt.Color(0, 0, 0));
        jt.setOpaque(false);
        jt.setSelectionBackground(new java.awt.Color(102, 102, 255));
        sp.setViewportView(jt);

        getContentPane().add(sp);
        sp.setBounds(10, 70, 610, 440);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt2.setText("EDIT");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(470, 530, 90, 30);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt1.setText("DELETE");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(70, 530, 100, 30);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIEW EMPLOYEES");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 370, 40);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminback.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(0, 0, 730, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
  //to edit a row, here scrollpane is disappeared and edit panel is displayed  
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
      
        if (jt.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "SELECT ROW FIRST");
        } 
        else 
        {
            String pk;
            pk = al.get(jt.getSelectedRow()).emp;
           // System.out.println(pk);
            sp.setVisible(false);
            
            tf1.setText(pk);
            tf1.setFocusable(false);
            tf2.setText(al.get(jt.getSelectedRow()).n);
            tf3.setText(al.get(jt.getSelectedRow()).ph);
            tf4.setText(al.get(jt.getSelectedRow()).email);
            tf5.setText(System.getProperty("user.home")+"\\images\\"+pk+".jpg");
           
            //photo applying
               try
               {
                  photoPath=System.getProperty("user.home") + "\\images\\" + pk + ".jpg";
                   System.out.println(photoPath+"edit button");
                   File f = new File(System.getProperty("user.home") + "\\images\\" + pk + ".jpg");
                //resize image code
                 BufferedImage orgimage = ImageIO.read(f);
                BufferedImage resizedImage = resize(orgimage,phlabel.getWidth(),phlabel.getHeight());
                //ends here
                 phlabel.setIcon(new ImageIcon(resizedImage));
                } 
               catch (Exception e)
               {
                   
               }
              
               
            //
             panel.setVisible(true);
            bt1.setVisible(false);
            bt2.setVisible(false);
        }
    }//GEN-LAST:event_bt2ActionPerformed

    //delete button
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        if (jt.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "SELECT ROW FIRST");
        } 
        else 
        {
            String pk;
            pk = al.get(jt.getSelectedRow()).emp;
            //System.out.println(pk);

            try {
                rs = stmt.executeQuery("select * from employee where emp_username='" + pk + "'");
                if (rs.next()) 
                {
                    rs.deleteRow();
                    getdata();
                }
              String path=System.getProperty("user.home")+"\\images\\"+pk+".jpg";
              File f=new File(path);
              f.delete();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt1ActionPerformed
 
    //to update the values in jtable as well ass database
    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        if (tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "ENTER ALL THE DETAILS");
        } 
        else 
        {
            try 
            {
                rs = stmt.executeQuery("select * from employee where emp_username='" + tf1.getText() + "'");
                if (rs.next()) 
                {
                    rs.updateString("name", tf2.getText());
                    rs.updateString("phone", tf3.getText());
                    rs.updateString("email", tf4.getText());
                    rs.updateRow();
                    getdata();
                   // this.setSize(650,450);
                    sp.setVisible(true);
                    panel.setVisible(false);
                    bt1.setVisible(true);
                    bt2.setVisible(true);
                }
                // photo updating
                
                String emp=tf1.getText();
                String path=tf5.getText();
             if(!photoPath.equals(path)) 
             {  
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
                //
            } 
            catch(Exception e) 
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt3ActionPerformed

    private void tf3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf3FocusLost
          System.out.println("in lost");
        if(!tf3.getText().equals(""))
       {
        
        try 
        {
            if(tf3.getText().length()==10)
            {
            long check=Long.parseLong(tf3.getText());
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Enter a valid phone number");
                 tf3.setText("");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            tf3.setText("");
            JOptionPane.showMessageDialog(this, "Enter a valid phone number");
        }
       }       
    }//GEN-LAST:event_tf3FocusLost

    private void tf4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf4FocusLost
      String check=tf4.getText();
         
          if(check.indexOf("@")==0||check.lastIndexOf("@")==-1||check.lastIndexOf(".")==-1||check.lastIndexOf("@")>check.lastIndexOf("."))
          {
              JOptionPane.showMessageDialog(this, "Please enter a valid email address");
              tf4.setText("");
          }
          
        
    }//GEN-LAST:event_tf4FocusLost

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
       
        JFileChooser fc=new JFileChooser();
      // fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));//code to filter images
        fc.setAcceptAllFileFilterUsed(true);
       int r=fc.showOpenDialog(this);
       
       if(r==JFileChooser.APPROVE_OPTION)
       {
           String path=fc.getSelectedFile().getPath();
           tf5.setText(path);
       }
        
    }//GEN-LAST:event_bt4ActionPerformed
   
    class Employee {

        String emp, n, ph, email, p;

        Employee(String emp, String n, String p, String email, String ph) {
            this.emp = emp;
            this.n = n;
            this.p = p;
            this.email = email;
            this.ph = ph;
        }
    }  //for arraylist al

    class EmployeeTableModel extends AbstractTableModel {

        String columnName[] = {"USERNAME", "NAME", "PASSWORD", "EMAIL", "PHONE"};

        public String getColumnName(int i) 
        {
            return columnName[i];
        }

        public int getRowCount() 
        {
            return al.size();
        }

        public int getColumnCount() 
        {
            return 5;
        }

        public Object getValueAt(int row, int col) 
        {
            if (col == 0) 
            {
                return al.get(row).emp;
            } 
            else if (col == 1) 
            {
                return al.get(row).n;
            } 
            else if (col == 2) 
            {
                return al.get(row).p;
            } 
            else if (col == 3) 
            {
                return al.get(row).email;
            } else 
            {
                return al.get(row).ph;
            }
        }

    } //for etm

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jt;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel phlabel;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
