
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import org.jdesktop.swingx.prompt.PromptSupport;

public class AdminLogin extends javax.swing.JFrame 
{

    Statement stmt;
    ResultSet rs;
    Connection conn;

    public AdminLogin() 
    {
        try {
            //##code
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
            System.out.println("connection created");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statement created");      
//             ##code ends here
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
         setTitle("Admin Login");
        setSize(500, 450);
         //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            // PlaceHolder
            PromptSupport.setPrompt("USERNAME",tf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf1);
            PromptSupport.setPrompt("PASSWORD",pf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, pf1);
            //
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf1 = new javax.swing.JTextField();
        pf1 = new javax.swing.JPasswordField();
        bt1 = new javax.swing.JButton();
        adminlabel = new javax.swing.JLabel();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.red);
        setForeground(new java.awt.Color(51, 0, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        tf1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tf1);
        tf1.setBounds(170, 120, 280, 40);

        pf1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pf1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pf1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(pf1);
        pf1.setBounds(170, 190, 280, 40);

        bt1.setFont(new java.awt.Font("Cooper Black", 1, 16)); // NOI18N
        bt1.setText("LOGIN");
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bt1.setOpaque(false);
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(210, 250, 170, 40);

        adminlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon_1.png"))); // NOI18N
        getContentPane().add(adminlabel);
        adminlabel.setBounds(50, 50, 100, 70);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login Page Image_1.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(0, -20, 560, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        String u, p;
        u = tf1.getText();
        p = pf1.getText();
        //System.out.println(u+" "+p);
        if (u.equals("") || p.equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Please enter all the fields");
        }
        else 
        {
            try {
                rs = stmt.executeQuery("select * from admin where username='"+u+"' and password='"+p+"'");
                System.out.println("ResultSet created");
               
                if(rs.next())//true
                {
                   JOptionPane.showMessageDialog(this, "Login is Successful");
                  
                   AdminHome obj=new AdminHome();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Admin name or password is incorrect, please try again");
                     tf1.setText("");
                     pf1.setText("");
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminlabel;
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
