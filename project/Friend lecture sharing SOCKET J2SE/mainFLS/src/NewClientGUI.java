import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NewClientGUI extends javax.swing.JFrame
{


    DataInputStream dis;
    DataOutputStream dos;
    Socket sock;
    public  javax.swing.JButton btHome1;
    public javax.swing.JButton btLogin2;
    public javax.swing.JButton btLogout3;

    public NewClientGUI()
    {
        initComponents();
        btHome1=this.btHome;
        btLogin2=this.btLogin;
        btLogout3=this.btLogout;
        this.setVisible(true);
        this.setSize(675, 408);
        this.setResizable(false);
        this.setTitle("Welcome to FLS");
        createFolders();

        //hide label and button
        lbConnected.setVisible(false);
        btLogin.setVisible(false);
        btHome.setVisible(false);
        btLogout.setVisible(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        tfIp = new javax.swing.JTextField();
        btConnect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbConnected = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        btHome = new javax.swing.JButton();
        btLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tfIp);
        tfIp.setBounds(270, 330, 240, 30);

        btConnect.setText("Connect");
        btConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btConnectActionPerformed(evt);
            }
        });
        getContentPane().add(btConnect);
        btConnect.setBounds(520, 330, 110, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Fill Server Ip");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 300, 130, 30);

        lbConnected.setText("Connected to server please Login");
        getContentPane().add(lbConnected);
        lbConnected.setBounds(460, 120, 210, 40);

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btLogin);
        btLogin.setBounds(460, 160, 170, 40);

        btHome.setText("Home Page");
        btHome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btHome);
        btHome.setBounds(460, 210, 170, 40);

        btLogout.setText("Exit");
        btLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btLogout);
        btLogout.setBounds(460, 260, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fls5.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 670, 380);

        setSize(new java.awt.Dimension(686, 416));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btConnectActionPerformed
    {//GEN-HEADEREND:event_btConnectActionPerformed
       //hide label and button
        lbConnected.setVisible(false);
        btLogin.setVisible(false);
        btHome.setVisible(false);
        btLogout.setVisible(false); 
        try
        {
            if (tfIp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please fill ip address", "Field Error", JOptionPane.ERROR_MESSAGE);

            }
            else
            {
            sock = new Socket(tfIp.getText(), 9000);
            dos = new DataOutputStream((sock.getOutputStream()));
            dis = new DataInputStream(sock.getInputStream());
            System.out.println("Connection Build");
            lbConnected.setVisible(true);
            btLogin.setVisible(true);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Server Error\nMight server is not running", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConnectActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btLoginActionPerformed
    {//GEN-HEADEREND:event_btLoginActionPerformed
        Login obj = new Login();
        obj.sock=sock;
        obj.newClientGUI=this;

    }//GEN-LAST:event_btLoginActionPerformed

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btLogoutActionPerformed
    {//GEN-HEADEREND:event_btLogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btHomeActionPerformed
    {//GEN-HEADEREND:event_btHomeActionPerformed
        NewHomeGUI obj=new NewHomeGUI("Homepage "+this.getTitle().substring(14));
        obj.dis=dis;
        obj.dos=dos;
    }//GEN-LAST:event_btHomeActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(NewClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(NewClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(NewClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(NewClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new NewClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbConnected;
    private javax.swing.JTextField tfIp;
    // End of variables declaration//GEN-END:variables

    public void createFolders()
    {
        try
        {
            File f = new File("C:\\FriendLectureSharing");
            if (!f.exists())
            {
                f.mkdir();
            }

            f = new File("C:\\FriendLectureSharing\\Pdf");
            if (!f.exists())
            {
                f.mkdir();
            }
            f = new File("C:\\FriendLectureSharing\\Videos");
            if (!f.exists())
            {
                f.mkdir();
            }
            f = new File("C:\\FriendLectureSharing\\Images");
            if (!f.exists())
            {
                f.mkdir();
            }
            f = new File("C:\\FriendLectureSharing\\Software");
            if (!f.exists())
            {
                f.mkdir();
            }
        } catch (Exception e)
        {
        }
    }

}
