package kekstar.fdi.nine11_logic;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
        _scenes = new LinkedList<>();
        _activeScene = 0;
        _scenes.push(new Scene("Prueba", 0, sprites, 20, 25, this));
    }
    public boolean run()
    {

        pollEvents();


        _scenes.get(_activeScene).tick();
        _scenes.get(_activeScene).draw(_game.getGraphics());
        _game.getGraphics().present();


        return true;
    }

    private void onClick()
    {

    }

    private void pollEvents(){
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

   private void loadSpritesheet(){
        sprites = new ArrayList<>();
        Random rnd = new Random();
        int n = rnd.nextInt(15)+1;
        Image spritesheet = _game.getGraphics().newImage("Assets/ASCII_"+n+".png");
        for (int i = 0; i < 16; i++) {
            for(int j = 0; j < 16; j++) {
                Sprite temp = new Sprite(spritesheet, new Rect(16 * j, 16 * i, 16, 16));
                sprites.add(temp);
            }
        }
    }
    public void setGamedificulty(int difficulty, int height){
        _gameDif = difficulty;
        _gameHeight = height;
    }


    Game _game;
    ArrayList<Sprite> sprites;
    LinkedList<Scene> _scenes;
    int _activeScene;
    int _gameDif;
    int _gameHeight;

}

