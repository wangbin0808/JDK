package com.jrj.jdk18;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class TestMathTests {

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55),
			new Employee(105, "田七", 38, 5555.55)
	);
	@Test
	public void test(){
		Integer[] sum={1,2,3,4,5};
		Stream<Integer> map = Arrays.stream(sum).map((x)->x*x);
		map.forEach(System.out::println);
	}
	
	@Test
	public void test1(){
		Optional<Integer> reduce = emps.stream().map((e)->1).reduce(Integer::sum);
		System.out.println(reduce.get());
	}
}
