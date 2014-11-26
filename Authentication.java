import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Dimension;

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
		if(arg0.getSource() == jbtSignIn)
		{
			do
			{
				if(jtxUser.getText().equals(CreateUser.userName[a]))
				{
					do
					{
						if(jpwPass.getText().equals(CreateUser.passWord[a]))
						{
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
		
		if(arg0.getSource() == jbtNewUser)
		{
			new CreateUser();
		}
	}	
}
