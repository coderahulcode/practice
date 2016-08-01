import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class SplashScreenDemo extends javax.swing.JFrame {

    public SplashScreenDemo() {
        try {
            initComponents();
            BufferedImage orgimage = ImageIO.read(getClass().getResource("spG.jpg"));
            BufferedImage resizedImage = resize(orgimage,400,300);
            jLabel1.setIcon(new ImageIcon(resizedImage));
            setSize(400,300);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
            UIManager.put(jProgressBar1, Color.red);
            UIManager.put(jProgressBar1, Color.blue);
            UIManager.put(jProgressBar1, Color.red);
            UIManager.put(jProgressBar1, Color.green);
            jProgressBar1.setForeground(new java.awt.Color(51,153,0));
            new Thread(new progress()).start();
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class progress implements Runnable
    {

     
        public void run() 
        {
            for (int i = 1; i <=100; i++) 
            {
                if(i<30)
                {
                    jLabel2.setText("Initializing..............");
                jProgressBar1.setValue(i);
                }
                else if(i<60)
                {
                    jLabel2.setText("Loading................");
                jProgressBar1.setValue(i);
                }
                else if(i<90)
                {
                    jLabel2.setText("Processing..............");
                jProgressBar1.setValue(i);
                }
                else
                {
                    jLabel2.setText("Launching..............");
                jProgressBar1.setValue(i);
                }
                try {
                    Thread.sleep(70);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreenDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             ClientHome obj=new ClientHome();
            dispose();
          
        }
        
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(255, 51, 51));
        jProgressBar1.setBorderPainted(false);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(0, 286, 400, 10);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 260, 110, 20);

      
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreenDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration                   
}
