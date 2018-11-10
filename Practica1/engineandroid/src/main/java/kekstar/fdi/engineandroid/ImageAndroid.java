package kekstar.fdi.engineandroid;
import kekstar.fdi.engine.Image;
import android.graphics.Bitmap;
public class ImageAndroid implements Image {
    private Bitmap sprite_;

    public ImageAndroid(Bitmap sprite){
        sprite_ = sprite;
    }

    @Override
    public int getWidth() {
        return sprite_.getWidth();
    }

    @Override
    public int getHeight() {
        return sprite_.getHeight();
    }

    public Bitmap getBitmap(){
        return sprite_;
    }


}
