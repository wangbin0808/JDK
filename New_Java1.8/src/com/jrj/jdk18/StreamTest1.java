package com.jrj.jdk18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest1 {
	
	@Test
	public void create(){
		//下面是通过Collection集合来创建流
		List<String> list=new ArrayList<>();
		//这是创建一个流
		Stream<String> stream = list.stream();
		//这是创建并行流
		Stream<String> parallelStream = list.parallelStream();
		//用数组来创建流
		Integer[] u=new Integer[10];
		Stream<Integer> stream2 = Arrays.stream(u);
		//使用Stream的of方法来创建流
		Stream<String> of = Stream.of("12");
		//创建无限流
		Stream.iterate(0, (x)->x+2).limit(10).forEach(System.out::println);
		Stream.generate(Math::random).limit(10).forEach(System.out::println);;
	}
	

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	@Test
	public void test1(){
		
//		emps.stream()
//			.filter((x)->x.getAge()>50)
//			.forEach(System.out::println);
//		//allMatch这个是判断所有的都符合薪水大于1000，满足为true，否则为false
//		boolean allMatch = emps.stream().allMatch(x->x.getSalary()>1000);
//		  
//		System.out.println(allMatch);
//		
//		emps.stream().map((x)->x).forEach(System.out::println);
		Stream<Employee> map = emps.stream().map((x)->x);
//		Optional<Employee> first = map.findFirst();
//		System.out.println(first);
//		Optional<Employee> findAny = map.findAny();
//		System.out.println(findAny);

		emps.stream().skip(2).distinct().forEach(System.out::println);
		
	}
	
	@Test
	public void test2(){
		String[] str={"aaa","bbb","ccc","ddd"};
		
//		Stream<String> stream = Arrays.stream(str);
//		Stream<String> map = stream.map(String::toUpperCase);
//		map.forEach(System.out::println);
//		
//		emps.stream().map(Employee::getName).forEach(System.out::println);
		
//		emps.parallelStream().map(x->x.getName()).forEach(System.out::println);
//		
//		Stream<Stream<Character>> map = Arrays.stream(str).map(StreamTest1::filter);
//		map.forEach(x->{
//			x.forEach(System.out::println);
//		});
		
//		emps.stream().sorted((e1,e2)->{
//			return -(e1.getAge()-e2.getAge());
//		}).forEach(System.out::println);;
		
		emps.stream()
		    .sorted((e1,e2)->{
		    	if(e1.getAge()==e2.getAge()){
		    		return e1.getName().compareTo(e2.getName());
		    	}else{
		    		return Integer.compare(e1.getAge(), e2.getAge());
		    	}
		    }).forEach(System.out::println);
		
		emps.stream().map(Employee::getName).sorted().forEach(System.out::println);
	}
	
	public static Stream<Character> filter(String name){
		
		List<Character> list=new ArrayList<>();
		for (Character character : name.toCharArray()) {
			list.add(character);
		}
		return list.stream();
		
		
	}
	
	/**
	 * 	allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值 ,这个是找到一个最大值
		min——返回流中最小值
	 */
	@Test
	public void test5(){
		Stream<Employee> stream = emps.stream();
//		long count = emps.stream().count();
//		System.out.println(count);
//		Optional<Employee> max = stream.max((e1,e2)->{
//			return -Integer.compare(e1.getAge(), e2.getAge());
//		});
//		
//		System.out.println(max);
		
		Optional<Employee> min = stream.min((e1,e2) ->{
			return (int) -(e1.getSalary()- e2.getSalary());
		});
		System.out.println(min);
	}
	/**
	 * 归约
		reduce(T identity, BinaryOperator) 
		/ reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test6(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Optional<Integer> reduce = list.stream().reduce((x,y)->{return x+y;});
		System.out.println(reduce);
		Optional<Double> reduce2 = emps.stream().map(Employee::getSalary).reduce((x,y)->{return x+y;});
		System.out.println(reduce2);
		
		 Double reduce3 = emps.stream().map(Employee::getSalary)
		 .reduce(0.0, Double::sum);
		 System.out.println(reduce3);
	}
	//collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	
	@Test
	public void test7(){
//		List<String> collect = emps.stream().map(Employee::getName).collect(Collectors.toList());
//		collect.stream().forEach(System.out::println);
//		
		//可以去重
		Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet());
		set.stream().forEach(System.out::println);
		//平均值
		Double collect = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(collect);
		Double sum = emps.stream()
		.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		Optional<Employee> max = emps.stream()
		.collect(Collectors.maxBy((x,y)->Double.compare(x.getSalary(), y.getSalary())));
		System.out.println(max.get());
	}

}
