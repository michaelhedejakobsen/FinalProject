import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

public class CreateProduct extends JFrame implements ActionListener {

	
	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638729L;
	
	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxProductName, jtxPrice;
	JLabel jlWelcome, jlNew, jlBlank, jlBlank2, jlPriceInfo;
	JButton jbtCreate;
	JPanel panelLeft, panelRight, panelCenter;
	
	/**
	 * Construct new public method FinalProjectGUI to create the design of the GUI.
	 */
	public CreateProduct(){	
		
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
		jlWelcome = new JLabel(" Welcome Admin, you can now input new products:  ");
		jlNew = new JLabel(" Input new product name: ");
		jlPriceInfo = new JLabel(" Input product price, in the format i.e. 197.95 for the price $197.95: ");
		jlBlank = new JLabel();
		jlBlank2 = new JLabel();

		/**
		 * Create text fields, checkboxes, and password field for input of personal information.
		 */
		jtxProductName= new JTextField(30);
		jtxProductName.setText("Honda");
		jtxProductName.setForeground(Color.gray);
		jtxPrice= new JTextField(30);
		jtxPrice.setText("197.95");
		jtxPrice.setForeground(Color.gray);
	
		/**
		 * Create a new button, to create the user.
		 */
		jbtCreate = new JButton("Create Product");
		jbtCreate.addActionListener(this);
		
		/**
		 * Adding the components to the panels.
		 */
		panelLeft.add(jlWelcome);
		panelLeft.add(jlNew);
		panelLeft.add(jlPriceInfo);
		
		panelCenter.add(jlBlank);
		panelCenter.add(jtxProductName);
		panelCenter.add(jtxPrice);
		
		panelRight.add(jlBlank2);
		panelRight.add(jbtCreate);

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
		new CreateProduct();
	}
}
