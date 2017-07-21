package cn.com.sky.jvm.tools.jstack;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO
 */
public class TestIO {

	public static void main(String[] args) throws InterruptedException, IOException {

		InputStream is = System.in;
		int i = is.read();
		System.out.println("exit...");

	}
}