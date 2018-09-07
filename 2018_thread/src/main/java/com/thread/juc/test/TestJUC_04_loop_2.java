package com.thread.juc.test;

import java.util.concurrent.atomic.AtomicInteger;

class Print {
	
	public int flg = 1;
	
	public synchronized void print5(int loop) {
		while ( flg != 1 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for ( int i = 1; i <= 5; i++ ) {
			System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
		}
		flg = 2;
		notifyAll();
	}
	
	public synchronized void print10(int loop) {
		while ( flg != 2 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for ( int i = 1; i <= 10; i++ ) {
			System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
		}
		flg = 3;
		notifyAll();
	}
	
	public synchronized void print15(int loop) {
		while ( flg != 3 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for ( int i = 1; i <= 15; i++ ) {
			System.out.println( Thread.currentThread().getName() + "在第"+(loop+1)+"次循环中打印:" + i );
		}
		
		flg = 1;
		notifyAll();
	}
}

public class TestJUC_04_loop_2 {

	public static void main(String[] args) throws Exception {
		
		final Print print = new Print();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print5(i);
				}
			}
		}, "第一个线程");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print10(i);
				}
			}
		}, "第二个线程");
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for ( int i = 0; i < 10; i++ ) {
					print.print15(i);
				}
			}
		}, "第三个线程");
		t3.start();
	}

}
