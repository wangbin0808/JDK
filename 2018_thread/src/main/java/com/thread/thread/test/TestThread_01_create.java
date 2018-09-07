package com.thread.thread.test;

public class TestThread_01_create {

	public static void main(String[] args) {
		/* 继承父类
		Thread thread = new MyThread();
		thread.start();
		System.out.println( "main..." );
		*/
		
		/* 实现接口
		Runnable run = new MyRunnable();
		Thread thread = new Thread(run);
		thread.start();
		System.out.println( "main..." );
		*/
		
		/* 匿名内部类
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println( "inner thread..." );
			}
			
		});
		t.start();
		*/
		
		//Runnable run = new MyThread();
		//System.out.println(MyThread.class.getInterfaces().length);
		/*
		Thread t = new Thread(()->{
			System.out.println( "xxxxxx" );
		});
		t.start();
		*/
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("mythread...");
	}
	
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println( "MyRunnable..." );
	}
	
}
