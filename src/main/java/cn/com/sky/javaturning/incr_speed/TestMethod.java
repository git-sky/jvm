package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

public class TestMethod {

	static int count = 10_0000_0000;

	static void smethod() {

	}

	void method() {

	}

	@Test
	public void test() {

		long start = System.currentTimeMillis();

		for (int i = 0; i < count - 1; i++) {
			smethod();
		}

		System.out.println("static method 耗时：" + (System.currentTimeMillis() - start) + "ms");
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < count - 1; i++) {
			method();
		}

		System.out.println("normal method 耗时：" + (System.currentTimeMillis() - start) + "ms");
	}

}
