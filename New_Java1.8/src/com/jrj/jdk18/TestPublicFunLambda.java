package com.jrj.jdk18;

import org.junit.Test;

public class TestPublicFunLambda {
	
	@Test
	public void test(){
		MyFunctionInte<String> my=x->x.toUpperCase();
		System.out.println(my.getValue("wangbin"));
		
		MyFunctionInte<String> m1=x->x.substring(2, 5);
		System.out.println(m1.getValue("ewefcsdsdwdw"));
	}
	
	@Test
	public void test1(){
		MyMathFun<Long,Long> m=x->x+x;
		System.out.println(m.math(10l));
	}

}
