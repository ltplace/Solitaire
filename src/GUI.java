import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends Main{

	private JFrame frame;
	private int tabIndex;
	private boolean tabPressed = false;
	private boolean wpPressed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Solitaire");
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.setBounds(100, 100, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnWastePile = new JButton("Waste Pile");
		btnWastePile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wpPressed = true;
			}
		});
		btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
		frame.getContentPane().add(btnWastePile);
		
		JButton Deck = new JButton("Deck");
		Deck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.moveToWastePile();
				btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnWastePile, 0, SpringLayout.NORTH, Deck);
		springLayout.putConstraint(SpringLayout.EAST, btnWastePile, -6, SpringLayout.WEST, Deck);
		springLayout.putConstraint(SpringLayout.NORTH, Deck, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Deck, -82, SpringLayout.EAST, frame.getContentPane());
		Deck.setIcon(new ImageIcon(GUI.class.getResource(Main.deck.examineFront().Img)));
		frame.getContentPane().add(Deck);
		
		// Foundation 0 has been pressed, checks whether Wastepile or Tableau card has been pressed
		JButton Foundation_0 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_0, 0, SpringLayout.NORTH, btnWastePile);
		springLayout.putConstraint(SpringLayout.WEST, Foundation_0, 10, SpringLayout.WEST, frame.getContentPane());
		Foundation_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					Main.FndMoveChecker(tabIndex, 0);
					if (!Main.Fnds.get(0).isMT()) {
						Foundation_0.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(0).top().Img)));
					}
					tabPressed = false;
				}
				if (wpPressed == true) {
					Main.WPtoFndChecker(0);
					if (!Main.Fnds.get(0).isMT()) {
						Foundation_0.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(0).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		Foundation_0.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_0);
		
		// Foundation 1 has been pressed, checks whether Wastepile or Tableau card has been pressed
		JButton Foundation_1 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Foundation_1, 193, SpringLayout.WEST, frame.getContentPane());
		Foundation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					Main.FndMoveChecker(tabIndex, 1);
					if (!Main.Fnds.get(1).isMT()) {
						Foundation_1.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(1).top().Img)));
					}
					tabPressed = false;
				}
				if (wpPressed == true) {
					Main.WPtoFndChecker(1);
					if (!Main.Fnds.get(1).isMT()) {
						Foundation_1.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(1).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		Foundation_1.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_1);
		
		// Foundation 2 has been pressed, checks whether Wastepile or Tableau card has been pressed
		JButton Foundation_2 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_2, 10, SpringLayout.NORTH, frame.getContentPane());
		Foundation_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					Main.FndMoveChecker(tabIndex, 0);
					if (!Main.Fnds.get(2).isMT()) {
						Foundation_2.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(2).top().Img)));
					}
					tabPressed = false;
				}
				if (wpPressed == true) {
					Main.WPtoFndChecker(2);
					if (!Main.Fnds.get(2).isMT()) {
						Foundation_2.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(2).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, Foundation_2, 6, SpringLayout.EAST, Foundation_1);
		Foundation_2.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_2);
		
		// Foundation 3 has been pressed, checks whether Wastepile or Tableau card has been pressed
		JButton Foundation_3 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_3, 10, SpringLayout.NORTH, frame.getContentPane());
		Foundation_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					Main.FndMoveChecker(tabIndex, 3);
					if (!Main.Fnds.get(3).isMT()) {
						Foundation_3.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(3).top().Img)));
					}
					tabPressed = false;
				}
				if (wpPressed == true) {
					Main.WPtoFndChecker(3);
					if (!Main.Fnds.get(3).isMT()) {
						Foundation_3.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(3).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, Foundation_3, 6, SpringLayout.EAST, Foundation_2);
		Foundation_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_3);
		
		JButton Tableau_0 = new JButton("");
		springLayout.putConstraint(SpringLayout.EAST, Tableau_0, 0, SpringLayout.EAST, Foundation_0);
		Tableau_0.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Tableau_0);
		
		JButton Tableau_1 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_0, 0, SpringLayout.NORTH, Tableau_1);
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, 0, SpringLayout.NORTH, Tableau_1);
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, 49, SpringLayout.SOUTH, Foundation_1);
		Tableau_1.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.EAST, Tableau_1, 0, SpringLayout.EAST, Foundation_1);
		frame.getContentPane().add(Tableau_1);
		
		JButton Tableau_2 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_2, 49, SpringLayout.SOUTH, Foundation_2);
		Tableau_2.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.WEST, Tableau_2, 0, SpringLayout.WEST, Foundation_2);
		frame.getContentPane().add(Tableau_2);
		
		JButton Tableau_3 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_3, 49, SpringLayout.SOUTH, Foundation_3);
		Tableau_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.EAST, Tableau_3, 0, SpringLayout.EAST, Foundation_3);
		frame.getContentPane().add(Tableau_3);
		
		JButton Tableau_4 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_4, 49, SpringLayout.SOUTH, btnWastePile);
		Tableau_4.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.WEST, Tableau_4, 5, SpringLayout.EAST, Tableau_3);
		frame.getContentPane().add(Tableau_4);
		
		JButton Tableau_5 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_5, 49, SpringLayout.SOUTH, btnWastePile);
		Tableau_5.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.WEST, Tableau_5, 6, SpringLayout.EAST, Tableau_4);
		frame.getContentPane().add(Tableau_5);
		
		JButton Tableau_6 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Tableau_6, 49, SpringLayout.SOUTH, btnWastePile);
		springLayout.putConstraint(SpringLayout.WEST, Tableau_6, 5, SpringLayout.EAST, Tableau_5);
		Tableau_6.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Tableau_6);
		
	}

}
