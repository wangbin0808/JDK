package com.thread.juc.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyRunnable implements Runnable {

	public void run() {
		System.out.println( "Runnable..." );
	}
	
}

class MyCallable implements Callable<String> {

	public String call() throws Exception {
		Thread.sleep(1000);
		System.out.println( "Callable..." );
		return "call";
	}
	
}

public class TestJUC_01_callable {

	public static void main(String[] args) throws Exception {
		//new Thread(new MyRunnable()).start();
		FutureTask<String> task = new FutureTask<String>(new MyCallable());
		new Thread(task).start();
		
		System.out.println( task.get() );
		System.out.println( "main..." );
	}

}
