package com.thread.create;

class ProductAndConsumer02{
	private int count=0;
	
	public void product(int i){
		synchronized (this) {
			while(count!=0){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
			++count;
			System.out.println("生产者生产了---："+count+"--:"+i);
		}
	}
	
	public void consumer(int i){
		synchronized (this) {
			while(count==0){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
			--count;
			System.out.println("消费者---："+count+"--:"+i);
		}
	}
}
public class Product02 {
	
	public static void main(String[] args) {
		final ProductAndConsumer02 p=new ProductAndConsumer02();
		
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
