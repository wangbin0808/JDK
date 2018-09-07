package com.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExcutorTest {
	public static void main(String[] args) {
		// 这个是获得固定的线程数量的线程池
		// ExecutorService pool = Executors.newFixedThreadPool(5);
		//
		// for (int i = 0; i < 20; i++) {
		// pool.execute(()->{
		// System.out.println(Thread.currentThread().getName()+"---newFixedThreadPool");
		// });
		// }
		// pool.shutdown();
		// System.out.println("-------");
		// //这个是获得单一的线程
		// ExecutorService service = Executors.newSingleThreadExecutor();
		// for (int i = 0; i < 20; i++) {
		// service.execute(()->{
		// System.out.println(Thread.currentThread().getName()+"---newSingleThreadExecutor");
		// });
		// }
		// service.shutdown();
		System.out.println("-------");
		ScheduledExecutorService service2 = Executors.newScheduledThreadPool(5);
		// for (int i = 0; i < 20; i++) {
		// service2.execute(()->{
		// System.out.println(Thread.currentThread().getName()+"---newScheduledThreadPool");
		// });
		// }

		service2.schedule(() -> {
			System.out.println(Thread.currentThread().getName() + "---newScheduledThreadPool--10秒钟执行一次");
		}, 10, TimeUnit.SECONDS);
		
		ScheduledFuture<String> future = service2.schedule(()->{
			System.out.println("---callable");
			return "10";
		}, 20, TimeUnit.SECONDS);
		try {
			String name = future.get();
			System.out.println(name+"------name");
		} catch (Exception e) {
			
			e.printStackTrace();
		}


	}

}
