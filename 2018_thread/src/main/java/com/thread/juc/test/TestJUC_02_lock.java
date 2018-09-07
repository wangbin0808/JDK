package com.thread.juc.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
	
	public int num = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void produce1() {
		// 加锁
		lock.lock();
		
		try {
			while ( num != 0  ) {
				try {
					//wait();
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			num++;
			//notifyAll();
			condition.signalAll();
		} finally {
			// 解锁
			lock.unlock();
		}

	}
	
	public synchronized void produce() {
		while ( num != 0  ) {
			try {
				wait();
				//Thread.sleep(100*600*60*24*7);
				//TimeUnit.DAYS.sleep(7);
				//TimeUnit.SECONDS.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		num++;
		notifyAll();
	}
}

public class TestJUC_02_lock {

	public static void main(String[] args) throws Exception {
		final ShareData data = new ShareData();
		// java.lang.IllegalMonitorStateException
	    new Thread( new Runnable() {
			
			@Override
			public void run() {
				data.produce1();
			}
		} ).start();
		 
	}

}
