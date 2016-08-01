import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public  class start extends Frame implements ActionListener
{
	Button bs;
	Label sl1,sl2,sl3;
	 public TextField st1,st2;
	CheckboxGroup gd;
	Checkbox r1,r2,r3,r4;
	// int xplayer=0,oplayer=0;
	int xx=0,yy=0;
	
	  
	start()
	{
		
		super("lets play game");
		
		 setLayout(new FlowLayout());
		sl1=new Label("X player name = ");
		sl2=new Label("O player name = ");
		st1=new TextField(15);
		st2=new TextField(15);
		sl3=new Label("         Round = ");
		bs=new Button("start");
		gd=new  CheckboxGroup();
		r1=new Checkbox("3",gd,true);
		r2=new Checkbox("5",gd,true);
		r3=new Checkbox("10",gd,true);
		r4=new Checkbox("20",gd,true);
		add(sl1);
		add(st1);
		add(sl2);
		add(st2);
		add(sl3);
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		bs.setBounds(450, 450, 15, 5);
		add(bs);
		bs.addActionListener(this);
		
		
		
		 addWindowListener(new WindowAdapter()
         {
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		
	}
          }
      );
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bs)
		{
		String s1,s2;
		s1=st1.getText();
		s2=st2.getText();
		//if(s1==""||s2=="")
		{
			//start bb=new start();
			st1.setText("the name cant be blank");
			st2.setText("the name cant be blank");
			//this.setVisible(false);
		}
	//	else{
			int sr1=Integer.parseInt(gd.getSelectedCheckbox().getLabel());
			zerokata f=new zerokata();
			f.z(s1, s2,sr1,xx,yy);
			this.setVisible(false);
			}
		}
		
	}

