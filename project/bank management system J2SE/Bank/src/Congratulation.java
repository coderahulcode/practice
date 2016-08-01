import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Congratulation extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1;
    Point p;
    Font f1,f2;
    Congratulation(String s,String s1)
    {
         super("Staff Joining");
        setVisible(true);
        setLayout(null);
        setSize(300,200);
        this.setResizable(false);
        p=new Point(300,100);
        this.setLocation(p);
        l1=new JLabel("CONGRATULATION !!!");
        l2=new JLabel("Name");
        l3=new JLabel("Employment Id");
        l4=new JLabel(s);
        l5=new JLabel(s1);
        b1=new JButton("OK");
        f1=new Font("Times New Roman",Font.BOLD,20);
        f2=new Font("Times New Roman",Font.PLAIN,16);
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        b1.setFont(f2);
        l1.setBounds(10,10,250,40);
        l2.setBounds(20,50,125,30 );
        l3.setBounds(20,90,125,30 );
        l4.setBounds(155,50,125,30 );
        l5.setBounds(155,90,125,30 );
        b1.setBounds(80,130, 80,40);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(b1);
         b1.addActionListener(this);
        try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");}
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
    Congratulation(String s,String s1,String s2)
    {
         super("Customer Personal Data");
        setVisible(true);
        setLayout(null);
        setSize(300,250);
        this.setResizable(false);
        p=new Point(300,100);
        this.setLocation(p);
        l1=new JLabel("CONGRATULATION !!!");
        l2=new JLabel("Name");
        l3=new JLabel("Account Number");
        l6=new JLabel("Security Code");
        l7=new JLabel(s2);
        l4=new JLabel(s);
        l5=new JLabel(s1);
        b1=new JButton("OK");
        f1=new Font("Times New Roman",Font.BOLD,20);
        f2=new Font("Times New Roman",Font.PLAIN,16);
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        b1.setFont(f2);
        l1.setBounds(10,10,250,40);
        l2.setBounds(20,50,125,30 );
        l3.setBounds(20,90,125,30 );
        l4.setBounds(155,50,125,30 );
        l5.setBounds(155,90,125,30 );
        b1.setBounds(80,170, 80,40);
        l6.setBounds(20,130,125,30);
        l7.setBounds(155,130,125,30);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(b1);
        add(l6);
        add(l7);
         b1.addActionListener(this);
        try
        { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
        System.out.println("rahul");}
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.dispose();
    }
}