import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;

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
		Main main = new Main();
		ArrayList<Tableau> Tabs = Main.Tabs;
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
		
		JButton btnFoudation_3 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnFoudation_3, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnFoudation_3, 10, SpringLayout.WEST, frame.getContentPane());
		btnFoudation_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnFoudation_3);
		
		JButton btnFoundation = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnFoundation, 0, SpringLayout.NORTH, btnFoudation_3);
		springLayout.putConstraint(SpringLayout.WEST, btnFoundation, 6, SpringLayout.EAST, btnFoudation_3);
		btnFoundation.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnFoundation);
		
		JButton btnFoundation_1 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnFoundation_1, 0, SpringLayout.NORTH, btnFoudation_3);
		springLayout.putConstraint(SpringLayout.WEST, btnFoundation_1, 6, SpringLayout.EAST, btnFoundation);
		btnFoundation_1.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnFoundation_1);
		
		JButton btnFoundation_2 = new JButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnFoundation_2, 6, SpringLayout.EAST, btnFoundation_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnFoundation_2, 0, SpringLayout.SOUTH, btnFoudation_3);
		btnFoundation_2.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnFoundation_2);
		
		JButton btnWastePile = new JButton("Waste Pile");
		btnWastePile.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnWastePile);
		
		JButton Deck = new JButton("Deck");
		springLayout.putConstraint(SpringLayout.NORTH, btnWastePile, 0, SpringLayout.NORTH, Deck);
		springLayout.putConstraint(SpringLayout.EAST, btnWastePile, -6, SpringLayout.WEST, Deck);
		springLayout.putConstraint(SpringLayout.NORTH, Deck, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Deck, -82, SpringLayout.EAST, frame.getContentPane());
		Deck.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Deck);
		
		JButton Tabluea1 = new JButton("");
		Tabluea1.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.NORTH, Tabluea1, 49, SpringLayout.SOUTH, btnFoudation_3);
		springLayout.putConstraint(SpringLayout.EAST, Tabluea1, 0, SpringLayout.EAST, btnFoudation_3);
		frame.getContentPane().add(Tabluea1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, Tabluea1);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, btnFoundation);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.WEST, button_1, 0, SpringLayout.WEST, btnFoundation_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, Tabluea1);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 0, SpringLayout.NORTH, Tabluea1);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, btnFoundation_2);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.NORTH, button_3, 0, SpringLayout.NORTH, Tabluea1);
		springLayout.putConstraint(SpringLayout.WEST, button_3, 5, SpringLayout.EAST, button_2);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		springLayout.putConstraint(SpringLayout.NORTH, button_4, 0, SpringLayout.NORTH, Tabluea1);
		springLayout.putConstraint(SpringLayout.WEST, button_4, 6, SpringLayout.EAST, button_3);
		frame.getContentPane().add(button_4);
		
		JButton btnNewButton = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, Tabluea1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 5, SpringLayout.EAST, button_4);
		btnNewButton.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(btnNewButton);
	}

}
