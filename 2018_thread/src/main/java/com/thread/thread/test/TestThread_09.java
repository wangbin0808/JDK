package com.thread.thread.test;

class Result {
	public int num = 0;
}

public class TestThread_09 {

	public static void main(String[] args) throws Exception {
		
		final Result r = new Result();
		
		new Thread(new Runnable() {
			public void run() {
				for ( int i = 1; i <= 50; i++ ) {
					r.num += i;
				}
			}
		}).start();
		
		for ( int i = 1; i <= 100; i++ ) {
			r.num += i;
		}
		// 6325
		System.out.println( "result  = " + r.num );
	}
}

