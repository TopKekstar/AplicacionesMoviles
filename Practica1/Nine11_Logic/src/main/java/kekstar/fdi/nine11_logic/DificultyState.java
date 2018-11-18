package kekstar.fdi.nine11_logic;
import java.util.List;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.TouchEvent;

public class DificultyState extends GameState {

    public DificultyState(Game g, Logic logic){
        this._game = g;
        this._logic = logic;
    }


    @Override
    void tick() {
        pollEvents();

    }

    @Override
    void init() {
        screen = new Screen(_game, _logic);
        screen.init(25,45);

        String aux = "Elija un nivel: 0 (AS) - 5 (principiante)";
        int Ystart = (screen.get_rows()/2)-1;
        int Xstart = (screen.get_cols()-aux.length())/2 ;

        screen.print(aux, Xstart, Ystart, color.RED);

        aux = "0 1 2 3 4 5";
        Xstart = (screen.get_cols()-aux.length())/2;

        screen.print( aux, Xstart,Ystart+2, color.WHITE);
    }

    @Override
    void deinit() {

    }

    @Override
    void pollEvents() {
        List<TouchEvent> temp;
        synchronized (this) {

            temp = _game.getInput().getTouchEvents();
            if (temp != null) {
                for (TouchEvent tE : temp) {

                    if (tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex() == 1) {

                        char touched = screen.getCharAtScreenCoords(tE.getX(), tE.getY());
                        if ((int) touched > 47 && (int) touched < 54) {
                            _logic.set_gameDif(((int) touched - 48));
                            _logic.changeState(_logic.get_activeState() + 1);
                        }
                    }
                    temp.remove(tE);
                }
            }
        }

    }
}
