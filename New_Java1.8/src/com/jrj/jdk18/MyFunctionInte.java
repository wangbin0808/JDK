package com.jrj.jdk18;
/**
 * 这是声明函数式接口
 * @author Administrator
 *
 */
@FunctionalInterface
public interface MyFunctionInte<T> {

	public T getValue(T name);
	
}
