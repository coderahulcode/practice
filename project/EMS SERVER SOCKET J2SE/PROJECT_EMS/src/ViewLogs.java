
import java.io.*;
import java.sql.*;
import javax.swing.ImageIcon;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import ch.randelshofer.media.avi.AVIOutputStream;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.jdesktop.swingx.prompt.PromptSupport;

public class ViewLogs extends javax.swing.JFrame {

    ResultSet rs, rs2, rs3, rs4, rs5;
    Connection conn;
    Statement stmt, stmt2, stmt3, stmt4, stmt5;
    ArrayList<DateTime> al = new ArrayList<>();
    LogTableModel ltm = new LogTableModel();

    class DateTime {

        String date, time;

        DateTime(String d, String t) {
            date = d;
            time = t;

        }

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

    class LogTableModel extends AbstractTableModel {

        String Column_Name[] = {"DATE  (YYYY-MM-DD)", "TIME  (Hrs:Mins:Secs)"};

        public String getColumnName(int i) {

            return Column_Name[i];
        }

        public int getRowCount() {
            return al.size();

        }

        public int getColumnCount() {

            return 2;
        }

        public Object getValueAt(int row, int col) {
            if (col == 0) {
                return al.get(row).date;

            } else {

                return al.get(row).time;

            }

        }

    }

