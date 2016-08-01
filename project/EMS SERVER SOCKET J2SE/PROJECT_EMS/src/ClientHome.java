
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.swingx.prompt.PromptSupport;

public class ClientHome extends javax.swing.JFrame implements WindowListener {

    String ip;

    boolean flag;
    Client obj;//connection builder
    PClient pobj;//connection builder with photo server
    ClientLogin cobj;//employee login frame
    String user;
    ChangeClientPassword passobj;

    public ClientHome() {
        initComponents();
        setTitle("Client Home");
        setSize(600, 600);
        panel1.setVisible(false);
        bt4.setVisible(false);
        bt2.setVisible(false);
        bt3.setVisible(false);
        panel2.setVisible(false);
        ta1.setFocusable(false);
        //------------------------
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        //--------------------------
        
        // Placeholder
            PromptSupport.setPrompt("ENTER IP ADDRESS",iptf);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, iptf);
            PromptSupport.setPrompt("Enter the Text",tf1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tf1);
        //
        setVisible(true);

        this.addWindowListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        iptf = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chatlb1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        tf1 = new javax.swing.JTextField();
        chatbt1 = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        pbt1 = new javax.swing.JButton();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt1.setText("CONNECT");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(200, 90, 180, 23);

        lb1.setFont(new java.awt.Font("Microsoft Uighur", 1, 36)); // NOI18N
        lb1.setForeground(new java.awt.Color(51, 0, 204));
        lb1.setText("                         CLIENT HOME");
        getContentPane().add(lb1);
        lb1.setBounds(80, 10, 410, 40);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt2.setText("LOGIN");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(200, 120, 180, 23);

        bt3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt3.setText("LOGOUT");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(210, 520, 160, 23);

        bt4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt4.setText("CHANGE PASSWORD");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(210, 480, 160, 23);
        getContentPane().add(iptf);
        iptf.setBounds(220, 60, 140, 20);

