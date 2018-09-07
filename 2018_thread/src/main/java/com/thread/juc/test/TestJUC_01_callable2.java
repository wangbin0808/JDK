package com.thread.juc.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class TestJUC_01_callable2 {

	public static void main(String[] args) throws Exception {
		//new Thread(new MyRunnable()).start();
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for ( int i = 1; i <= 50; i++ ) {
					sum += i;
				}
				return sum;
			}
		});
		new Thread(task).start();
		
		int sum = 0;
		for ( int i = 1; i <= 100; i++ ) {
			sum += i;
		}
		
		System.out.println( "final result = " + (sum + task.get()) );
		System.out.println( "main..." );
	}

}
