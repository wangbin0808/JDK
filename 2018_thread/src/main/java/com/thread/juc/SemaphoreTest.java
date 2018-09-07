package com.thread.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Sema{
	public void method(Semaphore se){
		try {
			se.acquire();//获得认可
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"run -----");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		se.release();
	}
}
public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore se=new Semaphore(10);
		int count=1;
		while(count<=1){
			new Thread(()->{
				new Sema().method(se);
			},""+(++count)).start();
		}
	}

}
