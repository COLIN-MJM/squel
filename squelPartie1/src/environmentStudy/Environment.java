package environmentStudy;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
	private ArrayList<Lane> lanes;
	private Game game;

    public Environment(Game game){
        this.lanes=new ArrayList<>();
        this.game = game;
        for(int i=0; i<game.height; i++){
            lanes.add(new Lane(game,i));
        }
    }

    //TODO
    @Override
    public boolean isSafe(Case c){
        for(Lane l : lanes){
            if(!l.isSafe(c)) return false;
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        if(c.ord == game.height-1) return true;
        return false;
    }

    @Override
    public void update() {
        for(Lane l : lanes){
            if(l.getOrd()!=0 && l.getOrd()!=game.height-1) l.update();
        }
    }

}
