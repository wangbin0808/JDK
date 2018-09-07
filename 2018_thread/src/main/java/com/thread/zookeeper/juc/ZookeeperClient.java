package com.thread.zookeeper.juc;

import org.apache.zookeeper.WatchedEvent;  
import org.apache.zookeeper.Watcher;  
import org.apache.zookeeper.ZooKeeper;  
  
import java.io.IOException;  
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;  
  
/** 
 * Created by Massive on 2016/12/18. 
 */  
public class ZookeeperClient {  
  
    private static String connectionString = "172.16.194.58:2181";  
    private static int sessionTimeout = 10000;  
  
  
    public static ZooKeeper getInstance() throws IOException, InterruptedException {  
        //--------------------------------------------------------------  
        // 为避免连接还未完成就执行zookeeper的get/create/exists操作引起的（KeeperErrorCode = ConnectionLoss)  
        // 这里等Zookeeper的连接完成才返回实例  
        //--------------------------------------------------------------  
        final CountDownLatch connectedSignal = new CountDownLatch(1);  
        ZooKeeper zk = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {  
             @Override  
             public void process(WatchedEvent event) {  
                 if  (event.getState()  ==  Event.KeeperState.SyncConnected) {  
                     connectedSignal.countDown();  
                 }  
             }  
         });  
        connectedSignal.await(sessionTimeout,TimeUnit.MILLISECONDS);  
        return zk;  
    }  
  
    public static String getConnectionString() {  
        return connectionString;  
    }  
  
    public static void setConnectionString(String connectionString) {  
        ZookeeperClient.connectionString = connectionString;  
    }  
  
    public static int getSessionTimeout() {  
        return sessionTimeout;  
    }  
  
    public static void setSessionTimeout(int sessionTimeout) {  
        ZookeeperClient.sessionTimeout = sessionTimeout;  
    }  
  
}  
