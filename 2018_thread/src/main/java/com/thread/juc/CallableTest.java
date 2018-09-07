package com.thread.juc;

import java.util.concurrent.FutureTask;

class Result{
	public int num=0;
}
public class CallableTest {
	public static void main(String[] args) throws Exception {
		Result r=new Result();
		FutureTask<Integer> fu=new FutureTask<>(()->{
			for(int i=1;i<=100;i++){
				r.num+=i;
			}
			return r.num;
		});
		
		new Thread(fu).start();
		Integer integer = fu.get();
		for (int i = 1; i <= 50; i++) {
			r.num+=i;
		}
		
		System.out.println(r.num+":----"+integer);
	}

}
