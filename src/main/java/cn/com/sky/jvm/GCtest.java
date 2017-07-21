package cn.com.sky.jvm;

/**
 * -XX:+PrintGC
 */
public class GCtest {

	private Object instance = null;
	private static final int _10M = 10 * 1 << 20;
	// 一个对象占10M，方便在GC日志中看出是否被回收
	private byte[] bigSize = new byte[_10M];

	public static void main(String[] args) {
		GCtest objA = new GCtest();
		GCtest objB = new GCtest();

		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		System.gc();
	}
}