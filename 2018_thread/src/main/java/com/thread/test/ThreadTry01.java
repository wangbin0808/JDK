package com.thread.test;

public class ThreadTry01 {

	public static void main(String[] args) {
		Thread t1=new Thread(()->{
			for (int i = 0; i < 100; i++) {
				read();
			}
		},"read");
		
		Thread t2=new Thread(()->{
			for (int i = 0; i < 100; i++) {
				read();
			}
		},"write");
		t1.start();
		t2.start();

	}
	
	public static void read(){
		System.out.println("---read----"+Thread.currentThread().getName());
	}
	
	public static void write(){
	
		System.out.println("---write----");
	}
}

