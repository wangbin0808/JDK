package com.thread.thread.test;

class ShareData6 {
	
	public static synchronized void method1() {
		System.out.println( "method1..." );
	}
}
class ShareData7 {
	
	public static synchronized void method2() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_6 {

	public static void main(String[] args) throws Exception {
		
		final ShareData6 data6 = new ShareData6();
		final ShareData7 data7 = new ShareData7();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data6.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data7.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

