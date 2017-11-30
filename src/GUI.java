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
	private int cardIndex;
	private boolean tabPressed = false;
	private boolean wpPressed = false;
	private SpringLayout springLayout;
	private JButton Deck;
	private JButton btnWastePile;
	private JButton Foundation_0;
	private JButton Foundation_1;
	private JButton Foundation_2;
	private JButton Foundation_3;

	
	
	// Variables for 
	int T0space = 49;
	int T1space = 49;
	int T2space = 49;
	int T3space = 49;
	int T4space = 49;
	int T5space = 49;
	int T6space = 49;

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
		springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		btnWastePile = new JButton("Waste Pile");
		btnWastePile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wpPressed = true;
			}
		});
		btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
		frame.getContentPane().add(btnWastePile);
		
		Deck = new JButton("Deck");	//FIXME
		Deck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.moveToWastePile();
				if (Main.WP.isMT()) {
					btnWastePile.setVisible(false);
					btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
				}
				else {
					btnWastePile.setVisible(true);
					btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnWastePile, 0, SpringLayout.NORTH, Deck);
		springLayout.putConstraint(SpringLayout.EAST, btnWastePile, -6, SpringLayout.WEST, Deck);
		springLayout.putConstraint(SpringLayout.NORTH, Deck, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, Deck, -82, SpringLayout.EAST, frame.getContentPane());
		Deck.setIcon(new ImageIcon(GUI.class.getResource(Main.deck.examineFront().Img)));
		frame.getContentPane().add(Deck);
		
		// Foundation 0 has been pressed, checks whether Wastepile or Tableau card has been pressed
		Foundation_0 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_0, 0, SpringLayout.NORTH, btnWastePile);
		springLayout.putConstraint(SpringLayout.WEST, Foundation_0, 10, SpringLayout.WEST, frame.getContentPane());
		Foundation_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					boolean transfer = FndMoveChecker(tabIndex, 0);
					if (!Fnds.get(0).isMT()) {
						Foundation_0.setIcon(new ImageIcon(GUI.class.getResource(Fnds.get(0).top().Img)));
						Tabs.get(tabIndex).get(cardIndex).card.setIcon(new ImageIcon(GUI.class.getResource(Fnds.get(0).top().Img)));
					}
					if (transfer == true) {
						frame.remove(Fnds.get(0).top().card);
						Fnds.get(0).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					transfer = false;
					tabPressed = false;
					tabIndex = 0;
					cardIndex = 0;
				}
				if (wpPressed == true) {
					WPtoFndChecker(0);
					if (!Fnds.get(0).isMT()) {
						Foundation_0.setIcon(new ImageIcon(GUI.class.getResource(Fnds.get(0).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		Foundation_0.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_0);
		
		// Foundation 1 has been pressed, checks whether Wastepile or Tableau card has been pressed
		Foundation_1 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Foundation_1, 193, SpringLayout.WEST, frame.getContentPane());
		Foundation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					boolean transfer = FndMoveChecker(tabIndex, 1);
					if (!Main.Fnds.get(1).isMT()) {
						Foundation_1.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(1).top().Img)));
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					if (transfer == true) {
						frame.remove(Fnds.get(1).top().card);
						Fnds.get(1).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					transfer = false;
					tabPressed = false;
					tabIndex = 0;
					cardIndex = 0;
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
		Foundation_2 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_2, 10, SpringLayout.NORTH, frame.getContentPane());
		Foundation_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					boolean transfer = FndMoveChecker(tabIndex, 0);
					if (!Main.Fnds.get(2).isMT()) {
						Foundation_2.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(2).top().Img)));
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					if (transfer == true) {
						frame.remove(Fnds.get(2).top().card);
						Fnds.get(2).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					transfer = false;
					tabPressed = false;
					tabIndex = 0;
					cardIndex = 0;
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
		Foundation_3 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, Foundation_3, 10, SpringLayout.NORTH, frame.getContentPane());
		Foundation_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabPressed == true) {
					boolean transfer = FndMoveChecker(tabIndex, 3);
					if (!Fnds.get(3).isMT()) {
						Foundation_3.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(3).top().Img)));
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					if (transfer == true) {
						frame.remove(Fnds.get(3).top().card);
						Fnds.get(3).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					transfer = false;
					tabPressed = false;
					tabIndex = 0;
					cardIndex = 0;
				}
				if (wpPressed == true) {
					WPtoFndChecker(3);
					if (!Fnds.get(3).isMT()) {
						Foundation_3.setIcon(new ImageIcon(GUI.class.getResource(Fnds.get(3).top().Img)));
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(WP.top().Img)));
					}
					wpPressed = false;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, Foundation_3, 6, SpringLayout.EAST, Foundation_2);
		Foundation_3.setIcon(new ImageIcon(GUI.class.getResource("/resources/red_back.png")));
		frame.getContentPane().add(Foundation_3);
		
		Tab0(Tabs.get(0).size());
		Tab1(Tabs.get(1).size());
		Tab2(Tabs.get(2).size());
		Tab3(Tabs.get(3).size());
		Tab4(Tabs.get(4).size());
		Tab5(Tabs.get(5).size());
		Tab6(Tabs.get(6).size());
	}
	
	public void Tab0(int num) {
		JButton Tableau_0;
		for(int i = 0; i < num; i++, T0space += 30) {
			Tableau_0 = new JButton("");
			Tableau_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 0;
						cardIndex = Tabs.get(0).size()-1;
					}
					else if (tabPressed == true && tabIndex != 0) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 0);
						if (transfer == true) {
							frame.remove(Tabs.get(0).top().card);
							Tabs.get(0).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(0);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.EAST, Tableau_0, 0, SpringLayout.EAST, Foundation_0);
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_0, 0, SpringLayout.NORTH, Foundation_0);
			Tableau_0.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(0).get(i).Img)));
			frame.getContentPane().add(Tableau_0);
			Tabs.get(0).get(i).card = Tableau_0;
		}
	}
	
	public void Tab1(int num) {
		JButton Tableau_1;
		for(int i = 0; i < num; i++, T1space += 30) {
			Tableau_1 = new JButton("");
			Tableau_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 1;
						cardIndex = Tabs.get(1).size()-1;
					}
					else if (tabPressed == true && tabIndex != 1) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 1);
						if (transfer == true) {
							frame.remove(Tabs.get(1).top().card);
							Tabs.get(1).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(1);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						//Tabs.get(index);
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, 0, SpringLayout.NORTH, Tableau_1);
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, T1space, SpringLayout.SOUTH, Foundation_1);
			Tableau_1.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(1).get(i).Img)));
			springLayout.putConstraint(SpringLayout.EAST, Tableau_1, 0, SpringLayout.EAST, Foundation_1);
			frame.getContentPane().add(Tableau_1);
			Tabs.get(1).get(i).card = Tableau_1;
		}
	}
	
	public void Tab2(int num) {
		JButton Tableau_2;
		for(int i = 0; i < num; i++, T2space += 30) {
			Tableau_2 = new JButton("");
			Tableau_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 2;
						cardIndex = Tabs.get(2).size()-1;
					}
					else if (tabPressed == true && tabIndex != 2) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 2);
						if (transfer == true) {
							frame.remove(Tabs.get(2).top().card);
							Tabs.get(2).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(2);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_2, T2space, SpringLayout.SOUTH, Foundation_2);
			Tableau_2.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(2).get(i).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_2, 0, SpringLayout.WEST, Foundation_2);
			frame.getContentPane().add(Tableau_2);
			Tabs.get(2).get(i).card = Tableau_2;
		}
	}
	
	public void Tab3(int num) {
		JButton Tableau_3;
		for(int i = 0; i < num; i++, T3space += 30) {
			Tableau_3 = new JButton("");
			Tableau_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 3;
						cardIndex = Tabs.get(3).size()-1;
					}
					else if (tabPressed == true && tabIndex != 3) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 3);
						if (transfer == true) {
							frame.remove(Tabs.get(3).top().card);
							Tabs.get(3).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(3);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_3, T3space, SpringLayout.SOUTH, Foundation_3);
			Tableau_3.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(3).get(i).Img)));
			springLayout.putConstraint(SpringLayout.EAST, Tableau_3, 0, SpringLayout.EAST, Foundation_3);
			frame.getContentPane().add(Tableau_3);
			Tabs.get(3).get(i).card = Tableau_3;
		}
	}
	
	public void Tab4(int num) {
		JButton Tableau_4;
		for(int i = 0; i < num; i++, T4space += 30) {
			Tableau_4 = new JButton("");
			Tableau_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 4;
						cardIndex = Tabs.get(4).size()-1;
					}
					else if (tabPressed == true && tabIndex != 4) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 4);
						if (transfer == true) {
							frame.remove(Tabs.get(4).top().card);
							Tabs.get(4).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(4);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_4, T4space, SpringLayout.SOUTH, btnWastePile);
			Tableau_4.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(4).get(i).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_4, 5, SpringLayout.EAST, Tabs.get(3).get(0).card);
			frame.getContentPane().add(Tableau_4);
			Tabs.get(4).get(i).card = Tableau_4;
		}
	}
	
	public void Tab5(int num) {
		JButton Tableau_5;
		for(int i = 0; i < num; i++, T5space += 30) {
			Tableau_5 = new JButton("");
			Tableau_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 5;
						cardIndex = Tabs.get(5).size()-1;
						frame.getContentPane().remove(Tabs.get(5).get(cardIndex).card);
						Tabs.get(5).get(cardIndex).card.setVisible(false);
					}
					else if (tabPressed == true && tabIndex != 5) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 5);
						if (transfer == true) {
							frame.remove(Tabs.get(5).top().card);
							Tabs.get(5).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(5);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_5, T5space, SpringLayout.SOUTH, btnWastePile);
			Tableau_5.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(5).get(i).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_5, 6, SpringLayout.EAST, Tabs.get(4).get(0).card);
			frame.getContentPane().add(Tableau_5);
			Tabs.get(5).get(i).card = Tableau_5;
		}
	}
	
	public void Tab6(int num) {
		JButton Tableau_6;
		for(int i = 0; i < num; i++, T6space += 30) {
			Tableau_6 = new JButton("");
			Tableau_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 6;
						cardIndex = Tabs.get(6).size()-1;
					}
					else if (tabPressed == true && tabIndex != 6) {
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 6);
						if (transfer == true) {
							frame.remove(Tabs.get(6).top().card);
							Tabs.get(6).top().card = null;
							frame.revalidate();
							frame.repaint();
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						WPtoTabChecker(6);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
					}
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_6, T6space, SpringLayout.SOUTH, btnWastePile);
			springLayout.putConstraint(SpringLayout.WEST, Tableau_6, 5, SpringLayout.EAST, Tabs.get(5).get(0).card);
			Tableau_6.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(6).get(i).Img)));
			frame.getContentPane().add(Tableau_6);
			Tabs.get(6).get(i).card = Tableau_6;
		}
	}
}
