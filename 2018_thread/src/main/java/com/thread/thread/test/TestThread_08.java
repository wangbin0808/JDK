package com.thread.thread.test;

class ShareData13 {
	
	public synchronized void method1() {
		System.out.println( "method1..." );
	}
	
	public void method2() {
		String s = "123";
		synchronized (s) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println( "method2..." );
		}
	}
}

public class TestThread_08 {

	public static void main(String[] args) throws Exception {
		
		final ShareData13 data13 = new ShareData13();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data13.method1();
			}
		});
		t.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				data13.method2();
			}
		}).start();
		
		System.out.println( "main ..." );
	}
}

