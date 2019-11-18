package erpcache;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Dashboard extends JFrame {

	 int r , c = 0;
	 JButton b1 , b2;
	 static DefaultTableModel model;
	 static JTable j;
	 JTextField tf1 ,tf2;
     String qty , pl;
     Object[][] tableData;
     static int nRow;
	 static int nCol;
	 
	
	Dashboard(){
		
		setLayout(null);

		this.setLocationRelativeTo(null);
     	this.setTitle("Dashboard");
     	this.setBackground(Color.WHITE);
     	this.getContentPane().setBackground(Color.WHITE);
     	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
     	
     	 JPanel panel=new JPanel(); 

         panel.setBounds(0 , 0 , 150 , 710);
         panel.setBackground(Color.WHITE);
         panel.setLayout(null);
         
         JLabel l1=new JLabel("Quantity Left :");
	     l1.setBounds(300, 650, 100, 50);
         JLabel l2=new JLabel("Profit / Loss :");
	     l2.setBounds(40, 650, 100, 50);
	     tf1=new JTextField(); 
	     tf1.setBounds(400, 650, 100, 50);
	     tf1.setEditable(false);
	     tf2=new JTextField(); 
	     tf2.setBounds(140, 650, 100, 50);
	     tf2.setEditable(false);
	     this.add(l1);
	     this.add(l2); 
	     this.add(tf1);
	     this.add(tf2);

         
          b1 = new JButton("EDIT");
          b2 = new JButton("ADD");
          JButton b3 = new JButton("REMOVE");
          JButton b4= new JButton("SAVE");
         
//         JButton b5 = new JButton("DATA");
//         JButton b6 = new JButton("COMPANIES");
//         JButton b7 = new JButton("STATS");
//         JButton b8= new JButton("PRICES");
//         JButton b9 = new JButton("STOCKS");
 

    
        b1.setBounds(700, 650, 100, 50); 
        b1.setBackground(Color.WHITE);
  		b1.setBorderPainted(true);
        b2.setBounds(850, 650, 100, 50); 
        b2.setBackground(Color.WHITE);
  		b2.setBorderPainted(true);
  	    b3.setBounds(1000, 650, 100, 50); 
        b3.setBackground(Color.WHITE);
		b3.setBorderPainted(true);
  	    b4.setBounds(1150, 650, 100, 50); 
        b4.setBackground(Color.WHITE);
		b4.setBorderPainted(true);
//      b5.setBounds(20, 70, 100, 50); 
//	    b5.setBackground(Color.WHITE);
//	    b5.setBorderPainted(true);
//	    b6.setBounds(20, 170, 100, 50); 
//	    b6.setBackground(Color.WHITE);
//	    b6.setBorderPainted(true);
//	    b7.setBounds(20, 270, 100, 50); 
//	    b7.setBackground(Color.WHITE);
//	    b7.setBorderPainted(true);
//	    b8.setBounds(20, 370, 100, 50); 
//	    b8.setBackground(Color.WHITE);
//	    b8.setBorderPainted(true);
//	    b9.setBounds(20, 470, 100, 50); 
//	    b9.setBackground(Color.WHITE);
//	    b9.setBorderPainted(true);

       	
         String[][] data = { 
                 { "", "", "" , "" , "" , "" , "" } 
                           }; 
	
         String[] columnNames = { "Purchase / Sell", "ITEM" ,"Ageing" , "PURCHASE-Date", "Vendor",  "Receipt" ,  "Issue"  , "SINO's" ,  "Value"};
         model = new DefaultTableModel(data, columnNames);
         j = new JTable(model);
         j.setRowHeight(100);
         j.setEnabled(false);

         
         TableColumnModel columnModel = j.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(200);
         columnModel.getColumn(1).setPreferredWidth(200);
         columnModel.getColumn(2).setPreferredWidth(200);
         columnModel.getColumn(3).setPreferredWidth(200);
         columnModel.getColumn(4).setPreferredWidth(200);
         columnModel.getColumn(5).setPreferredWidth(200);
         columnModel.getColumn(6).setPreferredWidth(200);
         columnModel.getColumn(7).setPreferredWidth(200);
         columnModel.getColumn(8).setPreferredWidth(200);
         


         j.setBounds(200, 90 , 1150 , 550);
         JScrollPane sp = new JScrollPane(j);
         sp.setBounds(200, 90, 1150, 550); 
   
         
         this.add(sp);
//         panel.add(b5);
//         panel.add(b6);
//         panel.add(b7);
//         panel.add(b8);
//         panel.add(b9);

         this.add(panel); 
         this.add(b1); 
         this.add(b2); 
         this.add(b3); 
         this.add(b4); 
      

//         TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) j.getModel());
//         j.setRowSorter(sorter);
//
//         ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(7);
//         sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
//         sortKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
//
//         sorter.setSortKeys(sortKeys);
        
         
        nRow = model.getRowCount();
 		nCol = model.getColumnCount();
 	      try {
				readInfo(Choices.value);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "No Data Found");
			}
 		
         
         this.addMouseListener(new MouseAdapter() {
        	    public void mouseClicked(MouseEvent e){
   		        
        	    	//make a function here for cell editing rather than adding it as a button. Also add a boolean for editing to be enabled or false to cover the case of b1 button as well. 
   		         j.setEnabled(false);
   		         

        	    	
        	    }
        	});
         
         
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				// Editing the table 
				
				   j.setEnabled(true);
     	 
			}
		});
        
        b2.addActionListener(new ActionListener() {
			
     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				// TODO Auto-generated method stub
     				
     				
    				// Adding the table 

     				r = model.getRowCount() - 1;
     			    				
     				if(j.getModel().getValueAt(r , c) == ""  ||  j.getModel().getValueAt(r , c + 1) == "" || j.getModel().getValueAt(r , c + 2) == "" || j.getModel().getValueAt(r , c + 3) == "" || j.getModel().getValueAt(r, c + 4) == "" || (j.getModel().getValueAt(r, c + 5) == "" & j.getModel().getValueAt(r, c + 6) == ""  ) ||  j.getModel().getValueAt(r, c + 7) == ""){
     					
     					JOptionPane.showMessageDialog(null, "Please fill previous details");            
     				}
     				
     			    else if(j.getModel().getValueAt(r, c) == null  ||  j.getModel().getValueAt(r, c + 1) == null || j.getModel().getValueAt(r, c + 2) == null || j.getModel().getValueAt(r, c + 3) == null || j.getModel().getValueAt(r, c + 4) == null || (j.getModel().getValueAt(r, c + 5) == null & j.getModel().getValueAt(r, c + 6) == null) ||  j.getModel().getValueAt(r, c + 7) == ""){
     					
     					JOptionPane.showMessageDialog(null, "Please fill previous details");
     					
     				}
     				
     				else{
     			        update();
     					r++;
     					System.out.println(r);
     					
     			    model = (DefaultTableModel) j.getModel();
     				model.addRow(new Object[]{});
     				
     				}
     				  				
     				
     			}
     		});
        
        
        
        b3.addActionListener(new ActionListener() {
			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 				
 				
				// Removing the table 
                 
 			    model = (DefaultTableModel) j.getModel();
                model.removeRow(j.getSelectedRow());             // disable cell editing before removing the row... 
                r = 0;
                nRow = model.getRowCount();
                if(r == nRow - 1){
                model.setValueAt(null , j.getEditingRow() -1  , j.getEditingColumn() - 1);
                }
                for(int i = 0 ; i < nRow -1 ; i++){
                	
                	update();
                	r++;
                	
                } 
 			 				
 			}
 		});
    
        
        
        b4.addActionListener(new ActionListener() {
			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 				
 				
				// Saving the table 
                
// 			    nRow = model.getRowCount();                                   //// saving the data by collecting data from the JTable fields and 
// 			    nCol = model.getColumnCount();                                //// saving them in a text file (normal text file, and not a CSV one.) .  
// 			   tableData = new Object[nRow][nCol];
// 			    for (int i = 0 ; i < nRow ; i++)
// 			        for (int j = 0 ; j < nCol ; j++)
// 			            tableData[i][j] = model.getValueAt(i,j);
// 			    
//// 			    for (int i = 0 ; i < nRow ; i++)
//// 			        for (int j = 0 ; j < nCol ; j++)
//// 		                 System.out.println(tableData[i][j]);  
// 			    
// 			   try {
//				updateInfo();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
 				
 				
 				
 				
 				
// 				
// 				erpcache.TableToExcel tte = new erpcache.TableToExcel(j, null, "My Table");
// 				//optional -> tte.setCustomTitles(colTitles);
// 				try {
//					tte.generate(new File("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache"));    //// saving the data by trying out Apache POI. 
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
// 				
 				
 				
 		       nRow = model.getRowCount();
 		       nCol = model.getColumnCount();
 				 				
 				
 				try {
					FileWriter csvWriter = new FileWriter(new File("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache\\Data\\" + Choices.value + ".csv"));
	//				FileWriter csvWriter = new FileWriter(new File("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache\\newtabledata.txt"));

					
					
					csvWriter.write("Purchase / Sell");
					csvWriter.write(",");
					csvWriter.write("ITEM");
					csvWriter.write(",");
					csvWriter.write("Ageing");
					csvWriter.write(",");
					csvWriter.write("PURCHASE-Date");
					csvWriter.write(",");
					csvWriter.write("Vendor");
					csvWriter.write(",");
					csvWriter.write("Receipt");
					csvWriter.write(",");
					csvWriter.write("Issue");
					csvWriter.write(",");
					csvWriter.write("SINO's");
					csvWriter.write(",");
					csvWriter.write("Value");
					csvWriter.write(System.lineSeparator());

					
					
					for (int i = 0 ; i < nRow -1 ; i++){
	 					
	 					for (int z = 0 ; z < nCol ; z++){
	 						
	 						
	 						csvWriter.write(String.valueOf(j.getValueAt(i, z)) == "null"?"":String.valueOf(j.getValueAt(i, z)));
	                        if(z == nCol - 1)
	                        	break;
	 						csvWriter.write(",");

	 						
	 					}
	 					if(i == nRow-2)
	 						break;
	 						
 						csvWriter.write(System.lineSeparator());
	 					
	 				}
					
					csvWriter.flush();
					csvWriter.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block                                //// saving the data by collecting data from the JTable fields and        
					e.printStackTrace();                                              //// saving them in a text file (a CSV one file.).
			}                                                                         //// need  cell editing to be disabled for proper saving of data......  

 							
 				
 			}
 		});
        
