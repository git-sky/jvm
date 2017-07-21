package cn.com.sky.javaturning.incr_speed;

import org.junit.Test;

public class TestCycle {

	static int count = 10000_0000;

	@Test
	public void test() {
		long start = System.currentTimeMillis();

		int[] array = new int[count];
		for (int i = 0; i < count - 1; i++) {
			array[i] = i;
		}

		System.out.println("展开循环前：" + (System.currentTimeMillis() - start));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();

		int[] array = new int[count];
		for (int i = 0; i < count - 6; i += 6) {
			array[i] = i;
			array[i + 1] = i + 1;
			array[i + 2] = i + 2;
			array[i + 3] = i + 3;
			array[i + 4] = i + 4;
			array[i + 5] = i + 5;
		}

		System.out.println("展开循环后：" + (System.currentTimeMillis() - start));
	}

}
