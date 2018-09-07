package com.thread.thread.test;

class ShareData8 {
	
	public static synchronized void method1() {
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
public class TestThread_07_lock8_6_1 {

	public static void main(String[] args) throws Exception {
		
		final ShareData8 data8 = new ShareData8();
		final ShareData8 data81 = new ShareData8();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ShareData8.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				ShareData8.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

