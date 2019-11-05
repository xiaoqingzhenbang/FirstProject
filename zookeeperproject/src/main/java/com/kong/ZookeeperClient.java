package com.kong;/**
 * Created by xuebi on 2019/9/18.
 */

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ZookeeperClient
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/18 17:00
 * @Version 1.0
 */
public class ZookeeperClient {

    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZookeeperClient client = new ZookeeperClient();

        //连接zookeeper集群
        client.getConnect();
        //注册监听
        client.regist();
        //业务处理
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/xiaokong", true);
        for(String child :children){
            System.out.println(child+"is online!!!");
        }
    }

    private void getConnect() throws IOException {
        zooKeeper = new ZooKeeper("47.93.245.225:2183,47.93.245.225:2184,47.93.245.225:2185", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                try {
                    regist();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
