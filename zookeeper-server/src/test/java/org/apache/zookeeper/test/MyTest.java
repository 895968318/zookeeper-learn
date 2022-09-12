package org.apache.zookeeper.test;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author wzw
 * @since 2022/9/12
 */

public class MyTest {

    @Test
    public void t1() throws UnknownHostException {
        InetAddress[] allByName = InetAddress.getAllByName("localhost");
        System.out.println(Arrays.toString(allByName));
    }

    @Test
    public void t2() throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 10000000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("connect");
            }
        });
        zooKeeper.exists("/watch", false);
        Thread.sleep(1000000);
        System.out.println(zooKeeper.getState());
    }

    @Test
    public void t3() throws IOException {

    }
}
