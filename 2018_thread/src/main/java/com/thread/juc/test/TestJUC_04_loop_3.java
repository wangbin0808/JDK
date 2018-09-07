package com.thread.juc.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print1 {
	
	public int flg = 1;
	
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void print5(int loop) {
		lock.lock();
		try {
			while ( flg != 1 ) {
				try {
					c1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for ( int i = 1; i <= 5; i++ ) {
				System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
			}
			flg = 2;
			c2.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void print10(int loop) {
		lock.lock();
		
		try {
			while ( flg != 2 ) {
				try {
					c2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for ( int i = 1; i <= 10; i++ ) {
				System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
			}
			flg = 3;
			c3.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void print15(int loop) {
		lock.lock();
		try {
			while ( flg != 3 ) {
				try {
					c3.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for ( int i = 1; i <= 15; i++ ) {
				System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
			}
			
			flg = 1;
			c1.signal();
		} finally {
			lock.unlock();
		}
	}
}

public class TestJUC_04_loop_3 {

	public static void main(String[] args) throws Exception {
		
		final Print1 print = new Print1();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print5(i);
				}
			}
		}, "第一个线程");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print10(i);
				}
			}
		}, "第二个线程");
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print15(i);
				}
			}
		}, "第三个线程");
		t3.start();
	}

}
