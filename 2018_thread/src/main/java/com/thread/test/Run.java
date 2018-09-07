package com.thread.test;

public class Run extends Thread{

	private static final int count=50;
	
	private volatile int num=1;
	
	private  String name;
	public Run(String name){
		this.name=name;
	}
	@Override
	public void run() {
		while(num<count){
			System.out.println("---"+name+"当前的号码是:"+numAdd(num));
		}
	}
	public synchronized int numAdd(int num){
		return ++num;
	}
}

