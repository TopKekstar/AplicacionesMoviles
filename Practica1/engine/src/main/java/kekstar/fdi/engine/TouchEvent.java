package kekstar.fdi.engine;


public class TouchEvent {
    public enum eventType{
        BUTTON_PRESSED,
        BUTTON_RELEASED,
        DRAGING
    }

    public TouchEvent(int buttonIndex, eventType eventType){
        this._buttonIndex = buttonIndex;
        this._eventType = eventType;

    }

    public int get_buttonIndex() {
        return _buttonIndex;
    }

    public eventType get_eventType() {
        return _eventType;
    }

    int _buttonIndex;
    eventType _eventType;
}
