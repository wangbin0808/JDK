package com.thread.juc.test;

import javax.swing.plaf.synth.SynthSpinnerUI;

class RedSpider {
	
	private String data = "";
	
	public synchronized void write( String data ) {
		this.data = data;
		System.out.println( "教师端输入数据 = " + data );
	}
	
	public synchronized String read() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "学生端"+Thread.currentThread().getName()+"读取数据 = " + data );
		return data;
	}
}

public class TestJUC_05_rw {

	public static void main(String[] args) throws Exception {
		final RedSpider rs = new RedSpider();
		
		// 多个线程的读取不需要加锁。
		// 一个线程写数据的时候不能被其他线程读取，应该增加锁。
		// 多个线程同时写入数据，也应该加锁。

		for ( int i = 0; i < 10; i++ ) {
			new Thread(new Runnable() {
				public void run() {
					rs.read();
				}
			}, ""+i).start();
		}
		Thread.sleep(100);
		new Thread(new Runnable() {
			public void run() {
				rs.write("java juc...");
			}
		}).start();
	}

}
