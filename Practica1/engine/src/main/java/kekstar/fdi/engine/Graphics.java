package kekstar.fdi.engine;

public interface Graphics {
    void clear(int color);
    int getWidth();
    int getHeight();
    boolean drawImage (Image im, Rect dest, Rect source);
    Image newImage(String name);
    void present();
}
