package com.thread.test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestJdk {

	public static void main(String[] args) {

		int i = 0xFFFFFFFF;
		char c = '\u0571';
		byte b = 01;
		long l = 455555666666l;

		CreateJFrame();
	}

	public static void CreateJFrame() {
		JFrame jf = new JFrame("这是一个JFrame窗体"); // 实例化一个JFrame对象
		jf.setVisible(true); // 设置窗体可视
		jf.setSize(500, 350); // 设置窗体大小
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置窗体关闭方式
	}

}
