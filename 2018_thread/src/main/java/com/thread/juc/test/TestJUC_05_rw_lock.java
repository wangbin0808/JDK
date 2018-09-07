package com.thread.juc.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RedSpider1 {
	private String data = "";
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	public void write( String data ) {
		lock.writeLock().lock();
		
		try {
			this.data = data;
			System.out.println( "教师端输入数据 = " + data );
		} finally  {
			lock.writeLock().unlock();
		}
	}
	public String read() {
		lock.readLock().lock();
		try {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println( "学生端"+Thread.currentThread().getName()+"读取数据 = " + data );
			return data;
		} finally {
			lock.readLock().unlock();
		}
	}
}
public class TestJUC_05_rw_lock {

	public static void main(String[] args) throws Exception {
		final RedSpider1 rs = new RedSpider1();	
		// 多个线程的读取不需要加锁。
		// 一个线程写数据的时候不能被其他线程读取，应该增加锁。
		// 多个线程同时写入数据，也应该加锁。
		for ( int i = 0; i < 10; i++ ) {
			new Thread(new Runnable() {
				public void run() {
					rs.read();
				}
			}, ""+i).start();
		}
		
		Thread.sleep(100);
		
		new Thread(new Runnable() {
			public void run() {
				rs.write("java juc...");
			}
		}).start();
		
	}

}
