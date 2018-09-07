package com.thread.juc.test;

public class TestJUC_01_callable3 {

	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		// 线程闭锁
		//final CountDownLatch latch = new CountDownLatch(20);
		
		for ( int i = 0; i < 20; i++ ) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println( Thread.currentThread().getName() + "清理库存完毕。。。" );
					//latch.countDown();
				}
			}, "线程" + i);
			t.start();
			t.join();
		}
		
		// 闭锁等待
		//latch.await();
		
		long end = System.currentTimeMillis();
		
		System.out.println( "清理库存总共花费时间为 = " + (end - start) );
		
	}

}
