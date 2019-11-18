package erpcache;               

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreen extends JFrame {
  
	JButton b1 , b2;
 	static String value;
	
	StartScreen(){
		
		
		this.setLayout(null);
      	this.setTitle("Cache ERP");
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
     	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
     	
     	 JPanel panel = new JPanel();
     	 panel.setBounds(0, 0, 1400 ,700);
     	 panel.setLayout(null);
         panel.setBackground(Color.WHITE);
	  	 this.add(panel); 
	     pack();
   	

         String[] choices = { "SERVERS" , "DESKTOPS" , "LAPTOPS" , "NETWORKING" , "SECURITY" , "SOFTWARE" , "SERVICES" , "MISCELLANEOUS" };   //array of all choices

         final JComboBox<String> cb = new JComboBox<String>(choices);
         cb.setBounds(200, 300, 900, 50);
         cb.setBackground(Color.WHITE);
         cb.setEditable(true);
     
         panel.add(cb);

         
 		JButton b1 = new JButton("Search");
        b1.setBounds(700, 400, 98, 27);
 		b1.setBackground(Color.WHITE);
		b1.setBorderPainted(true);
		
		panel.add(b1);
		
		JButton b2 = new JButton("Add new");
        b2.setBounds(400, 400, 98, 27);
 		b2.setBackground(Color.WHITE);
		b2.setBorderPainted(true);
		
		panel.add(b2);
		
		
//		switch(value){
//
//		
//		    default:
//		    	
//		        try {
//					Dashboard.readInfo();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		    			    	
//		}
//		
		
    
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				 value = cb.getSelectedItem().toString();
				 //Dashboard.main("start");
				 Choices.main(value);
				 setVisible(false);
				 
				 
				// System.out.println(value);
// search for value in a list of all items  
				
								
			}
		});
		
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// create arraylist objects in choices rather than string arrays.
				
				
			}
		});
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StartScreen start = new StartScreen();		
		start.setVisible(true);
	}
}