package kekstar.fdi.nine11_pc;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

public class ImagePC implements Image {
    public ImagePC(java.awt.Image img) {
        this._image = img;
    }

    @Override
    public int getWidth() {
        return _rect.get_width();
    }

    @Override
    public int getHeigth() {
        return _rect.get_width();
    }

    public java.awt.Image get_AwtImage() {
        return _image;
    }

    java.awt.Image _image;
    Rect _rect;
}
