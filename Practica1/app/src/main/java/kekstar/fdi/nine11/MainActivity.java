package kekstar.fdi.nine11;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Input;
import kekstar.fdi.engine.Rect;
import kekstar.fdi.engineandroid.GraphicsAndroid;
import kekstar.fdi.engineandroid.ImageAndroid;
import kekstar.fdi.engineandroid.InputAndroid;
import kekstar.fdi.nine11_logic.Logic;

public class MainActivity extends AppCompatActivity implements Game {

    protected GraphicsAndroid     graphics_;
    protected InputAndroid        input_;
    private MyView              renderView_;
    private Logic               logic_;
    boolean logicInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AssetManager assetManager = this.getAssets();
        renderView_ = new MyView(this,this);
        setContentView(renderView_);
        graphics_ = new GraphicsAndroid(renderView_,assetManager);
        input_ = new InputAndroid();
        renderView_.setOnTouchListener(input_);
        logicInit = false;
/*
        logic_ = new Logic(this);

        logic_.initLogic();
*/


    }
    @Override
    public void onConfigurationChanged (Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        logic_.calculateTileSize();
    }


    @Override
    protected void onResume(){
        super.onResume();
        renderView_.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        renderView_.pause();
    }

    @Override
    public Graphics getGraphics() {
        return graphics_;
    }

    @Override
    public Input getInput() {
        return input_;
    }

    class MyView extends SurfaceView implements Runnable {
        Game game_;
        public MyView(Context context, Game game) {
            super(context);
            game_=game;

        }

        public void resume(){
            if(!_running){
                _running=true;

                _runningThread = new Thread(this);
                _runningThread.start();

            }
        }
        public void pause(){

            _running = false;
        }



        @Override
        public void run() {
            while (getWidth()<=0){}
            if(!logicInit) {
                logic_ = new Logic(game_);
                logic_.initLogic();
                logicInit = true;
            }
            while (_running){
                logic_.run();
            }

        }

        volatile boolean _running;
        Thread _runningThread;



    }
}
