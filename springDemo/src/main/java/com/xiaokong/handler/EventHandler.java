package com.xiaokong.handler;

import com.xiaokong.event.MyEvent;

/**
 * Created by xuebi on 2019/11/19.
 */
public interface EventHandler {

    void handlerMethod(MyEvent myEvent);
}
