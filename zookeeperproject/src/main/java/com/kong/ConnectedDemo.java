package com.kong;/**
 * Created by xuebi on 2019/10/28.
 */

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ConnectedDemo
 * @Description 获取连接的安全写法（zookeeper在connecting状态下操作服务端会出错）
 * @Author xuebi
 * @Date 2019/10/28 14:44
 * @Version 1.0
 */
public class ConnectedDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch  countDownLatch= new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("47.93.245.225:2183,47.93.245.225:2184,47.93.245.225:2185", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (Event.KeeperState.SyncConnected==watchedEvent.getState()) {
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        // 增
        zooKeeper.create("/zkpersis", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 查
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/zkpersis", null, stat);
        System.out.println(new String(data));
        // 改
        zooKeeper.setData("/zkpersis","1".getBytes(),stat.getVersion());
        byte[] data1 = zooKeeper.getData("/zkpersis", null, stat);
        System.out.println(new String(data1));
        // 删
        zooKeeper.delete("/zkpersis",stat.getVersion());
        zooKeeper.close();
    }
}
