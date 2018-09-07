package com.thread.juc.m2018.m08.m06;


public class TestList {
	
	public static void main(String[] args) {
		way("bin");
		
	}
	
	public static void way(String key){
		
		switch (key) {
		case "wang": System.out.println("wangbin");
			
			break;
		case "bin":System.out.println("ooo");
			break;

		default:
			break;
		}
	}

}
