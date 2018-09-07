package com.thread.thread.test;


public class TestThread_03_method {

	public static void main(String[] args) throws Exception {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println( "t1..." );
			}
			
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println( "t2..." );
			}
		});
		t2.start();
		
		//Thread.sleep(1000); // sleep方法是静态方法，和对象没有关系，是让当前运行的线程休眠
		//t2.wait();
		t1.join();
		System.out.println( "main..." );
		
	}
}

