import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*; 


public class Sale extends JFrame implements ActionListener{
	public static void main(String[] args) {
		
		//create window named "Sales and Reporting
		JFrame window= new JFrame("Sales & Reporting");	
		window.setSize(500,400);                  //window size 
		window.setLocation(0,0);                  //window location
	
		//TextField
		JTextField tfield = new JTextField();     //create text field to get how many glasses
		tfield.setSize(100,20);  			      //tf size
		tfield.setLocation(50,210);			      //tf location
		window.add(tfield);					      //add tf to window

		//label
	
		JLabel lbl1= new JLabel("Select size:");                                        //create label 
		lbl1.setBounds(50, 20, 350, 40);												//label bounds	
		window.add(lbl1);																//add label to window 

		JLabel lbl2= new JLabel("Select which type of beverage you want to order:");
		lbl2.setBounds(50, 100, 350, 40);
		window.add(lbl2);
		
		JLabel lbl3= new JLabel("Select how many glasses you want to order:");
		lbl3.setBounds(50, 170, 350, 40);
		window.add(lbl3);
		
		JLabel lbl4 = new JLabel("");													//create label to write orders
		lbl4.setBounds(50, 280, 400, 40);
		window.add(lbl4);
		
		JLabel lbl5 = new JLabel("");													//create label to set&get money
		lbl5.setBounds(0, 0, 0, 0);
		window.add(lbl5);
	
		//combo box
		
		String[] items = { "Small", "Medium",  "Large"};								//array for combo box' items
		int [] sizePrice = {2,3,5};														//array for size price
		JComboBox cb = new JComboBox(items);											//combo box
		cb.setSize(120, 20);															//cb bounds
		cb.setLocation(50,65);
		window.add(cb);
		
		
		//radio button
		
		JRadioButton jrb1 = new JRadioButton("Juice");									//create radiobutton
		jrb1.setBounds(50, 145, 70, 20);												//rb bounds	
		window.add(jrb1);																//add window	
		
		JRadioButton jrb2 = new JRadioButton("Water");
		jrb2.setBounds(120, 145, 70, 20);
		window.add(jrb2);
		
		JRadioButton jrb3 = new JRadioButton("Tea");
		jrb3.setBounds(190, 145, 60, 20);
		window.add(jrb3);
		
		JRadioButton jrb4 = new JRadioButton("Coffee");
		jrb4.setBounds(250, 145, 70, 20);
		window.add(jrb4);
		
		 ButtonGroup group = new ButtonGroup();											//ButtonGroup to select only one button
		 group.add(jrb1);
		 group.add(jrb2);
		 group.add(jrb3);
		 group.add(jrb4);
	
		//JButton
		
		JButton jb1 = new JButton("Add");												//add&order button
		jb1.setBounds(50, 250, 80, 30);
		window.add(jb1);
		
		JButton jb2 = new JButton("Order");
		jb2.setBounds(150, 250, 80, 30);
		window.add(jb2);
		
	    ArrayList<String> order = new ArrayList<String>();								//arraylist to keep orders
	    ArrayList<Integer> money = new ArrayList<Integer>();							//arraylist to keep money

	   
		   jb1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            	if(tfield.getText().equals("") || !(jrb1.isSelected()) && !(jrb2.isSelected()) && !(jrb3.isSelected()) && !(jrb4.isSelected()) ) 
		            		//tf is empty or no rb is selected show message
		            		JOptionPane.showMessageDialog(null, "Choose a beverage type and enter an amount");
		            
		            	else if (jrb1.isSelected() &&!(tfield.getText().equals(""))) {
		            		//juice is selected and tf is not empty give option for juice
		            		String[] list = {"apple", "orange", "pineapple"};
		            		JComboBox jcb = new JComboBox(list);
		            		
		            		int [] itemPrice = {10,12,14}; 								//juice prices apple 10, orange 12, pineapple 14
		            		jcb.setEditable(true);
		            		JOptionPane.showConfirmDialog( null, jcb, "Select a fruit.", JOptionPane.OK_CANCEL_OPTION);	
		            		
		            		
		            		String abc =tfield.getText();								//getting how many glasses as string
		            		Integer cba= Integer.valueOf(abc);							//convert to integer
		            		lbl4.setText(tfield.getText() + " glass(es) of " + jcb.getSelectedItem() + " added.");
		            		
		            		
		            		int tut = cb.getSelectedIndex();							//get selected index from combobox
		        			int price=itemPrice[tut]*sizePrice[tut]* cba ;				//calculate price
		        			 order.add(jcb.getSelectedItem() +" juice - "+ price+ " TL");	
		        			 
		        			 money.add(price);
		        	
		            	}
		           
		            	else if(jrb2.isSelected() &&!(tfield.getText().equals(""))){
		            		if(JOptionPane.showConfirmDialog(null,"Would you like ice?", "Ice" ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            			lbl4.setText(tfield.getText() + " glass(es) of water with ice added." );
		            				
		            			int tut= cb.getSelectedIndex();
		            			String abc =tfield.getText();
			            		Integer cba= Integer.valueOf(abc);
		            			int price=(sizePrice[tut]*3*cba);
			        			 String water= "water with ice - "+ price + " TL";
			        			 order.add(water);
			        			 money.add(price);
			        			
		            		}
		            		
		            		else {
		            			lbl4.setText(tfield.getText() + " glass(es) of water added." );

			        			int tut= cb.getSelectedIndex();
			        			String abc =tfield.getText();
			            		Integer cba= Integer.valueOf(abc);
			        			int price=sizePrice[tut]*2*cba;
			        			 String waternoice= " water - "+ price + " TL";
			        			 order.add(waternoice);
		            			money.add(price);
			        			
		            		}
		            	}
		            	else if (jrb3.isSelected() &&!(tfield.getText().equals(""))) {
		            		if(JOptionPane.showConfirmDialog(null,"Would you like sugar?", "Sugar" ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            			lbl4.setText(tfield.getText() + " glass(es) of tea with sugar added." );
		            			
		            			int tut= cb.getSelectedIndex(); 
		            			String abc =tfield.getText();
			            		Integer cba= Integer.valueOf(abc);
		            			int price=(sizePrice[tut]*2*cba);
		            			String teasugar= "tea with sugar - " + price + " TL";
		            			order.add(teasugar);
		            			money.add(price);
		            		}
		            		else {
		            			int tut= cb.getSelectedIndex();
		            			lbl4.setText(tfield.getText() + " glass(es) of tea added." );
		            			String abc =tfield.getText();
			            		Integer cba= Integer.valueOf(abc);
		            			int price=sizePrice[tut]*2*cba;
		            			String tea="tea - "+ price + " TL";
		            			order.add(tea);
		            			money.add(price);
		            		}
		            		
		            	}
		            	
		            	else if (jrb4.isSelected() &&!(tfield.getText().equals(""))) {
		            		if(JOptionPane.showConfirmDialog(null,"Would you like milk?", "Milk" ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            			lbl4.setText(tfield.getText() + " glass(es) of coffee with milk added." );
		            			int tut= cb.getSelectedIndex();
		            			int price=sizePrice[tut]*6;
		            			String cofmil="coffee with milk -" +price+ " TL";
		            			order.add(cofmil);
		            			money.add(price);
		            		}
		            		else {
		            			lbl4.setText(tfield.getText() + " glass(es) of coffee added." );
		            			int tut= cb.getSelectedIndex();
		            			String abc =tfield.getText();
			            		Integer cba= Integer.valueOf(abc);
		            			int price= sizePrice[tut]*5*cba;
		            			String cof= "coffee -" + price+ " TL";
		            			order.add(cof);
		            			money.add(price);
		            		}
		            	}
		        }	
		    } );
		
		   jb2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	
		        	if(JOptionPane.showConfirmDialog(null,order, "Message" ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		        		
		        		double sum = 0;
		        		for(int i = 0; i < money.size(); i++) {
		        		    sum += money.get(i);
		        		lbl5.setText(""+sum);}
		        		
		        		String message= "You should pay " + lbl5.getText() + " TL." ;
            			JOptionPane.showMessageDialog(null, message);
		        	}        	
		        	
		        }} );
		   
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
