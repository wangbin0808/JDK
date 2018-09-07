package com.thread.create;

class TestVisiblle{
	 volatile boolean flag=false;
}
public class TestVisible {
	
	public static void main(String[] args) {
		final TestVisiblle te=new TestVisiblle();
		
		new Thread(()->{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			te.flag=true;
		}).start();
		while(true){
			if(te.flag==true){
				System.out.println("---------ggg");
				break;
			}
		}
		System.out.println("main......");
	}

}
