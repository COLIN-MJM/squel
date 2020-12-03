package environmentStudy;

import gameCommons.Game;
import util.Case;

import java.util.ArrayList;

public class EnvInf extends Environment {

    private ArrayList<Lane> lanes;
    private Game game;

    public EnvInf(Game game) {
        super(game);
    }

    @Override
    public boolean isSafe(Case c){
        for(Lane l : lanes){
            if(l.carAtThisPosition(c)) return false;
        }
        return true;
    }

    @Override
    public void update() {
        for(Lane l : lanes){
            l.update();
        }
    }

    public void updateInf() {
        for(Lane l : lanes){
            if(l.getOrd()==0) l.newOrd(game.height-1);
            l.newOrd(l.getOrd()-1);
        }
    }
}