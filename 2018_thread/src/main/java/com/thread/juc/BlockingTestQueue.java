package com.thread.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Blocking{
	private int num = 10;
	private int count=1;
	BlockingQueue<Integer> block=new ArrayBlockingQueue<>(num);
	public void put(){
		try {
			block.put(1);
		} catch (InterruptedException e) {
		}
	}
	public void task(){
		try {
			block.take();
		} catch (InterruptedException e) {
		}
	}
	public void sys(){
		while(count<1000){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("当前被阻塞的了多少"+block.size());
			count++;
		}

	}
}
public class BlockingTestQueue {
	public static void main(String[] args) {
		Blocking bl=new Blocking();
		new Thread(()->{
			bl.put();
		}).start();
		new Thread(()->{
			bl.put();
		}).start();
		new Thread(()->{
			bl.put();
		}).start();
		new Thread(()->{
			bl.put();
		}).start();
		new Thread(()->{
			bl.put();
		}).start();
		
		
		new Thread(()->{
			bl.task();
		}).start();
		new Thread(()->{
			bl.task();
		}).start();
		new Thread(()->{
			bl.task();
		}).start();
		
		
		new Thread(()->{
			bl.sys();
		}).start();
	}

}
