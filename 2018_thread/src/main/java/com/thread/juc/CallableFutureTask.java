package com.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTask {
	public static void main(String[] args) {
		
		FutureTask<Integer> fu=new FutureTask<>(()->{
			return 10;
		});
		new Thread(fu).start();
		try {
			Integer i = fu.get();
			System.out.println(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
