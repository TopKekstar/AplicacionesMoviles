package es.ucm.gdv.holamundo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            AssetManager assetManager = this.getAssets();
            InputStream inputStream = assetManager.open("logo.png");
            _sprite = BitmapFactory.decodeStream(inputStream);
        }
        catch (IOException ioe) {

        }

        _renderView = new MyView(this);
        setContentView(new MyView(this));
    }

    @Override
    protected void onResume(){
        super.onResume();
        _renderView.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        _renderView.pause();
    }




    private MyView _renderView;

    class MyView extends SurfaceView implements Runnable {
        public MyView(Context context) {
            super(context);
            _lastFrameTime = System.nanoTime();
            if (_sprite != null)
                _imageWidth = _sprite.getWidth();
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
            long currentTime;
            long nanoElapsedTime;
            double elapsedTime;
            SurfaceHolder sh = getHolder();
            while (_running){
                currentTime = System.nanoTime();
                nanoElapsedTime = currentTime - _lastFrameTime;
                _lastFrameTime = currentTime;
                elapsedTime = (double) nanoElapsedTime / 1.0e9;
                update(elapsedTime);


                while (!sh.getSurface().isValid()){}

                Canvas canvas = sh.lockCanvas();
                render(canvas);
                sh.unlockCanvasAndPost(canvas);


            }

        }

        protected void update(double elapsedTime){
            _x += _incX * elapsedTime;

            if (_x < 0) {
                _x = -_x;
                _incX *= -1;
            }
            else if (_x > getWidth() - _imageWidth) {
                _x = 2*(getWidth() - _imageWidth) - _x;
                _incX *= -1;
            }

        }



        protected void render(Canvas c){
            if (_sprite != null) {


                c.drawColor(0xFF0000FF);
                c.drawBitmap(_sprite, (int) _x, 100, null);


                invalidate();
            }
        }




        long _lastFrameTime;

        double _x = 0;
        int _incX = 50;
        int _imageWidth;
        volatile boolean _running;
        Thread _runningThread;



    }

    Bitmap _sprite;
}
