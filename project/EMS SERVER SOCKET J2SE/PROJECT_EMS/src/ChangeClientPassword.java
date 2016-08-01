
public class ChangeClientPassword extends javax.swing.JFrame 
{

   
    public ChangeClientPassword() 
    {  
        initComponents();
         setSize(500,450);
         
         
         setVisible(true);
         setTitle("Change Client Password");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void pbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbt1ActionPerformed
       
    }//GEN-LAST:event_pbt1ActionPerformed

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeClientPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
