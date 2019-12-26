package com.xiaokong.eventsource;/**
 * Created by xuebi on 2019/11/19.
 */

import com.xiaokong.event.MyEvent;
import com.xiaokong.handler.EventHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName MyEventSource
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/19 15:20
 * @Version 1.0
 */
public class MyEventSource {

    private List<EventHandler> list = new ArrayList<EventHandler>();

    public void addListener(EventHandler eventHandler){
        list.add(eventHandler);
    }

    public void delListener(EventHandler eventHandler){
        if(list.contains(eventHandler)){
            list.remove(eventHandler);
        }
    }

    public void notifyAllListener(MyEvent myEvent){
        Iterator<EventHandler> iterator = list.iterator();
        while (iterator.hasNext()){
            EventHandler next = iterator.next();
            next.handlerMethod(myEvent);
        }
    }
}
