import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;


public class Card {

	// Attributes
	protected String suit;
	protected int value;
	protected String color;
	private boolean faceDown = true;
	protected boolean grabbable = false;
	protected BufferedImage FaceImg = null;
	protected BufferedImage BackImg = null;
	protected BufferedImage Img = null;
	
	public Card (String suit, int value){
		this.suit = suit;
		this.value = value;
		if(suit == "S" || suit == "C")
			this.color = "Black";
		else
			this.color = "Red";
		
		// Set card to show back side of card
		try { this.BackImg = ImageIO.read(new File("Deck//red_back.png")); } catch (IOException e) {}
		Img = BackImg;
		resize(Img, 20, 40);
	}

	public void faceUp(boolean choice) {
		if (choice == true) {
			this.faceDown = false;
			this.Img = this.FaceImg;
			resize(this.Img, 20, 40);
		}
		else {
			this.faceDown = true;
			this.Img = this.BackImg;
			resize(Img, 20, 40);
		}
	}

	public String toString(){
		String grab;
		if (grabbable == true)
			grab = "+";
		else
			grab = "_";
		return String.format("%s%s%s", suit, value, grab);
	}
	
	//JAVAFX
	public void resize(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = tempImg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		
		img = tempImg;
	}
	
	// Getter for faceDown
	public boolean getFaceDown() {
		return faceDown;
	}
}
