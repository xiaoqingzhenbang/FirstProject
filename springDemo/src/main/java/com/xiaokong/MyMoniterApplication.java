package com.xiaokong;
/**
 * Created by xuebi on 2019/11/19.
 */

import com.xiaokong.event.MyEvent;
import com.xiaokong.eventsource.MyEventSource;
import com.xiaokong.handler.EventHandlerImpl;

/**
 * @ClassName MyMoniterApplication
 * @Description 监听者模式（回调函数）
 * @Author xuebi
 * @Date 2019/11/19 15:31
 * @Version 1.0
 */
public class MyMoniterApplication {
    public static void main(String[] args) {
        MyEventSource myEventSource = new MyEventSource();
        myEventSource.addListener(new EventHandlerImpl());
        myEventSource.notifyAllListener(new MyEvent("xiaokong"));
        myEventSource.notifyAllListener(new MyEvent("111"));
    }
}
