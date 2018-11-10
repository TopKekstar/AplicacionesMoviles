package kekstar.fdi.engine;

import java.awt.Event;
import java.util.List;

public interface Input {
    List<TouchEvent> getTouchEvents();
    void release();
}

