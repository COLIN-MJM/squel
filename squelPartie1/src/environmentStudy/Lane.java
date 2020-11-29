package environmentStudy;

import java.util.ArrayList;
import java.util.Random;

import gameCommons.IEnvironment;
import util.Case;
import gameCommons.Game;
import javax.swing.Timer;


public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private IEnvironment environment;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord){
		Random r = new Random();
		this.game=game;
		this.ord=ord;
		this.speed= game.minSpeedInTimerLoops+r.nextInt(10- game.minSpeedInTimerLoops);
		this.cars = new ArrayList<>();
		this.leftToRight=r.nextBoolean();
		this.density=r.nextDouble();
		this.environment=new Environment(game);
	}

	public void update() {
		for (Car c : this.cars){
			c.avanceCar();
		}
		mayAddCar();
	}

	// TODO : ajout de methodes

	public boolean carAtThisPosition(Case c){
		for(Car v : this.cars) {
			if(v.carHere(c)){
				return true;
			}
		}
		return false;
	}
	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (environment.isSafe(getFirstCase()) && environment.isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
