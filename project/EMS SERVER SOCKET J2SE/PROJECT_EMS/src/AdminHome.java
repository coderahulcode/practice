
import ch.randelshofer.media.avi.AVIOutputStream;
import java.net.*;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jdesktop.swingx.prompt.PromptSupport;
//main class frame

public class AdminHome extends javax.swing.JFrame {

    ArrayList<Server.ClientHandler> al = new ArrayList<>();
    ArrayList<Chat> alChat = new ArrayList<>();
    ArrayList<LiveStream> alLive = new ArrayList<>();
    ConnectTableModel ctm;
    Connection conn;
    ResultSet rs, rs2;
    Statement stmt, stmt2;
    ServerSocket sersock;
    ServerSocket psersock;
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

    public AdminHome() {
        Thread ts = new Thread(new Server());
        ts.start();
        Thread pts = new Thread(new PServer());
        pts.start();
        initComponents();
        ctm = new ConnectTableModel();
        jt1.setModel(ctm);
        setSize(600, 600);
        setTitle("Admin Home");
        //------------------------
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (width / 2) - (this.getWidth() / 2);
        int y = (height / 2) - (this.getHeight() / 2);
        setLocation(x, y);
        //--------------------------
        setVisible(true);
        //getContentPane().setBackground(Color.red);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        sp1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        backlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        bt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt1.setText("Add Employee");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(430, 70, 140, 20);

        bt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt2.setText("View Employee");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(430, 40, 140, 20);

        bt6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt6.setText("Start Chat");
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        getContentPane().add(bt6);
        bt6.setBounds(430, 130, 140, 20);

        bt7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt7.setText("Live Stream");
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });
        getContentPane().add(bt7);
        bt7.setBounds(430, 160, 140, 23);

        lb1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lb1.setText("ADMIN HOME");
        getContentPane().add(lb1);
        lb1.setBounds(50, 70, 270, 70);

        sp1.setBackground(new java.awt.Color(0, 0, 0));
        sp1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ONLINE EMPLOYEES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        sp1.setForeground(new java.awt.Color(0, 153, 255));

        jt1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sp1.setViewportView(jt1);

        getContentPane().add(sp1);
        sp1.setBounds(50, 330, 500, 200);

        bt3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt3.setText("View Logs");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(430, 100, 140, 20);

        bt4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt4.setText("ShutDown Selected");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(70, 530, 160, 20);

        bt5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt5.setText("Shutdown all");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        getContentPane().add(bt5);
        bt5.setBounds(340, 530, 170, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bossy4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 30, 130, 70);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 210, 140, 20);

        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminhomef.jpg"))); // NOI18N
        getContentPane().add(backlabel);
        backlabel.setBounds(0, 0, 600, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //to open new frame add employee
    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        AddEmployee obj = new AddEmployee();
        //this.dispose();
    }//GEN-LAST:event_bt1ActionPerformed

    //to open new frame view employee directory
    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        ViewEmployee obj = new ViewEmployee();
        //this.dispose();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        ViewLogs obj = new ViewLogs();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        if (jt1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please select row first");

        } else {
            try {
                al.get(jt1.getSelectedRow()).dos.writeBytes("Shutdown Request\r\n");
                System.out.println("shut down request sent");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        for (int i = 0; i < al.size(); i++) {
            try {
                al.get(i).dos.writeBytes("Shutdown Request\r\n");
                System.out.println("shut down request sent");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed

        if (jt1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Please Select the row first ");
        } else {
            int flag = 0, index = 0;
            String name = al.get(jt1.getSelectedRow()).employeeName;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "User Has not login yet!");

            } else {
                for (int i = 0; i < alChat.size(); i++) {
                    if (alChat.get(i).cname.equals(name)) {
                        index = i;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)//no such chat box opened
                {
                    Chat obj = new Chat(name);
                    alChat.add(obj);
                    obj.setState(JFrame.NORMAL);
                    obj.toFront();
                } else//user chat box already opened
                {
                    alChat.get(index).setState(JFrame.NORMAL);
                    alChat.get(index).toFront();
                }

            }
        }

    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        if (jt1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Please Select the row first ");
        } else {
            int flag = 0, index = 0;
            String name = al.get(jt1.getSelectedRow()).employeeName;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "User has not login yet!");
            } else {
                for (int i = 0; i < alLive.size(); i++) {
                    if (alLive.get(i).cname.equals(name))//already opened
                    {
                        index = i;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)//no such live box opened
                {
                    LiveStream obj = new LiveStream(name);
                    alLive.add(obj);
                    obj.setState(JFrame.NORMAL);
                    obj.toFront();
                } else//user live box already opened
                {
                    alLive.get(index).setState(JFrame.NORMAL);
                    alLive.get(index).toFront();
                }

            }
        }
    }//GEN-LAST:event_bt7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sersock.close();
            psersock.close();
            this.dispose();

            AdminLogin obj = new AdminLogin();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jt1;
    private javax.swing.JLabel lb1;
    private javax.swing.JScrollPane sp1;
    // End of variables declaration//GEN-END:variables
//main class admin home's frame formatting and editting only ends here here

    class ConnectTableModel extends AbstractTableModel {

        String col_name[] = {"IP ADDRESS", "CLIENT NAME"};

        public String getColumnName(int i) {
            return col_name[i];
        }

        public int getRowCount() {
            return al.size();
        }

        public int getColumnCount() {
            return 2;
        }

        public Object getValueAt(int row, int col) {

            if (col == 0) {

                return al.get(row).sock.getInetAddress().getHostAddress();

            } else {
                return al.get(row).employeeName;

            }

        }
    }

//running at backend infinitely at a separate thread to accept clients
    public class Server implements Runnable {

        Socket sock;

        public void run() {
            try {
                sersock = new ServerSocket(9090);
                System.out.println("Server build");
                while (true) {
                    sock = sersock.accept();
                    System.out.println("Connection Established");
                    ClientHandler cl = new ClientHandler(sock);
                    Thread t1 = new Thread(cl);
                    t1.start();
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        //connection passed here
        class ClientHandler implements Runnable {

            String employeeName;
            DataInputStream dis;
            DataOutputStream dos;
            Socket sock;

            ClientHandler(Socket sock) {
                this.sock = sock;
                try {
                    dis = new DataInputStream(sock.getInputStream());
                    dos = new DataOutputStream(sock.getOutputStream());
                    employeeName = "";
                    al.add(this);
                    ctm.fireTableDataChanged();//to update ip address in table
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            public void run() {
                try {
                    //data streams exchange messages 
                    dos.writeBytes("hi Client\r\n");
                    dos.flush();
                    String s;
                    s = dis.readLine();
                    System.out.println(s);
             //till here

                    //client handler
                    while (true)//this will prevent client handler to terminate
                    {
                        // System.out.println("in while");
                        String s1 = dis.readLine();
                        //System.out.println(s1);
                        if (s1.equals("Login Request")) {
                            String user = dis.readLine();
                            String pass = dis.readLine();
                            int flag = 0;

                            for (int i = 0; i < al.size(); i++) {
                                if (al.get(i).employeeName.equals(user)) {
                                    flag = 1;
                                    break;
                                }

                            }
                            if (flag == 1) {
                                dos.writeBytes("Already Logged in\r\n");
                                System.out.println("Already Logged in");

                            } else { //##code
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded succesfully");
                                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
                                System.out.println("connection created");
                                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                System.out.println("statement created");
                                //             ##code ends here
                                rs = stmt.executeQuery("select * from employee where emp_username='" + user + "' and password='" + pass + "'");
                                System.out.println("resultset created");
                                if (rs.next())//means login user and password is correct 
                                {

                                    employeeName = rs.getString("emp_username");//which is global in this class=client handler
                                    System.out.println(employeeName);

                                    ctm.fireTableDataChanged();//employee name is updated and then shown in table
                                    dos.writeBytes("Login Successful\r\n");
                                    stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    rs2 = stmt2.executeQuery("select * from log");
                                    rs2.moveToInsertRow();
                                    rs2.updateString("user_name", rs.getString("emp_username"));
                                    rs2.updateDate("start_date", new java.sql.Date(new java.util.Date().getTime()));
                                    rs2.updateTime("start_time", new java.sql.Time(new java.util.Date().getTime()));
                                    rs2.insertRow();
                                    //photo dp sending to client

                                    File f = new File(System.getProperty("user.home") + "\\images\\" + user + ".jpg");
                                    FileInputStream fis = new FileInputStream(f);
                                    dos.writeLong(f.length());
                                    long count = 0;
                                    long size = f.length();
                                    byte b[] = new byte[10000];
                                    while (true) {
                                        int r = fis.read(b, 0, 10000);
                                        count = count + r;
                                        dos.write(b, 0, r);
                                        if (count == size) {
                                            break;
                                        }
                                    }
                                    System.out.println(dis.readLine());

                                    try {
                                        // Previous chat sending to client
                                        rs2 = stmt2.executeQuery("select count(*) as c1 from chat where msg_from='" + employeeName + "' or msg_to='" + employeeName + "'");
                                        System.out.println("Chat resultset created");
                                        int count2 = 0;
                                        if (rs2.next()) {
                                            count2 = rs2.getInt("c1");
                                            System.out.println(count2);
                                        }
                                        dos.writeInt(count2);

                                        rs2 = stmt2.executeQuery("select * from chat where msg_from='" + employeeName + "' or msg_to='" + employeeName + "'");
                                        System.out.println("Chat resultset created");
                                        String message, message_from;
                                        while (rs2.next())//message sending from database to respective client
                                        {
                                            message = rs2.getString("msg");
                                            message_from = rs2.getString("msg_from");
                                            dos.writeBytes(message + "\r\n");
                                            dos.writeBytes(message_from + "\r\n");
                                        }

                                        //end here previous chat
                                    } catch (Exception e) {
                                    }

                                } else {
                                    dos.writeBytes("Login Failed\r\n");
                                }
                            }
                        } else if (s1.equals("Logout Request")) {
                            System.out.println(s1);
                            String userlogout = dis.readLine();
                            System.out.println(userlogout);
                            int maxid = 1;
                            //##code
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded succesfully");
                            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "amritsar");
                            System.out.println("connection created");
                            stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("statement created");
                            // ##code ends here
                            rs2 = stmt2.executeQuery("select max(logid) as id from log where user_name='" + userlogout + "'");
                            if (rs2.next()) {
                                maxid = rs2.getInt("id");
                                // System.out.println(maxid);
                            }

                            rs2 = stmt2.executeQuery("select * from log where logid=" + maxid + "");
                            if (rs2.next()) {
                                rs2.updateDate("end_date", new java.sql.Date(new java.util.Date().getTime()));
                                rs2.updateTime("end_time", new java.sql.Time(new java.util.Date().getTime()));
                                rs2.updateRow();
                                // String temp=rs2.getString("user_name");
                                // System.out.println(temp+" selected logout username");
                                dos.writeBytes("Logout Successful\r\n");

////create video         
                                // Code of Creation of Video from Images
                                SwingUtilities.invokeLater(new Runnable()//anonymous thread
                                {
                                    public void run() {
                                        try {
                                            String cur_date = new java.sql.Date(new java.util.Date().getTime()).toString();
                                            File dir = new File(System.getProperty("user.home") + "\\videosEMS");
                                            if (!dir.exists()) {
                                                dir.mkdir();

                                            }
                                            dir = new File(dir.getPath() + "\\" + userlogout);//  c://mk_13//gur//
                                            if (!dir.exists()) {
                                                dir.mkdir();

                                            }
                                            File f = new File(dir.getPath() + "\\" + cur_date + ".avi");

                                            AVIOutputStream av = new AVIOutputStream(f, AVIOutputStream.VideoFormat.JPG);

                                            File f2 = new File((System.getProperty("user.home") + "\\ScreenShots\\" + userlogout + "\\" + cur_date));// Images Folder Path 
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
                                    }
                                });

                                al.remove(this);
                                System.out.println(employeeName);
                                // this.employeeName=name;
                                ctm.fireTableDataChanged();//employee name is updated and then shown in table

                            }

                        } else if (s1.equals("Edit Photo")) {
                            String user = dis.readLine();
                            System.out.println("in edit photo : " + user);
                            File f = new File(System.getProperty("user.home") + "\\images\\" + user + ".jpg");
                            FileOutputStream fos = new FileOutputStream(f);
                            long size = dis.readLong();

                            long count = 0;
                            byte b[] = new byte[10000];
                            while (true) {
                                System.out.println("in while");
                                int temp = dis.read(b, 0, 10000);
                                count = count + temp;
                                fos.write(b, 0, temp);
                                if (count == size) {
                                    break;
                                }
                            }

                            fos.close();
                            System.out.println("photo updated in admin home");

                        } else if (s1.equals("Change Password")) {
                            System.out.println("in change password");
                            String user = dis.readLine();
                            String old_pass = dis.readLine();
                            String new_pass = dis.readLine();
                            System.out.println(user + " " + old_pass + " " + new_pass);
                            ResultSet rs3;
                            Statement stmt3;
                            stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("statement created");
                            // ##code ends here
                            rs3 = stmt3.executeQuery("select * from employee where emp_username='" + user + "'");
                            System.out.println("result set created");
                            if (rs3.next()) {
                                System.out.println("inside rs3 next");
                                if (old_pass.equals(rs3.getString("password"))) {
                                    System.out.println("old password matched");
                                    rs3.updateString("password", new_pass);
                                    rs3.updateRow();
                                    dos.writeBytes("password query\r\n");
                                    dos.writeBytes("password updated\r\n");
                                } else {
                                    System.out.println("old pasword did not match");
                                    dos.writeBytes("password query\r\n");
                                    dos.writeBytes("password not matched\r\n");
                                }
                            }
                        } else if (s1.equals("Receive Message")) {
                            String msg = dis.readLine();
                            System.out.println(msg);
                            int flag = 0, index = 0;
                            for (int i = 0; i < alChat.size(); i++) {

                                if (alChat.get(i).cname.equals(employeeName))//employee chat box opened
                                {
                                    index = i;
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 1) {
                                alChat.get(index).toFront();
                                alChat.get(index).setState(JFrame.NORMAL);
                                alChat.get(index).chatta1.append(employeeName + ": " + msg + "\n");
                                alChat.get(index).chatta1.setCaretPosition(alChat.get(index).chatta1.getText().length());//bring to down

                            } else {
                                Chat obj = new Chat(employeeName);
                                Thread.sleep(500);
                                alChat.add(obj);
                                obj.chatta1.append(employeeName + ": " + msg + "\n");
                                obj.chatta1.setCaretPosition(obj.chatta1.getText().length());//bring to down
                                obj.toFront();
                                obj.setState(JFrame.NORMAL);
                            }
                            //to insert chat into chat database
                            try {
                                rs = stmt.executeQuery("select * from chat");
                                rs.moveToInsertRow();
                                rs.updateString("msg_to", "server");
                                rs.updateString("msg_from", employeeName);
                                rs.updateString("msg", msg);
                                rs.insertRow();
                                System.out.println("row inserted");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    al.remove(this);
                    System.out.println("ArrayList");
                    ctm.fireTableDataChanged();
                }
            }

        }

    }

    public class PServer implements Runnable {

        Socket psock;

        public void run() {
            try {
                psersock = new ServerSocket(9080);
                System.out.println("Photo Server built");
                while (true) {
                    psock = psersock.accept();
                    System.out.println("Connection with photo socket Established with client");
                    PClientHandler pcl = new PClientHandler(psock);//connection passed to pclient handler
                    Thread pt1 = new Thread(pcl);
                    pt1.start();
                }
            } catch (Exception e) {
                // e.printStackTrace();
            }

        }

        class PClientHandler implements Runnable {

            DataInputStream pdis;
            DataOutputStream pdos;
            FileOutputStream pfos;
            Socket psock;

            PClientHandler(Socket psock) {
                this.psock = psock;//coneection managed here by pclient handler
                try {
                    pdis = new DataInputStream(psock.getInputStream());
                    pdos = new DataOutputStream(psock.getOutputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            public void run() {
                try {
                    pdos.writeBytes("hi Photo Client\r\n");
                    pdos.flush();
                    String ps = pdis.readLine();
                    System.out.println(ps);
                    String username = pdis.readLine();//username sent from user client

                    //to find username of pc and assign location
                    File pf;
                    File pfuser = new File(System.getProperty("user.home"));//  C:\Users\mk_13
                    File dir = new File(pfuser.getPath() + "\\ScreenShots");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }

                    dir = new File(dir.getPath() + "\\" + username);

                    if (!dir.exists()) {
                        dir.mkdir();
                    }

                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar d = Calendar.getInstance();
                    String date = dateFormat.format(d.getTime());
                    dir = new File(dir.getPath() + "\\" + date);
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    System.out.println(dir.getPath());
                    //code ends

                    int i = dir.listFiles().length;//to find no. of files in the folder
                    // System.out.println("length of files in folder"+dir.listFiles().length);
                    //receiving files whenever it gets
                    while (true) {
                        long psize = pdis.readLong();
                        long pcount = 0;
                        pf = new File(dir.getPath() + "\\" + i + ".jpg");
                        // System.out.println(pf.getPath());
                        pfos = new FileOutputStream(pf);
                        byte pb[] = new byte[10000];

                        while (true) {
                            int r = pdis.read(pb, 0, 10000);

                            pfos.write(pb, 0, r);
                            pcount += r;

                            if (pcount == psize) {
                                break;
                            }
                        }
                        pfos.close();
                        pdos.writeBytes("File Recieved \r\n");
                        pdos.flush();
                        //experimental live streaming
                        int flag = 0, index = 0;
                        for (int j = 0; j < alLive.size(); j++) {

                            if (alLive.get(j).cname.equals(username))//employee livestreaming box opened
                            {
                                //System.out.println("found");
                                index = j;
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            //resize image code
                            BufferedImage orgimage = ImageIO.read(pf);
                            BufferedImage resizedImage = resize(orgimage, alLive.get(index).livelb.getWidth(), alLive.get(index).livelb.getHeight());
                            //ends here
                            alLive.get(index).livelb.setIcon(new ImageIcon(resizedImage));
                            //System.out.println("resized"); 

                        }

                        i++;
                    }
                } catch (Exception pe) {
                    pe.printStackTrace();

                }
            }
        }
    }

    // CHAT ROOM
    public class Chat extends javax.swing.JFrame implements WindowListener {

        String cname;

        public Chat(String cname) {
            initComponents();
            System.out.println("in cons " + cname);
            this.cname = cname;
            setSize(650, 650);
            setTitle("CHAT BOX");

            chatlb1.setText("CHAT WITH " + this.cname);
            chatta1.setFocusable(false);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE
            this.addWindowListener(this);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width / 2) - (this.getWidth() / 2);
            int y = (height / 2) - (this.getHeight() / 2);
            setLocation(x, y);
            //--------------------------
            // placeHolder
              PromptSupport.setPrompt("Enter the Text",chattf1);
              PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, chattf1);
            //
            setVisible(true);

            new Thread(new Runnable()//anonymous thread
            {
                public void run() {
                    System.out.println("in thread");
                    try {
                        ResultSet rsc = null;
                        Statement stat;
                        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rsc = stat.executeQuery("select * from chat where msg_to='" + cname + "' or msg_from ='" + cname + "'");

                        while (rsc.next()) {
                            System.out.println("in while ");
                            String message, message_from;
                            message = rsc.getString("msg");
                            message_from = rsc.getString("msg_from");
                            if (message_from.equals("server")) {
                                chatta1.append("ME: " + message + "\n");

                            } else {
                                chatta1.append(cname + ": " + message + "\n");

                            }

                        }
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }

            }
            ).start();

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            chatlb1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            chatta1 = new javax.swing.JTextArea();
            chattf1 = new javax.swing.JTextField();
            chatbt1 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            backlabel = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            getContentPane().setLayout(null);

            chatlb1.setBackground(new java.awt.Color(255, 255, 255));
            chatlb1.setFont(new java.awt.Font("Simplified Arabic Fixed", 1, 18)); // NOI18N
            chatlb1.setForeground(new java.awt.Color(0, 51, 204));
            chatlb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            chatlb1.setText(" CHAT WITH");
            chatlb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            chatlb1.setOpaque(true);
            getContentPane().add(chatlb1);
            chatlb1.setBounds(120, 100, 410, 35);

            chatta1.setBackground(new java.awt.Color(204, 204, 255));
            chatta1.setColumns(20);
            chatta1.setFont(new java.awt.Font("Plantagenet Cherokee", 1, 14)); // NOI18N
            chatta1.setRows(5);
            chatta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 4));
            jScrollPane1.setViewportView(chatta1);

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(70, 140, 510, 240);

            chattf1.setBackground(new java.awt.Color(255, 255, 204));
            chattf1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
            chattf1.setForeground(new java.awt.Color(0, 153, 51));
            chattf1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 5, true));
            chattf1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chattf1ActionPerformed(evt);
                }
            });
            getContentPane().add(chattf1);
            chattf1.setBounds(70, 390, 410, 40);

            chatbt1.setFont(new java.awt.Font("Franklin Gothic Demi", 3, 14)); // NOI18N
            chatbt1.setText("SEND");
            chatbt1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chatbt1ActionPerformed(evt);
                }
            });
            getContentPane().add(chatbt1);
            chatbt1.setBounds(490, 390, 92, 40);

            jLabel1.setBackground(new java.awt.Color(102, 102, 102));
            jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 0));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("CHAT BOX");
            jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jLabel1.setOpaque(true);
            getContentPane().add(jLabel1);
            jLabel1.setBounds(210, 30, 240, 40);

            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/default-icon.png"))); // NOI18N
            getContentPane().add(jLabel2);
            jLabel2.setBounds(170, 420, 250, 250);

            backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatboxback.jpg"))); // NOI18N
            getContentPane().add(backlabel);
            backlabel.setBounds(0, -20, 640, 700);

            pack();
        }// </editor-fold>                        

        private void chatbt1ActionPerformed(java.awt.event.ActionEvent evt) {
            String msg = chattf1.getText();
            if (!msg.equals("")) {
                chatta1.append("ME: " + msg + "\n");
                for (int i = 0; i < al.size(); i++) {
                    //if user is found in the client handler list
                    if (al.get(i).employeeName.equals(cname)) {
                        System.out.println("user identified");
                        try {
                            //message sent to respective client using dos   
                            al.get(i).dos.writeBytes("Receive Message\r\n");
                            al.get(i).dos.writeBytes(msg + "\r\n");
                            System.out.println(msg);
                            chattf1.setText("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
                try {
                    rs = stmt.executeQuery("select * from chat");
                    rs.moveToInsertRow();
                    rs.updateString("msg_to", cname);
                    rs.updateString("msg_from", "server");
                    rs.updateString("msg", msg);
                    rs.insertRow();
                    System.out.println("row inserted");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        private void chattf1ActionPerformed(java.awt.event.ActionEvent evt) {
            String msg = chattf1.getText();
            if (!msg.equals("")) {
                chatta1.append("ME: " + msg + "\n");
                for (int i = 0; i < al.size(); i++) {
                    //if user is found in the client handler list
                    if (al.get(i).employeeName.equals(cname)) {
                        System.out.println("user identified");
                        try {
                            //message sent to respective client using dos   
                            al.get(i).dos.writeBytes("Receive Message\r\n");
                            al.get(i).dos.writeBytes(msg + "\r\n");
                            System.out.println(msg);
                            chattf1.setText("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
                try {
                    rs = stmt.executeQuery("select * from chat");
                    rs.moveToInsertRow();
                    rs.updateString("msg_to", cname);
                    rs.updateString("msg_from", "server");
                    rs.updateString("msg", msg);
                    rs.insertRow();
                    System.out.println("row inserted");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        // Variables declaration - do not modify                     
        private javax.swing.JLabel backlabel;
        private javax.swing.JButton chatbt1;
        private javax.swing.JLabel chatlb1;
        private javax.swing.JTextArea chatta1;
        private javax.swing.JTextField chattf1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration                       

        public void windowOpened(WindowEvent e) {

        }

        public void windowClosing(WindowEvent e) {
            this.dispose();
            alChat.remove(this);
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
    }
 // ending chat room

    //live stream
    public class LiveStream extends javax.swing.JFrame implements WindowListener {

        String cname;
        private JLabel jLabel4;

        public LiveStream(String cname) {

            initComponents();
            this.cname = cname;
            setSize(1100, 700);
            lb1.setText("Employee: " + cname);
            setTitle("Live Stream");
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//by defaultoperation is EXIT_ON_CLOSE
            this.addWindowListener(this);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width / 2) - (this.getWidth() / 2);
            int y = (height / 2) - (this.getHeight() / 2);
            setLocation(x, y);
            //--------------------------
            setVisible(true);

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        livelb = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loader.gif"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-70, 70, 410, 550);
        getContentPane().add(livelb);
        livelb.setBounds(320, 130, 610, 340);

        lb1.setBackground(new java.awt.Color(204, 204, 204));
        lb1.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(153, 0, 0));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Employee: ");
        lb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb1.setOpaque(true);
        getContentPane().add(lb1);
        lb1.setBounds(310, 500, 630, 40);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Livestream.com-02.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2)));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 10, 320, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apple.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 20, 840, 650);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backlit_keyboard.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -70, 1130, 740);

        pack();
    }// </editor-fold>               
       
        // Variables declaration - do not modify                     
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel lb1;
        private javax.swing.JLabel livelb;
        // End of variables declaration                      

        public void windowOpened(WindowEvent e) {

        }

        public void windowClosing(WindowEvent e) {
            //this.dispose();
            alLive.remove(this);
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
    }

 //live stream ends
}
