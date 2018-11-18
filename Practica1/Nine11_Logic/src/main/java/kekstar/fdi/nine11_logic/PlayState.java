package kekstar.fdi.nine11_logic;


import java.util.Random;

import kekstar.fdi.engine.Game;
enum substate {
    build,
    play,
    landing,
    end;
}
public class PlayState extends GameState {

    Pair _planePos;
    boolean built;
    substate _actState;
    int buildings[];


    public PlayState(Game game, Logic logic)
    {
        _game = game;
        _logic = logic;

    }

    @Override
    void tick() {

    }

    @Override
    void init() {
        screen = new Screen(_game, _logic);
        screen.init(25,20);
        buildings = new int[11];

        built = false;
        _actState = substate.build;
        _planePos = new Pair(1,1);

        Random rand = new Random();
        for(int i = 0; i < buildings.length; i++){
            buildings[i] = _logic.get_gameDif()+rand.nextInt(8);
        }

        for(int i = 0; i < screen.get_cols(); i++){
            screen.print("_",i,screen.get_rows()-2, color.WHITE);
        }
        screen.print("PUNTOS",0, screen.get_rows()-1, color.WHITE);
        screen.print("MAX 0", screen.get_cols()- 5, screen.get_rows()-1, color.WHITE);

    }



    @Override
    void deinit() {

    }

    @Override
    void pollEvents() {

    }
}
