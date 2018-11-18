package kekstar.fdi.nine11_logic;

import java.util.List;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.TouchEvent;

class SpeedState extends GameState {
    public SpeedState(Game game, Logic logic)

    {
        _game = game;
        _logic = logic;
    }

    @Override
    void tick()
    {
        pollEvents();
    }

    @Override
    void init()
    {
        screen = new Screen(_game, _logic);
        screen.init(25,45);

        String aux = "Elija una velocidad: 0 (MAX) a 9 (MIN)";

        int Ystart = (screen.get_rows()/2)-1;
        int Xstart = (screen.get_cols()-aux.length())/2 ;

        screen.print(aux, Xstart, Ystart, color.RED);

        aux = "0 1 2 3 4";
        String aux2 = "5 6 7 8 9";
        Xstart = (screen.get_cols()-aux.length())/2;

        screen.print(aux, Xstart,Ystart+2, color.WHITE);
        screen.print(aux2, Xstart, Ystart+4, color.WHITE);

    }

    @Override
    void deinit()
    {

    }

    @Override
    void pollEvents()
    {
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if (temp != null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    if(tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex()== 1){
                        char touched = screen.getCharAtScreenCoords(tE.getX(), tE.getY());
                        if((int)touched >47 && (int)touched < 58) {
                            _logic.set_gameSpeed(((int)touched-48));
                            _logic.changeState(_logic.get_activeState()+1);
                        }
                    }
                    temp.remove(tE);
                }
            }
        }

    }
}
