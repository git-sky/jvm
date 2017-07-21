package cn.com.sky.javaturning.stack;

import org.junit.Test;

/**
 * -Xss1M
 * 
 * 
 * deep of stack is 11375
 * 
 * java.lang.StackOverflowError
 * 
 */
public class TestStack {
	private int count = 0;

	public void recursion() throws InterruptedException {
		count++;
		recursion();
	}

	@Test
	public void testStack() {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();

		}
	}

	public void t() {
	}

}