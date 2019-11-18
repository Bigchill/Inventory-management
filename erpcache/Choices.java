package erpcache;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Choices extends JFrame {
	
	JButton b1 , b2;
 	static String value;
 	String[] choices;
 	
 	HashMap<String, String[]> allchoices = new HashMap<String, String[]>()
 	{{
 		 		
 		
 		
 		 put("SERVERS", new String[]{ "SERVERS" , "SERVER RAM" , "MOTHERBOARD" , "PROCESSORS" , "HARD DISK" , "RAILKIT" } );
 		 put("DESKTOPS", new String[]{ "DESKTOPS" , "DESKTOP RAM" , "DESKTOP HARD DISK" , "DESKTOP CPUs" , "MOTHERBOARD" , "POWER SUPPLY"  } );   
 		 put("LAPTOPS", new String[]{ "LAPTOPS" , "LAPTOP RAM" , "LAPTOP HARD DISK" , "LAPTOP CPUs" , "MOTHERBOARD" , "POWER SUPPLY"  } );
 		 put("NETWORKING", new String[]{ "SWITCH" , "CABLE" , "HUB" , "ROUTER"  } );
 		 put("SECURITY", new String[]{  "CAMERA"  } );
 		 put("SOFTWARE", new String[]{  "STOCK REGISTER" , "ERP"  } );
 		 put("SERVICES", new String[]{   } );
 		 put("MISCELLANEOUS", new String[]{   } );
 		 put("SERVER RAM", new String[]{ "1GB DDR-1 06P4055" , "1GB HS 21 RAM 46C7421" } );    // server ram alltypes
 	     put("DESKTOP RAM", new String[]{ "2GB DDR3" } );
 		 put("LAPTOP RAM", new String[]{ "256MB 33L3069" } );
 		 put("DESKTOP HARD DISK", new String[]{ "40GB HDD" } );
 		 put("LAPTOP HARD DISK", new String[]{ "60GB HDD" , "80GB HDD" } );
 		

 		 
 	}};
 	
 	static int i = 1;
 	
 	static ArrayList<String> choice2 = new ArrayList<String>();
 		
			
 	
	Choices(String choice){
		
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
	     
     	
//         switch(choice){
//        
//         case "SERVERS":
//         choices = new String[]{ "SERVERS" , "MEMORY" , "MOTHERBOARD" , "PROCESSORS" , "HARD DISK" , "RAILKIT" };
//         break;
//         
//         case "DESKTOPS":
//         choices = new String[]{ "DESKTOPS" };
//         break;
//         
//         case "LAPTOPS":
//         choices = new String[]{ "LAPTOPS" };
//         break;	
//         
//         case "NETWORKING":
//         choices = new String[]{ "NETWORKING" };
//         break;	
//         
//         case "SECURITY":
//         choices = new String[]{ "SECURITY" };
//         break;	 
//         
//         case "SOFTWARE":
//         choices = new String[]{ "SOFTWARE" };
//         break;	 
//         
//         case "SERVICES":
//         choices = new String[]{ "SERVICES" };
//         break;
//         
//         case "MISCELLANEOUS":	
//         choices = new String[]{ "MISCELLANEOUS" };
//         break;
//         
//         default :
//
//        	 
//         }
	     
	     
	     choices = getValue(choice.toUpperCase());
	     
         
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
		
    
	
		 b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
								
				 value = cb.getSelectedItem().toString().toUpperCase();
				 if(allchoices.containsKey(value) & value != choice ){
					 

					    choice2.add(choice);
	    				Choices options = new Choices(value);
						options.setVisible(true);
						setVisible(false);
						System.out.println(choice2);

						 
					 
				 }
				 
				 else{
					 
                 Dashboard.main("start");
				 setVisible(false);
				 
				 }
											
			}		
		});
		 
		 
		 b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				// create arraylist objects in choices rather than string arrays.

				
				
			}
		});
		
		
	
		cb.getEditor().getEditorComponent().addKeyListener(new KeyListener() {
			
		    @Override
		    public void keyReleased(KeyEvent e) {

		    				
		    }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				if (e.isAltDown() ) {
					
					if(i == choice2.size() + 1){
						
						StartScreen start = new StartScreen();		
						start.setVisible(true);
						setVisible(false);
						
					}
						
					else{
						
					    System.out.println(choice2.get(choice2.size() - i));
					    Choices options = new Choices(choice2.get(choice2.size() - i));
					    options.setVisible(true);
					    setVisible(false);
					    i++;
			
					}
					
			}
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		    
		}); 
			
		
							
	}
	
	
	
	String[] getValue(String key){
		
		
		return allchoices.get(key);
		
	}
	
	
	

	public static void main(String args) {
		// TODO Auto-generated method stub

		Choices options = new Choices(args);
		options.setVisible(true);
		
	}

	
}
