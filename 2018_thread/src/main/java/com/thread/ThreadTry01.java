package com.thread;

public class ThreadTry01 {

	public static void main(String[] args) {
		
		Thread t1=new Thread(){
			public void run(){
				for (int i = 0; i < 100; i++) {
					prinle("task 1-->"+i);
				}
			}
		};
		t1.start();
		
		for (int i = 0; i < 100; i++) {
			prinle("task 2-->"+i);
		}
		
//		read();
//		write();
	}

	public static void read(){
		try {
			Thread.sleep(1000);
			System.out.println("---read----");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void write(){
		try {
			Thread.sleep(1000);
			System.out.println("---write----");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public static void prinle(String name){
		System.out.println("---prinle:"+name);
	}
	
}
