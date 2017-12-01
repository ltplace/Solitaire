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
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					if (transfer == true) {
						System.out.println(Fnds.get(0).top().card);
						frame.remove(Fnds.get(0).top().card);
						Fnds.get(0).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						if(Tabs.get(tabIndex).space != 49 || Tabs.get(tabIndex).space != 0) {
							Tabs.get(tabIndex).space -= 30;
						}
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
						System.out.println(Fnds.get(1).top().card);
						frame.remove(Fnds.get(1).top().card);
						Fnds.get(1).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						if(Tabs.get(tabIndex).space != 49 || Tabs.get(tabIndex).space != 0) {
							Tabs.get(tabIndex).space -= 30;
						}
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
					boolean transfer = FndMoveChecker(tabIndex, 2);
					if (!Main.Fnds.get(2).isMT()) {
						Foundation_2.setIcon(new ImageIcon(GUI.class.getResource(Main.Fnds.get(2).top().Img)));
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
					}
					if (transfer == true) {
						System.out.println(Fnds.get(2).top().card);
						frame.remove(Fnds.get(2).top().card);
						Fnds.get(2).top().card = null;
						frame.revalidate();
						frame.repaint();
						Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						if(Tabs.get(tabIndex).space != 49 || Tabs.get(tabIndex).space != 0) {
							Tabs.get(tabIndex).space -= 30;
						}
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
						System.out.println(Fnds.get(3).top().card);
						frame.remove(Fnds.get(3).top().card);
						Fnds.get(3).top().card = null;
						frame.revalidate();
						frame.repaint();
						if (Tabs.get(tabIndex).isMT()) {	//FIXME
							
						}
						else {
							Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
						}
						if(Tabs.get(tabIndex).space != 49 || Tabs.get(tabIndex).space != 0) {
							Tabs.get(tabIndex).space -= 30;
						}
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
		
		// Create columns
		Tabs.get(0).space = 0;
		Tab1(Tabs.get(1).size(), 0);
		Tab0(Tabs.get(0).size(), 0);
		Tab2(Tabs.get(2).size(), 0);
		Tab3(Tabs.get(3).size(), 0);
		Tab4(Tabs.get(4).size(), 0);
		Tab5(Tabs.get(5).size(), 0);
		Tab6(Tabs.get(6).size(), 0);
	}
	
	public void Tab0(int num, int k) {
		JButton Tableau_0;
		for(int i = 0; i < num; i++) {
			int index = k;
			int indexInsideLoop = index;
			Tableau_0 = new JButton("");
			Tableau_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 0;
						cardIndex = indexInsideLoop;
					}
					else if (tabPressed == true && tabIndex != 0) {
						int sBefore = Tabs.get(0).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 0);
						int sAfter = Tabs.get(0).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(0).get(Tabs.get(0).size()-i).card);
								Tabs.get(0).get(Tabs.get(0).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
							if (Tabs.get(tabIndex).space != 0) 
								Tabs.get(tabIndex).space -= 30;
							}
							Tab0(sBefore - sAfter, Tabs.get(0).size() - (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(0);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab0(1, Tabs.get(0).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.EAST, Tableau_0, 0, SpringLayout.EAST, Foundation_0);
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_0, Tabs.get(0).space, SpringLayout.NORTH, Tabs.get(1).get(0).card);
			Tableau_0.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(0).get(index).Img)));
			frame.getContentPane().add(Tableau_0);
			Tabs.get(0).get(index).card = Tableau_0;
			Tabs.get(0).space += 30;
		}
	}
	
	public void Tab1(int num, final int k) {	//TODO continue to work on indices and fix zero index
		JButton Tableau_1;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_1 = new JButton("");
			Tableau_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 1;
						cardIndex = indexInLoop;
						System.out.println(indexInLoop);
					}
					else if (tabPressed == true && tabIndex != 1) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 1);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(1).get(Tabs.get(1).size()-i).card);
								Tabs.get(1).get(Tabs.get(1).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab1(sBefore - sAfter, Tabs.get(1).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(1);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab1(1, Tabs.get(1).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, 0, SpringLayout.NORTH, Tableau_1);
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_1, Tabs.get(1).space, SpringLayout.SOUTH, Foundation_1);
			Tableau_1.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(1).get(index).Img)));
			springLayout.putConstraint(SpringLayout.EAST, Tableau_1, 0, SpringLayout.EAST, Foundation_1);
			frame.getContentPane().add(Tableau_1);
			Tabs.get(1).get(index).card = Tableau_1;
			Tabs.get(1).space += 30;
		}
	}
	
	public void Tab2(int num, final int k) {
		JButton Tableau_2;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_2 = new JButton("");
			Tableau_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 2;
						cardIndex = indexInLoop;
						System.out.println(indexInLoop);
					}
					else if (tabPressed == true && tabIndex != 2) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 2);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(2).get(Tabs.get(2).size()-i).card);
								Tabs.get(2).get(Tabs.get(2).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab2(sBefore - sAfter, Tabs.get(2).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(2);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab2(1, Tabs.get(2).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_2, Tabs.get(2).space, SpringLayout.SOUTH, Foundation_2);
			Tableau_2.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(2).get(index).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_2, 0, SpringLayout.WEST, Foundation_2);
			frame.getContentPane().add(Tableau_2);
			Tabs.get(2).get(index).card = Tableau_2;
			Tabs.get(2).space += 30;
		}
	}
	
	public void Tab3(int num, final int k) {
		JButton Tableau_3;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_3 = new JButton("");
			Tableau_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 3;
						cardIndex = indexInLoop;;
						System.out.println(indexInLoop);
					}
					else if (tabPressed == true && tabIndex != 3) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 3);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(3).get(Tabs.get(3).size()-i).card);
								Tabs.get(3).get(Tabs.get(3).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab3(sBefore - sAfter, Tabs.get(3).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(3);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab3(1, Tabs.get(3).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_3, Tabs.get(3).space, SpringLayout.SOUTH, Foundation_3);
			Tableau_3.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(3).get(index).Img)));
			springLayout.putConstraint(SpringLayout.EAST, Tableau_3, 0, SpringLayout.EAST, Foundation_3);
			frame.getContentPane().add(Tableau_3);
			Tabs.get(3).get(index).card = Tableau_3;
			Tabs.get(3).space += 30;
		}
	}
	
	public void Tab4(int num, final int k) {
		JButton Tableau_4;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_4 = new JButton("");
			Tableau_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 4;
						cardIndex = indexInLoop;
						System.out.println(indexInLoop);
					}
					else if (tabPressed == true && tabIndex != 4) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 4);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(4).get(Tabs.get(4).size()-i).card);
								Tabs.get(4).get(Tabs.get(4).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img))); //TODO FIXME
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab4(sBefore - sAfter, Tabs.get(4).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(4);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab4(1, Tabs.get(4).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_4, Tabs.get(4).space, SpringLayout.SOUTH, btnWastePile);
			Tableau_4.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(4).get(index).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_4, 5, SpringLayout.EAST, Tabs.get(3).get(0).card);
			frame.getContentPane().add(Tableau_4);
			Tabs.get(4).get(index).card = Tableau_4;
			Tabs.get(4).space += 30;
		}
	}
	
	public void Tab5(int num, final int k) {
		JButton Tableau_5;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_5 = new JButton("");
			Tableau_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 5;
						cardIndex = indexInLoop;
						System.out.println(indexInLoop);
						//frame.getContentPane().remove(Tabs.get(5).get(cardIndex).card);
						//Tabs.get(5).get(cardIndex).card.setVisible(false);
					}
					else if (tabPressed == true && tabIndex != 5) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 5);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(5).get(Tabs.get(5).size()-i).card);
								Tabs.get(5).get(Tabs.get(5).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab5(sBefore - sAfter, Tabs.get(5).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(5);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab5(1, Tabs.get(5).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_5, Tabs.get(5).space, SpringLayout.SOUTH, btnWastePile);
			Tableau_5.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(5).get(index).Img)));
			springLayout.putConstraint(SpringLayout.WEST, Tableau_5, 6, SpringLayout.EAST, Tabs.get(4).get(0).card);
			frame.getContentPane().add(Tableau_5);
			Tabs.get(5).get(index).card = Tableau_5;
			Tabs.get(5).space += 30;
		}
	}
	
	public void Tab6(int num, final int k) {
		JButton Tableau_6;
		for(int i = 0; i < num; i++) {
			int index = k + i;
			int indexInLoop = index;
			Tableau_6 = new JButton("");
			Tableau_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabPressed == false && wpPressed == false) {
						tabPressed = true;
						tabIndex = 6;
						cardIndex = indexInLoop;
						System.out.println(indexInLoop);
					}
					else if (tabPressed == true && tabIndex != 6) {
						int sBefore = Tabs.get(tabIndex).size();
						boolean transfer = TabMoveChecker(tabIndex, cardIndex, 6);
						int sAfter = Tabs.get(tabIndex).size();
						if (transfer == true) {
							for(int i = 1; i < sBefore - sAfter + 1; i++) {
								frame.remove(Tabs.get(6).get(Tabs.get(6).size()-i).card);
								Tabs.get(6).get(Tabs.get(6).size()-i).card = null;
								Tabs.get(tabIndex).top().card.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(tabIndex).top().Img)));
								if (Tabs.get(tabIndex).space != 49) 
									Tabs.get(tabIndex).space -= 30;
							}
							Tab6(sBefore - sAfter, Tabs.get(6).size()- (sBefore - sAfter));
							frame.revalidate();
							frame.repaint();
						}
						tabIndex = 0;
						cardIndex = 0;
						tabPressed = false;
						transfer = false;
					}
					else if (wpPressed == true) {
						boolean transfer = WPtoTabChecker(6);
						btnWastePile.setIcon(new ImageIcon(GUI.class.getResource(Main.WP.top().Img)));
						if (transfer == true) {
							Tab6(1, Tabs.get(6).size()- 1);
							frame.revalidate();
							frame.repaint();
						}
					}
					wpPressed = false;
				}
			});
			springLayout.putConstraint(SpringLayout.NORTH, Tableau_6, Tabs.get(6).space, SpringLayout.SOUTH, btnWastePile);
			springLayout.putConstraint(SpringLayout.WEST, Tableau_6, 5, SpringLayout.EAST, Tabs.get(5).get(0).card);
			Tableau_6.setIcon(new ImageIcon(GUI.class.getResource(Tabs.get(6).get(index).Img)));
			frame.getContentPane().add(Tableau_6);
			Tabs.get(6).get(index).card = Tableau_6;
			Tabs.get(6).space += 30;
		}
	}
}
