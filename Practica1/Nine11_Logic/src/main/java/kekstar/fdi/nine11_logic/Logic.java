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
        sprites = new ArrayList<ArrayList<Sprite>>();
        images = new ArrayList<>();
        _states = new LinkedList<>();

        loadSpritesheets();
        _activeScene = 0;
        _states.push(new InstructionsState(_game, this));
        _states.get(0).init();
    }
    public boolean run()
    {

        pollEvents();
        _states.get(_activeScene).tick();
        _states.get(_activeScene).draw();
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

   private void loadSpritesheets(){

       int n = 0;
       for (n = 0; n < 16; n++) {

           Image spritesheet = _game.getGraphics().newImage("Assets/ASCII_" + n + ".png");
           images.add(spritesheet);
           ArrayList<Sprite> sSheet = new ArrayList<>();

           for (int i = 0; i < 16; i++) {
               for (int j = 0; j < 16; j++) {
                   Sprite temp = new Sprite(spritesheet, new Rect(16 * j, 16 * i, 16, 16));
                   sSheet.add(temp);
               }
           }

           sprites.add(sSheet);
       }
    }
    public void setGamedificulty(int difficulty, int height){
        _gameDif = difficulty;
        _gameHeight = height;
    }
    public Sprite getSprite(int color, char character){
        return sprites.get(color).get(character);
    }


    Game _game;
    ArrayList<ArrayList<Sprite>> sprites;
    ArrayList<Image>images;
    LinkedList<GameState> _states;
    int _activeScene;
    int _gameDif;
    int _gameHeight;

}

