
public class LiveStream extends javax.swing.JFrame {

     String cname;
    public LiveStream(String cname)
    {
        
        initComponents();
        this.cname=cname;
        setSize(1100,700);
        lb1.setText("Employee: "+cname);
        setTitle("Live Stream");
        setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents
public static void main(String[] args) {
        LiveStream obj=new LiveStream("hello");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel livelb;
    // End of variables declaration//GEN-END:variables
}
