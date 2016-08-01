
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ServerFrame extends javax.swing.JFrame
{

    ArrayList<Server.ClientHandler> al = new ArrayList<Server.ClientHandler>();
    
    TableModel tm;

    public ServerFrame()
    {
        initComponents();
        setSize(400, 400);
        setVisible(true);
        tm = new TableModel();
        jt.setModel(tm);
    }

    class user
    {

        String name, gender, username;

        user(String name, String gender, String username)
        {
            this.username = username;
            this.name = name;
            this.gender = gender;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jButton1.setText("Start Server");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(95, 53, 150, 30);

        jScrollPane1.setViewportView(jt);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 320, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton1ActionPerformed
        Server ser = new Server();
        Thread t = new Thread(ser);
        t.start();

        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public class Server implements Runnable
    {

        public void run()
        {
            try
            {
                ServerSocket sersock = new ServerSocket(9000);
                while (true)
                {
                    Socket sock;
                    sock = sersock.accept();
                    ClientHandler ch = new ClientHandler(sock);
                    Thread t = new Thread(ch);
                    t.start();
                }

            } catch (Exception ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public class ClientHandler implements Runnable
        {

            ArrayList<user> u_al = new ArrayList<>();
     ArrayList<String> f_al = new ArrayList<>();
            DataOutputStream dos;
            DataInputStream dis;
            Socket sock;
            String username;

            ClientHandler(Socket sock)
            {
                this.sock = sock;
            }

            public void run()
            {
                try
                {
                    dos = new DataOutputStream(sock.getOutputStream());
                    dos.writeBytes("Hello client..\r\n");
                    dis = new DataInputStream(sock.getInputStream());
                    String s = dis.readLine();
                    System.out.println(" s: " + s);
                    al.add(this);
                    tm.fireTableDataChanged();
                    while (true)
                    {
                        s = dis.readLine();
                        System.out.println(" s: " + s);
                        if (s.equals("signuprequest"))
                        {
                            String Username = dis.readLine();
                            String Name = dis.readLine();
                            String Email = dis.readLine();
                            String Phone_no = dis.readLine();
                            String gender = dis.readLine();
                            String DOB = dis.readLine();
                            String Password = dis.readLine();

                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            //     Statement stmt=conn.createStatement();
                            ResultSet rs = stmt.executeQuery("Select * from User where UserName='" + Username + "'");

                            dos.writeBytes("loginresponse\r\n");
                            if (rs.next())
                            {
                                dos.writeBytes("alreadyexist\r\n");
                            } else
                            {
                                rs.moveToInsertRow();
                                System.out.println(rs);
                                rs.updateString("username", Username);
                                rs.updateString("name", Name);
                                rs.updateString("email", Email);
                                rs.updateString("phone", Phone_no);
                                rs.updateString("gender", gender);
                                rs.updateString("dob", DOB);
                                rs.updateString("password", Password);
                                rs.insertRow();
                                System.out.println("Row Inserted Successfully....");

                                dos.writeBytes("addedsuccessfully\r\n");
                            }
                        } else if (s.equals("login"))
                        {
                            username = dis.readLine();
                            String password = dis.readLine();

                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                            ResultSet rs = stmt.executeQuery("Select * from User where Username='" + username + "' and Password='" + password + "'");
                            dos.writeBytes("login\r\n");
                            if (rs.next())
                            {
                                tm.fireTableDataChanged();
                                dos.writeBytes("login successfully\r\n");
                            } else
                            {
                                dos.writeBytes("login Failed\r\n");
                            }
                        } else if (s.equals("searchrequest"))
                        {
                            u_al.clear();
                            String search = dis.readLine();
                            System.out.println(" search " + search);
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                            ResultSet rs = stmt.executeQuery("Select * from User where name like '" + search + "%'");
                            while (rs.next())
                            {
                                String username = rs.getString("username");
                                if (!username.equals(this.username))
                                {
                                    String name = rs.getString("name");
                                    String gender = rs.getString("gender");
                                    String user = rs.getString("username");
                                    u_al.add(new user(name, gender, user));
                                }
                            }
                            dos.writeBytes("searchresponse\r\n");

                            for (int i = 0; i < u_al.size(); i++)
                            {
                                dos.writeBytes(u_al.get(i).name + "\r\n");
                                dos.writeBytes(u_al.get(i).gender + "\r\n");
                                dos.writeBytes(u_al.get(i).username + "\r\n");
                            }
                            dos.writeBytes("end\r\n");

                        } else if (s.equals("SendFriendRequest"))
                        {
                            String friendname = dis.readLine();
                            System.out.println("name:" + friendname);

                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                            ResultSet rs = stmt.executeQuery("Select * from friends where request_to='" + friendname + "' and request_from='" + username + "'");
                            dos.writeBytes("sendrequestresponse\r\n");
                            if (rs.next())
                            {
                                System.out.println("already request sent");
                                dos.writeBytes("Already exist \r\n");
                            } else
                            {
                                rs.moveToInsertRow();
                                System.out.println(rs);
                                rs.updateString("request_to", friendname);
                                rs.updateString("request_from", username);
                                rs.updateString("status", "request sent");
                                rs.insertRow();
                                dos.writeBytes("Request sent successfully\r\n");
                                System.out.println("Rows are inserted");

                            }
                        } else if (s.equals("ViewPendingRequests"))
                        {
                            u_al.clear();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                            ResultSet rs = stmt.executeQuery("Select * from friends where request_to='" + username + "' and status='request sent'");
                            while (rs.next())
                            {

                                String user = rs.getString("request_from");

                                Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                                ResultSet rs2 = stmt2.executeQuery("Select * from user where username='" + user + "'");
                                if (rs2.next())
                                {
                                    String gender = rs2.getString("gender");
                                    String name = rs2.getString("name");
                                    u_al.add(new user(name, gender, user));
                                }
                            }
                            dos.writeBytes("ViewPendingRequestsResponce\r\n");

                            for (int i = 0; i < u_al.size(); i++)
                            {
                                dos.writeBytes(u_al.get(i).name + "\r\n");
                                dos.writeBytes(u_al.get(i).gender + "\r\n");
                                dos.writeBytes(u_al.get(i).username + "\r\n");
                            }
                            dos.writeBytes("end\r\n");

                        } else if (s.equals("AcceptRequest"))
                        {
                            String user = dis.readLine();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("Select * from friends where request_from='" + user + "'and request_to='" + username + "'");

                            if (rs.next())
                            {
                                rs.updateString("status", "friends");
                                rs.updateRow();

                                System.out.println("row inserted successfully");
//                             Statement stmt2=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                            }
                            rs = stmt.executeQuery("Select * from friends ");
                            rs.moveToInsertRow();
                            rs.updateString("request_to", user);
                            rs.updateString("request_from", username);
                            rs.updateString("status", "friends");
                            rs.insertRow();
                            dos.writeBytes("Friend request accepted\r\n");

                        } else if (s.equals("RejectRequest"))
                        {
                            String user = dis.readLine();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("Select * from friends where request_from='" + user + "'and request_to='" + username + "'");

                            if (rs.next())
                            {
                                rs.updateString("status", "rejected");
                                rs.updateRow();

                                dos.writeBytes("Request Rejected\r\n");
//                      
                            }
                        } else if (s.equals("ViewOnlineFriends"))
                        {
                            f_al.clear();
                            for(int i=0;i<al.size();i++)
                            {   
                                String onlineUser=al.get(i).username;
                                System.out.println(" username "+onlineUser);
                                if(!onlineUser.equals(username)){
                                
                                  Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver Loading successful");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("connection with database successful...........");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("Select * from friends where request_to='" + onlineUser + "' and request_from='" + username + "' and status='friends'");
                           if(rs.next())
                           {
                               f_al.add(onlineUser);
                               System.out.println(" online user "+onlineUser);
                           }
                            }
                            }
                        System.out.println(f_al.size());
                        for(int i=0;i<f_al.size();i++){
                        System.out.println(f_al.size());}
                            dos.writeBytes("Review list\r\n");
                            dos.writeInt(f_al.size());

                            for (int i = 0; i < f_al.size(); i++)
                            {
                                    dos.writeBytes(f_al.get(i) + "\r\n");
                            }
                        }
                    }
                } catch (Exception ex)
                {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    al.remove(this);
                    tm.fireTableDataChanged();
                }
            }

        }

//    public static void main(String[] args) throws IOException {
//        new Server();
//        
//    }
    }

    class TableModel extends AbstractTableModel
    {

        @Override
        public int getRowCount()
        {

            return al.size();
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getColumnCount()
        {
            return 3;
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            if (columnIndex == 0)
            {
                return al.get(rowIndex).sock.getInetAddress().getHostAddress();
            } else
            {
                return al.get(rowIndex).username;
            }
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

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
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ServerFrame().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    // End of variables declaration//GEN-END:variables
}
