package kekstar.fdi.nine11_pc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import kekstar.fdi.engine.Input;
import kekstar.fdi.engine.TouchEvent;

public class InputPC implements Input, MouseListener {

    public InputPC(JFrame frame) {
        _frame = frame;
        frame.addMouseListener(this);
        this._touchEvents = new LinkedList<TouchEvent>();
    }

    @Override
    public void release(){
        _frame.removeMouseListener(this);
    }

    //TODO: Implementar inputPC y getTouchEvents
    @Override
    public List<TouchEvent> getTouchEvents(){
        return _touchEvents;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        synchronized (this){
            _touchEvents.add(new TouchEvent(mouseEvent.getButton(), TouchEvent.eventType.BUTTON_PRESSED,mouseEvent.getX(),mouseEvent.getY()));
        }
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
    List<TouchEvent> _touchEvents;
    JFrame _frame;
}
