package com.thread.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		CountDownLatch count = new CountDownLatch(10);
		for (int i = 0; i <10; i++) {	
			new Thread(()->{
				System.out.println("清除缓存"+Thread.currentThread().getName());
				count.countDown();//这个每执行一次都减一
			},"线程"+i).start();
			
		}
			//这个是闭锁等待，只有当count.getCount();这个等于0的时候才不会等待
		count.await();
		long end = System.currentTimeMillis();
		System.out.println("时间："+(end-start));
	}

}
