package com.xiaokong.handler;/**
 * Created by xuebi on 2019/11/19.
 */

import com.xiaokong.event.MyEvent;

/**
 * @ClassName EventHandlerImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/19 15:17
 * @Version 1.0
 */
public class EventHandlerImpl implements EventHandler {
    public void handlerMethod(MyEvent myEvent) {
        if("xiaokong".equals(myEvent.getName())){
            System.out.println("您新建了一个类名字叫xiaokong!");
        }else{
            System.out.println("请按默认方式新建类!");
        }
    }
}
