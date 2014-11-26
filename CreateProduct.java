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
	JLabel jlWelcome, jlNew, jlBlank, jlBlank2, jlPriceInfo, jlCreated;
	JButton jbtCreate, jbtSignOut;
	JPanel panelLeft, panelRight, panelCenter;
	public int b = 0;
	
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
		
		if(arg0.getSource() == jbtCreate)
		{	
			do
			{
				if(productName [b] == null)
				{
					productName [b] = jtxProductName.getText();
					productPrice [b] = jtxPrice.getText() + "\n";
					b++;
			
				}else b++;

			}while (productName == null);
			
			jlCreated.setText("The product you have entered, is now in the catalog ");
		
			System.out.println(productName[b-1] + " " + productPrice[b-1]);
			System.out.println(b);
		}	
		
		if(arg0.getSource() == jbtSignOut)
		{
			new Authentication();
		}
	}
}
