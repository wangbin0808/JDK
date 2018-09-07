package com.jrj.jdk18.time;

import java.lang.reflect.Method;

import org.junit.Test;
/**
 * 重复注解和类型注解
 * @author Administrator
 *
 */
public class MyAnnocationTest {
	

	
	@Test
	public void test1() throws Exception{
		System.out.println("---");
		Class<MyAnnocationTest> clss=MyAnnocationTest.class;
		Method method = clss.getMethod("test");
		MyAnnocation[] type = method.getAnnotationsByType(MyAnnocation.class);
		for (MyAnnocation myAnnocation : type) {
			System.out.println("---");
			System.out.println(myAnnocation.value());
		}
		System.out.println("99999");
	}
	
	@MyAnnocation("wang")
	@MyAnnocation("hahah")
	@MyAnnocation("wang1")
	@MyAnnocation("wang12")
	@MyAnnocation("wang123")
	public void test(){
		
	}

}
