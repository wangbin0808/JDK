package com.thread.thread.test;

class ShareData1 {
	
	public synchronized void method1() {
		System.out.println( "method1..." );
	}
	
	public synchronized void method2() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_2 {

	public static void main(String[] args) throws Exception {
		
		final ShareData1 data = new ShareData1();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

