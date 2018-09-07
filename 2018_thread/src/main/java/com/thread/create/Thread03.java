package com.thread.create;

import java.util.concurrent.Callable;

public class Thread03 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		
		return "-----Thread03----创建线程的第三种方式";
	}

}
