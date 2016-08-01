package project;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuFr extends JFrame implements ActionListener {
	JComboBox combo;
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuFr(){
	setLayout(new FlowLayout());	
    setTitle("Brain Bite Home");
   setBounds(0,0,3000,3000);
    setVisible(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
      JMenuBar menuBar=new JMenuBar();
	 setJMenuBar(menuBar);
	 JMenu menuHome=new JMenu("Home");
	JMenu menuSetting=new JMenu("Setting");
	 JMenu menuAbout=new JMenu("About Us");
	 
	 menuBar.add(menuHome);
	 menuBar.add(menuSetting);
	 menuBar.add(menuAbout);
	 JMenuItem itemAdmin=new JMenuItem("Update");
	// JMenu menuUser=new JMenu("User");
	 menuSetting.add(itemAdmin);
	
	 
	 
	 
	 
	/* JMenuItem itemGeneral=new JMenuItem("General");
	 JMenuItem itemView=new JMenuItem("View");
	 JMenuItem itemReport=new JMenuItem("Report");
	 
	 menuUser.add(itemGeneral);
	 menuUser.add(itemView);
	 menuUser.add(itemReport);
	 menuSetting.add(menuUser);*/
	 
	 JLabel category=new JLabel("Category");
	 String[] education={"GK","Sports","Technical"};
		 combo=new JComboBox(education);
	     add(category);
	     add(combo);
	 combo.addActionListener(this);
	 menuAbout.addActionListener(this);
	 
     }
	
	public void actionPerformed(ActionEvent a) {
		String str=a.getActionCommand();
		System.out.println(combo.getSelectedItem());
		 if(combo.getSelectedItem().equals("GK")){
			QuestionFrameGK gk=new QuestionFrameGK();
		 }
		 else if(combo.getSelectedItem().equals("Sports")){
			 QuestionFrameSports sp=new QuestionFrameSports();
		 }
		 else if(combo.getSelectedItem().equals("Technical")){
			 QuestionFrameTechnical tech=new QuestionFrameTechnical();
		 }
		 if(str.equals("About Us"))
		 {
			 new AboutUs();
		 }
	/*public static void main(String[] args) {
		
          MenuFrame mf=new MenuFrame();
	}*/

}
}