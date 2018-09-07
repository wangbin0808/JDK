package com.thread.lock.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProductAndConsumer{
	
	private int num=0;
	
	Lock lock=new ReentrantLock();
	Condition condition = lock.newCondition();

	public void product(){
		lock.lock();//加锁
		while(num!=0){
			try {
				condition.await();
			} catch (InterruptedException e) {

			}
		}
		condition.signalAll();//唤醒
		++num;
		lock.unlock();//解锁
		System.out.println("生产了："+num);
	}
	public void consumer(){
		lock.lock();//加锁
		while(num==0){
			try {
				condition.await();
			} catch (InterruptedException e) {

			}
		}
		--num;
		condition.signalAll();//唤醒
		lock.unlock();//解锁
		System.out.println("消费了："+num);
	}
	
}
public class LockTest1 {

	public static void main(String[] args) {
		final ProductAndConsumer p=new ProductAndConsumer();
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				p.product();
			}
		},"生产者").start();
		
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				p.consumer();
			}
		},"消费者").start();
	}
}
