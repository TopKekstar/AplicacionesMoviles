package kekstar.fdi.engine;

import java.util.List;

public interface Input {
    class TouchEvent{}
    List<TouchEvent> getTouchEvents();
}
