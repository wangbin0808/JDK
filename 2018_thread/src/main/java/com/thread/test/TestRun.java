package com.thread.test;

public class TestRun {

	public static void main(String[] args) {
		
		final Run1 r1=new Run1("哈哈哈");
		Thread t1=new Thread(r1, "线程1");
		Thread t2=new Thread(r1, "线程2");
		Thread t3=new Thread(r1, "线程3");
		t1.start();
		t2.start();
		t3.start();
//		Run r1=new Run("Yihao");
//		r1.start();
//		Run r2=new Run("erhao");
//		r2.start();
//		Run r3=new Run("sanhao");
//		r3.start();
	}
}
