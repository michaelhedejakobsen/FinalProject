import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

/***
 * The class Print contains the graphic user interface for a program to print the purchase information.
 * The product, price, and total is displayed. 
 * A text field allows the "User" to input a coupon code, acquired from the Survey class. And a new calculated total will appear.
 * Sign Out button will take the "User" to the Authentication frame.
 * Survey button will take the "User" to the Survey frame.
 * Submit Coupon button will calculate the new total with 10% off.
 * The design is 1 frame containing 3 panels using grid layout.
 * The class extends JFrame and implements ActionListener, for the action of the button.
 * 
 * @authors Michael H. Jakobsen & Amine Bourdi
 * Date: 26 November 2014
 */
public class Print extends JFrame implements ActionListener {

	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638731L;
	
	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxCoupon;
	JLabel jlWelcome, jlProductInfo, jlProduct, jlBlank, jlBlank2, jlTotalInfo, jlTotal, jlCouponInfo, jlNewTotalInfo, jlNewTotal;
	JButton jbtFinish, jbtSurvey, jbtSubmit;
	JPanel panelLeft, panelRight, panelCenter;
	public int f = 0;
	
	/**
	 * Construct new public method Print to create the design of the GUI.
	 */
	public Print(){
		/**
		 * Create new JFrame.
		 */
		JFrame frame = new JFrame("Final Project");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    /**
	     *  Create text fields, check boxes, labels, password field, and buttons.
	     */
	    jlWelcome = new JLabel("Here is your Receipt");
	    jlProductInfo = new JLabel("You Purchased the Following items:                 ");
	    jlProduct = new JLabel();
	    jlTotalInfo = new JLabel("Your Total is:             ");
	    jlTotal = new JLabel();
	    jlCouponInfo = new JLabel("Enter Survey Coupon Code Here: ");
	    jtxCoupon = new JTextField(20);
	    jlNewTotalInfo = new JLabel();
	    jlNewTotal = new JLabel();
		jlBlank = new JLabel();
		jlBlank2 = new JLabel();

		jbtSubmit = new JButton("Submit Coupon");
		jbtSubmit.addActionListener(this);
		jbtFinish = new JButton("Sign Out");
		jbtFinish.addActionListener(this);
		jbtSurvey = new JButton("Survey");
		jbtSurvey.addActionListener(this);
		
	    /**
	     * IF the text from the Product text field equals the productName content from the array.
	     * Input the product name and product price into the label.
	     */
	    if(SellProduct.jtxProduct.getText().equalsIgnoreCase(CreateProduct.productName[0])) {
	    	
	    	jlProduct.setText(SellProduct.jtxProduct.getText() + " for: $" + CreateProduct.productPrice[0]);
	    	jlTotal.setText(CreateProduct.productPrice[0]);
	    	}
	   
	    if(SellProduct.jtxProduct.getText().equalsIgnoreCase(CreateProduct.productName[1])) {
	    	
		   jlProduct.setText(SellProduct.jtxProduct.getText() + " for: $" + CreateProduct.productPrice[1]);
		   jlTotal.setText(CreateProduct.productPrice[1]);
		    }
	    
	    if(SellProduct.jtxProduct.getText().equalsIgnoreCase(CreateProduct.productName[2])) {
	    	
		    jlProduct.setText(SellProduct.jtxProduct.getText() + " for: $" + CreateProduct.productPrice[2]);
		    jlTotal.setText(CreateProduct.productPrice[2]);
		    }
	    
	    /**
	     * Input the total value into label.
	     */
	    jlTotal.setText("$" + jlTotal.getText());
	    
	    /**
		 * Create 3 panels with grid layout.
		 */
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(8,1));
		panelLeft.setBackground(Color.LIGHT_GRAY);
		panelLeft.setSize(200, 400);

		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(8,1));
		panelRight.setBackground(Color.LIGHT_GRAY);
		panelRight.setSize(200, 400);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(8,1));
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.setSize(200, 400);
		
		/**
		 * Add the components to the panels.
		 */
		panelCenter.add(jlWelcome);
		panelCenter.add(jlProduct);
		panelCenter.add(jlTotal);
		panelCenter.add(jtxCoupon);
		panelCenter.add(jlNewTotal);
		
		panelLeft.add(jlBlank2);
		panelLeft.add(jlProductInfo);
		panelLeft.add(jlTotalInfo);
		panelLeft.add(jlCouponInfo);
		panelLeft.add(jlNewTotalInfo);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtFinish);
		panelRight.add(jbtSurvey);
		panelRight.add(jbtSubmit);

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
	public void actionPerformed(ActionEvent arg0) {
		
		/**
		 * IF statements - to ensure the appropriate action is taken with the buttons.
		 */
		if(arg0.getSource() == jbtFinish)
		{	
			new Authentication();
		}	
		
		if(arg0.getSource() == jbtSurvey)
		{
			new Survey();
		}
		
		/**
		 * IF jbtSubmit button is pushed, calculate the new discounted price. 
		 * First validate the input coupon is correct.
		 */
		if(arg0.getSource() == jbtSubmit)
		{

			if(jtxCoupon.getText().equals("CSC200")) 
			{
				String Amount = jlTotal.getText();
				int length = Amount.length();
				String NewAmount = Amount.substring(1, length);
				double total = (Double.parseDouble(NewAmount));
		    
				double newTotal = total*.9;
		   	
				jlNewTotalInfo.setText("Your New Total after the Coupon Is:");
				jlNewTotal.setText("$" + Double.toString(newTotal));
		   	
			}else  jlNewTotalInfo.setText("Sorry Invalid Code");
		}
	}
}