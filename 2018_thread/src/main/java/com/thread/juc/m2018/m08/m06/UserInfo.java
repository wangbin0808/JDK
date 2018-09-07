package com.thread.juc.m2018.m08.m06;

import java.util.Objects;

public class UserInfo {
	  private Long id;
	  private String name;
	  private Integer age;
	 
	  public UserInfo(Long id, String name, Integer age) {
	    this.id = id;
	    this.name = name;
	    this.age = age;
	  }
	 
	  public void setName(String name) {
	    this.name = name;
	  }
	 
	  @Override
	  public String toString() {
	    return "UserInfo{" +
	      "id=" + id +
	      ", name='" + name + '\'' +
	      ", age=" + age +
	      '}';
	  }
	 
	  @Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    UserInfo info = (UserInfo) o;
	    return Objects.equals(id, info.id) &&
	      Objects.equals(name, info.name) &&
	      Objects.equals(age, info.age);
	  }
	 
	  @Override
	  public int hashCode() {
	    return Objects.hash(id, name, age);
	  }
	   
	}
