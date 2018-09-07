package com.jrj.jdk18;

@FunctionalInterface
public interface MyMathFun<T,R> {

	public R math(T t);
}
