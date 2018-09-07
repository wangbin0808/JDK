package com.thread.create;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class ThreadOne01 {
	
	@Test
	public void test01(){
		Thread01 t1=new Thread01();
		t1.start();
	}

	@Test
	public void test02(){
		Thread02 t1=new Thread02();
		Thread t2=new Thread(t1);
		t2.start();
		//t1.run();
	}
	@Test
	public void test03(){
		Thread03 t1=new Thread03();
		FutureTask<String> ft=new FutureTask<>(t1);
		Thread t2=new Thread(ft);
		t2.start();
		try {
			String name = ft.get();
			System.out.println(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
