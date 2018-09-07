package com.thread.lock.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Read{
	String name="";
	ReadWriteLock r=new ReentrantReadWriteLock();
	public void write(){
		r.writeLock().lock();
		try {
			name="juc----";
			System.out.println("zai xie --");
		} finally {
			r.writeLock().unlock();
		}

	}
	
	public void read(int i){
		r.readLock().lock();
		try {
			System.out.println(name + "----读" + i);
		} finally {
			r.readLock().unlock();
		}
	}
}
public class ReadWriteLockTest {
	
	public static void main(String[] args) {
		final Read r=new Read();
		new Thread(()->{
			r.write();
		}).start();
		
		for (int i = 0; i <10; i++) {
			new Thread(()->{
				int count=1;
				r.read(count);
				++count;
			}).start();
		}
	}

}
