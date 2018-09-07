package com.jrj.jdk18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestLamada {
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	
	//先取出年龄大于50的
	@Test
	public void test1(){
		List<Employee> list = testsalaryEmployee(emps);
		for (Employee employee : list) {
			
			System.out.println(employee);
		}
	}
	
	//取出大于5000的
	public List<Employee> testsalaryEmployee(List<Employee> emp){
		List<Employee> e=new ArrayList<Employee>();
		
		for (Employee employee : emp) {
			if(employee.getSalary()>5000){
				e.add(employee);
			}
		}
		return e;
	}
	
	public List<Employee> test1Employee(List<Employee> emp){
		List<Employee> e=new ArrayList<Employee>();
		
		for (Employee employee : emp) {
			if(employee.getAge()>50){
				e.add(employee);
			}
		}
		return e;
	}
	//下面---------------------------------------------
	
	@Test
	public void test2(){
		
/*		List<Employee> list = FunEmployeeInterface(emps,(em)->{
			if(em.getSalary()>5000){
				return true;
			}
			return false;
		});*/
		List<Employee> list = FunEmployeeInterface(emps,(m)-> m.getAge()>50);
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	public List<Employee> FunEmployeeInterface(List<Employee> emp,FunEmployeeInterface<Employee> fun){
		List<Employee> e=new ArrayList<Employee>();
		
		for (Employee employee : emp) {
			if(fun.test(employee)){
				e.add(employee);
			}
		}
		return e;
	}
	
	@Test
	public void test3(){
		emps.stream().filter((m)->m.getAge()>50).forEach(System.out::println);;
		
		emps.stream().map(Employee::getName).forEach(System.out::println);
		
		emps.stream()
			.filter((m)->m.getSalary()>5000)
			.limit(2)
			.forEach(System.out::println);
		
	}
	
	@Test
	public void test4(){

		Collections.sort((List<Employee>) emps, (e1,e2) ->{
			if(e1.getAge()==e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

}
