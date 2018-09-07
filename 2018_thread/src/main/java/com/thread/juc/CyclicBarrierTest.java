package com.thread.juc;
import java.util.concurrent.CyclicBarrier;
class Cycl{
	public void method(CyclicBarrier cyc){
		System.out.println(Thread.currentThread().getName()+"等所有人到齐后在开会-----");
		try {
			cyc.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class CyclicBarrierTest {
	public static void main(String[] args) {
		final CyclicBarrier cyc=new CyclicBarrier(10, ()->{
			System.out.println("好现在开会");
		});
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				new Cycl().method(cyc);;
			},"线程"+i).start();
		}}
	}
