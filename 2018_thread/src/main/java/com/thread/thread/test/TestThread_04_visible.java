package com.thread.thread.test;


public class TestThread_04_visible {

	public static void main(String[] args) throws Exception {
		
		// javac Test
		// JVM JIT Just In Time
//		int i = 10;
//		i = 20;
//		i = 30;
//		System.out.println( i );
		
		
		final Demo demo = new Demo();
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				demo.flg = true;
			}
		});
		t.start();
		
		while ( true ) {
			if ( demo.flg == true ) {
				System.out.println( "demo.flg = " + demo.flg );
				break;
			}
		}
		System.out.println( "main...." );
		
	}
}
class Demo {
	public volatile boolean flg = false;
}

