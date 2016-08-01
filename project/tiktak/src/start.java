import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public  class start extends JFrame implements ActionListener
{
	JButton bs;
	JLabel sl1,sl2,sl3,sl4;
	 public JTextField st1,st2;
	CheckboxGroup gd;
	Checkbox r1,r2,r3,r4;
	int xx=0,yy=0,xy=0,sr1;
	//JRadioButton r1,r2,r3,r4;
	//ButtonGroup bg;
	
	  
	start()
	{
		super("lets play game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception c)
        {
            c.printStackTrace();
        }
		
		
		setLayout(null);
		sl1=new JLabel("X player name = ");
		sl2=new JLabel("O player name = ");
		st1=new JTextField(15);
		st2=new JTextField(15);
		sl3=new JLabel("Round = ");
		bs=new JButton("start");
		sl4=new JLabel("hi");
		
		
		gd=new  CheckboxGroup();
		gd=new  CheckboxGroup();
		r1=new Checkbox("3",gd,true);
		r2=new Checkbox("5",gd,false);
		r3=new Checkbox("10",gd,false);
		r4=new Checkbox("20",gd,false);
		
		
		sl1.setBounds(20, 20, 100, 25);
		sl2.setBounds(20, 50, 100, 25);
		st1.setBounds(150, 20, 120, 25);
		st2.setBounds(150, 50, 120, 25);
		sl3.setBounds(20, 70, 100, 25);
		r1.setBounds(150, 80,200,20);
		r2.setBounds(150, 100, 200, 15);
	    r3.setBounds(150, 120, 200, 15);
		r4.setBounds(150, 140, 200, 15);
		bs.setBounds(100, 160, 100, 25);
		add(sl1);
		add(st1);
		add(sl2);
		add(st2);
		add(sl3);
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		add(bs);
		bs.addActionListener(this);
	/*	r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);*/
		this.setResizable(false);

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==bs)
		{
		String s1,s2;
		s1=st1.getText();
		s2=st2.getText();
		
		 if((st1.getText().isEmpty())||(st2.getText().isEmpty()))	
		{
			 JOptionPane.showMessageDialog(this,"PLEASE FILL YOUR NAME ");
		}
		else {if((s1.equals(s2)))
	   
		{
			JOptionPane.showMessageDialog(this," chose diffrent name");
		}
		else{
			int sr1=Integer.parseInt(gd.getSelectedCheckbox().getLabel());
			tiktak f=new tiktak();
			f.z(s1, s2,sr1,xx,yy,xy);
			this.setVisible(false);
			
			}}
	     }
	}}
  
