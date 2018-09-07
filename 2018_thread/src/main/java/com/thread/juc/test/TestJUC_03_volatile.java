package com.thread.juc.test;

import java.util.concurrent.atomic.AtomicInteger;

class Product {
	//public volatile int num = 0;
	public AtomicInteger ai = new AtomicInteger();
	
	public void produce() {
		//num++; // 1） _a = num；2） num= num+1
		//int j = i++; // 1) _a = i; 2) i = i + 1 3) j = _a
		//num++;
		ai.getAndIncrement();
	}
	
	public void consume() {
		//num--;
		ai.getAndDecrement();
	}
}

public class TestJUC_03_volatile {

	public static void main(String[] args) throws Exception {
		final Product product = new Product();
		// java.lang.IllegalMonitorStateException
	    Thread t1 = new Thread( new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					product.produce();
				}
			}
		} );
		t1.start();
		
	    Thread t2 = new Thread( new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					product.consume();
				}
			}
		} );
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} finally {
			System.out.println( "product.num = " + product.ai.get() );
		}
		 
	}

}
