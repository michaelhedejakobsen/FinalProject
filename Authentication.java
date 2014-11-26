import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Dimension;

/***
 * The class Authentication contains the graphic user interface for a program to authenticate an existing account.
 * The user inputs information into 2 text fields, and the information is validated with the arrays passWord and userName.
 * If the corresponding account is a "User" account open up SellProduct frame.
 * If the corresponding account is an "Admin" account open up CreateProduct frame.
 * The design is 1 frame containing 3 panels using grid layout.
 * The class extends JFrame and implements ActionListener, for the action of the button.
 * 
 * @authors Michael H. Jakobsen & Amine Bourdi
 * Date: 26 November 2014
 */
public class Authentication extends JFrame implements ActionListener {
	
	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638728L;
	
	/**
	 * Initializing variables; text fields, labels, panels, buttons.
	 */
	public JTextField jtxUser;
	JPasswordField jpwPass;
	JLabel jlPass, jlUser, jlInstructions, jlBlank;
	JButton jbtSignIn, jbtNewUser;
	JPanel panelLeft, panelRight, panelCenter;
	JFrame mainFrame;
	public int a = 0;

	/**
	 * Construct new public method Authentication to create the design of the GUI.
	 */
	public Authentication(){	
		/**
		 * Create new JFrame.
		 */
		JFrame frame = new JFrame("Final Project");
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
		 * Create text fields, labels, password field, and buttons.
		 */
		jlInstructions = new JLabel(" Sign in to your account:  ");
		jlPass = new JLabel(" Input password");
		jlUser = new JLabel(" Input username");
		jlBlank = new JLabel();

		jtxUser= new JTextField(30);
		jtxUser.setForeground(Color.gray);
		jtxUser.setText("i.e. userUser123");
		
		jpwPass = new JPasswordField(30);
		jpwPass.setText("xxxxxxxx");

		jbtSignIn = new JButton("Sign In");
		jbtSignIn.addActionListener(this);
		jbtNewUser = new JButton("Create New User");
		jbtNewUser.addActionListener(this);
		
		/**
		 * Add the components to the panels.
		 */
		panelLeft.add(jlInstructions);
		panelLeft.add(jlUser);
		panelLeft.add(jtxUser);
		panelLeft.add(jlPass);
		panelLeft.add(jpwPass);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtSignIn);
		panelRight.add(jbtNewUser);

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
		 * IF jbtSignIn button is pushed, do this:
		 */
		if(arg0.getSource() == jbtSignIn)
		{
			/**
			 * DO	
			 * WHILE - the counter a is less than 10, AND the input information does not correspond with the array.
			 */
			do
			{
				
				/**
				 * IF the the input user name equals the user name from array userName
				 */
				if(jtxUser.getText().equals(CreateUser.userName[a]))
				{
					
					/**
					 * DO
					 * WHILE - the location in the array userName is NOT empty.
					 */
					do
					{
						
						/**
						 * IF the input password equals the password in the array passWord.
						 */
						if(jpwPass.getText().equals(CreateUser.passWord[a]))
						{
							
							/**
							 * IF it is a "User" account - open the SellProduct frame.
							 * ELSE - open the CreateProduct frame.
							 */
							if (CreateUser.accountType[a].equalsIgnoreCase("User"))
							{
								new SellProduct();
							}
							else
							{
								new CreateProduct();
							}
							break;
						}

						/**
						 * ELSE - the input password is INcorrect, dialog box "Wrong Password"
						 */
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong password");
							break;
						}
					}while(CreateUser.userName != null);
					
				}else{a++;
					
				}
				break;
			
			}while (a<10 || !jtxUser.getText().equals(CreateUser.userName[a]));
		}	
		
		/**
		 * IF - the button jbtNewUser is hit, open the frame CreateUser.
		 */
		if(arg0.getSource() == jbtNewUser)
		{
			new CreateUser();
		}
	}	
}
