package com.kong;/**
 * Created by xuebi on 2019/9/18.
 */

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @ClassName ZookeeperServer
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/18 17:00
 * @Version 1.0
 */
public class ZookeeperServer {

    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZookeeperServer server = new ZookeeperServer();

        //连接zookeeper集群
        server.getConnect();
        //注册服务列表
        server.regist(args[0]);
        //处理业务
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostName) throws KeeperException, InterruptedException {
        String path = zooKeeper.create("/xiaokong/" + hostName, hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    private void getConnect() throws IOException {
        zooKeeper = new ZooKeeper("47.93.245.225:2183,47.93.245.225:2184,47.93.245.225:2185", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
