import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class start extends JFrame implements MouseMotionListener,ActionListener {
	JButton b[][];
	int ci=0,fl=0,fmotico=0;
	JButton check;
	String str,go;
	start()
	{
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
		this.setBounds(0, 0, 1000, 700);
		b=new JButton[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				b[i][j]=new JButton();
				b[i][j].addActionListener(this);
				if(ci==0)
				{
					b[i][j].setBackground(Color.gray);
					ci=1;
				}
				else {b[i][j].setBackground(Color.white);ci=0;}
					
				
				this.add(b[i][j]);
				
			}
			if(ci==0){ci=1;}
			else{ci=0;}
			
		}
		
		this.setLayout(new GridLayout(8,8));
		this.setVisible(true);
		this.setResizable(false);
		this.addMouseMotionListener(this);
		this.requestFocus();
		
	}
	public static  void main(String args[])
	{
		start s=new start();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		if(fmotico==0){
	for(int j=0;j<8;j++)
	{
		b[1][j].setText("@");
		b[6][j].setText("$");
	}
	b[0][0].setText("ELEPHANT");
	b[0][7].setText("ELEPHANT");
	b[7][0].setText("elephant");
	b[7][7].setText("elephant");
	b[0][1].setText("HORSE");
	b[0][6].setText("HORSE");
	b[7][1].setText("horse");
	b[7][6].setText("horse");
	b[0][2].setText("CAMEL");
	b[0][5].setText("CAMEL");
	b[7][2].setText("camel");
	b[7][5].setText("camel");
	b[0][3].setText("QUEEN");
	b[0][4].setText("KING");
	b[7][4].setText("king ");
	b[7][3].setText("queen");
	fmotico=1;
		}
	//b[0][0].setText("[]");
	//b[0][0].setText("[]");
	//b[0][0].setText("[]");
	//b[0][0].setText("[]");
	
	
	
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	    int ki = 0,kj=0;	
		//JOptionPane.showMessageDialog(this, str+"hi");
		if(fl==0)
		{
		for(int  i=0;i<8;i++)
		{
			for(int  j=0;j<8;j++)
			{
				if(e.getSource()==b[i][j])
				{
					b[i][j].setBackground(Color.magenta);
					str=b[i][j].getLabel();
					//b[i][j].setLabel(null);
					ki=i;
					kj=j;
					fl=1;
					break;
					//JOptionPane.showMessageDialog(this,b[i][j].getActionCommand());
				}
			}
		}
		}
		else
		{
			for(int k=0;k<8;k++)
			{
				for(int l=0;l<8;l++)
				{
					
					if(e.getSource()==b[k][l])
					{
						//JOptionPane.showMessageDialog(this, str+"hi");
						
						if(str=="$")
						{
							if(ki<k)
							{
							  if(b[k][l].getLabel()=="")
						        {  
								b[ki][kj].setLabel(null);
								b[k][l].setLabel(str);							
								} 
							  else
							    {
								b[ki][kj].setText(str);
								//JOptionPane.showMessageDialog(this, str+"hi");
							    }}
							  else  {b[k][l].setText(str);}
							  
							
						}
						if(str=="$")
						{
							if(b[k][l].getLabel()=="")
						        {  
								b[k][l].setLabel(str);
								}
						}
						if(str=="$")
						{
							if(b[k][l].getLabel()=="")
						        {  
								b[k][l].setLabel(str);
								}
						} 
						
						fl=0;
					}
				}
			}
		}
		
	}

}
