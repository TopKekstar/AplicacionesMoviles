package kekstar.fdi.gamepc;

import javax.swing.JFrame;
import kekstar.fdi.nine11_pc.*;
import kekstar.fdi.engine.*;
import kekstar.fdi.nine11_logic.*;

public class GamePC implements Game{
    public GamePC(GraphicsPC _graphics, InputPC _input) {
        this._graphics = _graphics;
        this._input = _input;
    }

    //TODO: El main solo tiene que inicializar Graphics, Input y Lógica. Lógica tiene el bucle de juego.
    public static void main (String [] args)
    {
        System.out.print("Init Game..");
        GraphicsPC g = new GraphicsPC(new JFrame("Nine11"));
        //TODO: Input I = declaration
        Logic l = new Logic(new GamePC(g, null));
        l.initLogic();

        while(true) l.run();



    }
    @Override
    public Graphics getGraphics(){
        return _graphics;
    }
    @Override
    public Input getInput() {
        return _input;
    }

    GraphicsPC _graphics;
    InputPC _input;

}
