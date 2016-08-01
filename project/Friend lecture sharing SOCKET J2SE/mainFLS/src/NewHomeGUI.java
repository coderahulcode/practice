import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.xswingx.BuddySupport;
import org.jdesktop.xswingx.PromptSupport;

public class NewHomeGUI extends javax.swing.JFrame
{
    //Variables
    DataOutputStream dos;
    DataInputStream dis;
    downloadmodel dm;
    ArrayList<downloadpanel> dl = new ArrayList<>();
    InnerServer innerServer;
    ArrayList<SearchResult> sl;
    ArrayList<Friend> friendList;
    TableModel tableModel;
    InnerClient innerClient;
    SearchTableModel searchTableModel;
    ArrayList<MyFriend> myFriendList;
    TableModelFriend tableModelFriend;

    public NewHomeGUI(String title)
    {
        initComponents();
        this.setSize(1120, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle(title);
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        startServices();
        PromptSupport.setPrompt("  Search name of user", tfSearch);
        PromptSupport.setPrompt("  Search file", tfSearchFile);
        btSearchActionPerformed(null);

    }

    private void startServices()
    {
        try
        {
            //for friends 
            friendList = new ArrayList<>();
            tableModel = new TableModel();
            jTable1.setModel(tableModel);

            //for online friends
            myFriendList = new ArrayList<>();
            tableModelFriend = new TableModelFriend();
            jTable2.setModel(tableModelFriend);

            //for friends
            sl = new ArrayList<>();
            dm = new downloadmodel();
            searchTableModel = new SearchTableModel();
            jTable3.setModel(searchTableModel);

            downloadtable.setModel(dm);
            downloadtable.setRowHeight(100);
            downloadtable.getColumnModel().getColumn(0).setCellRenderer(new mycellrenderer());
            innerServer = new InnerServer();
        } catch (Exception e)
        {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btAccept = new javax.swing.JButton();
        btReject = new javax.swing.JButton();
        btSendRequest = new javax.swing.JButton();
        btPendingRequest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        tfSearchFile = new javax.swing.JTextField();
        btSearchFile = new javax.swing.JButton();
        rbPdf = new javax.swing.JRadioButton();
        rbImage = new javax.swing.JRadioButton();
        rbVideo = new javax.swing.JRadioButton();
        rbSoftware = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btDownload = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        downloadtable = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(tfSearch);
        tfSearch.setBounds(10, 30, 230, 30);

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btSearch);
        btSearch.setBounds(250, 30, 100, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 340, 310);

        btAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Check.png"))); // NOI18N
        btAccept.setText("Accept");
        btAccept.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAcceptActionPerformed(evt);
            }
        });
        jPanel1.add(btAccept);
        btAccept.setBounds(370, 70, 160, 40);

        btReject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btReject.setText("Reject");
        btReject.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRejectActionPerformed(evt);
            }
        });
        jPanel1.add(btReject);
        btReject.setBounds(370, 120, 160, 40);

        btSendRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        btSendRequest.setText("Send Request");
        btSendRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSendRequestActionPerformed(evt);
            }
        });
        jPanel1.add(btSendRequest);
        btSendRequest.setBounds(370, 170, 160, 40);

        btPendingRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hourglass.png"))); // NOI18N
        btPendingRequest.setText("Pending Request");
        btPendingRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btPendingRequestActionPerformed(evt);
            }
        });
        jPanel1.add(btPendingRequest);
        btPendingRequest.setBounds(370, 220, 160, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hd3.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -10, 630, 420);

        jTabbedPane1.addTab("Control Panel", jPanel1);

        jPanel2.setLayout(null);

        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        btRefresh.setText("Refresh");
        btRefresh.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btRefresh);
        btRefresh.setBounds(10, 30, 110, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 520, 310);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hd3.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, -10, 680, 420);

        jTabbedPane1.addTab("Online Friends", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 70, 560, 430);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);
        jPanel3.add(tfSearchFile);
        tfSearchFile.setBounds(10, 30, 270, 30);

        btSearchFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        btSearchFile.setText("Search");
        btSearchFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSearchFileActionPerformed(evt);
            }
        });
        jPanel3.add(btSearchFile);
        btSearchFile.setBounds(290, 30, 110, 30);

        rbPdf.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbPdf);
        rbPdf.setSelected(true);
        rbPdf.setText("Pdf");
        jPanel3.add(rbPdf);
        rbPdf.setBounds(50, 70, 60, 23);

        rbImage.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbImage);
        rbImage.setText("Image");
        jPanel3.add(rbImage);
        rbImage.setBounds(110, 70, 60, 23);

        rbVideo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbVideo);
        rbVideo.setText("Video");
        jPanel3.add(rbVideo);
        rbVideo.setBounds(180, 70, 60, 23);

        rbSoftware.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbSoftware);
        rbSoftware.setText("Software");
        jPanel3.add(rbSoftware);
        rbSoftware.setBounds(240, 70, 93, 23);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 100, 390, 270);

        btDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Download.png"))); // NOI18N
        btDownload.setText("Download");
        btDownload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDownload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDownload.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btDownloadActionPerformed(evt);
            }
        });
        jPanel3.add(btDownload);
        btDownload.setBounds(423, 280, 100, 70);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hd5.jpg"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(60, 20, 510, 300);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Type:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 70, 60, 20);

        jTabbedPane2.addTab("Search Files", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        downloadtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(downloadtable);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(10, 30, 400, 360);

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hd5.jpg"))); // NOI18N
        jPanel4.add(jLabel55);
        jLabel55.setBounds(60, 20, 510, 300);

        jTabbedPane2.addTab("Downloads", jPanel4);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(560, 70, 600, 430);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fls2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-170, -70, 1380, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSearchActionPerformed
    {//GEN-HEADEREND:event_btSearchActionPerformed
        try
        {
            friendList.clear();
            dos.writeBytes("search\r\n");
            dos.writeBytes(tfSearch.getText() + "\r\n");
            String msg = dis.readLine();
            System.out.println(msg);
            if (msg.equals("found"))
            {
                while (true)
                {

                    String name, email, status;
                    name = dis.readLine();
                    if (name.equals("dataFinished"))
                    {
                        break;
                    }
                    email = dis.readLine();
                    status = dis.readLine();
                    friendList.add(new Friend(name, status, email));
                }
                tableModel.fireTableDataChanged();

            } else
            {
                JOptionPane.showMessageDialog(this, "No Result found", "Error", JOptionPane.ERROR_MESSAGE);
                tableModel.fireTableDataChanged();

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAcceptActionPerformed
    {//GEN-HEADEREND:event_btAcceptActionPerformed
        try
        {
            if (friendList.get(jTable1.getSelectedRow()).Status.equals("Accept/Reject"))
            {
                String friendEmail = friendList.get(jTable1.getSelectedRow()).Email;
                dos.writeBytes("accept\r\n");
                dos.writeBytes(friendEmail + "\r\n");
                String msg = dis.readLine();
                if (msg.equals("accepted"))
                {
                    JOptionPane.showMessageDialog(this, "Request Accepted", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    friendList.get(jTable1.getSelectedRow()).Status = "Friend";
                    tableModel.fireTableDataChanged();
                }
            } else
            {
                JOptionPane.showMessageDialog(this, "Invalid Operation", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btAcceptActionPerformed

    private void btRejectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRejectActionPerformed
    {//GEN-HEADEREND:event_btRejectActionPerformed
        try
        {
            if (friendList.get(jTable1.getSelectedRow()).Status.equals("Accept/Reject"))
            {
                String friendEmail = friendList.get(jTable1.getSelectedRow()).Email;
                dos.writeBytes("reject\r\n");
                dos.writeBytes(friendEmail + "\r\n");
                String msg = dis.readLine();
                if (msg.equals("deleted"))
                {
                    JOptionPane.showMessageDialog(this, "Request Rejected", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    friendList.remove(jTable1.getSelectedRow());
                    tableModel.fireTableDataChanged();
                }
            } else
            {
                JOptionPane.showMessageDialog(this, "Invalid Operation", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btRejectActionPerformed

    private void btSendRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSendRequestActionPerformed
    {//GEN-HEADEREND:event_btSendRequestActionPerformed
        String status = friendList.get(jTable1.getSelectedRow()).Status;
        System.out.println(status);
        if (status.equals("Add Friend"))
        {
            String email = friendList.get(jTable1.getSelectedRow()).Email;
            try
            {
                dos.writeBytes("friendRequest" + "\r\n");
                dos.writeBytes(email + "\r\n");
                String msg = dis.readLine();
                if (msg.equals("send"))
                {
                    JOptionPane.showMessageDialog(this, "Request Send", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    friendList.get(jTable1.getSelectedRow()).Status = "Pending";
                    tableModel.fireTableDataChanged();

                } else
                {
                    JOptionPane.showMessageDialog(this, "Request not send", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e)
            {
            }

        } else
        {
            JOptionPane.showMessageDialog(this, "Cannot send friend request", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSendRequestActionPerformed

    private void btPendingRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btPendingRequestActionPerformed
    {//GEN-HEADEREND:event_btPendingRequestActionPerformed
        try
        {
            dos.writeBytes("pendingRequest\r\n");

            try
            {
                friendList.clear();
                tableModel.fireTableDataChanged();
                System.out.println("LIST CLEARED    ");
            } catch (Exception e)
            {
            }
            String msg = dis.readLine();

            if (msg.equals("found"))
            {
                while (true)
                {
                    String userEmail, name, status;
                    userEmail = dis.readLine();
                    if (userEmail.equals("dataEnd"))
                    {
                        break;
                    }
                    name = dis.readLine();
                    status = dis.readLine();
                    friendList.add(new Friend(name, status, userEmail));
                }
                tableModel.fireTableDataChanged();
            }

        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btPendingRequestActionPerformed

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRefreshActionPerformed
    {//GEN-HEADEREND:event_btRefreshActionPerformed
        try
        {
            myFriendList.clear();
            dos.writeBytes("fetch\r\n");
            String msg = dis.readLine();
            System.out.println(msg);
            if (msg.equals("friendExist"))
            {
                while (true)
                {
                    String ip, name, email;
                    email = dis.readLine();
                    if (email.equals("dataFinished"))
                    {
                        break;
                    }
                    name = dis.readLine();
                    ip = dis.readLine();
                    myFriendList.add(new MyFriend(ip, name, email));
                }
                tableModelFriend.fireTableDataChanged();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btRefreshActionPerformed

    private void btSearchFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSearchFileActionPerformed
    {//GEN-HEADEREND:event_btSearchFileActionPerformed
        SearchJob searchJob = new SearchJob();
    }//GEN-LAST:event_btSearchFileActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btDownloadActionPerformed
    {//GEN-HEADEREND:event_btDownloadActionPerformed
        try
        {
            if (jTable3.getSelectedRow() != -1)
            {
                int index = jTable3.getSelectedRow();
                String ip = sl.get(index).ip;
                String path = sl.get(index).path;
                String username = sl.get(index).username;
                InnerClient icl = new InnerClient("download#" + path, ip, username);
                Thread t = new Thread(icl);
                t.start();
            } else
            {
                JOptionPane.showMessageDialog(this, "Please select file to download", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e)
        {
        }

    }//GEN-LAST:event_btDownloadActionPerformed

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
            java.util.logging.Logger.getLogger(NewHomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(NewHomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(NewHomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(NewHomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new NewHomeGUI("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccept;
    private javax.swing.JButton btDownload;
    private javax.swing.JButton btPendingRequest;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btReject;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchFile;
    private javax.swing.JButton btSendRequest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable downloadtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JRadioButton rbImage;
    private javax.swing.JRadioButton rbPdf;
    private javax.swing.JRadioButton rbSoftware;
    private javax.swing.JRadioButton rbVideo;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSearchFile;
    // End of variables declaration//GEN-END:variables

    /**
     * *--------------------Internal server class
     * started.....................................................
     */
    class InnerServer implements Runnable
    {
        Thread innerServerThread;

        ServerSocket innerServerSerSocket;
        Socket innerServerSocket;

        public InnerServer()
        {
            try
            {
                innerServerSerSocket = new ServerSocket(8800);
                innerServerThread = new Thread(this);
                innerServerThread.start();
            } catch (Exception e)
            {
            }

        }

        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    innerServerSocket = innerServerSerSocket.accept();
                    InnerServerClientHandler innerClientHandler = new InnerServerClientHandler(innerServerSocket);

                } catch (Exception e)
                {
                }

            }
        }

        class InnerServerClientHandler implements Runnable
        {
            Thread innerServerClientHandlerThread;
            DataOutputStream innerServerClientHandlerDOS;
            DataInputStream innerServerClientHandlerDIS;

            public InnerServerClientHandler(Socket sock)
            {
                try
                {
                    innerServerClientHandlerDOS = new DataOutputStream(sock.getOutputStream());
                    innerServerClientHandlerDIS = new DataInputStream(sock.getInputStream());
                    innerServerClientHandlerThread = new Thread(this);
                    innerServerClientHandlerThread.start();
                } catch (Exception e)
                {
                }

            }

            @Override
            public void run()
            {
                try
                {
                    String msg = innerServerClientHandlerDIS.readLine();
                    if (msg.equals("search"))
                    {
                        String searchText, type;
                        searchText = innerServerClientHandlerDIS.readLine();
                        type = innerServerClientHandlerDIS.readLine();
                        System.out.println("Inner server: " + msg + "  " + searchText + "   " + type);

                        File f = new File("C:\\FriendLectureSharing\\" + type);
                        File[] files = f.listFiles();
                        for (int i = 0; i < files.length; i++)
                        {
                            String name = files[i].getName();
                            if (name.contains(searchText))
                            {
                                System.out.println(files[i].getName());
                                innerServerClientHandlerDOS.writeBytes(files[i].getName() + "\r\n");
                                innerServerClientHandlerDOS.writeBytes(files[i].getPath() + "\r\n");
                                innerServerClientHandlerDOS.writeBytes(files[i].length() + "\r\n");
                            }
                        }
                        innerServerClientHandlerDOS.writeBytes("dataFinished\r\n");
                    } else if (msg.equals("download"))
                    {
                        String path = innerServerClientHandlerDIS.readLine();
                        File f = new File(path);
                        FileInputStream fis = new FileInputStream(f);
                        long size = f.length();
                        innerServerClientHandlerDOS.writeLong(size);
                        byte b[] = new byte[10000];
                        long count = 0;
                        while (true)
                        {
                            int r = fis.read(b, 0, 10000);
                            innerServerClientHandlerDOS.write(b, 0, r);
                            count = count + r;
                            if (count >= size)
                            {
                                break;
                            }
                        }
                        fis.close();
                    }
                } catch (Exception e)
                {
                }
            }

        }

    }

    /**
     * *--------------------Internal server class
     * Finished.......................................................
     */
    class SearchJob implements Runnable
    {
        Thread searchJobThread;

        public SearchJob()
        {
            searchJobThread = new Thread(this);
            searchJobThread.start();
        }

        @Override
        public void run()
        {
            try
            {
                Thread[] searchThreads = new Thread[myFriendList.size()]; //creates a thread array
                for (int i = 0; i < myFriendList.size(); i++)
                {
                    InnerClient icl = new InnerClient("search", myFriendList.get(i).ip, myFriendList.get(i).name);
                    searchThreads[i] = new Thread(icl);//initialise thread array's element
                    searchThreads[i].start();

                }
                for (int i = 0; i < myFriendList.size(); i++)
                {
                    searchThreads[i].join();
                }
                JOptionPane.showMessageDialog(null, "Search completed", "Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e)
            {
            }
        }

    }

    class SearchTableModel extends AbstractTableModel
    {
        String[] columnNames =
        {
            "Username", "File", "Size"
        };

        @Override
        public int getRowCount()
        {
            return sl.size();
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
                return sl.get(rowIndex).username;
            } else if (columnIndex == 1)
            {
                return sl.get(rowIndex).file;
            } else
            {
                return sl.get(rowIndex).size;
            }
        }

        public String getColumnName(int columnIndex)
        {
            return columnNames[columnIndex];
        }

    }

    class SearchResult
    {
        String ip, username, file, size, path, type;

        public SearchResult(String ip, String username, String file, String size, String path, String type)
        {
            this.ip = ip;
            this.username = username;
            this.file = file;
            this.size = size;
            this.path = path;
            this.type = type;
        }

    }

    class InnerClient implements Runnable
    {
        DataOutputStream innerClientDOS;
        DataInputStream innerClientDIS;
        //Thread innerClientThread;
        Socket innerClientSocket;
        String command, ip, username;

        public InnerClient(String command, String ip, String username)
        {
            try
            {
                this.command = command;
                this.ip = ip;
                this.username = username;
            } catch (Exception e)
            {
            }
        }

        @Override
        public void run()
        {
            try
            {
                innerClientSocket = new Socket(ip, 8800);
                innerClientDIS = new DataInputStream(innerClientSocket.getInputStream());
                innerClientDOS = new DataOutputStream(innerClientSocket.getOutputStream());
                StringTokenizer st = new StringTokenizer(command, "#");
                String s = st.nextToken();
                if (s.equals("search"))
                {
                    innerClientDOS.writeBytes("search\r\n");
                    innerClientDOS.writeBytes(tfSearchFile.getText() + "\r\n");
                    String type = "";
                    if (rbPdf.isSelected())
                    {
                        type = "Pdf";
                    } else if (rbImage.isSelected())
                    {
                        type = "Images";
                    } else if (rbVideo.isSelected())
                    {
                        type = "Videos";
                    } else
                    {
                        type = "Software";
                    }
                    innerClientDOS.writeBytes(type + "\r\n");
                    System.out.println("data sent from inner client");

                    /*-----------get data from innerServerClient------------*/
                    String fileName, filePath, fileLength;
                    while (true)
                    {
                        System.out.println("data receiving");
                        fileName = innerClientDIS.readLine();
                        if (fileName.equals("dataFinished"))
                        {
                            break;
                        }
                        filePath = innerClientDIS.readLine();
                        fileLength = innerClientDIS.readLine();
                        sl.add(new SearchResult(ip, username, fileName, fileLength, filePath, type));

                    }
                    searchTableModel.fireTableDataChanged();

                } else if (s.equals("download"))
                {
                    String path = st.nextToken();
                    innerClientDOS.writeBytes("download\r\n");
                    innerClientDOS.writeBytes(path + "\r\n");
                    File f = new File(path);
                    FileOutputStream fos = new FileOutputStream(f);
                    long size = innerClientDIS.readLong();
                    byte b[] = new byte[10000];
                    long count = 0;
                    downloadpanel d = new downloadpanel();
                    d.jProgressBar1.setValue(0);
                    d.lbfile.setText(path);
                    d.lbuser.setText(username);
                    dl.add(d);
                    dm.fireTableDataChanged();
                    while (true)
                    {
                        int r = innerClientDIS.read(b, 0, 10000);
                        fos.write(b, 0, r);
                        count = count + r;
                        d.jProgressBar1.setValue((int) ((count * 100) / size));
                        dm.fireTableDataChanged();
                        if (count >= size)
                        {
                            break;
                        }
                    }
                    fos.close();
                    dl.remove(d);
                    dm.fireTableDataChanged();
                    JOptionPane.showMessageDialog(null, "File Downloaded");
                }
            } catch (Exception e)
            {
            }
        }

    }

    class Friend
    {
        String Name;
        String Status;
        String Email;

        public Friend(String Name, String Status, String Email)
        {
            this.Name = Name;
            this.Status = Status;
            this.Email = Email;
        }

    }

    class TableModel extends AbstractTableModel
    {

        String[] columnName =
        {
            "Name", "Email", "Status"
        };

        @Override
        public int getRowCount()
        {
            return friendList.size();
        }

        @Override
        public int getColumnCount()
        {
            return columnName.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            if (columnIndex == 0)
            {
                return friendList.get(rowIndex).Name;
            } else if (columnIndex == 1)
            {
                return friendList.get(rowIndex).Email;
            } else
            {
                return friendList.get(rowIndex).Status;
            }
        }

        public String getColumnName(int columnIndex)
        {
            return columnName[columnIndex];
        }

    }

    class MyFriend
    {
        String ip;
        String name;
        String email;

        public MyFriend(String ip, String name, String email)
        {
            this.ip = ip;
            this.name = name;
            this.email = email;
        }

    }

    class TableModelFriend extends AbstractTableModel
    {

        String[] columnNames =
        {
            "Ip", "Name", "Email"
        };

        @Override
        public int getRowCount()
        {
            return myFriendList.size();
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
                return myFriendList.get(rowIndex).ip;

            } else if (columnIndex == 1)
            {
                return myFriendList.get(rowIndex).name;

            } else
            {
                return myFriendList.get(rowIndex).email;

            }
        }

        public String getColumnName(int columnIndex)
        {
            return columnNames[columnIndex];

        }
    }

    class downloadmodel extends AbstractTableModel
    {
        String name[] =
        {
            "Download"
        };

        @Override
        public String getColumnName(int column)
        {
            return name[column];
        }

        @Override
        public int getRowCount()
        {
            return dl.size();
        }

        @Override
        public int getColumnCount()
        {
            return name.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return null;
        }

    }

    class mycellrenderer extends DefaultTableCellRenderer
    {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            return dl.get(row);
        }

    }
}
