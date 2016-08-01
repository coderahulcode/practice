import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class ServerGUI extends javax.swing.JFrame
{
    String fName, lName, password, contact, email, secQues, answer;

    public ServerGUI()
    {
        al = new ArrayList<>();
        tableModel = new TableModel();
        initComponents();
        lbServer.setVisible(false);
        this.setSize(650, 500);
        this.setResizable(false);
        this.setTitle("Server");
        btStartActionPerformed(null);

    }

    ArrayList<ServerClass.ClientHandler> al;
    TableModel tableModel;

    class TableModel extends AbstractTableModel
    {
        String[] columnNames =
        {
            "Ip Address", "Email"
        };

        @Override
        public int getRowCount()
        {
            return al.size();
        }

        @Override
        public int getColumnCount()
        {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            if (columnIndex == 0)
            {
                return al.get(rowIndex).sock.getInetAddress().getHostAddress();
            } else
            {
                return al.get(rowIndex).clientEmail;
            }
        }

        public String getColumnName(int colIndex)
        {
            return columnNames[colIndex];
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        btStart = new javax.swing.JButton();
        btStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbServer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        btStart.setText("Start");
        btStart.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btStartActionPerformed(evt);
            }
        });
        jPanel1.add(btStart);
        btStart.setBounds(10, 30, 118, 36);

        btStop.setText("Stop");
        btStop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btStopActionPerformed(evt);
            }
        });
        jPanel1.add(btStop);
        btStop.setBounds(160, 30, 112, 36);

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 550, 280);

        lbServer.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbServer.setForeground(new java.awt.Color(0, 204, 204));
        lbServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/serverSmall.png"))); // NOI18N
        lbServer.setText("Server Running");
        lbServer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lbServer);
        lbServer.setBounds(290, 0, 240, 110);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 500);

        setSize(new java.awt.Dimension(681, 535));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btStartActionPerformed
    {//GEN-HEADEREND:event_btStartActionPerformed
        serverThread = new Thread(new ServerClass());
        serverThread.start();
        System.out.println("Server Thread Started");
        btStart.setEnabled(false);
        lbServer.setVisible(true);

    }//GEN-LAST:event_btStartActionPerformed

    private void btStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btStopActionPerformed
    {//GEN-HEADEREND:event_btStopActionPerformed
        try
        {
            serverThread.stop();
            System.out.println("Server Thread Stopped");
        } catch (Exception e)
        {
        }
        btStart.setEnabled(true);

    }//GEN-LAST:event_btStopActionPerformed

    Thread serverThread;

    public class ServerClass implements Runnable
    {

        ServerSocket serSock;

        public ServerClass()
        {

            try
            {
                serSock = new ServerSocket(9000);
                System.out.println("Server Started");

            } catch (Exception e)
            {
                System.out.println("Server Error");
            }
        }

        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    Socket sock = serSock.accept();
                    System.out.println("Connection Build");
                    ClientHandler cl = new ClientHandler(sock);
                    al.add(cl);
                    tableModel.fireTableDataChanged();
                } catch (Exception e)
                {
                }

            }
        }

        public class ClientHandler implements Runnable
        {

            Socket sock;
            DataInputStream dis;
            DataOutputStream dos;
            Thread t1;
            String clientEmail = "Undefined";

            @Override
            public void run()
            {
                System.out.println("Thread Started");
                try
                {
                    dis = new DataInputStream(sock.getInputStream());
                    dos = new DataOutputStream(sock.getOutputStream());
                    while (true)
                    {
                        String s = dis.readLine();
                        if (s.equals("signup"))
                        {
                            fName = dis.readLine();
                            lName = dis.readLine();
                            email = dis.readLine();
                            password = dis.readLine();
                            contact = dis.readLine();
                            secQues = dis.readLine();
                            answer = dis.readLine();

                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");

                            try
                            {
                                ResultSet rs = stmt.executeQuery("select * from  user1 where email='" + email + "';");
                                        if (rs.next())
                                {
                                    dos.writeBytes("AlreadyExists\r\n");
                                } else
                                {
                                    rs.moveToInsertRow();
                                    rs.updateString(1, fName);
                                    rs.updateString(2, lName);
                                    rs.updateString(3, email);
                                    rs.updateString(4, password);
                                    rs.updateString(5, contact);
                                    rs.updateString(6, secQues);
                                    rs.updateString(7, answer);
                                    rs.insertRow();
                                    dos.writeBytes("successful\r\n");
                                }
                            } catch (Exception e)
                            {
                                dos.writeBytes("Error\r\n");
                                e.printStackTrace();
                            }

                        } else if (s.equals("login"))
                        {
                            String email = dis.readLine();
                            String password = dis.readLine();
                            clientEmail = email;

                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");

                            ResultSet rs = stmt.executeQuery("select * from user1 where email='" + email + "' and password='" + password + "'");
                            System.out.println(email + "     " + password);

                            if (rs.next())
                            {
                                dos.writeBytes("Login Successful\r\n");
                                tableModel.fireTableDataChanged();

                            } else
                            {
                                dos.writeBytes("Invalid Credentials\r\n");
                            }

                        } else if (s.equals("changePassword"))
                        {
                            String email, oldPass, newPass;

                            email = dis.readLine();
                            oldPass = dis.readLine();
                            newPass = dis.readLine();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");

                            ResultSet rs = stmt.executeQuery("select * from user1 where email='" + email + "' and password='" + oldPass + "'");
                            if (rs.next())
                            {
                                rs.updateString("password", newPass);
                                rs.updateRow();
                                dos.writeBytes("Update Successful\r\n");
                            } else
                            {
                                dos.writeBytes("Invalid email or old password\r\n");
                            }

                        } else if (s.equals("forgotPassword"))
                        {
                            email = dis.readLine();
                            System.out.println("email: " + email);
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");
                            ResultSet rs = null;
                            try
                            {
                                System.out.println("Result Set ");
                                rs = stmt.executeQuery("select * from user1 where email='" + email + "'");
                                System.out.println("Result set: " + rs);
                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            if (rs.next())
                            {
                                dos.writeBytes("found\r\n");
                                dos.writeBytes(rs.getString("SecQues") + "\r\n");
                                dos.writeBytes(rs.getString("Answer") + "\r\n");
                                dos.writeBytes(rs.getString("Password") + "\r\n");
                            } else
                            {
                                dos.writeBytes("notFound\r\n");
                            }

                        } else if (s.equals("search"))
                        {
                            try
                            {
                                String searchText = dis.readLine();
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                                System.out.println("Connection build");
                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                System.out.println("Statement Created");
                                String query = "select * from user1 where fname like '" + searchText + "%'" + " and email NOT IN('" + clientEmail + "')"; //shows username of other users except current user
                                System.out.println(query);
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Done");
                                if (rs.next())
                                {
                                    System.out.println("Entered");
                                    dos.writeBytes("found\r\n");
                                    String fullName = rs.getString("fname") + " " + rs.getString("lname");
                                    System.out.println(fullName);
                                    dos.writeBytes(fullName + "\r\n");
                                    dos.writeBytes(rs.getString("email") + "\r\n");
                                    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    ResultSet rs1 = stmt2.executeQuery("select * from friends where (UserEmail='" + clientEmail
                                            + "' and FriendEmail='" + rs.getString("email")
                                            + "' ) or (UserEmail='" + rs.getString("email") + "' and FriendEmail='" + clientEmail + "' )");

                                    String status = "";
                                    if (rs1.next()) //entry exists
                                    {
                                        if (rs1.getString("status").equals("Friend"))
                                        {
                                            status = "Friend";
                                        } else
                                        {
                                            if (rs1.getString("UserEmail").equals(clientEmail)) //request is sent by current user
                                            {
                                                status = rs1.getString("status");
                                            } else //request is sent to current user by other user
                                            {
                                                status = "Accept/Reject";
                                            }
                                        }

                                    } else
                                    {
                                        status = "Add Friend";
                                    }
                                    dos.writeBytes(status + "\r\n");
                                    while (rs.next())
                                    {
                                        fullName = rs.getString("fname") + " " + rs.getString("lname");
                                        dos.writeBytes(fullName + "\r\n");
                                        dos.writeBytes(rs.getString("email") + "\r\n");
                                        rs1 = stmt2.executeQuery("select * from friends where (UserEmail='" + clientEmail
                                                + "' and FriendEmail='" + rs.getString("email")
                                                + "' ) or (UserEmail='" + rs.getString("email") + "' and FriendEmail='" + clientEmail + "' )");

                                        if (rs1.next()) //entry exists
                                        {
                                            if (rs1.getString("status").equals("Friend"))
                                            {
                                                status = "Friend";
                                            } else
                                            {
                                                if (rs1.getString("UserEmail").equals(clientEmail)) //request is sent by current user
                                                {
                                                    status = rs1.getString("status");
                                                } else //request is sent to current user by other user
                                                {
                                                    status = "Accept/Reject";
                                                }
                                            }

                                        } else
                                        {
                                            status = "Add Friend";
                                        }
                                        dos.writeBytes(status + "\r\n");
                                    }
                                    dos.writeBytes("dataFinished\r\n");

                                } else
                                {
                                    System.out.println("Not Found");
                                    dos.writeBytes("notFound\r\n");

                                }

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        } else if (s.equals("friendRequest"))
                        {
                            System.out.println("Enteres in request");
                            String friendEmail = dis.readLine();
                            System.out.println("Friend email: " + friendEmail);
                            try
                            {
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                                System.out.println("Connection build");
                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                System.out.println("Statement Created");

                                ResultSet rs = stmt.executeQuery("SELECT * FROM FRIENDS");

                                System.out.println("Result set created");
                                rs.moveToInsertRow();
                                rs.updateString("FriendEmail", friendEmail);
                                rs.updateString("UserEmail", clientEmail);
                                rs.updateString("Status", "Pending");
                                rs.insertRow();
                                System.out.println("Row inserted");
                                dos.writeBytes("send" + "\r\n");

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                                dos.writeBytes("error" + "\r\n");
                            }

                        } else if (s.equals("reject"))
                        {
                            String friendEmail = dis.readLine();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");
                            String query = "select * from friends where UserEmail='" + friendEmail + "' and FriendEmail='" + clientEmail + "'";
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next())
                            {
                                rs.deleteRow();
                                dos.writeBytes("deleted\r\n");
                            } else
                            {
                                dos.writeBytes("error\r\n");
                            }
                        } else if (s.equals("accept"))
                        {
                            String friendEmail = dis.readLine();
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");
                            String query = "select * from friends where UserEmail='" + friendEmail + "' and FriendEmail='" + clientEmail + "'";
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next())
                            {
                                rs.updateString("Status", "Friend");
                                rs.updateRow();
                                dos.writeBytes("accepted\r\n");
                            } else
                            {
                                dos.writeBytes("error\r\n");
                            }
                        } else if (s.equals("pendingRequest"))
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            System.out.println("Driver loaded successfully");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                            System.out.println("Connection build");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            System.out.println("Statement Created");
                            String query = "select * from friends where FriendEmail='" + clientEmail + "' and Status='Pending'";
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next())
                            {
                                System.out.println("data found of friend pending request");
                                dos.writeBytes("found\r\n");
                                rs.previous();
                                while (rs.next())
                                {
                                    dos.writeBytes(rs.getString("UserEmail") + "\r\n");
                                    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    System.out.println("Statement Created");
                                    String query1 = "select * from user1 where email='" + rs.getString("UserEmail") + "'";
                                    ResultSet rs1 = stmt1.executeQuery(query1);
                                    rs1.next();
                                    String fname = rs1.getString("fname");
                                    String lname = rs1.getString("lname");
                                    dos.writeBytes(fname + " " + lname + "\r\n");
                                    dos.writeBytes("Accept/Reject\r\n");
                                }
                                dos.writeBytes("dataEnd\r\n");
                            } else
                            {
                                dos.writeBytes("notFound\r\n");
                            }

                        } else if (s.equals("fetch"))
                        {
                            try
                            {
                                Class.forName("com.mysql.jdbc.Driver");
                                System.out.println("Driver loaded successfully");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
                                System.out.println("Connection build");
                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                System.out.println("Statement Created");
                                String query = "select * from friends where (UserEmail='" + clientEmail + "' or FriendEmail='" + clientEmail + "') and Status='Friend'";
                                System.out.println(query);
                                ResultSet rs = stmt.executeQuery(query);
                                if (rs.next())
                                {
                                    dos.writeBytes("friendExist\r\n");
                                    rs.previous();
                                    while (rs.next())
                                    {

                                        String friendEmail = rs.getString("FriendEmail");
                                        if (friendEmail.equals(clientEmail))
                                        {
                                            friendEmail = rs.getString("UserEmail");
                                        }
                                        System.out.println("Entered in fetch friend: " + friendEmail);

                                        //check whether friend is online
                                        for (ClientHandler clientHandler : al)
                                        {
                                            if (friendEmail.equals(clientHandler.clientEmail))
                                            {
                                                //get fullname of friend
                                                dos.writeBytes(friendEmail + "\r\n");

                                                Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                                System.out.println("Statement Created");
                                                String query1 = "select * from user1 where Email='" + friendEmail + "'";
                                                ResultSet rs1 = stmt1.executeQuery(query1);
                                                rs1.next();
                                                String fname = rs1.getString("fname");
                                                String lname = rs1.getString("lname");
                                                dos.writeBytes(fname + " " + lname + "\r\n");
                                                dos.writeBytes(clientHandler.sock.getInetAddress().getHostAddress() + "\r\n");
                                                break;
                                            }
                                        }

                                    }
                                    dos.writeBytes("dataFinished\r\n");

                                } else
                                {
                                    dos.writeBytes("notFriend\r\n");
                                }
                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                    al.remove(this);
                    tableModel.fireTableDataChanged();
                }

            }

            public ClientHandler(Socket sock)
            {
                try
                {
                    this.sock = sock;
                    t1 = new Thread(this);
                    t1.start();

                } catch (Exception e)
                {
                }
            }

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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStart;
    private javax.swing.JButton btStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbServer;
    // End of variables declaration//GEN-END:variables
}
