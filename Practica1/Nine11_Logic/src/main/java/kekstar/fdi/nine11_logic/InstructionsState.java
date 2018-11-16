package kekstar.fdi.nine11_logic;

import java.sql.Time;
import java.util.List;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.TouchEvent;

public class InstructionsState extends GameState{
    private Game _game;
    private Logic _logic;
    int i = 0;
    int j = 0;


    //TODO: RETIRAR ESTO
    double lastTime;
    double actTime;
    double elapsed;

    public InstructionsState(Game g, Logic l) {
        this._game = g;
        this._logic = l;
        lastTime = System.currentTimeMillis();
        actTime = lastTime;

    }
    @Override
    public void tick()  {
        pollEvents();

    }


    @Override
    public void init() {

        String instrucciones = "Usted esta pilotando un avion sobre una ciudad desierta y tiene que pasar sobre " +
                "los edificios para aterrizar y repostar. Su avion se mueve de izquierda a derecha.\n"+
                "\nAl llegar a la derecha el avion vuelve a salir por la izquierda pero MAS BAJO. Dispone de un numero limitado de bombas"
                + "y puede hacerlas caer sobre los edificios pulsando sobre la pantalla.\n" +
                "\nCada vez que aterriza, sube la altura de los edificios y la velodicad.\n" +
                "\nUNA VEZ DISPARADA UNA BOMBA YA NO PUEDE DISPARAR OTRA MIENTRAS NO HAYA EXPLOSIONADO LA PRIMERA!!!!\n";

        screen = new Screen(_game, _logic);
        screen.init(25,45);

        screen.print(instrucciones, 0,0,color.LIGHTGREEN);
        screen.print("Pulse para empezar...", 0, screen.get_rows()-5, color.RED);

        //Copiamos de color a
    }
    @Override
    public void pollEvents () {
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if (temp != null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    if(tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex()== 1){
                        _logic.changeScene(_logic.get_activeState()+1);
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
