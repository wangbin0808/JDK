package com.thread.thread.test;

class ShareData5 {
	
	public static synchronized void method1() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method1..." );
	}
	
	public static synchronized void method2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_5 {

	public static void main(String[] args) throws Exception {
		
		final ShareData5 data = new ShareData5();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ShareData5.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				ShareData5.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

