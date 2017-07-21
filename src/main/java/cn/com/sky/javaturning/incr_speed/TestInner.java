package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

public class TestInner {

	@Test
	public void test() {
		long start = System.currentTimeMillis();

		long a = 0;
		for (long i = 0; i < Integer.MAX_VALUE - 10; i++) {
			a++;
		}

		System.out.println(System.currentTimeMillis() - start);
	}

	static long a = 0;

	@Test
	public void test2() {
		long start = System.currentTimeMillis();

		for (long i = 0; i < Integer.MAX_VALUE - 10; i++) {
			a++;
		}

		System.out.println(System.currentTimeMillis() - start);
	}

}
