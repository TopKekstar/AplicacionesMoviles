package kekstar.fdi.nine11_logic;

import kekstar.fdi.engine.Game;

public class InstructionsState extends GameState{
    private Game _game;
    private Logic _logic;


    public InstructionsState(Game g, Logic l)
    {
        this._game = g;
        this._logic = l;

    }
    @Override
    public void tick()  {

    }


    @Override
    public void init() {

        String instrucciones = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        screen = new Screen(_game, _logic);
        screen.init(25,45);

        screen.print(instrucciones, 0,0,color.WHITE);

        //Copiamos de color a
    }

    @Override
    public void deinit() {

    }

}
