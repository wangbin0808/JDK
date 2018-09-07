package com.thread.thread.test;

class Product3 {
	
	public int num = 0;
	
	public synchronized void produce() {
		while ( num != 0 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		num++;
		System.out.println( "生产 num =" + num );
		notifyAll();
	}
	
	public synchronized void consume() {

		if ( num == 0 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		num--;
		System.out.println( "消费 num =" + num );
		notifyAll();
	}
}

public class TestThread_06_wakeup {

	public static void main(String[] args) throws Exception {
		
		// 
		final Product3 product = new Product3();
		// java.lang.IllegalMonitorStateException
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.produce();
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.consume();
				}
			}
		});
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.produce();
				}
			}
		});
		t3.start();
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					product.consume();
				}
			}
		});
		t4.start();
	}
}

