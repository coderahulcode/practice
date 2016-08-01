import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientGUI extends javax.swing.JFrame
{
    DataInputStream dis;
    DataOutputStream dos;
    Socket sock;

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

    public ClientGUI()
    {
        initComponents();
        this.setSize(500, 350);
        this.setResizable(false);
        this.setTitle("Client");
        createFolders();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        tfIp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btConnect = new javax.swing.JButton();
        btSignUp = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        btChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        tfIp.setText("127.0.0.1");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Fill IP");

        btConnect.setText("Connect");
        btConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btConnectActionPerformed(evt);
            }
        });

        btSignUp.setText("Sign Up");
        btSignUp.setEnabled(false);
        btSignUp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSignUpActionPerformed(evt);
            }
        });

        btLogin.setText("Login");
        btLogin.setEnabled(false);
        btLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btLoginActionPerformed(evt);
            }
        });

        btChangePassword.setText("Change Password");
        btChangePassword.setEnabled(false);
        btChangePassword.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfIp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btChangePassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfIp)
                    .addComponent(btConnect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 620, 330);

        setSize(new java.awt.Dimension(635, 365));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btConnectActionPerformed
    {//GEN-HEADEREND:event_btConnectActionPerformed
        try
        {
            sock = new Socket(tfIp.getText(), 9000);
            dos = new DataOutputStream((sock.getOutputStream()));
            dis = new DataInputStream(sock.getInputStream());
            System.out.println("Connection Build");

            btLogin.setEnabled(true);
            btSignUp.setEnabled(true);
            btChangePassword.setEnabled(true);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Server Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConnectActionPerformed

    private void btSignUpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSignUpActionPerformed
    {//GEN-HEADEREND:event_btSignUpActionPerformed
        SignUp obj = new SignUp();

    }//GEN-LAST:event_btSignUpActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btLoginActionPerformed
    {//GEN-HEADEREND:event_btLoginActionPerformed
        try
        {
            Login obj = new Login();
            obj.dos = dos;
            obj.dis = dis;
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void btChangePasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btChangePasswordActionPerformed
    {//GEN-HEADEREND:event_btChangePasswordActionPerformed
        ChangePassword obj = new ChangePassword();
        obj.dis = dis;
        obj.dos = dos;
    }//GEN-LAST:event_btChangePasswordActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChangePassword;
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfIp;
    // End of variables declaration//GEN-END:variables

    /*-------------------------------------------------------------------------------------------------------------------------------------
     ***End of Client GUI
     ---------------------------------------------------------------------------------------------------------------------------------------*/
    /*----------------- Sign Up Inner Class------------------------------------------------*/
    public class SignUp extends javax.swing.JFrame
    {

        /**
         * Creates new form SignUp
         */
        public SignUp()
        {
            initComponents();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
            this.setTitle("Sign Up");
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            tfContact = new javax.swing.JTextField();
            tfFName = new javax.swing.JTextField();
            tfLName = new javax.swing.JTextField();
            tfConPass = new javax.swing.JPasswordField();
            tfPass = new javax.swing.JPasswordField();
            tfEmail = new javax.swing.JTextField();
            cbSecurity = new javax.swing.JComboBox();
            tfAnswer = new javax.swing.JTextField();
            btSignUp = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(0, 153, 255));

            jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel1.setText("First Name");

            jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel2.setText("Last Name");

            jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel3.setText("Email");

            jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel4.setText("Password");

            jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel5.setText("Confirm Password");

            jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel6.setText("Contact");

            jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel7.setText("Security Question");

            jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
            jLabel8.setText("Answer");

            cbSecurity.setModel(new javax.swing.DefaultComboBoxModel(new String[]
            {
                "Who is your best friend?",
                "Where did you study?",
                "What is your favorite dish?"
            }));

            btSignUp.setText("Sign Up");
            btSignUp.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btSignUpActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfPass, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                    .addComponent(btSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(84, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfFName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfLName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addComponent(btSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(32, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>                        

        private void btSignUpActionPerformed(java.awt.event.ActionEvent evt)
        {
            if (tfFName.getText().trim().isEmpty() || tfLName.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty() || tfContact.getText().trim().isEmpty() || tfPass.getText().isEmpty() || tfConPass.getText().isEmpty() || tfAnswer.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Fill all fields", "Field Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(tfPass.getText().equals(tfConPass.getText())))
            {
                JOptionPane.showMessageDialog(this, "Password not matched", "Field Error", JOptionPane.ERROR_MESSAGE);

            } else
            {
                try
                {

                    dos.writeBytes("signup" + "\r\n");
                    dos.writeBytes(tfFName.getText() + "\r\n");
                    dos.writeBytes(tfLName.getText() + "\r\n");
                    dos.writeBytes(tfEmail.getText() + "\r\n");
                    dos.writeBytes(tfPass.getText() + "\r\n");
                    dos.writeBytes(tfContact.getText() + "\r\n");
                    dos.writeBytes(cbSecurity.getSelectedItem().toString() + "\r\n");
                    dos.writeBytes(tfAnswer.getText() + "\r\n");

                    String msg = dis.readLine();
                    if (msg.equals("AlreadyExists"))
                    {
                        JOptionPane.showMessageDialog(this, "Email already registered", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (msg.equals("successful"))
                    {
                        JOptionPane.showMessageDialog(this, "Registration Successful", "Successful", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } else
                    {
                        JOptionPane.showMessageDialog(this, "Server Error", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } catch (Exception e)
                {
                }

            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btSignUp;
        private javax.swing.JComboBox cbSecurity;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField tfAnswer;
        private javax.swing.JPasswordField tfConPass;
        private javax.swing.JTextField tfContact;
        private javax.swing.JTextField tfEmail;
        private javax.swing.JTextField tfFName;
        private javax.swing.JTextField tfLName;
        private javax.swing.JPasswordField tfPass;
        // End of variables declaration                   
    }

    /*----------------- Sign Up Inner Class Finished---------------------------------------*/
    /*----------------- Forgot Password Inner Class------------------------------------------------*/
    public class ForgetPassword extends javax.swing.JFrame
    {

        String answer, password;

        public ForgetPassword()
        {
            initComponents();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(650, 350);
            setResizable(false);
            setVisible(true);

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            tfEmail = new javax.swing.JTextField();
            tfSec = new javax.swing.JTextField();
            tfAns = new javax.swing.JTextField();
            btGo = new javax.swing.JButton();
            btSubmit = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            jPanel1.setBackground(new java.awt.Color(0, 0, 0));
            jPanel1.setForeground(new java.awt.Color(204, 255, 0));

            jLabel1.setForeground(new java.awt.Color(204, 255, 0));
            jLabel1.setText("Enter Email");

            jLabel2.setForeground(new java.awt.Color(204, 255, 0));
            jLabel2.setText("Security Question");

            jLabel3.setForeground(new java.awt.Color(204, 255, 0));
            jLabel3.setText("Security Answer");

            tfSec.setFocusable(false);

            btGo.setText("Go");
            btGo.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btGoActionPerformed(evt);
                }
            });

            btSubmit.setText("Submit");
            btSubmit.setEnabled(false);
            btSubmit.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btSubmitActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfSec, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btGo, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfAns, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(47, 47, 47))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(btGo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfSec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfAns, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(39, Short.MAX_VALUE))
            );

            getContentPane().add(jPanel1);
            jPanel1.setBounds(40, 30, 560, 250);

            setSize(new java.awt.Dimension(655, 350));
            setLocationRelativeTo(null);
        }// </editor-fold>                        

        private void btGoActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());

            } catch (Exception e)
            {
            }
            if (tfEmail.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Fill Email Id", "Field Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
                try
                {
                    dos.writeBytes("forgotPassword\r\n");
                    dos.writeBytes(tfEmail.getText() + "\r\n");
                    if (dis.readLine().equals("found"))
                    {
                        btSubmit.setEnabled(true);
                        tfSec.setText(dis.readLine());
                        answer = dis.readLine();
                        password = dis.readLine();
                    } else
                    {
                        System.out.println("Invalid Email");
                    }

                } catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        private void btSubmitActionPerformed(java.awt.event.ActionEvent evt)
        {
            if (tfSec.getText().isEmpty() || tfAns.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Fill All fields", "Field Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
                if (answer.equals(tfAns.getText()))
                {
                    JOptionPane.showMessageDialog(this, "Your Password is: " + password, "Message", JOptionPane.INFORMATION_MESSAGE);
                } else
                {
                    JOptionPane.showMessageDialog(this, "Please enter correct answer", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btGo;
        private javax.swing.JButton btSubmit;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField tfAns;
        private javax.swing.JTextField tfEmail;
        private javax.swing.JTextField tfSec;
        // End of variables declaration                   
    }
    /*----------------- Forgot Password Inner Class Finished---------------------------------------*/

    /*----------------- Change Password Inner Class------------------------------------------------*/
    public class ChangePassword extends javax.swing.JFrame
    {
        DataOutputStream dos;
        DataInputStream dis;

        public ChangePassword()
        {
            initComponents();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            tfEmail = new javax.swing.JTextField();
            tfConPass = new javax.swing.JPasswordField();
            tfOldPassword = new javax.swing.JPasswordField();
            tfNewPassword = new javax.swing.JPasswordField();
            btChangePass = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(51, 153, 255));

            jLabel1.setText("Email");

            jLabel2.setText("Old Password");

            jLabel3.setText("New Password");

            jLabel4.setText("Confirm Password");

            btChangePass.setText("Change Password");
            btChangePass.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btChangePassActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(tfOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(tfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(tfConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btChangePass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(164, 164, 164))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(btChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(44, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }// </editor-fold>                        

        private void btChangePassActionPerformed(java.awt.event.ActionEvent evt)
        {

            if (tfConPass.getText().isEmpty() || tfEmail.getText().isEmpty() || tfNewPassword.getText().isEmpty() || tfOldPassword.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Fill All fields", "Field Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
                try
                {
                    dos.writeBytes("changePassword\r\n");
                    dos.writeBytes(tfEmail.getText() + "\r\n");
                    dos.writeBytes(tfOldPassword.getText() + "\r\n");
                    dos.writeBytes(tfNewPassword.getText() + "\r\n");

                    String msg = dis.readLine();
                    JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.ERROR_MESSAGE);

                } catch (Exception e)
                {

                }

            }
//        else if(tfNewPassword==tfConPass)
//        {
//            System.out.println("Password Matched Change Successfully");
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(this, "Password Mismatch", "Field Error", JOptionPane.ERROR_MESSAGE);
//        }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btChangePass;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPasswordField tfConPass;
        private javax.swing.JTextField tfEmail;
        private javax.swing.JPasswordField tfNewPassword;
        private javax.swing.JPasswordField tfOldPassword;
        // End of variables declaration                   
    }

    /*----------------- Change Password Inner Class Finished---------------------------------------*/
}
