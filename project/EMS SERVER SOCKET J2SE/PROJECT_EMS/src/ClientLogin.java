
import java.awt.Toolkit;
import org.jdesktop.swingx.prompt.PromptSupport;


public class ClientLogin extends javax.swing.JFrame {

    
    public ClientLogin() {
        initComponents();
        setSize(500,450);
         //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            
            // PlaceHolder
              PromptSupport.setPrompt("USERNAME",ctf1);
              PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ctf1);
              PromptSupport.setPrompt("PASSWORD",ctf2);
              PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, ctf2);
            //
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void cbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbt1ActionPerformed

   
    public static void main(String[] args) {
        ClientLogin obj=new ClientLogin();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JButton cbt1;
    private javax.swing.JLabel clb1;
    private javax.swing.JLabel clb2;
    private javax.swing.JLabel clb3;
    private javax.swing.JTextField ctf1;
    private javax.swing.JPasswordField ctf2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
