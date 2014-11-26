import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Dimension;

public class Print extends JFrame implements ActionListener {

	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 5577077535315638731L;
	
	/**
	 * Initializing variables; text fields, labels, panels, button and option panel
	 */
	public JTextField jtxProductName, jtxPrice;
	JLabel jlWelcome, jlProduct, jlBlank, jlBlank2, jlCartInfo, jlPrice;
	JButton jbtFinish, jbtSurvey;
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
		jlWelcome = new JLabel("Do.......  ");
		jlBlank = new JLabel();

		jtxProductName= new JTextField(30);
		jtxProductName.setForeground(Color.gray);
		jtxProductName.setText("");

		jbtFinish = new JButton("Finish");
		jbtFinish.addActionListener(this);
		jbtSurvey = new JButton("Survey");
		jbtSurvey.addActionListener(this);
		
		/**
		 * Add the components to the panels.
		 */
		panelLeft.add(jlWelcome);

		panelCenter.add(jtxProductName);
		
		panelRight.add(jlBlank);
		panelRight.add(jbtFinish);
		panelRight.add(jbtSurvey);


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
		if(arg0.getSource() == jbtFinish)
		{	
			System.exit(0);
		}	
		
		if(arg0.getSource() == jbtSurvey)
		{
			new Survey();
		}
	}
	
	public static void main(String[] args) {

		new Print();
	}

}
