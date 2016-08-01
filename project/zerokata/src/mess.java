import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class mess extends  Frame  implements ActionListener 
{
	Button k;
	Label l1,l2,l3,l4,l5,l6,l7;
	Font f;
	 String w1,w2;
	int  roundcheck,xflag,oflag ;
	
	
	mess(String s,String aa,String bb,int cc,int dd,int ee)
	{
		
		super("messages");
		
		
       addWindowListener(new WindowAdapter()
		         {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
				
			}
		          }
	          );
       roundcheck=cc;
       w1=aa;
       w2=bb;
       xflag=dd;
       oflag=ee;
       if(s=="X")
       {
    	   s=aa;
    	
    	 xflag++;
    	   
       }
       if(s=="O")
       {
    	   s=bb;
    	 
    	  oflag++;
       }
       
		  setLayout(new FlowLayout());
		Label l=new Label();
		add(l);
		l.setText(s+"  is win in this round  ");
    	l2=new Label(w1+"  toatal score");
		add(l2);
		l4=new Label();
		l4.setText(""+xflag);
		add(l4);
		l3=new Label(w2+" total  Score ");
		add(l3);
		l5=new Label(""+oflag);
		add(l5);
		l7=new Label("     draw games=");
		add(l7);
		l6=new Label("only wise is win the match ");
		add(l6);
		k=new Button("replay");
		k.setBounds(150, 250, 50, 20);
		add(k);
		k.addActionListener(this);	
	}
	
	@Override
	public  void actionPerformed(ActionEvent q)
	{
		int  g=0;
		if(q.getSource()==k)
		{
			if (roundcheck>1)
			{
				zerokata q1=new zerokata();
				roundcheck--;
				q1.z(w1, w2,roundcheck,xflag,oflag);
				this.setVisible(false);
			}
			else
			{
				if(xflag>oflag)
				{
					k.setLabel("play again");
					l6.setText("the winner of the game is "+w1);
					
					if(g==1)
					{
						start e=new start();
						e.setBounds(300, 300, 280, 280);
						this.setVisible(false);
					}
					g=1;
					
				}
				else
				{
					k.setLabel("play again ");
					l6.setText("the winner of the game is "+w2);
					
					if(g==1)
					{
						start e=new start();
						e.setBounds(300, 300, 280, 280);
						this.setVisible(false);
					}
					g=1;
				}
			
			}
			
	
		
				
			
		}
		
	}
	
}