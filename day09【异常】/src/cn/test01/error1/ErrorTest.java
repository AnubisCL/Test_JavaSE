package cn.test01.error1;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Error:
 * Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。
 * 
 * 一般不编写针对性的代码进行处理。
 *
 */
public class ErrorTest {
	public static void main(String[] args) {

		System.out.println(args[0]+" "+args[1]);
		//1.栈溢出：java.lang.StackOverflowError

		//2.堆溢出：java.lang.OutOfMemoryError 
		Integer[] arr = new Integer[1024*1024*1024];
		//CTRL+ALT+t
		ErrorTest errorTest = new ErrorTest();
		errorTest.add();

		ArrayList<Object> objects = new ArrayList<>();
		new LinkedList<>();
	}


	public int add(){
		return 1;
	}
}
