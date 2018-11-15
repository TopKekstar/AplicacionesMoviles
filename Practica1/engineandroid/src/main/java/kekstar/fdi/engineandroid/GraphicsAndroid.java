package kekstar.fdi.engineandroid;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.io.InputStream;

import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

import static android.content.ContentValues.TAG;

public class GraphicsAndroid implements Graphics  {
    private SurfaceView surfaceView_;
    private AssetManager assetManager_;
    private SurfaceHolder surfaceHolder_;
    private Canvas currentCanvas_;
    public GraphicsAndroid(SurfaceView surfaceView,AssetManager assetManager){
        assetManager_ = assetManager;
        surfaceView_ = surfaceView;
        surfaceHolder_ = surfaceView_.getHolder();


    }


    @Override
    public void clear(int color) {
        while (!surfaceHolder_.getSurface().isValid()){}
        currentCanvas_ = surfaceHolder_.lockCanvas();
        currentCanvas_.drawColor(0xFF000000);


    }

    @Override
    public int getWidth() {
        return surfaceView_.getWidth();
    }

    @Override
    public int getHeight() {
        return surfaceView_.getHeight();
    }

    @Override
    public boolean drawImage(Image im, Rect dest, Rect source) {
        android.graphics.Rect dest2 = new android.graphics.Rect(
                dest.get_x(),
                dest.get_y(),
                dest.get_x()+dest.get_width(),
                dest.get_y()+dest.get_height());
        android.graphics.Rect src2 = new android.graphics.Rect(
                source.get_x(),
                source.get_y(),
                source.get_x()+source.get_width(),
                source.get_y()+source.get_height());

        ImageAndroid img = (ImageAndroid) im;

        currentCanvas_.drawBitmap(img.getBitmap(),src2,dest2,null);


        dest2 = null;
        src2 = null;

        return true;
    }

    @Override
    public Image newImage(String name) {
        ImageAndroid img = null;
        Bitmap sprite_ ;

        try {
            InputStream inputStream = assetManager_.open(name);
            sprite_ = BitmapFactory.decodeStream(inputStream);
            img = new ImageAndroid(sprite_);
            inputStream.close();
        }catch (IOException e){
            Log.d(TAG, "newImage: "+ e.getMessage());

            

        }



        return img;
    }

    @Override
    public void present() {

        surfaceHolder_.unlockCanvasAndPost(currentCanvas_);


    }


}
