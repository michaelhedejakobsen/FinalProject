import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

public class Survey extends JFrame implements ActionListener {
	
	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638732L;

	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxAnswer1, jtxAnswer2, jtxAnswer3;
	JLabel jlQuestion1, jlQuestion2, jlQuestion3, jlCoupon, jlInstructions, jlBlank;
	JButton jbtSubmit, jbtContinue, jbtSignOut;
	JPanel panelLeft, panelRight, panelCenter;
	public int d = 0;
	
	static String[] Answer1 = new String[10];
	static String[] Answer2 = new String[10];
	static String[] Answer3 = new String[10];	
	
	/**
	 * Construct new public method Survey to create the design of the GUI.
	 */
	public Survey(){
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
		jlQuestion1 = new JLabel(" Was this online shopping applcation easy to use?");
		jlQuestion2 = new JLabel(" Are you satisfied with your transaction?");
		jlQuestion3 = new JLabel(" Will you be using this application to shop again");
		jlBlank = new JLabel();
		jlCoupon = new JLabel();
		jlInstructions = new JLabel(" Answer the questions below for a 10% off Coupon Code:");

		jtxAnswer1= new JTextField(30);
		jtxAnswer1.setText("Answer to Question 1");
		jtxAnswer1.setForeground(Color.gray);
		jtxAnswer2= new JTextField(30);
		jtxAnswer2.setText("Answer to Question 2");
		jtxAnswer2.setForeground(Color.gray);
		jtxAnswer3= new JTextField(30);
		jtxAnswer3.setText("Answer to Question 3");
		jtxAnswer3.setForeground(Color.gray);

		jbtSubmit = new JButton("                  Submit Survey                 ");
		jbtSubmit.addActionListener(this);
		jbtContinue = new JButton("Continue shopping");
		jbtContinue.addActionListener(this);
		jbtSignOut = new JButton("Sign Out");
		jbtSignOut.addActionListener(this);
		
		/**
		 * Adding the components to the panels.
		 */
		panelLeft.add(jlInstructions);
		panelLeft.add(jlQuestion1);
		panelLeft.add(jtxAnswer1);
		panelLeft.add(jlQuestion2);
		panelLeft.add(jtxAnswer2);
		panelLeft.add(jlQuestion3);
		panelLeft.add(jtxAnswer3);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtSubmit);
		panelRight.add(jlCoupon);
		panelRight.add(jbtContinue);
		panelRight.add(jbtSignOut);
		
		/**
		 * Setting Grid Layout for panels
		 */
		panelLeft.setLayout(new GridLayout(11,1));
		panelRight.setLayout(new GridLayout(11,1));
		panelCenter.setLayout(new GridLayout(11,1));

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
	
	/**
	 * Method for actionPerformed	
	 */
	public void actionPerformed(ActionEvent arg0) {
	
		if(arg0.getSource() == jbtSubmit)
		{

		do{
			if(Answer1 [d] == null){
		
					Answer1 [d] = jtxAnswer1.getText();
					Answer2 [d] = jtxAnswer2.getText();
					Answer3 [d] = jtxAnswer3.getText();
					d++;

			}else d++;

		}while (Answer1 == null);		
		
		if (Answer1[d-1].equals("Answer to Question 1") || 
			Answer2[d-1].equals("Answer to Question 2") || 
			Answer3[d-1].equals("Answer to Question 3")) {
			
			jlCoupon.setText("Sorry you did not answer all of the questions. ");
						
		} else jlCoupon.setText("Your Coupon Code is: CSC200 ");
		
		System.out.println(Answer1[d-1] + " " + Answer2[d-1] + " " + Answer3[d-1]);
		System.out.println(d);
	}
	
	if(arg0.getSource() == jbtSignOut)
		{
		new Authentication();	
		}
	
	if(arg0.getSource() == jbtContinue)
		{
		new SellProduct();
		}
		
	}
}