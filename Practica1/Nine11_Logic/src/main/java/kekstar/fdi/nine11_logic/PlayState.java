package kekstar.fdi.nine11_logic;


import java.util.List;
import java.util.Random;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.TouchEvent;

enum substate {
    build,
    play,
    landing,
    end;
}
public class PlayState extends GameState {

    boolean built;
    substate _actState;

    int buildings[];
    int buildIndex;
    int buildL;
    long _sleepTime;

    Pair _planePos;
    String _planeDraw;

    Pair _bombPos;
    boolean _bombDropped;
    String _bombPaint;
    int _bomStrenght;


    public PlayState(Game game, Logic logic)
    {
        _game = game;
        _logic = logic;

    }

    @Override
    void tick() {
        pollEvents();
        try {
            Thread.sleep(_sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!built) {
            built = createBuildings();
            if(built) {
                _actState = substate.play;
                _sleepTime=(long) ((10-_logic._gameSpeed)*100);
            }
        }else{
            switch (_actState){
                case play:
                    movePlane();
                    moveBomb();
                    if(checkEndGame())
                        _actState=substate.landing;
                    break;
                case landing:
                    moveBomb();
                    break;
                case end:
                    break;


            }
        }




    }

    @Override
    void init() {
        screen = new Screen(_game, _logic);
        screen.init(25,20);
        buildings = new int[11];
        buildIndex = 0;
        buildL=0;
        char c = 241;
        _planeDraw ="";
        _planeDraw += c;
        c=242;
        _planeDraw += c;
        _sleepTime=(long) (50);
        _bombDropped = false;
        c = 252;
        _bombPaint="";
        _bombPaint +=c;
        _bomStrenght= 0;

        built = false;
        _actState = substate.build;
        _planePos = new Pair(1,1);
        _bombPos = new Pair(0,0);


        Random rand = new Random();
        for(int i = 0; i < buildings.length; i++){
            buildings[i] = _logic.get_gameDif()+rand.nextInt(1)+1;
        }

        for(int i = 0; i < screen.get_cols(); i++){
            screen.print("_",i,screen.get_rows()-2, color.WHITE);
        }
        screen.print("PUNTOS",0, screen.get_rows()-1, color.WHITE);


        screen.print("MAX 0", screen.get_cols()- 5, screen.get_rows()-1, color.WHITE);

    }


    boolean createBuildings(){


        char c;
        String s;
        if(buildings[buildIndex]<=buildL) {
            c = 244;
            s="";
            s+=c;
            screen.print(s,5+buildIndex,22-buildL, color.values()[buildIndex+1]);

            buildIndex++;
            buildL=0;
        }
        if(buildIndex>=11)
            return true;
        c = 143;
        s="";
        s += c;



        screen.print(s,5+buildIndex,22-buildL, color.values()[buildIndex+1]);
        buildL++;

        return false;
    }

    @Override
    void deinit() {

    }

    @Override
    void pollEvents() {
        List<TouchEvent> temp;
        temp = _game.getInput().getTouchEvents();
        if (temp != null) {
            for (TouchEvent tE : temp) {
                synchronized (this) {
                    if(tE.get_eventType() == TouchEvent.eventType.BUTTON_PRESSED && tE.get_buttonIndex()== 1){
                        if(!_bombDropped&&_actState==substate.play){
                            Random rand = new Random();
                            _bombDropped = true;
                            _bombPos.x = 1+_planePos.x;
                            _bombPos.y =1+ _planePos.y;
                            _bomStrenght = rand.nextInt(2)+2;

                        }
                    }
                    temp.remove(tE);
                }
            }
        }
    }

    void movePlane(){
        screen.print("  ",_planePos.x,_planePos.y,color.BLACK);
        _planePos.x++;
        if(_planePos.x>18){
            _planePos.x = 1;
            _planePos.y++;
        }
        if(checkColision(_planePos.x+1,_planePos.y)){
            char c =238;
            String s="";
            s+=c;
            _planePos.x++;
            screen.print(s,_planePos.x,_planePos.y,color.WHITE);
            _actState = substate.end;

        }else{
            screen.print(_planeDraw,_planePos.x,_planePos.y,color.WHITE);
        }

    }
    void moveBomb(){
        if(_bombDropped) {
            screen.print(" ", _bombPos.x, _bombPos.y, color.BLACK);
            _bombPos.y++;
            if(_bombPos.y<23&&!checkColision(_bombPos.x,_bombPos.y)){
                screen.print(_bombPaint, _bombPos.x, _bombPos.y, color.GREEN);
            }else if(checkColision(_bombPos.x,_bombPos.y)&&_bomStrenght > 0){
                char c = 188;
                String s ="";
                s+= c;
                screen.print(s, _bombPos.x, _bombPos.y, color.GREEN);
                buildings[_bombPos.x-5]--;
                _bomStrenght--;
            }else{
                _bombDropped =false;
            }

        }

    }
    boolean checkEndGame(){
        for (int i =0;i< buildings.length;++i){
            if(buildings[i]>0)return false;
        }

        return true;
    }
    boolean checkColision(int posX,int posY){
        char c = screen.getGridCharAt(posX,posY);
        return c==143 || c ==244;
    }
}
