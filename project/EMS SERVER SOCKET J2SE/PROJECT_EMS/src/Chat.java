
public class Chat extends javax.swing.JFrame {

   String cname;
    public Chat(String cname) {
        initComponents();
        this.cname=cname;
        setSize(650,650);
        setTitle("CHAT BOX");
        chatlb1.setText("CHAT WITH "+this.cname);
        chatta1.setFocusable(false);
         
         setVisible(true);
    } 
        
       
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void chatbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatbt1ActionPerformed
        
        
        
    }//GEN-LAST:event_chatbt1ActionPerformed

    private void chattf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chattf1ActionPerformed
        
        
        
        
    }//GEN-LAST:event_chattf1ActionPerformed

    public static void main(String[] args) {
        Chat obj=new Chat("hello");
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton chatbt1;
    private javax.swing.JLabel chatlb1;
    private javax.swing.JTextArea chatta1;
    private javax.swing.JTextField chattf1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
