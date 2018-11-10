package kekstar.fdi.nine11_logic;



import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;
import kekstar.fdi.engine.TouchEvent;
//TODO: Implementar Lógica y su bucle de juego.

public class Logic {

    public Logic(Game game)
    {
        this._game = game;
    }

    public void initLogic()
    {
        sprites = new ArrayList<>();
        Image spritesheet = _game.getGraphics().newImage("./Assets/ASCII_05.png");
        for (int i = 0; i < 16; i++) {
            for(int j = 0; j < 16; j++) {
                Sprite temp = new Sprite(spritesheet, new Rect(16 * j, 16 * i, 16, 16));
                sprites.add(temp);
            }
        }

    }
    public void run()
    {
        pollEvents();





        String prueba = new String("HOLA GUINDILLA");
        _game.getGraphics().clear(0x00000000);
        int margin = 16;
        int i = 0;
        int j = 0;
        for (int x = 0; x < prueba.length(); x++){
            sprites.get(prueba.charAt(x)).draw(_game.getGraphics(), new Rect(x*16, 32, 16, 16));
        }

        sprites.get(65).draw(_game.getGraphics(),new Rect(32,0, 32,32));
        _game.getGraphics().present();

    }

    public void pollEvents(){
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();

        for(TouchEvent tE : temp ){
            synchronized (this){
                System.out.print("EVENT RECIEVED:\n");
                System.out.print("Event type: " +tE.get_eventType()+ "\n");
                temp.remove(tE);
            }
        }

    }

    Game _game;
    ArrayList<Sprite> sprites;

}

