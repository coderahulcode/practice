import java.awt.Component;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class HomeGUI extends javax.swing.JFrame
{
    DataOutputStream dos;
    DataInputStream dis;
    downloadmodel dm;
    ArrayList<downloadpanel>dl=new ArrayList<>();
    public HomeGUI()
    {
        //for friends 
        friendList = new ArrayList<>();
        tableModel = new TableModel();

        //for online friends
        myFriendList = new ArrayList<>();
        tableModelFriend = new TableModelFriend();

        //for friends
        sl = new ArrayList<>();
        dm=new downloadmodel();
        searchTableModel = new SearchTableModel();
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        downloadtable.setModel(dm);
        downloadtable.setRowHeight(100);
        downloadtable.getColumnModel().getColumn(0).setCellRenderer(new mycellrenderer());
        innerServer = new InnerServer();
    }

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
                        System.out.println("Inner server: " + msg+"  "+searchText+"   "+type);

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
                    }
                    else if(msg.equals("download"))
                    {
                        String path=innerServerClientHandlerDIS.readLine();
                        File f=new File(path);
                        FileInputStream fis=new FileInputStream(f);
                        long size=f.length();
                        innerServerClientHandlerDOS.writeLong(size);
                        byte b[]=new byte[10000];
                        long count=0;
                        while(true){
                            int r=fis.read(b,0,10000);
                            innerServerClientHandlerDOS.write(b,0,r);
                            count=count+r;
                            if(count>=size)
                                break;
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
    InnerServer innerServer;

    ArrayList<SearchResult> sl;

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
    SearchTableModel searchTableModel;

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
                StringTokenizer st=new StringTokenizer(command,"#");
                String s=st.nextToken();
                if (s.equals("search"))
                {
                    innerClientDOS.writeBytes("search\r\n");
                    innerClientDOS.writeBytes(tfSearchFile.getText() + "\r\n");
                    String type = "";
                    if (rbPdf.isSelected())
                    {
                        type = "Pdf";
                    } else if (rbImages.isSelected())
                    {
                        type = "Images";
                    } else if (rbVideos.isSelected())
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

                }
                else if(s.equals("download")){
                    String path=st.nextToken();
                    innerClientDOS.writeBytes("download\r\n");
                    innerClientDOS.writeBytes(path+"\r\n");
                    File f=new File(path);
                    FileOutputStream fos=new FileOutputStream(f);
                    long size=innerClientDIS.readLong();
                    byte b[]=new byte[10000];
                    long count=0;
                    downloadpanel d=new downloadpanel();
                    d.jProgressBar1.setValue(0);
                    d.lbfile.setText(path);
                    d.lbuser.setText(username);
                    dl.add(d);
                    dm.fireTableDataChanged();
                    while(true){
                        int r=innerClientDIS.read(b,0,10000);
                        fos.write(b,0,r);
                        count=count+r;
                        d.jProgressBar1.setValue((int)((count*100)/size));
                        dm.fireTableDataChanged();
                        if(count>=size)break;
                    }
                    fos.close();
                    dl.remove(d);
                    dm.fireTableDataChanged();
                    JOptionPane.showMessageDialog(HomeGUI.this, "File Downloaded");
                }
            } catch (Exception e)
            {
            }
        }

    }
    InnerClient innerClient;

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

    ArrayList<Friend> friendList;
    TableModel tableModel;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btAccept = new javax.swing.JButton();
        btReject = new javax.swing.JButton();
        btAccept1 = new javax.swing.JButton();
        btAccept2 = new javax.swing.JButton();
        btFetch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tfSearchFile = new javax.swing.JTextField();
        btSearchFile = new javax.swing.JButton();
        rbPdf = new javax.swing.JRadioButton();
        rbImages = new javax.swing.JRadioButton();
        rbVideos = new javax.swing.JRadioButton();
        rbSoftwares = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btDownload = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        downloadtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setText("Search for User");

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(tableModel);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        btAccept.setText("Accept");
        btAccept.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAcceptActionPerformed(evt);
            }
        });

        btReject.setText("Reject");
        btReject.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRejectActionPerformed(evt);
            }
        });

        btAccept1.setText("Add Friend");
        btAccept1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAccept1ActionPerformed(evt);
            }
        });

        btAccept2.setText("Pending Request");
        btAccept2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAccept2ActionPerformed(evt);
            }
        });

        btFetch.setText("Fetch List");
        btFetch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btFetchActionPerformed(evt);
            }
        });

        jTable2.setModel(tableModelFriend);
        jScrollPane2.setViewportView(jTable2);

        btSearchFile.setText("Search");
        btSearchFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSearchFileActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbPdf);
        rbPdf.setSelected(true);
        rbPdf.setText("PDF");

        buttonGroup1.add(rbImages);
        rbImages.setText("Images");

        buttonGroup1.add(rbVideos);
        rbVideos.setText("Videos");

        buttonGroup1.add(rbSoftwares);
        rbSoftwares.setText("Software");

        jTable3.setModel(searchTableModel);
        jScrollPane3.setViewportView(jTable3);

        btDownload.setText("Download");
        btDownload.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btDownloadActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btReject, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(tfSearch)
                                            .addGap(18, 18, 18)
                                            .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btFetch, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAccept1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAccept2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfSearchFile, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSearchFile))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbPdf)
                                .addGap(18, 18, 18)
                                .addComponent(rbImages)
                                .addGap(18, 18, 18)
                                .addComponent(rbVideos)
                                .addGap(18, 18, 18)
                                .addComponent(rbSoftwares))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDownload)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSearchFile)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(tfSearch)
                        .addComponent(btSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btFetch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(btSearchFile, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btReject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAccept1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAccept2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbPdf)
                                    .addComponent(rbImages)
                                    .addComponent(rbVideos)
                                    .addComponent(rbSoftwares))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDownload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(265, 265, 265))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1029, 614));
        setLocationRelativeTo(null);
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

    ArrayList<MyFriend> myFriendList;
    TableModelFriend tableModelFriend;

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

    private void btAccept1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAccept1ActionPerformed
    {//GEN-HEADEREND:event_btAccept1ActionPerformed
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
    }//GEN-LAST:event_btAccept1ActionPerformed

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
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btRejectActionPerformed

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
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btAcceptActionPerformed

    private void btAccept2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAccept2ActionPerformed
    {//GEN-HEADEREND:event_btAccept2ActionPerformed
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
    }//GEN-LAST:event_btAccept2ActionPerformed

    private void btFetchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btFetchActionPerformed
    {//GEN-HEADEREND:event_btFetchActionPerformed
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
    }//GEN-LAST:event_btFetchActionPerformed

    private void btSearchFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSearchFileActionPerformed
    {//GEN-HEADEREND:event_btSearchFileActionPerformed
        SearchJob searchJob = new SearchJob();
    }//GEN-LAST:event_btSearchFileActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btDownloadActionPerformed
    {//GEN-HEADEREND:event_btDownloadActionPerformed
       int index=jTable3.getSelectedRow();
       String ip=sl.get(index).ip;
       String path=sl.get(index).path;
       String username=sl.get(index).username;
        InnerClient icl =new InnerClient("download#"+path, ip, username);
        Thread t=new Thread(icl);
        t.start();
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
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new HomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccept;
    private javax.swing.JButton btAccept1;
    private javax.swing.JButton btAccept2;
    private javax.swing.JButton btDownload;
    private javax.swing.JButton btFetch;
    private javax.swing.JButton btReject;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable downloadtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JRadioButton rbImages;
    private javax.swing.JRadioButton rbPdf;
    private javax.swing.JRadioButton rbSoftwares;
    private javax.swing.JRadioButton rbVideos;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSearchFile;
    // End of variables declaration//GEN-END:variables
class downloadmodel extends AbstractTableModel
{
        String name[]={"Download"};
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
