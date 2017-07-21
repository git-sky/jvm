package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

public class TestBooleanAndBit {

	static int count = 10000_0000;

	@Test
	public void test() {
		long start = System.currentTimeMillis();
		boolean a = false;
		boolean b = true;
		int d = 0;
		for (int i = 0; i < count - 1; i++) {
			if (a & b & "Java_Plat".contains("Java")) {
				d = 1;
			}
		}

		System.out.println(d);
		System.out.println("bit：" + (System.currentTimeMillis() - start));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();

		boolean a = false;
		boolean b = true;
		int d = 0;
		for (int i = 0; i < count - 1; i++) {
			if (a && b && "Java_Plat".contains("Java")) {
				d = 1;
			}
		}

		System.out.println(d);

		System.out.println("boolean：" + (System.currentTimeMillis() - start));
	}

}
