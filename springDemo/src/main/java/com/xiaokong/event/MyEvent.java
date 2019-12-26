package com.xiaokong.event;/**
 * Created by xuebi on 2019/11/19.
 */

/**
 * @ClassName MyEvent
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/19 15:14
 * @Version 1.0
 */
public class MyEvent {

    private String name;

    public MyEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
