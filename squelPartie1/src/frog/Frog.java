package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case emplacement;
	private Direction direction;

	public Frog(Game game, Case emplacement, Direction direction) {
		this.game = game;
		this.emplacement = new Case (0, 13);
		this.direction = direction;
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
		if (key == Direction.up) {
			this.getPosition().ord = this.getPosition().ord + 1;
		} else if (key == Direction.down) {
			this.getPosition().ord = this.getPosition().ord - 1;
		} else if (key == Direction.left) {
			this.getPosition().absc = this.getPosition().absc - 1;
		} else if (key == Direction.right) {
			this.getPosition().absc = this.getPosition().absc + 1;
		}
	}
}
