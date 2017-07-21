package cn.com.sky.jvm;

/**
 * 
 * -XX:+PrintGCDetails
 */
public class Test {
	public static void main(String[] args) {
		Object obj = new Object();
		System.gc();
		System.out.println();
		obj = new Object();
		obj = new Object();
		System.gc();
		System.out.println();
	}
}
