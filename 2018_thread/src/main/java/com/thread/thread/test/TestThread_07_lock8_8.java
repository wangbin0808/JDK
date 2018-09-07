package com.thread.thread.test;

class ShareData10 {
	
	public synchronized void method1() {
		System.out.println( "method1..." );
	}
}
class ShareData11 {
	
	public static synchronized void method2() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_8 {

	public static void main(String[] args) throws Exception {
		
		final ShareData10 data10 = new ShareData10();
		final ShareData11 data11 = new ShareData11();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data10.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data11.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