//        b5.addActionListener(new ActionListener() {
//			
//     			@Override
//     			public void actionPerformed(ActionEvent arg0) {
//     				// TODO Auto-generated method stub
//     				
//     				
//    				// Dashboarding the table 
//
//     				sp.setVisible(true);
//     				b1.setVisible(true);
//     				b2.setVisible(true);
//     				b3.setVisible(true);
//     				b4.setVisible(true);
//     				
//     			}
//     		});
//        
//        b6.addActionListener(new ActionListener() {
//			
//     			@Override
//     			public void actionPerformed(ActionEvent arg0) {
//     				// TODO Auto-generated method stub
//     				
//     				
//    				// Dashboarding the table 
//
//     				sp.setVisible(false);
//     				b1.setVisible(false);
//     				b2.setVisible(false);
//     				b3.setVisible(false);
//     				b4.setVisible(false);
//
//     				/*
//     				 Squares squares = new Squares();
//     			      getContentPane().add(squares);
//     			      for (int i = 0; i < 15; i++) {
//     			         squares.addSquare(i * 10, i * 10, 100, 100);
//     			      }
//     				*/
//     				
//     			}
//     		});
//        
//        b7.addActionListener(new ActionListener() {
//			
//     			@Override
//     			public void actionPerformed(ActionEvent arg0) {
//     				// TODO Auto-generated method stub
//     				
//     				
//    				// Dashboarding the table 
//
//     				
//     				
//     			}
//     		});
//        
//        b8.addActionListener(new ActionListener() {
//			
//     			@Override
//     			public void actionPerformed(ActionEvent arg0) {
//     				// TODO Auto-generated method stub
//     				
//     				
//    				// Dashboarding the table 
//
//     				
//     				
//     			}
//     		});
//        
//        b9.addActionListener(new ActionListener() {
//			
//     			@Override
//     			public void actionPerformed(ActionEvent arg0) {
//     				// TODO Auto-generated method stub
//     				
//     				
//    				// Dashboarding the table 
//	
//     				
//     			}
//     		});
     
         
        
              
	} 	

	public void update() {
		// TODO Auto-generated method stub
		
		int price;
		if(r == 0){
		
			if( String.valueOf(j.getModel().getValueAt(r, c + 5)).equals("")  |  String.valueOf(j.getModel().getValueAt(r, c + 5)).equals("null"))
			{
				
				
				price = - (Integer.parseInt(j.getModel().getValueAt(r, c).toString()) * Integer.parseInt(j.getModel().getValueAt(r, c + 6).toString()));
				j.getModel().setValueAt(price, r, c + 8);
				qty = "-" + j.getModel().getValueAt(r, c + 6).toString();
				tf1.setText(qty);
				pl = Integer.toString(price);
	     		tf2.setText(pl);	
				
		
			}
			
			else{
				
				price = Integer.parseInt(j.getModel().getValueAt(r, c).toString()) * Integer.parseInt(j.getModel().getValueAt(r, c + 5).toString());
				j.getModel().setValueAt(price, r, c + 8);
				qty = j.getModel().getValueAt(r, c + 5).toString();
				tf1.setText(qty);
				pl = Integer.toString(price);
	     		tf2.setText(pl);		
				
			}
			
		}
		
		else{
			
			if( String.valueOf(j.getModel().getValueAt(r, c + 5)).equals("")  |  String.valueOf(j.getModel().getValueAt(r, c + 5)).equals("null")){
				

				
				price = - (Integer.parseInt(j.getModel().getValueAt(r, c).toString()) * Integer.parseInt(j.getModel().getValueAt(r, c + 6).toString()));
				j.getModel().setValueAt(price, r, c + 8);
				qty = Integer.toString(-(Integer.parseInt(j.getModel().getValueAt(r, c + 6).toString())) + Integer.parseInt(qty));
				tf1.setText(qty);
				pl = Integer.toString(Integer.parseInt(j.getModel().getValueAt(r, c + 8).toString()) + Integer.parseInt(pl)); 
				tf2.setText(pl);
				
					
			}
			
			
			else{
				
				
				price = Integer.parseInt(j.getModel().getValueAt(r, c).toString()) * Integer.parseInt(j.getModel().getValueAt(r, c + 5).toString());
				j.getModel().setValueAt(price, r, c + 8);
				qty = Integer.toString(Integer.parseInt(j.getModel().getValueAt(r, c + 5).toString()) + Integer.parseInt(qty));
				tf1.setText(qty);
				pl = Integer.toString(Integer.parseInt(j.getModel().getValueAt(r, c + 8).toString()) + Integer.parseInt(pl)); 
				tf2.setText(pl);
				
				
			}
			
		}
		
	}
	
	
	
