package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import gameCommons.Main;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case emplacement;
	private Direction direction;

	public Frog(Game game) {
		this.game = game;
		this.emplacement = new Case(13, 0);
		this.direction = Direction.up;
	}


	@Override
	public Case getPosition() {
		return this.emplacement;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public void move(Direction key) {
		if (key.equals(Direction.up)) {
			this.emplacement = new Case (getPosition().absc, getPosition().ord + 1);
		} else if (key.equals(Direction.down)) {
			if(getPosition().ord != 0) {
				this.emplacement = new Case (getPosition().absc, getPosition().ord - 1);
			}
		} else if (key.equals(Direction.left)) {
			this.emplacement = new Case (getPosition().absc - 1, getPosition().ord);
		} else if (key.equals(Direction.right)) {
			this.emplacement = new Case (getPosition().absc + 1, getPosition().ord);
		}
	}
}
