package com.thread.juc;

import java.util.concurrent.CountDownLatch;

class Count{
	
	int num=0;
	public void method1(){
		System.out.println("只有当10个线程执行完了才会执行这个-----");
	}

}
public class TestCountDownLatch {

	public static void main(String[] args) {
		CountDownLatch count=new CountDownLatch(10);
		Count cn=new Count();
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"还在清除缓存");
				count.countDown();//这个是为了锁减一
			},"线程"+i+"----").start();
			
		}
		try {
			count.await();//只有当锁的个数等于=0的时候，才会向下执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(()->{
			cn.method1();
		}).start();
	}
}
