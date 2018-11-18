package kekstar.fdi.nine11_logic;



import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

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
        _activeState = 0;
        _states.add(new InstructionsState(_game, this));
        _states.add(new DificultyState(_game, this));
        _states.add(new SpeedState(_game, this));
        _states.add(new PlayState(_game, this));
        _states.add(new GameOverState(_game, this));


        _states.get(0).init();
    }
    public boolean run()
    {
        _states.get(_activeState).tick();
        _states.get(_activeState).draw();
        _game.getGraphics().present();



        return true;
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


    public void changeState(int nState){

        try {
            int temp = _activeState;
            _activeState = nState;
            _states.get(temp).deinit();
            _states.get(_activeState).init();
        }
        catch(Exception e){
            System.out.println("Could not Load new State. State was nullptr");
            System.out.print(e.getMessage());

        }
    }
    public void calculateTileSize() {
        _states.get(_activeState).calculateTileSize();
    }
    public int get_activeState() {
        return _activeState;
    }

    public void set_gameDif(int ndif){
        _gameDif = ndif;
    }
    public int get_gameDif(){
        return _gameDif;
    }
    public void set_gameHeight(int nHeight){
        _gameHeight = nHeight;
    }

    public int get_gameHeight(){
        return _gameHeight;
    }
    public int get_gameSpeed() {
        return _gameSpeed;
    }

    public void set_gameSpeed(int gameSpeed) {
        this._gameSpeed = gameSpeed;
    }


    Game _game;
    ArrayList<ArrayList<Sprite>> sprites;
    ArrayList<Image>images;

    LinkedList<GameState> _states;

    int _activeState;
    int _gameDif;
    int _gameHeight;
    int _gameSpeed;
    private int _currentScore;

    public int get_currentScore() {
        return _currentScore;
    }

    public void set_currentScore(int _currentScore) {
        this._currentScore = _currentScore;
    }

    public int get_maxScore() {
        return _maxScore;
    }

    public void set_maxScore(int _maxScore) {
        this._maxScore = _maxScore;
    }

    private int _maxScore;

}

