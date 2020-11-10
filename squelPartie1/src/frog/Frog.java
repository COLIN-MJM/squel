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
		this.emplacement = emplacement;
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
			this.emplacement.ord = this.emplacement.ord++;
		} else if (key == Direction.down) {
			this.emplacement.ord = this.emplacement.ord--;
		} else if (key == Direction.left) {
			this.emplacement.absc = this.emplacement.absc--;
		} else if (key == Direction.right) {
			this.emplacement.absc = this.emplacement.absc++;
		}
	}
}
