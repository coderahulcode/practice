import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public  class  tiktak extends JFrame implements ActionListener
{
	int h=0,g=1,mm,nn,oo,Draw, ggg=1;
	 JButton a[][];
	   String s="X";
	   String ll,kk;
	
    tiktak ()
    {
    	super ("RAJU 0-X");
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
    	
    	addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			System.exit(0);
    		}
    	});
    	setBounds(500,250,200,300);
    	this.setBackground(Color.BLUE);
		setVisible(true);
		setResizable(false);
    setLayout(new GridLayout(3,3));
       a=new JButton[3][3];
      
      for(int i=0;i<3;i++)
        { 
		for(int j=0;j<3;j++)
		   { 
	  (a[i][j])=new  JButton();
            add(a[i][j]);
            a[i][j].addActionListener(this);
            
        	}	
        }
        
    }
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		
		for(int  m=0;m<3;m++)
        {
     	 for(int n=0;n<3;n++)
     	 {
     		 if(e.getSource()==a[m][n])
     		 {
     			if (a[m][n].getLabel()=="")
     			{
     			 a[m][n].setLabel(s);
     			 if(s=="X")
     			 {s="O";}
     			 else
     			 {s="X";}
     		      h=h+1;
     		      
     		     }
     		 }
     	 }
        }
		//corner  coding  
		if(e.getSource()==a[0][0])
		{
			  if((a[0][0].getLabel()) == (a[0][1].getLabel()))
			  {
		         if((a[0][1].getLabel())==(a[0][02].getLabel()))
		         {
		        	 f(a[0][0].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[0][0].getLabel()) == (a[1][0].getLabel()))
			  {
		         if((a[1][0].getLabel())==(a[2][0].getLabel()))
		         {
		        	 f(a[0][0].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[0][0].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[0][0].getLabel());
		        	 g=0;
		         }
			  }
		}
		if(e.getSource()==a[2][0])
		{
			  if((a[2][0].getLabel()) == (a[1][0].getLabel()))
			  {
		         if((a[1][0].getLabel())==(a[0][0].getLabel()))
		         {
		        	 f(a[2][0].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[2][0].getLabel()) == (a[2][1].getLabel()))
			  {
		         if((a[2][1].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[2][0].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[2][0].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[0][2].getLabel()))
		         {
		        	 f(a[2][0].getLabel());
		        	 g=0;
		         }
			  }
		}
		// 3 coding 
		if(e.getSource()==a[2][2])
		{
			  if((a[2][2].getLabel()) == (a[2][1].getLabel()))
			  {
		         if((a[2][1].getLabel())==(a[2][0].getLabel()))
		         {
		        	 f(a[2][2].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[2][2].getLabel()) == (a[1][2].getLabel()))
			  {
		         if((a[1][2].getLabel())==(a[0][2].getLabel()))
		         {
		        	 f(a[2][2].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[2][2].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[0][0].getLabel()))
		         {
		        	 f(a[2][2].getLabel());
		        	 g=0;
		         }
			  }
		}
		// 4 coding of corner 
		if(e.getSource()==a[0][2])
		{
			  if((a[0][2].getLabel()) == (a[0][1].getLabel()))
			  {
		         if((a[0][1].getLabel())==(a[0][0].getLabel()))
		         {
		        	 f(a[0][2].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[0][2].getLabel()) == (a[1][2].getLabel()))
			  {
		         if((a[1][2].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[0][2].getLabel());
		        	 g=0;
		         }
			  }
			  if((a[0][2].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[2][0].getLabel()))
		         {
		        	 f(a[0][2].getLabel());
		        	 g=0;
		         }
			  }
		}
		/// start of coding plus 1
		if(e.getSource()==a[0][1])
		{
			 if((a[0][1].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[2][1].getLabel()))
		         {
		        	 f(a[0][1].getLabel());
		        	 g=0;
		         }
			  }
			 if((a[0][1].getLabel()) == (a[0][0].getLabel()))
			  {
		         if((a[0][0].getLabel())==(a[0][2].getLabel()))
		         {
		        	 f(a[0][1].getLabel());
		        	 g=0;
		         }
			  }
		}
		//  start of coding plus 2
		if(e.getSource()==a[1][0])
		{
			 if((a[1][0].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[1][2].getLabel()))
		         {
		        	 f(a[1][0].getLabel());
		        	 g=0;
		         }
			  }
			 if((a[1][0].getLabel()) == (a[0][0].getLabel()))
			  {
		         if((a[0][0].getLabel())==(a[2][0].getLabel()))
		         {
		        	 f(a[1][0].getLabel());
		        	 g=0;
		         }
			  }
		}
	 //	Star of coding  plus 3
		if(e.getSource()==a[2][1])
		{
			 if((a[2][1].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[0][1].getLabel()))
		         {
		        	 f(a[2][1].getLabel());
		        	 g=0;
		         }
			  }
			 if((a[2][1].getLabel()) == (a[2][0].getLabel()))
			  {
		         if((a[2][0].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[2][1].getLabel());
		        	 g=0;
		         }
			  }
		}
		// Start of coding plus 4
		if(e.getSource()==a[1][2])
		{
			 if((a[1][2].getLabel()) == (a[1][1].getLabel()))
			  {
		         if((a[1][1].getLabel())==(a[1][0].getLabel()))
		         {
		        	 f(a[1][2].getLabel());
		        	 g=0;
		         }
			  }
			 if((a[1][2].getLabel()) == (a[0][2].getLabel()))
			  {
		         if((a[0][2].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[1][2].getLabel());
		        	 g=0;
		         }
			  }
		}
		// Strat of coding of center 
		if(e.getSource()==a[1][1])
		{
			 if((a[1][1].getLabel()) == (a[0][1].getLabel()))
			  {
		         if((a[0][1].getLabel())==(a[2][1].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 if((a[1][1].getLabel()) == (a[1][0].getLabel()))
			  {
		         if((a[1][0].getLabel())==(a[1][2].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 if((a[1][1].getLabel()) == (a[2][1].getLabel()))
			  {
		         if((a[2][1].getLabel())==(a[0][1].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 if((a[1][1].getLabel()) == (a[1][2].getLabel()))
			  {
		         if((a[1][2].getLabel())==(a[1][0].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 if((a[1][1].getLabel()) == (a[0][0].getLabel()))
			  {
		         if((a[0][0].getLabel())==(a[2][2].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 if((a[1][1].getLabel()) == (a[2][0].getLabel()))
			  {
		         if((a[2][0].getLabel())==(a[0][2].getLabel()))
		         {
		        	 f(a[1][1].getLabel());
		        	 g=0;
		         }
		      }
			 
			
		}
		if(h==9&&g==1)
		{
			 Draw=Draw+1;
			  ggg=0;
			 
			message p=new message( s,ll,kk,mm,nn,oo,Draw,ggg);
			 p.setBounds(500, 250, 250, 300);
			 p.setVisible(true);
			 this.setVisible(false);
			
			
			 
		}
		
		
	}
 void 	f(String sc)
 
 {
	
	 message m=new message(sc,ll,kk,mm,nn,oo,Draw,ggg);
	 m.setBounds(500, 250, 250,300);
	 m.setVisible(true);
	// m.setResizable(false);
	 this.setVisible(false);
	
 }
	
	
	public static  void main(String args[])
	{
		start s= new start();
		s.setBounds(500,250, 300,300);
		s.setVisible(true);
		s.setBackground(Color.ORANGE);
		//s.setResizable(false);
	
	}
   void 	z(String a,String b,int c,int gg,int hh,int dd)
	{
	      ll=a;
	      kk=b;
		  mm=c;
		  nn=gg;
		  oo=hh;
		  Draw=dd;
	}}