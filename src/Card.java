import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

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
	protected String FaceImg = null;
	protected String BackImg = null;
	protected String Img = null;

	public Card (String suit, int value){
		this.suit = suit;
		this.value = value;
		if(suit == "S" || suit == "C")
			this.color = "Black";
		else
			this.color = "Red";

		// Set card to show back side of card
		this.BackImg = "resources//red_back.png";
		Img = BackImg;
		
	}

	public void faceUp(boolean choice) {
		if (choice == true) {
			this.faceDown = false;
			this.Img = this.FaceImg;

		}
		else {
			this.faceDown = true;
			this.Img = this.BackImg;

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


	// Getter for faceDown
	public boolean getFaceDown() {
		return faceDown;
	}
}
