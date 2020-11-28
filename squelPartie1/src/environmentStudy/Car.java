package environmentStudy;

import java.awt.Color;
import java.util.Random;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case c, boolean leftToRight) {
		this.game=game;
		this.leftPosition=c;
		this.leftToRight=leftToRight;
		Random r=new Random();
		this.length=r.nextInt(4);
	}

	//TODO Constructeur(s)
	public boolean carHere(Case c){
		for(int i = leftPosition.absc + 1 ; i<=leftPosition.absc+length; i++){
			Case cNew = new Case(i,leftPosition.ord);
			if(c.equals(cNew)) return true;
		}
		return false;
	}
	//TODO : ajout de methodes
	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight) {
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
