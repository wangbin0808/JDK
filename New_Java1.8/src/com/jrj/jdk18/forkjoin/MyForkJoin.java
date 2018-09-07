package com.jrj.jdk18.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long start;
	
	private long end;
	
	private static final long THRESHOP=10000;

	public MyForkJoin(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		
		if(end-start<=THRESHOP){
			long sum = 0;
			for (long i = start; i <=end; i++) {
				sum+=i;
			}
			return sum;
		}else{
			long middle=(end-start)/2;
			
			MyForkJoin fork1=new MyForkJoin(start,middle);
			fork1.fork();
			MyForkJoin fork2=new MyForkJoin(middle+1,end);
			fork2.fork();
			return fork1.join()+fork2.join();	
		}	
	}

}