//	void updateInfo() throws IOException{
//		
//		FileWriter file2 = new FileWriter("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache\\TableData.txt" );
//		String lineSeparator = System.lineSeparator();
//		StringBuilder sb = new StringBuilder();
//		for (Object[] row : tableData) {
//		    sb.append(Arrays.toString(row))
//		      .append(lineSeparator);
//		}
//
//		String result = sb.toString();
//
//		file2.write(result);
//		file2.close();
//		
//	}
	
	
	
	 void readInfo(String name) throws IOException{
		
		 r = 0;
		FileReader file = new FileReader("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache\\Data\\" + name + ".csv"); 
		// FileReader file = new FileReader("C:\\Users\\YAJUR\\workspace\\ERPcache\\src\\erpcache\\newtabledata.txt"); 
		BufferedReader buf = new BufferedReader(file);
		String line;
		String[] ar = new String[nCol];
		int r1 = 0;	
		
				while((line = buf.readLine()) != null){
				   // System.out.println(line);

               //    line = line.substring(1 , line.length()-1);
            	  	String[] values = line.split(",");
                  
            		        for(int i = 0 ; i < nCol ; i++){ 
            		                if(r1 == 0)
            		                	break;
                                   ar[i] = values[i].trim(); 
                                   j.getModel().setValueAt(ar[i], r1 -1  , i);
                                   
            		        }
            		        if(r1 == 0){
            		        	r1++;
            		        	continue;
            		        }
            				update();
            				r++;
             			   model.addRow(new Object[]{});
                           r1++;
                           
		}
				
				//model.removeRow(j.getRowCount() - 1);
		
		buf.close();
		
	}
	 

	 
	public static void main(String args) {
		// TODO Auto-generated method stub
		
		Dashboard dash = new Dashboard();
		dash.setVisible(true); 

	}
	
}


//Purchase ITEM Date Vendor qty VendorPO Value