package cn.com.sky.jvm.tools.jinfo;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 简单的应用,有大量的循环和创建对象，供测试JDK自带的jinfo使用
 * 
 * 参数：-Xms30m -Xmx60m
 * 
 */
public class EasyJinfo {

	public byte[] placeHolder = new byte[1 * 1024]; // 占位符

	public static void main(String[] args) throws Exception {

		while (true) {

			Random random = new Random();

			int loops = random.nextInt(10000);

			EasyJinfo jstat = new EasyJinfo();

			System.out.println("......正在构建对象：" + loops + "(个)");

			jstat.getLoop(loops); // 多次循环，产生大量对象

			Thread.sleep(100);

		}

	}

	public void getLoop(int size) {

		ArrayList<EasyJinfo> list = new ArrayList<EasyJinfo>();

		for (int i = 0; i < size; i++) {
			EasyJinfo jstat = new EasyJinfo();
			list.add(jstat);
		}

	}

}