package kekstar.fdi.engineandroid;
import android.view.MotionEvent;
import android.view.View;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import kekstar.fdi.engine.Input;
import kekstar.fdi.engine.TouchEvent;

public class InputAndroid implements Input,View.OnTouchListener {
    InputAndroid(){
        touchEvents = new LinkedList<TouchEvent>();
    }
    @Override
    public List<TouchEvent> getTouchEvents() {
        return null;
    }

    @Override
    public void release() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
    List<TouchEvent> touchEvents;
}
