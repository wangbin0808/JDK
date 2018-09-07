package com.thread.juc;

import java.util.concurrent.Semaphore;
class Sem{
	
	public void test(Semaphore se){
		try {
			se.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"---");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		se.release();
	}
}
public class SemaphoreTest1 {

	public static void main(String[] args) {
		
		final Sem s=new Sem();
		Semaphore se=new Semaphore(10,true);
		int count=1;
		while(count<=100){
			new Thread(()->{
				s.test(se);
			},""+count).start();
			++count;
		}
	}
}
