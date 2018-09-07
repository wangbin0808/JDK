package com.thread.test;

public class Run1 implements Runnable{

	private static final int count=50;
	
	private static int num=1;
	
	private  String name;
	public Run1(String name){
		this.name=name;
	}
	@Override
	public void run() {
		while(num<count){
			System.out.println("---"+name+"当前的号码是:"+(num++)+Thread.currentThread().getName());
		}
		
	}

}
