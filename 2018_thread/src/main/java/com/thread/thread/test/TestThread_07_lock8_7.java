package com.thread.thread.test;

class ShareData9 {
	
	public synchronized void method1() {
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

public class TestThread_07_lock8_7 {

	public static void main(String[] args) throws Exception {
		
		final ShareData9 data = new ShareData9();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

