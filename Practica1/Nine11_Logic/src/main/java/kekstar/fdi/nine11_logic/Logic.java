package kekstar.fdi.nine11_logic;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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

        loadSpritesheet();
        _scenes = new Stack<Scene>();
        _scenes.push(new Scene("Prueba", 0, sprites, 20, 25));

    }
    public void run()
    {
        pollEvents();

        
        _scenes.peek().draw(_game.getGraphics());
        _game.getGraphics().present();
    }

    public void pollEvents(){
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if(temp!=null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    System.out.print("EVENT RECIEVED:\n");
                    System.out.print("Event type: " + tE.get_eventType() + "\n");
                    System.out.print("Button Pressed: " + tE.get_buttonIndex() + "\n");
                    temp.remove(tE);
                }
            }
        }

    }

    void loadSpritesheet(){
        sprites = new ArrayList<>();
        Image spritesheet = _game.getGraphics().newImage("Assets/ASCII_05.png");
        for (int i = 0; i < 16; i++) {
            for(int j = 0; j < 16; j++) {
                Sprite temp = new Sprite(spritesheet, new Rect(16 * j, 16 * i, 16, 16));
                sprites.add(temp);
            }
        }
    }

    Game _game;
    ArrayList<Sprite> sprites;
    Stack<Scene> _scenes;

}

