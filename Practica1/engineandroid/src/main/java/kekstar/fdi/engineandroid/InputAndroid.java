package kekstar.fdi.engineandroid;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import kekstar.fdi.engine.Input;
import kekstar.fdi.engine.TouchEvent;

import static android.content.ContentValues.TAG;

public class InputAndroid implements Input,View.OnTouchListener {

    public InputAndroid(){
        touchEvents = new LinkedList<>();

    }
    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchEvents;
    }

    @Override
    public void release() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean insert = false;
        TouchEvent.eventType eventType=null;
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                eventType = TouchEvent.eventType.BUTTON_PRESSED;
                insert = true;
                break;
            case MotionEvent.ACTION_UP:
                eventType = TouchEvent.eventType.BUTTON_RELEASED;
                insert = true;
                break;
        }
        if(insert) {
            TouchEvent touchEvent = new TouchEvent(
                    event.getActionIndex()+1, //+1 TO adjust to the same scheme as java PC
                    eventType,
                    (int) event.getX(),
                    (int) event.getY());


            synchronized (this) {
                touchEvents.addLast(touchEvent);
            }
        }

        return true;
    }
    LinkedList<TouchEvent> touchEvents;
}
