package eRyder;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

public class ERyderLog {
    private String log;
    private String event;
    private LocalDateTime timeStamp;
   
    public ERyderLog(String log, String event, LocalDateTime timeStamp){
        this.log=log;
        this.event=event;
        this.timeStamp=timeStamp;
    }
    public ERyderLog(){};
    public String getEvent() {
        return event;
    }
    public String getLog() {
        return log;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    @Override 
    public String toString(){
        return getEvent()+"-"+getEvent()+"-"+getTimeStamp();
    }
    
}