        panel2.setBackground(new java.awt.Color(102, 102, 255));
        panel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), new java.awt.Color(0, 0, 0)));
        panel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatlogo2.png"))); // NOI18N
        jLabel1.setToolTipText("");
        panel2.add(jLabel1);
        jLabel1.setBounds(210, 0, 60, 50);

        chatlb1.setBackground(new java.awt.Color(255, 255, 255));
        chatlb1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        chatlb1.setForeground(new java.awt.Color(255, 255, 255));
        chatlb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatlb1.setText(" CHAT BOX");
        panel2.add(chatlb1);
        chatlb1.setBounds(40, 0, 160, 50);

        ta1.setBackground(new java.awt.Color(255, 255, 204));
        ta1.setColumns(20);
        ta1.setFont(new java.awt.Font("Vrinda", 1, 18)); // NOI18N
        ta1.setForeground(new java.awt.Color(153, 0, 0));
        ta1.setRows(5);
        ta1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(ta1);

        panel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 290, 190);

        tf1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        panel2.add(tf1);
        tf1.setBounds(10, 250, 210, 30);

        chatbt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chatbt1.setText("SEND");
        chatbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatbt1ActionPerformed(evt);
            }
        });
        panel2.add(chatbt1);
        chatbt1.setBounds(220, 250, 80, 30);

        getContentPane().add(panel2);
        panel2.setBounds(260, 160, 310, 300);

        panel1.setBackground(new java.awt.Color(110, 173, 233));
        panel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        panel1.setLayout(null);

        lb2.setFont(new java.awt.Font("Myanmar Text", 3, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("welcome employee");
        panel1.add(lb2);
        lb2.setBounds(20, 10, 210, 20);

        lb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dp.jpg"))); // NOI18N
        lb3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panel1.add(lb3);
        lb3.setBounds(30, 40, 180, 190);

        pbt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pbt1.setText("EDIT PHOTO");
        pbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbt1ActionPerformed(evt);
            }
        });
        panel1.add(pbt1);
        pbt1.setBounds(60, 250, 130, 30);

        getContentPane().add(panel1);
        panel1.setBounds(10, 160, 240, 300);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee-silhouette.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(-70, 0, 710, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 //function to resize image

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    //till here

    //to make connection with server which passes connection to client handler
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        if (iptf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter i.p address first");
        } else {
            ip = iptf.getText();
            obj = new Client();//to run client class
            Thread tc = new Thread(obj);
            tc.start();
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        //login button
        cobj = new ClientLogin();
        cobj.setVisible(true);
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        try {
            obj.dos.writeBytes("Logout Request\r\n");
            obj.dos.writeBytes(user + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_bt3ActionPerformed

    private void pbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbt1ActionPerformed

        JFileChooser fc = new JFileChooser();
        // fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));//code to filter images
        fc.setAcceptAllFileFilterUsed(true);
        int r = fc.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {

                File f = fc.getSelectedFile();
                FileInputStream fis = new FileInputStream(f);
                obj.dos.writeBytes("Edit Photo\r\n");
                System.out.println("Edit Photo");
                obj.dos.writeBytes(user + "\r\n");
                System.out.println(user);
                obj.dos.writeLong(f.length());
                long size = f.length();
                byte b[] = new byte[10000];
                long count = 0;
                while (true) {
                    int temp = fis.read(b, 0, 10000);

                    obj.dos.write(b, 0, temp);
                    count += temp;
                    if (count == size) {
                        break;
                    }
                }

                fis.close();
                File f2 = f;
                //resize image code
                BufferedImage orgimage = ImageIO.read(f2);
                BufferedImage resizedImage = resize(orgimage, lb3.getWidth(), lb3.getHeight());
                //ends here
                lb3.setIcon(new ImageIcon(resizedImage));
                System.out.println(f2.getPath());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_pbt1ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        passobj = new ChangeClientPassword();

    }//GEN-LAST:event_bt4ActionPerformed

    private void chatbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatbt1ActionPerformed
        String msg = tf1.getText();
        if (!msg.equals("")) {

            try {
                obj.dos.writeBytes("Receive Message\r\n");
                obj.dos.writeBytes(msg + "\r\n");
                ta1.append("ME: " + msg + "\n");
                ta1.setCaretPosition(ta1.getText().length());
                System.out.println(msg);
                tf1.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_chatbt1ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        String msg = tf1.getText();
        if (!msg.equals("")) {
            try {
                obj.dos.writeBytes("Receive Message\r\n");
                obj.dos.writeBytes(msg + "\r\n");
                ta1.append("ME: " + msg + "\n");
                ta1.setCaretPosition(ta1.getText().length());
                System.out.println(msg);
                tf1.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tf1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton chatbt1;
    private javax.swing.JLabel chatlb1;
    private javax.swing.JTextField iptf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton pbt1;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) //logout command only
    {
        try {
            obj.dos.writeBytes("Logout Request\r\n");
            obj.dos.writeBytes(user + "\r\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }

    //////makes connection with server, on a thread because we want it to run at backend
    //allowing other processes to work
    public class Client implements Runnable {

        Socket sock;
        DataInputStream dis;
        DataOutputStream dos;

        public void run() {
            try {
                sock = new Socket(ip, 9090);
                System.out.println("Connection with Server Established");
                bt1.setEnabled(false);//connect button disabled once connection established
                bt2.setVisible(true);//login button
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                //data streams exchange messages 
                String s;
                s = dis.readLine();
                System.out.println(s);
                dos.writeBytes("Hi Server\r\n");
                dos.flush();
                //till here

                while (true) //this will prevent client to terminate
                {
                    //System.out.println("in while loop of client");
                    String s1 = dis.readLine();
                    System.out.println(s1);
                    if (s1.equals("Already Logged in")) {
                        JOptionPane.showMessageDialog(cobj, "This Username has Already Logged in");
                        System.out.println("This Username has Already Logged in");
                        cobj.ctf1.setText("");
                        cobj.ctf2.setText("");

                    } else if (s1.equals("Login Successful")) {
                        flag = true;
                        bt2.setEnabled(false);//since logged in this button is disabled
                        bt3.setVisible(true);//logout button is visible
                        bt4.setVisible(true);//change password button is visible
                        cobj.dispose();//login frame
                        pobj = new PClient();
                        Thread pt1 = new Thread(pobj);
                        pt1.start();
                        panel1.setVisible(true);
                        panel2.setVisible(true);
                        lb2.setText("welcome " + user);

                        //dp received
                        File f = new File(System.getProperty("user.home")+"\\dp.jpg");
                        FileOutputStream fos = new FileOutputStream(f);
                        long size;
                        size = dis.readLong();
                        long count = 0;
                        byte b[] = new byte[10000];
                        while (true) {
                            int r = dis.read(b, 0, 10000);
                            fos.write(b, 0, r);
                            count = count + r;
                            if (count == size) {
                                break;
                            }
                        }
                        dos.writeBytes("file received\r\n");
                        //resize image code
                        BufferedImage orgimage = ImageIO.read(f);
                        BufferedImage resizedImage = resize(orgimage, lb3.getWidth(), lb3.getHeight());
                        //ends here
                        lb3.setIcon(new ImageIcon(resizedImage));
                        JOptionPane.showMessageDialog(cobj,"Login successful");
                               // previous chat gaining from server
                                try {
                                    int count2 = Client.this.dis.readInt();//number of meesages from server
                                    System.out.println("count got");
                                    String message, message_from;
                                    for (int i = 0; i < count2; i++) {
                                        message = Client.this.dis.readLine();
                                        message_from = Client.this.dis.readLine();
                                        System.out.println("got message");
                                        if (message_from.equals("server")) {
                                            ta1.append("ADMIN: " + message + "\n");

                                        } else {
                                            ta1.append("ME: " + message + "\n");
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            
                      
                        ta1.setCaretPosition(ta1.getText().length());//bring to down

                        // chat gaining end here
                    } else if (s1.equals("Login Failed")) {
                        cobj.ctf1.setText("");
                        cobj.ctf2.setText("");
                        JOptionPane.showMessageDialog(cobj, s1);
                    } else if (s1.equals("Logout Successful")) {

                        flag = false;
                        JOptionPane.showMessageDialog(rootPane, "LOGOUT SUCCESSFUL");
//                        dos.writeBytes("create video\r\n");
                        bt3.setVisible(false);
                        bt4.setVisible(false);
                        bt2.setVisible(false);
                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        bt2.setEnabled(true);
                        bt1.setEnabled(true);
                        break;
                    } else if (s1.equals("password query")) {
                        String ack = dis.readLine();
                        if (ack.equals("password updated")) {
                            JOptionPane.showMessageDialog(rootPane, "Password Changed Succesfully");
                            passobj.dispose();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Authentication failed! TRY AGAIN");
                            passobj.dispose();
                        }

                    } else if (s1.equals("Shutdown Request")) {
                        System.out.println("pc shutting down now");

                         //shut down code below
                              
                         Runtime r = Runtime.getRuntime();
                         r.exec("shutdown -s -t 0");
                         System.exit(0);
                         
                    } else if (s1.equals("Receive Message")) {
                        String msg = dis.readLine();
                        System.out.println("in receive msg");
                        ta1.append("ADMIN: " + msg + "\n");
                        ta1.setCaretPosition(ta1.getText().length());
                        System.out.println(msg);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //////class ends here

    ///////EMPLOYEE LOGIN FRAME
    public class ClientLogin extends javax.swing.JFrame {

        public ClientLogin() {
            initComponents();
            
            setSize(490, 450);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width / 2) - (this.getWidth() / 2);
            int y = (height / 2) - (this.getHeight() / 2);
            setLocation(x, y);
            //--------------------------
             // PlaceHolder
              PromptSupport.setPrompt("USERNAME",ctf1);
              PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ctf1);
              PromptSupport.setPrompt("PASSWORD",ctf2);
              PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ctf2);
            //    
            
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            clb1 = new javax.swing.JLabel();
            clb3 = new javax.swing.JLabel();
            clb2 = new javax.swing.JLabel();
            ctf1 = new javax.swing.JTextField();
            ctf2 = new javax.swing.JPasswordField();
            cbt1 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            backlabel = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            getContentPane().setLayout(null);

            clb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            clb1.setForeground(new java.awt.Color(255, 255, 0));
            clb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logolog.png"))); // NOI18N
            getContentPane().add(clb1);
            clb1.setBounds(10, 0, 470, 220);

            clb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            clb3.setForeground(new java.awt.Color(255, 255, 255));
            clb3.setText("PASSWORD");
            getContentPane().add(clb3);
            clb3.setBounds(60, 140, 120, 30);

            clb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            clb2.setForeground(new java.awt.Color(255, 255, 255));
            clb2.setText("USERNAME");
            getContentPane().add(clb2);
            clb2.setBounds(60, 100, 120, 30);
            getContentPane().add(ctf1);
            ctf1.setBounds(180, 100, 230, 30);
            getContentPane().add(ctf2);
            ctf2.setBounds(180, 140, 230, 30);

            cbt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            cbt1.setText("LOGIN");
            cbt1.setOpaque(false);
            cbt1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbt1ActionPerformed(evt);
                }
            });
            getContentPane().add(cbt1);
            cbt1.setBounds(280, 190, 130, 40);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login-icon.png"))); // NOI18N
            getContentPane().add(jLabel1);
            jLabel1.setBounds(10, 170, 270, 210);

            backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinlog.jpg"))); // NOI18N
            getContentPane().add(backlabel);
            backlabel.setBounds(-20, -70, 510, 530);

            pack();
        }// </editor-fold>              

        private void cbt1ActionPerformed(java.awt.event.ActionEvent evt) {
            //login button 
            user = ctf1.getText();//declared global
            String pass = ctf2.getText();

            if (user.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter all the details");
            } else {
                try {
                    //System.out.println(user);
                    //System.out.println(pass);
                    //client obj is global
                    obj.dos.writeBytes("Login Request\r\n");
                    obj.dos.writeBytes(user + "\r\n");
                    obj.dos.writeBytes(pass + "\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JLabel backlabel;
        private javax.swing.JButton cbt1;
        private javax.swing.JLabel clb1;
        private javax.swing.JLabel clb2;
        private javax.swing.JLabel clb3;
        private javax.swing.JTextField ctf1;
        private javax.swing.JPasswordField ctf2;
        private javax.swing.JLabel jLabel1;
    // End of variables declaration                 

        ////end of clientlogin class
    }

    public class PClient implements Runnable {

        Socket psock;
        DataInputStream pdis;
        DataOutputStream pdos;
        FileInputStream pfis;

        public void run() {
            try {
                psock = new Socket(ip, 9080);
                System.out.println("Connection with Photo Server Established");
                pdis = new DataInputStream(psock.getInputStream());
                pdos = new DataOutputStream(psock.getOutputStream());

                //checking message sending receiving and sending the user name
                String ps = pdis.readLine();
                System.out.println(ps);
                pdos.writeBytes("Hi Photo Server\r\n");
                pdos.writeBytes(user + "\r\n");//this user(global) has arrived when user logged in client login
                //till here

                //this will run unless user logs out
                while (flag) {
                    // code for Photo Capturing
                   
                    Toolkit tool = Toolkit.getDefaultToolkit();
                    Dimension d = tool.getScreenSize();
                    Rectangle rect = new Rectangle(d);
                    Robot robot = new Robot();
                    File pf = new File(System.getProperty("user.home")+"\\screenshotClient.jpeg");
                    BufferedImage img = robot.createScreenCapture(rect);
                    ImageIO.write(img, "jpeg", pf);//image saved at pf file path in client computer
                    tool.beep();

                    // Code for file Transfer to  PhotoServer
                    long psize = pf.length();
                    pfis = new FileInputStream(pf);
                    pdos.writeLong(psize);
                    long pcount = 0;
                    byte pb[] = new byte[10000];
                    while (true) {
                        int r = pfis.read(pb, 0, 10000);

                        pdos.write(pb, 0, r);

                        pcount += r;

                        if (pcount == psize) {
                            break;
                        }
                    }
                    System.out.println(pdis.readLine());
                     Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //change password frame
    public class ChangeClientPassword extends javax.swing.JFrame {

        public ChangeClientPassword() {
            initComponents();
            setSize(500, 450);
            setTitle("Change Client Password");
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width / 2) - (this.getWidth() / 2);
            int y = (height / 2) - (this.getHeight() / 2);
            setLocation(x, y);
            //--------------------------
            // Placeholder
               PromptSupport.setPrompt("CURRENT PASSWORD",ptf1);
               PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ptf1);
               PromptSupport.setPrompt("NEW PASSWORD",ptf2);
               PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ptf2);
               PromptSupport.setPrompt("CONFIRM PASSWORD",ptf3);
               PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ptf3);
            //
            setVisible(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            plb2 = new javax.swing.JLabel();
            plb3 = new javax.swing.JLabel();
            plb4 = new javax.swing.JLabel();
            ptf1 = new javax.swing.JPasswordField();
            ptf2 = new javax.swing.JPasswordField();
            ptf3 = new javax.swing.JPasswordField();
            jLabel1 = new javax.swing.JLabel();
            pbt1 = new javax.swing.JButton();
            backlabel2 = new javax.swing.JLabel();
            backlabel = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            getContentPane().setLayout(null);

            plb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            plb2.setForeground(new java.awt.Color(255, 255, 255));
            plb2.setText("Current Password");
            getContentPane().add(plb2);
            plb2.setBounds(50, 90, 140, 30);

            plb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            plb3.setForeground(new java.awt.Color(255, 255, 255));
            plb3.setText("New Password");
            getContentPane().add(plb3);
            plb3.setBounds(50, 140, 140, 30);

            plb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            plb4.setForeground(new java.awt.Color(255, 255, 255));
            plb4.setText("Confirm Password");
            getContentPane().add(plb4);
            plb4.setBounds(50, 190, 150, 30);
            getContentPane().add(ptf1);
            ptf1.setBounds(200, 90, 230, 30);
            getContentPane().add(ptf2);
            ptf2.setBounds(200, 140, 230, 30);
            getContentPane().add(ptf3);
            ptf3.setBounds(200, 190, 230, 30);

            jLabel1.setBackground(new java.awt.Color(102, 102, 102));
            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 0));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("CHANGE PASSWORD");
            jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 0), new java.awt.Color(0, 0, 0)));
            jLabel1.setOpaque(true);
            getContentPane().add(jLabel1);
            jLabel1.setBounds(130, 10, 250, 40);

            pbt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            pbt1.setText("CHANGE PASSWORD");
            pbt1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pbt1ActionPerformed(evt);
                }
            });
            getContentPane().add(pbt1);
            pbt1.setBounds(230, 240, 200, 30);

            backlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/preferences-desktop-user-password.png"))); // NOI18N
            getContentPane().add(backlabel2);
            backlabel2.setBounds(50, 230, 140, 130);

            backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinlog.jpg"))); // NOI18N
            getContentPane().add(backlabel);
            backlabel.setBounds(-20, -100, 530, 540);

            pack();
        }// </editor-fold>              

        private void pbt1ActionPerformed(java.awt.event.ActionEvent evt) {
            if (ptf1.getText().equals("") || ptf2.getText().equals("") || ptf3.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please Enter All The Fields");
            } else if (!ptf2.getText().equals(ptf3.getText())) {
                JOptionPane.showMessageDialog(rootPane, " New password does not match");
                ptf2.setText("");
                ptf3.setText("");
            } else {
                try {
                    obj.dos.writeBytes("Change Password\r\n");
                    obj.dos.writeBytes(user + "\r\n");
                    obj.dos.writeBytes(ptf1.getText() + "\r\n");//old password  
                    obj.dos.writeBytes(ptf2.getText() + "\r\n");  //new password
                    System.out.println("data sent");
                //acknowledgement will be received at client

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // Variables declaration - do not modify                     
        private javax.swing.JLabel backlabel;
        private javax.swing.JLabel backlabel2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JButton pbt1;
        private javax.swing.JLabel plb2;
        private javax.swing.JLabel plb3;
        private javax.swing.JLabel plb4;
        private javax.swing.JPasswordField ptf1;
        private javax.swing.JPasswordField ptf2;
        private javax.swing.JPasswordField ptf3;
    // End of variables declaration                       
    }

}
