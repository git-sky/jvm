package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

/**
 * 位运算快于乘除运算
 */
public class TestBitCalc {

	static int count = 1000_000_000;

	@Test
	public void test() {
		long start = System.currentTimeMillis();

		long a = 100;
		for (long i = 0; i < count; i++) {
			a *= 2;
			a /= 2;
		}

		System.out.println(a);
		System.out.println("乘除运算：" + (System.currentTimeMillis() - start));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();

		long a = 100;
		for (long i = 0; i < count; i++) {
			a <<= 1;
			a >>= 1;
		}
		System.out.println(a);
		System.out.println("位运算：" + (System.currentTimeMillis() - start));
	}

}
