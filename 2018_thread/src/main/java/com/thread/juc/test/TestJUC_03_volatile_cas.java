package com.thread.juc.test;

import java.util.Random;

class CompareAndSwap {
	public int num = 0;
	
	public synchronized int get() {
		return num;
	}
	
	public synchronized boolean compareAndSwap(int expect, int newValue) {
		if ( expect == num ) {
			num = newValue;
			return true;
		}
		
		return false;
	}
}

public class TestJUC_03_volatile_cas {

	public static void main(String[] args) throws Exception {
		
		final CompareAndSwap cas = new CompareAndSwap();
		
		for ( int i = 0; i < 10; i++ ) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(cas.compareAndSwap(cas.get(), new Random().nextInt()));
				}
			}).start();
		}
		
		 
	}

}
