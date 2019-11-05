package com.kong;/**
 * Created by xuebi on 2019/9/17.
 */

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ZookeeperApplication
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/17 17:55
 * @Version 1.0
 */
public class ZookeeperApplication {

    private static String connectStr = "47.93.245.225:2183,47.93.245.225:2184,47.93.245.225:2185";
    private static int sessionTime = 2000;
    private ZooKeeper zkClient;

    @Before
    public void initMethod() throws IOException {

        zkClient = new ZooKeeper(connectStr, sessionTime, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/xiaokong", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(String child:children){
                    System.out.println(child);
                }
            }
        });
        System.out.println(zkClient);
    }

    /**
     * 添加子节点
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkClient.create("/xiaokong/xiaoqiang", "zhenshuai".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(path);
    }

    /**
     * 获取子节点并监听
     */
    @Test
    public void getDateAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for(String child:children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 判断节点是否存在
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/xiaokong", false);
        System.out.println(stat == null?"not exist":"exist");
    }
}
