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
}