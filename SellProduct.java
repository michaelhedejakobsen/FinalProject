import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

public class SellProduct extends JFrame implements ActionListener {

	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638730L;
	
	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxProductName, jtxPrice;
	JTextArea jtaCart, jtaCatalog;
	JTextField jtxProduct; 
	JLabel jlWelcome, jlProduct, jlBlank, jlBlank2, jlBlank3,jlBlank4, jlBlank5, jlBlank6, jlBlank7, jlBlank8, jlCartInfo, jlPrice, jlCart;
	JButton jbtSelect, jbtConfirm;
	JPanel panelLeft, panelRight, panelCenter;
	public int c = 0;
	
	public static String[] productName = new String[100];
	public static Double[] productPrice = new Double[100];
	public static JLabel[] product = new JLabel[5];
	
	/**
	 * Construct new public method SellProduct to create the design of the GUI.
	 */
	public SellProduct(){	
		/**
		 * Create new JFrame.
		 */
		JFrame frame = new JFrame("Final Project");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		/**
		 * Creating 3 panels with grid layout.
		 */
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(12,1));
		panelLeft.setBackground(Color.LIGHT_GRAY);
		panelLeft.setSize(200, 400);
		
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(4,1));
		panelRight.setBackground(Color.LIGHT_GRAY);
		panelRight.setSize(200, 400);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(4,1));
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.setSize(200, 400);
		
		/**
		 * Create text fields, check boxes, labels, password field, and buttons.
		 */
		jlWelcome = new JLabel(" Welcome Customer, start your purchase:  ");
		jlProduct = new JLabel(" ");
		jlPrice = new JLabel(" Select product from catalog: ");
		jlBlank = new JLabel();
		jlBlank2 = new JLabel();
		jlBlank3 = new JLabel();
		jlBlank4 = new JLabel();
		jlBlank5 = new JLabel();
		jlBlank6 = new JLabel();
		jlBlank7 = new JLabel();
		jlBlank8 = new JLabel();
		jlCart = new JLabel();
		jlCart.setForeground(Color.RED);
		jlCartInfo = new JLabel("Shopping Cart: ");
	
		jtxProduct= new JTextField(30);
		jtxProduct.setForeground(Color.gray);
		jtxProduct.setText("i.e. Toyota");

		jbtSelect = new JButton("Select Product");
		jbtSelect.addActionListener(this);
		jbtConfirm = new JButton("Confirm Purchase");
		jbtConfirm.addActionListener(this);;
		
		/**
		 * 
		 */
		jtaCart = new JTextArea();
		jtaCatalog = new JTextArea();
		jtaCatalog.setText(CreateProduct.productName[0] + " " + CreateProduct.productPrice[0] + "\n" +
						 CreateProduct.productName[1]  + " " + CreateProduct.productPrice[1] + "\n" +
						 CreateProduct.productName[2]  + " " + CreateProduct.productPrice[2]);
		/**
		 * Add the components to the panels.
		 */
		panelLeft.add(jlWelcome);
		panelLeft.add(jlProduct);
		panelLeft.add(jlPrice);
		panelLeft.add(jlCart);
		panelLeft.add(jtxProduct);
		panelLeft.add(jbtSelect);
		panelLeft.add(jlBlank6);
		panelLeft.add(jlBlank7);
		panelLeft.add(jlBlank8);
		panelLeft.add(jlCartInfo);
		
		panelCenter.add(jlBlank);
		panelCenter.add(jtaCatalog);
		panelCenter.add(jlBlank4);
		panelCenter.add(jtaCart);
		
		panelRight.add(jlBlank2);
		panelRight.add(jlBlank3);
		panelRight.add(jlBlank5);
		panelRight.add(jbtConfirm);
		
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

		if(arg0.getSource() == jbtSelect)
		{	
			if(jtxProduct.getText().equalsIgnoreCase("i.e. Toyota"))
			{
				jtaCart.setText("No items in you shopping cart");
			}
			else
			{	
				jtaCart.setText(jtxProduct.getText());
			}
		}	
		
		if(arg0.getSource() == jbtConfirm)
			{
			new Print();	
			}	
	}
}
