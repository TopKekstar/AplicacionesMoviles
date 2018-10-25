package kekstar.fdi.engine;

public interface Graphics {
    public void clear(int color);
    public int getWidth();
    public int getHeight();
    public boolean drawImage (Image im, Rect dest, Rect source);
    Image newImage(String name);
}
