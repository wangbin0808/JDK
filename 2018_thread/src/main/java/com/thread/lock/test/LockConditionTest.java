package com.thread.lock.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestCondition{
	
	Lock lock=new ReentrantLock();
	Condition con1=lock.newCondition();
	Condition con2=lock.newCondition();
	Condition con3=lock.newCondition();
	
	private int flg=1;
	public void product1(int j){
		lock.lock();
		try {
			while(flg!=1){
				try {
					con1.await();
				} catch (InterruptedException e) {
				}
			}
			con2.signal();
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"---"+i+"第"+j+"轮");
			}
			flg=2;
		} finally {
			lock.unlock();
		}
	}	
	public void product2(int j){
		lock.lock();
		try {
			while(flg!=2){
				try {
					con2.await();
				} catch (InterruptedException e) {
				}
			}
			con3.signal();
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+"---"+i+"第"+j+"轮");
			}
	
			flg=3;
		} finally {
			lock.unlock();
		}
	}
	public void product3(int j){
		lock.lock();
		try {
			while(flg!=3){
				try {
					con3.await();
				} catch (InterruptedException e) {

				}
			}
			flg=1;
			con1.signal();
			for (int i = 0; i < 15; i++) {
				System.out.println(Thread.currentThread().getName()+"---"+i+"第"+j+"轮");
			}

		} finally {
			lock.unlock();
		}
	}
}
public class LockConditionTest {
	public static void main(String[] args) {	
		TestCondition ts=new TestCondition();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				ts.product1(i+1);
			}
		},"第一个线程").start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				ts.product2(i+1);
			}
		},"第er个线程").start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				ts.product3(i+1);
			}
		},"第san个线程").start();
	}

}
