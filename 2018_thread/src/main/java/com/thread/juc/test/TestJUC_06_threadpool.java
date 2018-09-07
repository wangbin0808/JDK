package com.thread.juc.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TestJUC_06_threadpool {

	public static void main(String[] args) throws Exception {
		// 线程池
		
		// 固定线程池打印20次业务操作 
		//ExecutorService es = Executors.newFixedThreadPool(5);
		// 单一线程池打印20次业务操作
		//ExecutorService es = Executors.newSingleThreadExecutor();
		// 按需线程池打印20次业务操作
		ExecutorService es = Executors.newCachedThreadPool();

		for ( int i = 0; i < 20; i++ ) {
		    es.execute(new Runnable() {
		    	public void run() {
		    		System.out.println( Thread.currentThread().getName() + "打印业务");
		    	}
		    });
		}
		
		
		// 让线程池支持时间调度
		ScheduledExecutorService service = Executors.newScheduledThreadPool(20);
		
		for ( int i = 0; i < 10; i++ ) {
			Future<Integer> f = service.schedule(new Callable<Integer>() {
				public Integer call() throws Exception {
					return 100;
				}
			}, 1, TimeUnit.SECONDS);
			
			System.out.println( "线程执行结果 = " + f.get() );
		}
		// 关闭线程池
		try {	 
		} finally {
			service.shutdown();
		}
	}

}
