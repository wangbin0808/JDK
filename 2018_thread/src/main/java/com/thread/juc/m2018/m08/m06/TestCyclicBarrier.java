package com.thread.juc.m2018.m08.m06;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CyclicBarr{
	
	public static void method(CyclicBarrier cyc){
		System.out.println(""+Thread.currentThread().getName());
		try {
			cyc.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class TestCyclicBarrier {
	
	public static void main(String[] args) {
		CyclicBarrier cyc=new CyclicBarrier(10,()->{
			System.out.println("现在大家都到齐了，可以开会了");
		});
		
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				CyclicBarr.method(cyc);
			},"线程"+i+1).start();
		}
	}

}
