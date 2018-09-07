package com.thread.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskTest extends RecursiveTask<Integer>{
	private static final long serialVersionUID = 1L;

	private int begin , end;
	
	public ForkJoinTaskTest() {
		super();
	}

	public ForkJoinTaskTest(int begin ,int end ) {
		this.begin=begin;
		this.end=end;
	}
	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName());
		int num=0;
		if(end-begin<=2){
			for (int i = begin; i <=end; i++) {
				num+=i;
			}
		}else {//拆分
			ForkJoinTaskTest task1 = new ForkJoinTaskTest(begin, (end+begin)/2);
			ForkJoinTaskTest task2 = new ForkJoinTaskTest((end+begin)/2+1, end);
			task1.fork();
			task2.fork();//拆分
			
			Integer a = task1.join();
			Integer b = task2.join();//合并
			num = a+ b;
		}
		return num;
	}
	
	public static void main(String[] args) throws Exception {
		ForkJoinPool fork=new ForkJoinPool(3);
		ForkJoinTask<Integer> task = fork.submit(new ForkJoinTaskTest(1,100));
		Integer num = task.get();
		System.out.println(num);
	}

}
