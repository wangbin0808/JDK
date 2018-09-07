package com.jrj.jdk18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class TestLamdba1 {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	@Test
	public void test1(){
		
		Employee em=new Employee();
		em.setName("wangbin");
		
		Supplier<String> su=()->"Supplier";
		String string = su.get();
		System.out.println(string);
		System.out.println("------supplier--------");
		Consumer<Employee> con=(m)->m.getName();
		con.accept(em);
		
		Consumer<String> con1=m ->System.out.println("consumer--");
		con1.accept("hhh");
		System.out.println("--------------consumer-----");
		Function<String, Employee> fun=(x)->new Employee(x);
		Employee employee = fun.apply("wangbin");
		System.out.println(employee);
		//这是构造器的引用
		Function<String ,Employee> fun1=Employee::new;
		Employee employee2 = fun1.apply("wangtianyan");
		System.out.println(employee2);
		System.out.println("-----数组的引用");
		
		Function<Integer,String[]> fun2=String[]::new;
		String[] strings = fun2.apply(10);
		System.out.println(strings.length);
		Function<Integer,String[]> fun4=x->new String[x];
		String[] str = fun4.apply(20);
		System.out.println(str.length);
	}
	/**
	 * 方法的引用
	 */
	@Test
	public void test2(){
		Function<Employee, String> fun=Employee::getName;//这个地方需要注意，并不要()
		String string = fun.apply(new Employee("wangbin"));
		System.out.println(string);
		
		Function<Employee,String> fun1=x->x.getName();
		String str2 = fun1.apply(new Employee("wangbin"));
		System.out.println(str2);
	}
	/**
	 * 断言
	 */
	@Test
	public void test3(){
		Predicate<String> pre=x->x.equals("wangbin");
		System.out.println(pre.test("wangbin"));
		
		BiPredicate<String,String> pre1=String::equals;
		boolean b = pre1.test("wang", "wang");
		System.out.println(b);
	}
	/**
	 * 静态方法的引用
	 */
	@Test
	public void test4(){
		Comparator<Integer> com=(x,y)->Integer.compare(x, y);
		int compare = com.compare(10, 20);
		System.out.println(compare);
		Comparator<Integer> com1=Integer::compare;
		int i = com1.compare(20, 23);
		System.out.println(i);
	}
	
	
}
