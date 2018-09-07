package com.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class Thread04 implements Runnable{

	private  volatile int count=100;
	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("--当前线程是"+Thread.currentThread().getName()+":"+i);
		}
		
	}
	
}
public class ThreadPool01 {

	public static void main(String[] args) {
		//这个是获得固定线程池的方法，
		ExecutorService pool=Executors.newFixedThreadPool(10);
		Thread04 t=new Thread04();
		//下面表示的并行执行
		pool.submit(t);
		pool.submit(t);
		pool.submit(t);
		//关闭线程池
		pool.shutdown();
		
	}

}
