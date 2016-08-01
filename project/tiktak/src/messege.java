import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class message extends  JFrame  implements ActionListener 
{
	JButton k,quit;
	JLabel l, l1,l2,l3,l4,l5,l6,l7;
	 String w1,w2;
	int  roundcheck,xflag,oflag,drawmatch ;
	int  g=0;
	message(String s,String aa,String bb,int cc,int dd,int ee, int draw, int  drawindecate)
	{
		
		super("messages");
	
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       roundcheck=cc;
       w1=aa;
       w2=bb;
       xflag=dd;
       oflag=ee;
       drawmatch=draw;
       if (drawindecate==0)
       {
    	   if(s=="X")
           {
        	   s="NO ONE " ;
        	
        
        	   
           }
           if(s=="O")
           {
        	   s="NO ONE";
           } 
        	 
    	   
       }
       else
       {
       if(s=="X")
       {
    	   s=aa;
    	
    	 xflag++;
    	   
       }
       if(s=="O")
       {
    	   s=bb;
    	 
    	  oflag++;
       }}
       
		setLayout(null);
		 l=new JLabel();
		add(l);
		l.setText(s+" IS WIN IN THIS ROUND  ");
    	l2=new JLabel(w1+"  Toatal score ="+ xflag);
		add(l2);
		l3=new JLabel(w2+" Total  Score="+ oflag);
		add(l3);
		
		l7=new JLabel("draw games="+draw );
		add(l7);
		l6=new JLabel("only wise is win the match ");
		add(l6);
		k=new JButton("replay");
		quit=new JButton("QUITE");
		//k.setBounds(150, 250, 50, 20);
		add(k);
		k.addActionListener(this);	
		l.setBounds(20, 20, 200, 20);
		l2.setBounds(20, 40, 200, 20);
		l3.setBounds(20, 60, 200, 20);
		l6.setBounds(20, 100, 200, 20);
		l7.setBounds(20,80, 200, 20);
		k.setBounds(30, 150, 150, 20);
		quit.setBounds(30, 170, 150, 20);
		add(quit);
		quit.addActionListener(this);
		//l9.setBounds(20, 180, 200, 20);
		this.setResizable(false);
		
	}
	
	@Override
	public  void actionPerformed(ActionEvent q)
	{
		
		if(q.getSource()==quit)
		{
			//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(false);
			
		}
		if(q.getSource()==k)
		{
			if (roundcheck>1)
			{
				tiktak q1=new tiktak();
				roundcheck--;
				q1.z(w1, w2,roundcheck,xflag,oflag,drawmatch);
				this.setVisible(false);
			}
			else if(xflag==oflag)
				{
					k.setLabel("play again");
					l6.setText("match is draw");

					if(g==1)
					{
						// JOptionPane.showMessageDialog(this,"NAME FIELDS SHOULD NOT BE LEFT BL equl");
						start e=new start();
						e.setBounds(500,250, 300, 300);
						e.setVisible(true);
						this.setVisible(false);
					}
					g=1;
				}
				else if(xflag>oflag)
				     {
					k.setLabel("play again");
					l6.setText("winner of game is "+w1);
					if(g==1)
					{
						 //JOptionPane.showMessageDialog(this,"NAME FIELDS SHOULD NOT BE  L greatre");
						start e=new start();
						e.setBounds(500, 250, 300, 300);
						e.setVisible(true);
						this.setVisible(false);
					}
					g=1;
					
					
				 }
				else
				   {
					k.setLabel("play again ");
					l6.setText(" winner of game is "+w2);
					
					if(g==1)
					{//JOptionPane.showMessageDialog(this,"NAME FIELDS SHOULD NOT BE LEFT BLANK!!");
						start e=new start();
						e.setBounds(500, 250, 300,300);
						e.setVisible(true);
						this.setVisible(false);
						
					}
					g=1;
				   }
					
					
				   }
				}
	          
}