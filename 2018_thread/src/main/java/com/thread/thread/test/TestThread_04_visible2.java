package com.thread.thread.test;

class Product1 {
	
	public int num = 0;
	
	public synchronized void produce() {
		num++;
	}
	
	public synchronized void consume() {
		num--;
	}
}

public class TestThread_04_visible2 {

	public static void main(String[] args) throws Exception {
		
		final Product1 product = new Product1();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10000; i++ ) {
					product.produce();
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10000; i++ ) {
					product.consume();
				}
			}
		});
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} finally {
			System.out.println( "product num = " + product.num );
		}
	}
}

