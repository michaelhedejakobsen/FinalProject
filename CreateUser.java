import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;
/***
 * The class CreateUser contains the graphic user interface for a program to create a new account.
 * The account information is stored is 5 different arrays of strings; firstName, lastName, userName, passWord, accountType.
 * The design is 1 frame containing 3 panels using grid layout.
 * The class extends JFrame and implements ActionListener, for the action of the button.
 *
 * @authors Michael H. Jakobsen & Amine Bourdi
 * Date: 26 November 2014
 */
public class CreateUser extends JFrame implements ActionListener {
	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638727L;
	
	/**
	 * Initializing variables; text fields, labels, panels, buttons.
	 */
	public JTextField jtxFirst, jtxLast, jtxUser, jtxAccType;
	JPasswordField jpwPass;
	JLabel jlPass, jlUser, jlInstructions, jlBlank;
	JCheckBox jcbUser, jcbAdmin;
	JButton jbtCreate, jbtSignIn;
	JPanel panelLeft, panelRight, panelCenter;
	final JFrame frame;
	public int i=0;
	
	/**
	 * Create 5 arrays for storage of account information.
	 */
	public static String[] firstName = new String[10];
	public static String[] lastName = new String[10];
	public static String[] userName = new String[10];
	public static String[] passWord = new String[10];
	public static String[] accountType = new String[10];
	
	/**
	 * Construct new public method CreateUser to create the design of the GUI.
	 */
	public CreateUser(){	
		
		/**
		 * Loop to check if the counter i has already been initiated with other user, 
		 * to ensure new accounts are stored in a new location in the array.
		 */
		int x = 0;
		do
		{
			if (firstName[x]!=null)
			{
				x++;
			}
		}while(firstName[x]!=null);
		i = x;
		
		/**
		 * Create new JFrame.
		 */
	    frame = new JFrame("Final Project");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Create 3 panels with grid layout.
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
		jlInstructions = new JLabel(" Enter your personal information to create an account:  ");
		jlPass = new JLabel(" Input your desired password");
		jlUser = new JLabel(" Input your desired user name");
		jlBlank = new JLabel();

		jtxFirst= new JTextField(30);
		jtxFirst.setText("Input your first name");
		jtxFirst.setForeground(Color.gray);
		jtxLast= new JTextField(30);
		jtxLast.setText("Input your last name");
		jtxLast.setForeground(Color.gray);
		jtxUser= new JTextField(30);
		jtxUser.setForeground(Color.gray);
		jtxUser.setText("i.e. userUser123");
		
		jpwPass = new JPasswordField(30);
		jpwPass.setText("xxxxxxxx");
		
		jcbUser = new JCheckBox("User");
		jcbAdmin = new JCheckBox("Admin");
		
		/**
		 * Create 2 buttons, 1 for creating the account, 1 for signing in with existing account.
		 */
		jbtCreate = new JButton("Create Account");
		jbtCreate.addActionListener(this);
		jbtSignIn = new JButton("Sign In With Existing Username");
		jbtSignIn.addActionListener(this);
		
		/**
		 * Add the components to the panels.
		 */
		panelLeft.add(jlInstructions);
		panelLeft.add(jtxFirst);
		panelLeft.add(jtxLast);
		panelLeft.add(jlUser);
		panelLeft.add(jtxUser);
		panelLeft.add(jlPass);
		panelLeft.add(jpwPass);
		panelLeft.add(jcbUser);
		panelLeft.add(jcbAdmin);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtCreate);
		panelRight.add(jbtSignIn);

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
	
	@SuppressWarnings("deprecation")
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
		 * DO - store the information from the text fields into the arrays.	
		 * WHILE - the array location is empty.
		 */
		do{

		/**
		 * IF location in array is empty do the following.
		 * ELSE increment counter i with 1.	
		 */
		if(firstName [i] == null){
	
				firstName [i] = jtxFirst.getText();
				lastName [i] = jtxLast.getText();
				passWord [i] = jpwPass.getText();
				userName [i] = jtxUser.getText();
				
				/**
				 * IF the check box User is selected, store "User" in the array accountType.
				 * ELSE store Admin
				 */
				if (jcbUser.isSelected()){
					if(jcbAdmin.isSelected()){
						JOptionPane.showMessageDialog(null, "ONLY select User OR Admin, noth both");
						break;
					}
					accountType [i] = "User";
				}else {accountType [i] = "Admin";}
				
				i++;
		
		}else i++;

		}while (firstName == null);
		
		/**
		 * Switch to Authentication frame.
		 */
		new Authentication();
		frame.setVisible(false);
	}
	
	/**
	 * IF jbtSignIn button is pushed, open Authentication frame.
	 */
	if(arg0.getSource() == jbtSignIn)
		{
			new Authentication();
		}
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		new CreateUser();
	}
}
