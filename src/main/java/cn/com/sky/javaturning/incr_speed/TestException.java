package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

public class TestException {

	@Test
	public void test() {

		long start = System.currentTimeMillis();
		long a = 0;
		try {
			for (long i = 0; i < Integer.MAX_VALUE * 100; i++) {
				a++;
			}

		} catch (Exception e) {

		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
	}

	@Test
	public void test2() {

		long start = System.currentTimeMillis();

		long a = 0;
		for (long i = 0; i < Integer.MAX_VALUE * 100; i++) {
			try {
				a++;

			} catch (Exception e) {

			}
			a++;
		}

		System.out.println("耗时:" + (System.currentTimeMillis() - start));

	}
}
