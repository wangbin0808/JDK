package com.thread.thread.test;

class ShareData3 {
	
	public synchronized void method1() {
		System.out.println( "method1..." );
	}
}
class ShareData4 {
	
	public synchronized void method2() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "method2..." );
	}
}

public class TestThread_07_lock8_4 {

	public static void main(String[] args) throws Exception {
		
		final ShareData3 data3 = new ShareData3();
		final ShareData4 data4 = new ShareData4();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data3.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data4.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

