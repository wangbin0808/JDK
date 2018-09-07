package com.thread.thread.test;

class ShareData {
	
	public synchronized void method1() {
		System.out.println( "method1..." );
	}
	
	public synchronized void method2() {
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_1 {

	public static void main(String[] args) throws Exception {
		
		final ShareData data = new ShareData();
		
		new Thread(new Runnable() {
			public void run() {
				data.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				data.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

