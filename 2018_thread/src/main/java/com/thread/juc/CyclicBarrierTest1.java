package com.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Cyy{
	CyclicBarrier cyc=new CyclicBarrier(10,()->{
		System.out.println("等所有人到齐后在开会---");
	});
	
	public void test(){
		System.out.println(Thread.currentThread().getName()+"--等待开会----- ");
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
public class CyclicBarrierTest1 {

	public static void main(String[] args) {
		Cyy cy=new Cyy();
		
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				cy.test();
			},"线程----"+i).start();
		}

	}
}
