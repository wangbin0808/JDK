package com.thread.thread.test;

class Product {
	
	private int num = 0;
	
	public synchronized void produce() {

		if ( num != 0 ) {
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

public class TestThread_03_method_wait {

	public static void main(String[] args) throws Exception {
		// 产品，生产10次，消费10次
		// 开发程序，需要遵循 高内聚，低耦合的原则
		// MVC2
		// servlet ==> jsp ==> mvc1 ==> mvc2
		// 
		
		// wait, notify, notifyAll 必须和同步关键字一起使用
		// java.lang.IllegalMonitorStateException
		
		final Product product = new Product();
		
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
		
	}
}

