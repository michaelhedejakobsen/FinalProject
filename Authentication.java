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
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxUser;
	JPasswordField jpwPass;
	JLabel jlPass, jlUser, jlInstructions, jlBlank;
	JButton jbtSignIn;
	JPanel panelLeft, panelRight, panelCenter;
	
	/**
	 * Construct new public method FinalProjectGUI to create the design of the GUI.
	 */
	public Authentication(){	
		
		/**
		 * Creating a panel with grid layout.
		 */
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(11,1));
		panelLeft.setBackground(Color.LIGHT_GRAY);
		panelLeft.setSize(200, 400);
		
		/**
		 * Creating a panel with grid layout.
		 */
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(11,1));
		panelRight.setBackground(Color.LIGHT_GRAY);
		panelRight.setSize(200, 400);
		
		/**
		 * Creating a panel with grid layout.
		 */
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(11,1));
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.setSize(200, 400);
		
		/**
		 * Create new labels with instructions.
		 */
		jlInstructions = new JLabel(" Sign in to your account:  ");
		jlPass = new JLabel(" Input password");
		jlUser = new JLabel(" Input username");
		jlBlank = new JLabel();

		/**
		 * Create text fields, checkboxes, and password field for input of personal information.
		 */
		jtxUser= new JTextField(30);
		jtxUser.setForeground(Color.gray);
		jtxUser.setText("i.e. userUser123");
		
		jpwPass = new JPasswordField(30);
		jpwPass.setText("xxxxxxxx");
		
		/**
		 * Create a new button, to create the user.
		 */
		jbtSignIn = new JButton("Sign In");
		jbtSignIn.addActionListener(this);
		
		/**
		 * Adding the components to the panels.
		 */
		panelLeft.add(jlInstructions);
		panelLeft.add(jlUser);
		panelLeft.add(jtxUser);
		panelLeft.add(jlPass);
		panelLeft.add(jpwPass);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtSignIn);

		/**
		 * Add the panels to the BorderLayout
		 */
		add(panelLeft, BorderLayout.WEST);
		add(panelRight, BorderLayout.EAST);
		add(panelCenter, BorderLayout.CENTER);

		/**
		 * Set the size and GUI visible.
		 */
		setSize(new Dimension(800,400));
		setVisible(true);
		setForeground(Color.LIGHT_GRAY);
	}
	
	@Override
	/**
	 * Method for actionPerformed
	 */
	public void actionPerformed(ActionEvent arg0) {
		

	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Create new instance of the class CreateUser.
		 */
		new Authentication();
	}
}
