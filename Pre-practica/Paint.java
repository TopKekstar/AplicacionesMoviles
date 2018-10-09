import java.awt.*;
import javax.swing.*;
import javax.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;


public class Paint extends JFrame {

    public static void main (String[] args)
    {
        Paint ventana = new Paint("Hola");
        ventana.init();
        ventana.setVisible(true);
    }
    public void paint(Graphics g)
    {
        _x += _incX;
        if(_x < 0) {
            _x = -_x;
            _incX *=-1;
        }
        else if (_x + _imageWidth > getWidth())
        {
            _x = 2*(getWidth()- _imageWidth)-_x;
            _incX *= -1;
        }
        g.drawImage(_logo, _x, 200, null);


        repaint();
        System.out.println("Tengo que pintarme");
    }
    public Paint(String title)
    {
        super(title);
    }
    public void init()
    {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            _logo = javax.imageio.ImageIO.read(new java.io.File("beer.png"));    
            _imageWidth = _logo.getWidth(null);
        } catch (Exception e) {
           System.out.println(e);
        }
        
    }
    
    Image _logo;
    int _x = 0;
    int _incX = 5;
    int _imageWidth;

}