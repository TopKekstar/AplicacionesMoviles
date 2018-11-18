package kekstar.fdi.nine11_logic;

import java.util.List;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.TouchEvent;

public class GameOverState extends GameState{
    private Game _game;
    private Logic _logic;
    int i = 0;
    int j = 0;


    public GameOverState(Game g, Logic l) {
        this._game = g;
        this._logic = l;


    }
    @Override
    public void tick()  {
        pollEvents();

    }


    @Override
    public void init() {

        String instrucciones = "HA CONSEGUIDO "+ _logic.get_currentScore()+"\n";
        if(_logic.get_currentScore()>_logic.get_maxScore()) {
            instrucciones += "HA REVENTADO EL PUTO RECORD!!!\n\n\n";
            _logic.set_maxScore(_logic.get_currentScore());
            _logic.set_currentScore(0);
        }

        screen = new Screen(_game, _logic);
        screen.init(25,45);

        screen.print(instrucciones, 0,0,color.LIGHTGREEN);
        screen.print("Pulse para empezar...", 0, screen.get_rows()-5, color.RED);


    }
    @Override
    public void pollEvents () {
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if (temp != null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    if(tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex()== 1){
                        _logic.changeState(1);
                    }
                    temp.remove(tE);
                }
            }
        }
    }


    @Override
    public void deinit() {

    }

}
