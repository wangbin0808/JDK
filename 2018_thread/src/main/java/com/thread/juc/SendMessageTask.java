package com.thread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class SendMessageTask extends RecursiveAction {

	// 每个“小任务”只最多只给10名用户发送短信
	private static final int THRESHOLD = 10;
	private int start;
	private int end;
	List<String> list = null;

	// 从start到end的任务
	public SendMessageTask(int start, int end, List<String> list) {
		this.start = start;
		this.end = end;
		this.list = list;
	}

	@Override
    protected void compute() {
        // TODO Auto-generated method stub
        if(end - start < THRESHOLD){
            String mobileno="";
            for (int i = start ; i < end ; i++ )
            {
                 //此处做手机号码累加，用于发送给短信运营商
                 mobileno+=list.get(i)+",";
            }
            System.out.println("给手机号码=="+mobileno+"的用户发送手机短信");
        }else{
            // 如果当end与start之间的差大于THRESHOLD时，即要发送的数超过10个
            // 将大任务分解成两个小任务。
            int middle = (start + end) /2;
            SendMessageTask left = new SendMessageTask(start, middle,list);
            SendMessageTask right = new SendMessageTask(middle, end,list);
            // 并行执行两个“小任务”
            left.fork();
            right.fork();
        }

    }

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 500; i++) {
			list.add("i------" + i);// 假设此处为手机号码--项目中从数据库中获取
		}
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new SendMessageTask(0, list.size(), list));
		// 线程阻塞，等待所有任务完成
		pool.awaitTermination(10, TimeUnit.SECONDS);
		// 关闭线程池
		pool.shutdown();
	}

	// /**
	// *
	// */
	// private static final long serialVersionUID = 1L;
	//
	// private int begin,end;
	//
	// private final int max=10;
	//
	// private List<String> list;
	//
	// public SendMessageTask(int begin, int end, List<String> list) {
	// super();
	// this.begin = begin;
	// this.end = end;
	// this.list = list;
	// }
	//
	// @Override
	// protected void compute() {
	//
	// if(end-begin<=max){
	// String st=new String();
	// for (int i = begin; i < end; i++) {
	// st+=list.get(i)+",";
	// }
	// System.out.println(st);
	// }else{
	// int resu=(end-begin)/2;
	// SendMessageTask left=new SendMessageTask(begin,resu,list);
	// SendMessageTask right=new SendMessageTask(resu,end,list);
	// left.fork();
	// right.fork();
	// }
	//
	// }
	//
	// public static void main(String[] args) {
	//
	// List<String> list=new ArrayList<String>();
	// for (int i = 0; i < 380; i++) {
	// list.add(""+i);
	// }
	//
	// ForkJoinPool fork=new ForkJoinPool();
	// fork.submit(new SendMessageTask(1, 380, list));
	//
	//// try {
	//// fork.awaitTermination(10, TimeUnit.SECONDS);
	//// } catch (InterruptedException e) {
	//// // TODO Auto-generated catch block
	//// e.printStackTrace();
	//// }
	// fork.shutdown();
	// }

}
