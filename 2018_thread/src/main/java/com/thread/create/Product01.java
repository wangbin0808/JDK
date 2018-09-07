package com.thread.create;
/**
 * 
 * @author bin.wang
 * 生产者消费者
 *
 */
class ProductAndConsumer{

	private int count=0;

	public synchronized void product(int i){
		while(count!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		++count;
		System.out.println("生产了："+count+"---:"+i);
	}
	
	public synchronized void consumer(int i){
		while(count==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		notifyAll();
		--count;
		System.out.println("消费完还剩余的数量是："+count+"---:"+i);
	}
	
}
public class Product01 {

	public static void main(String[] args) {
		final ProductAndConsumer p =new ProductAndConsumer();
		
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				p.product(i);
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				p.consumer(i);
			}
		}).start();
	}

}
