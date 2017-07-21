package cn.com.sky.jvm.object_size;

import static cn.com.sky.jvm.object_size.SizeOfObject.fullSizeOf;
import static cn.com.sky.jvm.object_size.SizeOfObject.sizeOf;

import java.io.File;

public class SizeofWithInstrumetation {
	private static class ObjectA {
		String str; // 4
		int i1; // 4
		byte b1; // 1
		byte b2; // 1
		int i2; // 4
		ObjectB obj; // 4
		byte b3; // 1
	}

	private static class ObjectB {

	}

	public static void main(String[] args) {
		System.out.println(sizeOf(new ObjectA()));
		System.out.println(sizeOf(new ObjectB()));
	}
}
