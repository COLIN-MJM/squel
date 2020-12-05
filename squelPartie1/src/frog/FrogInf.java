package frog;

import environmentStudy.Lane;
import gameCommons.Game;
import util.Case;
import util.Direction;

public class FrogInf extends Frog {

    private Game game;
    private Case emplacement;
    private Direction direction;

    public FrogInf(Game game) {
        super(game);
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
        } else if (key.equals(Direction.left) && getPosition().absc>0) {
            this.emplacement = new Case (getPosition().absc - 1, getPosition().ord);
        } else if (key.equals(Direction.right) && getPosition().absc<game.width - 1) {
            this.emplacement = new Case (getPosition().absc + 1, getPosition().ord);
        }
    }
}
