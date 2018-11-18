package kekstar.fdi.nine11_logic;

public class Pair {

    public Pair(int xn, int yn){
        x = xn;
        y = yn;
    }
    public boolean isEqual (Pair aux)
    {
        return (aux.getX() == x && aux.getY() == y);
    }
    int getX(){return x;}
    int getY(){return y;}
    int x;
    int y;
}