    public ViewLogs() {
        initComponents();
        // Binding LogTableModel with AbstractTableModel
        jt1.setModel(ltm);
       
       
        //
        
        sp1.setVisible(false);
        setSize(650, 650);
        setTitle("View Logs");
        bt2.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        ch1.addItem("select");

        cmb2.removeAllItems();
        cmb2.addItem("yyyy");
        cmb3.removeAllItems();
        cmb3.addItem("mm");
        cmb4.removeAllItems();
        cmb4.addItem("dd");
        cmb5.removeAllItems();
        cmb5.addItem("yyyy");
        cmb6.removeAllItems();
        cmb6.addItem("mm");
        cmb7.removeAllItems();
        cmb7.addItem("dd");
        for (int i = 1; i <= 12; i++) {
            cmb3.addItem(i);
            cmb6.addItem(i);
        }
        for (int i = 1; i <= 31; i++) {
            cmb4.addItem(i);
            cmb7.addItem(i);
        }
        for (int i = 2015; i <= 2030; i++) {
            cmb2.addItem(i);
            cmb5.addItem(i);
        }
        try {
            //##code
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
            System.out.println("connection created");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statement created");
            //     ##code ends here
            rs = stmt.executeQuery("select * from employee");
            System.out.println("resultset created");

            while (rs.next()) {
                ch1.addItem(rs.getString("emp_username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            // Place Holder
            PromptSupport.setPrompt("USERNAME",tf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf1);
            PromptSupport.setPrompt("NAME",tf2);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf2);
            PromptSupport.setPrompt("EMAIL",tf3);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf3);
            PromptSupport.setPrompt("PHONE",tf4);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf4);
            //
            
            
            //set lb8 icon
            
            try 
            {
                BufferedImage orgimage = ImageIO.read(getClass().getResource("dp.jpg"));
                BufferedImage resizedImage = resize(orgimage,lb8.getWidth(),lb8.getHeight());
                lb8.setIcon(new ImageIcon(resizedImage));
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            //
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        bt2 = new javax.swing.JButton();
        sp1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ch1 = new java.awt.Choice();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lby = new javax.swing.JLabel();
        lbm = new javax.swing.JLabel();
        lbd = new javax.swing.JLabel();
        cmb2 = new javax.swing.JComboBox();
        cmb3 = new javax.swing.JComboBox();
        cmb4 = new javax.swing.JComboBox();
        cmb5 = new javax.swing.JComboBox();
        cmb6 = new javax.swing.JComboBox();
        cmb7 = new javax.swing.JComboBox();
        lb3 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        panel.setBackground(new java.awt.Color(0, 102, 153));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setLayout(null);

        lb4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText("Username");
        panel.add(lb4);
        lb4.setBounds(10, 150, 60, 20);

        lb5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText("Name");
        panel.add(lb5);
        lb5.setBounds(10, 170, 60, 20);

        lb6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setText("Email");
        panel.add(lb6);
        lb6.setBounds(10, 190, 60, 20);

        lb7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb7.setForeground(new java.awt.Color(255, 255, 255));
        lb7.setText("Phone");
        panel.add(lb7);
        lb7.setBounds(10, 210, 60, 20);

        lb8.setBackground(new java.awt.Color(255, 255, 255));
        lb8.setForeground(new java.awt.Color(255, 255, 255));
        lb8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dp.jpg"))); // NOI18N
        lb8.setToolTipText("");
        lb8.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        lb8.setOpaque(true);
        panel.add(lb8);
        lb8.setBounds(50, 10, 160, 130);
        panel.add(tf1);
        tf1.setBounds(70, 150, 180, 20);
        panel.add(tf2);
        tf2.setBounds(70, 170, 180, 20);
        panel.add(tf3);
        tf3.setBounds(70, 190, 180, 20);
        panel.add(tf4);
        tf4.setBounds(70, 210, 180, 20);

        getContentPane().add(panel);
        panel.setBounds(370, 70, 260, 240);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt2.setText("VIEW VIDEO");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(290, 530, 150, 30);

        sp1.setBackground(new java.awt.Color(0, 102, 153));
        sp1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "LOG TABLE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0)))); // NOI18N
        sp1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jt1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sp1.setViewportView(jt1);

        getContentPane().add(sp1);
        sp1.setBounds(60, 310, 530, 190);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 247, 48));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOG HOME");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 20, 260, 40);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        ch1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch1ItemStateChanged(evt);
            }
        });
        jPanel1.add(ch1);
        ch1.setBounds(70, 40, 190, 30);

        lb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("SELECT EMPLOYEE");
        jPanel1.add(lb1);
        lb1.setBounds(110, 20, 140, 20);

        lb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("SELECT START DATE");
        jPanel1.add(lb2);
        lb2.setBounds(10, 110, 140, 20);

        lby.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lby.setForeground(new java.awt.Color(255, 255, 0));
        lby.setText("YEAR");
        jPanel1.add(lby);
        lby.setBounds(150, 80, 40, 20);

        lbm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbm.setForeground(new java.awt.Color(255, 255, 0));
        lbm.setText("MONTH");
        jPanel1.add(lbm);
        lbm.setBounds(210, 80, 50, 20);

        lbd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbd.setForeground(new java.awt.Color(255, 255, 0));
        lbd.setText("DAY");
        jPanel1.add(lbd);
        lbd.setBounds(290, 80, 40, 20);

        cmb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb2);
        cmb2.setBounds(140, 110, 56, 20);

        cmb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb3);
        cmb3.setBounds(210, 110, 56, 20);

        cmb4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb4);
        cmb4.setBounds(280, 110, 56, 20);

        cmb5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb5);
        cmb5.setBounds(140, 150, 56, 20);

        cmb6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb6);
        cmb6.setBounds(210, 150, 56, 20);

        cmb7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmb7);
        cmb7.setBounds(280, 150, 56, 20);

        lb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText("SELECT END DATE");
        jPanel1.add(lb3);
        lb3.setBounds(10, 150, 120, 20);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt1.setText("FETCH DETAILS");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        jPanel1.add(bt1);
        bt1.setBounds(90, 190, 160, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 70, 360, 240);

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bossy4.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 510, 290, 70);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminback.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(0, 0, 820, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ch1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch1ItemStateChanged
        String user = ch1.getSelectedItem();
        if(user.equals("select"))
        {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            try 
            {
                BufferedImage orgimage = ImageIO.read(getClass().getResource("dp.jpg"));
                BufferedImage resizedImage = resize(orgimage,lb8.getWidth(),lb8.getHeight());
                lb8.setIcon(new ImageIcon(resizedImage));
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
  
        }    
        // String user="mk13";
        
        else
        {      System.out.println(user);
                try {

                  stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                  System.out.println("statement created");
                  rs2 = stmt.executeQuery("select * from employee where emp_username='" + user + "'");
                  System.out.println("result set created");
                  if (rs2.next()) {
                      tf1.setText(rs2.getString("emp_username"));
                      tf2.setText(rs2.getString("name"));
                      tf3.setText(rs2.getString("email"));
                      tf4.setText(rs2.getString("phone"));
                      File f = new File(System.getProperty("user.home") + "\\images\\" + user + ".jpg");
                     //resize image code
                      BufferedImage orgimage = ImageIO.read(f);
                     BufferedImage resizedImage = resize(orgimage,lb8.getWidth(),lb8.getHeight());
                     //ends here
                      lb8.setIcon(new ImageIcon(resizedImage));
                  } else {
                      System.out.println("not found");
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
      }          
    }//GEN-LAST:event_ch1ItemStateChanged

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String username = ch1.getSelectedItem();
        int y1 = Integer.parseInt(cmb2.getSelectedItem().toString());
        int m1 = Integer.parseInt(cmb3.getSelectedItem().toString());
        int d1 = Integer.parseInt(cmb4.getSelectedItem().toString());
        int y2 = Integer.parseInt(cmb5.getSelectedItem().toString());
        int m2 = Integer.parseInt(cmb6.getSelectedItem().toString());
        int d2 = Integer.parseInt(cmb7.getSelectedItem().toString());
        java.sql.Date st = new java.sql.Date(y1 - 1900, m1 - 1, d1);
        java.sql.Date en = new java.sql.Date(y2 - 1900, m2 - 1, d2);

        al.clear();// DATA REFRESEH
        try {
            //##code
            stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // System.out.println("statement3 created");
            rs3 = stmt3.executeQuery("select distinct(start_date) from log where start_date>='" + st + "' and end_date<='" + en + "' and user_name='" + username + "'");
            // System.out.println("result set3 created");    
            while (rs3.next()) {
                String st_date1 = rs3.getString("start_date");

                stmt4 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                // System.out.println("statement created 4");
                rs4 = stmt4.executeQuery("select logid from log where start_date='" + st_date1 + "' and user_name='" + username + "'");
                // System.out.println("result set created 4");  
                int seconds = 0;
                int mins, hrs;
                String time;
                while (rs4.next()) {
                    int log_id = rs4.getInt("logid");

                    stmt5 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    // System.out.println("statement created 5");
                    rs5 = stmt5.executeQuery("select TIME_TO_SEC(end_time)-TIME_TO_SEC(start_time) as sec from log where logid=" + log_id);
                    // System.out.println("result set created 5");  
                    if (rs5.next()) {
                        seconds = seconds + rs5.getInt("sec");
                    }
                }

                if (seconds < 60) {
                    mins = 0;
                    hrs = 0;
                    seconds = seconds;
                    time = "00:00:" + seconds;
                } else if (seconds < 3600) {
                    hrs = 0;
                    mins = seconds / 60;
                    seconds %= 60;
                    time = "00:" + mins + ":" + seconds;
                } else {
                    hrs = seconds / 3600;
                    seconds = seconds / 60;
                    mins = seconds / 60;
                    seconds = seconds % 60;
                    time = hrs + ":" + mins + ":" + seconds;
                }
                System.out.println("start date=" + st_date1 + " time=" + time);
                al.add(new DateTime(st_date1, time));
                sp1.setVisible(true);
                bt2.setVisible(true);
            }

            ltm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        if (jt1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please Select the Row first");

        } else {
            String cur_user = ch1.getSelectedItem();
            String cur_date = al.get(jt1.getSelectedRow()).date;
            System.out.println(cur_user + " " + cur_date);

            File dir = new File(System.getProperty("user.home") + "\\videosEMS");
            if (!dir.exists()) {
                dir.mkdir();

            }
            dir = new File(dir.getPath() + "\\"+cur_user);//  c://mk_13//gur//
            if (!dir.exists()) {
                dir.mkdir();

            }
            File f = new File(dir.getPath() + "\\" + cur_date + ".avi");  // c:\\mk_13\\cur_user\\date.avi
            if (f.exists()) {
                   
                System.out.println("in view video");
               
                
                //to view video in default media player+
                try 
                 {
                     Thread.sleep(4000);
                    Desktop.getDesktop().open(f);
                    
              
                } 
                 catch (Exception e) 
                 {
                     e.printStackTrace();
                }
              
               

            } else {

                System.out.println("in create video");
                
               
                // Code of Creation of Video from Images
                try {

                    
                    AVIOutputStream av = new AVIOutputStream(f, AVIOutputStream.VideoFormat.JPG);

                    File f2 = new File((System.getProperty("user.home")+"\\ScreenShots\\"+cur_user+"\\"+cur_date));// Images Folder Path 
                    System.out.println(f2.getPath());
                    int len = f2.listFiles().length;

                    av.setFrameRate(3);
                    av.setVideoDimension(500, 500);

                    for (int i = 0; i < len; i++) {
                        File f1 = new File(f2 + "\\" + i + ".jpg");
                        FileInputStream fis = new FileInputStream(f1);
                        av.writeFrame(fis);
                        System.out.println("Image fetched : " + i);
                    }

                    av.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //to view video in default media player  
                bt2.setLabel("starting video");
                try 
                 {
                    Desktop.getDesktop().open(f);
                   
                   
                } 
                 catch (Exception e) 
                 {
                     e.printStackTrace();
                 }
            }

        }


    }//GEN-LAST:event_bt2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private java.awt.Choice ch1;
    private javax.swing.JComboBox cmb2;
    private javax.swing.JComboBox cmb3;
    private javax.swing.JComboBox cmb4;
    private javax.swing.JComboBox cmb5;
    private javax.swing.JComboBox cmb6;
    private javax.swing.JComboBox cmb7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lbd;
    private javax.swing.JLabel lbm;
    private javax.swing.JLabel lby;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
