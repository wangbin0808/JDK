package com.thread.juc.m2018.m08.m06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUserInfo {
	public static void main(String[] args) {
		  // 将对象加入set
		  UserInfo info1 = new UserInfo(1L, "zhangsan", 22);
		  UserInfo info2 = new UserInfo(2L, "lisi", 23);
		  UserInfo info3 = new UserInfo(3L, "wangwu", 24);
		  Set<UserInfo> userInfoSet = new HashSet<>();
		  userInfoSet.add(info1);
		  userInfoSet.add(info2);
		  userInfoSet.add(info3);
		  userInfoSet.stream().forEach(System.out::println);
		  
		  // 对访问到的元素加入集合
		  List<UserInfo> visited = new ArrayList<>();
		  visited.add(info1);
		  visited.add(info2);
		  visited.add(info3);
		  System.out.println("------");
		  visited.stream().forEach(System.out::println);
		  // 假设对其中一个对象进行修改
		  info1.setName("liliu");
		  System.out.println("------");
		  userInfoSet.stream().forEach(System.out::println);
		  System.out.println("------");
		  visited.stream().forEach(System.out::println);
		  System.out.println("------");
		  // 去掉访问过的元素
		  userInfoSet.removeAll(visited);
		  userInfoSet.stream().forEach(System.out::println);
		}
}
