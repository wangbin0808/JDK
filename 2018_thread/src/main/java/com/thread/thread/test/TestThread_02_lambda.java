package com.thread.thread.test;

interface MyLambda {
	public int test(int a);
	/*
	public default int test1(int a) {
		return 0;
	}
	public static int test2() {
		return 1;
	}
	*/
}

public class TestThread_02_lambda {

	public static void main(String[] args) {
		// 在JDK1.8后，可以使用lambda表达式来代替匿名内部类或接口
		// lambda表达式只关心业务逻辑实现，不关心名称
		// lambda表达式的语法规则： ()->{}
		// lambda表达式要求接口中的方法只能有一个
		// 在使用时，方法的参数如果只有一个，那么lambda表达式中的小括号可以省略
		// 如果一个接口想要使用lambda表达式，
		//      那么接口中只能有一个方法，不能添加其他的方法，
		//      可以通过增加注解（@FunctionalInterface）进行约束
		// jdk1.8后，接口中的方法可以增加default关键字默认实现方法。
		// jdk1.8后，接口中的方法可以增加static关键字实现方法。静态调用
		/*
		new Runnable() {
			public void run() {
			}
		}
		*/
		// Spring AOP
		// execution( * com.atuigui..*Service.*(..) )
		// public void test()
		/*
		MyLambda myLambda = a -> {
			return a;
		};
		
		System.err.println(myLambda.test(1));
		*/
		
	}
}

