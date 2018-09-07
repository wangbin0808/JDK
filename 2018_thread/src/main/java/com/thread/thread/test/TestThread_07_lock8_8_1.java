package com.thread.thread.test;

class ShareData12 {
	
	public synchronized void method1() {
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

public class TestThread_07_lock8_8_1 {

	public static void main(String[] args) throws Exception {
		
		final ShareData12 data12 = new ShareData12();
		final ShareData12 data121 = new ShareData12();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				data12.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data121.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

