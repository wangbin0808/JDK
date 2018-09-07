package com.thread.thread.test;

class Product2 {
	
	public int num = 0;
	
	public  void produce(Object lock) {

		synchronized(lock) {
			if ( num != 0 ) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num++;
			System.out.println( "生产 num =" + num );
			lock.notifyAll();
		}
	}
	
	public void consume(Object lock) {
		synchronized(lock) {
			if ( num == 0 ) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			num--;
			System.out.println( "消费 num =" + num );
			lock.notifyAll();
		}
	}
}

public class TestThread_05_monitor {

	public static void main(String[] args) throws Exception {
		
		// 
		final Product2 product = new Product2();
		final Object lock = new Object();
		// java.lang.IllegalMonitorStateException
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.produce(lock);
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.consume(lock);
				}
			}
		});
		t2.start();
	}
}

