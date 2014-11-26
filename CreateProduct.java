import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

/***
 * The class CreateProduct contains the graphic user interface for a program to create new products and prices into arrays.
 * The user inputs information into 2 text fields, and the information is stored with the arrays productName and productPrice.
 * The "Admin" can then sign out, when he is done inputting products into the catalog.
 * The design is 1 frame containing 3 panels using grid layout.
 * The class extends JFrame and implements ActionListener, for the action of the button.
 * 
 * @authors Michael H. Jakobsen & Amine Bourdi
 * Date: 26 November 2014
 */
public class CreateProduct extends JFrame implements ActionListener {

	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638729L;
	
	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxProductName, jtxPrice;
	JLabel jlWelcome, jlNew, jlBlank, jlBlank2, jlPriceInfo, jlCreated;
	JButton jbtCreate, jbtSignOut;
	JPanel panelLeft, panelRight, panelCenter;
	public int b = 0;
	
	/**
	 * Create 2 arrays for storage of product information.
	 */
	public static String[] productName = new String[10];
	public static String[] productPrice = new String[10];
	
	/**
	 * Construct new public method CreateProduct to create the design of the GUI.
	 */
	public CreateProduct(){	
		/**
		 * Create new JFrame.
		 */
		JFrame frame = new JFrame("Final Project");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		/**
		 * Creating 3 panels with grid layout.
		 */
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(11,1));
		panelLeft.setBackground(Color.LIGHT_GRAY);
		panelLeft.setSize(200, 400);
		
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(11,1));
		panelRight.setBackground(Color.LIGHT_GRAY);
		panelRight.setSize(200, 400);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(11,1));
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.setSize(200, 400);
		
		/**
		 * Create text fields, check boxes, labels, password field, and buttons.
		 */
		jlWelcome = new JLabel(" Welcome Admin, you can now input new products:  ");
		jlNew = new JLabel(" Input new product name: ");
		jlPriceInfo = new JLabel(" Input product price, in the format i.e. 197.95 for the price $197.95: ");
		jlBlank = new JLabel();
		jlBlank2 = new JLabel();
		jlCreated = new JLabel();
		jlCreated.setForeground(Color.RED);

		jtxProductName= new JTextField(30);
		jtxProductName.setText("Honda");
		jtxProductName.setForeground(Color.gray);
		jtxPrice= new JTextField(30);
		jtxPrice.setText("197.95");
		jtxPrice.setForeground(Color.gray);
	
		jbtCreate = new JButton("Create Product");
		jbtCreate.addActionListener(this);
		jbtSignOut = new JButton("Sign Out");
		jbtSignOut.addActionListener(this);;
		
		/**
		 * Add the components to the panels.
		 */
		panelLeft.add(jlWelcome);
		panelLeft.add(jlNew);
		panelLeft.add(jlPriceInfo);
		panelLeft.add(jlCreated);
		
		panelCenter.add(jlBlank);
		panelCenter.add(jtxProductName);
		panelCenter.add(jtxPrice);
		
		panelRight.add(jlBlank2);
		panelRight.add(jbtCreate);
		panelRight.add(jbtSignOut);

		/**
		 * Add the panels to the BorderLayout
		 */
		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panelRight, BorderLayout.EAST);
		frame.add(panelCenter, BorderLayout.CENTER);

		/**
		 * Set the size and GUI visible.
		 */
		frame.setSize(new Dimension(800,500));
		frame.setVisible(true);
		frame.setForeground(Color.LIGHT_GRAY);
	}
	
	@Override
	/**
	 * Method for actionPerformed
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		/**
		 * IF statement - to ensure the appropriate action is taken with the buttons.
		 * IF jbtCreate button is pushed, do this:
		 */
		if(arg0.getSource() == jbtCreate)
		{	
			/**
			 * DO	
			 * WHILE - the location in the productName is empty.
			 */
			do
			{
				/**
				 * IF the location is empty, store the information from the textfields into the arrays.
				 * ELSE - increment counter b by 1.
				 */
				if(productName [b] == null)
				{
					productName [b] = jtxProductName.getText();
					productPrice [b] = jtxPrice.getText() + "\n";
					b++;
			
				}else b++;

			}while (productName == null);
			/**
			 * Set text in label, informing the product is in the catalog.
			 */
			jlCreated.setText("The product you have entered, is now in the catalog ");
		}	
		
		/**
		 * IF jbtCreate button is pushed, open new Authentication frame. 
		 */
		if(arg0.getSource() == jbtSignOut)
		{
			new Authentication();
		}
	}
}
