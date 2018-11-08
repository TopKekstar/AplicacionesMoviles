package kekstar.fdi.nine11_pc;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

public class ImagePC implements Image {
    public ImagePC(java.awt.Image img) {
        this._image = img;
    }

    @Override
    public int getWidth() { return _image.getWidth(null); }
    @Override
    public int getHeight() {
        return _image.getHeight(null);
    }

    public java.awt.Image get_AwtImage() {
        return _image;
    }

    java.awt.Image _image;
}
