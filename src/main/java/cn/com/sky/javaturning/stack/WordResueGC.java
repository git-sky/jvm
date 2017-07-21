package cn.com.sky.javaturning.stack;

/**
 * -verbose:gc
 */
public class WordResueGC {

	public static void test1() {// GC无法回收b，因为b还在局部变量表中。
		{
			byte[] b = new byte[6 * 1204 * 1024];
		}
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test2() {// GC可以回收b，赋值为null将回收局部变量表中的数据
		{
			byte[] b = new byte[6 * 1204 * 1024];
			b = null;
		}
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test3() {// GC可以回收b，因为a复用了b的字,GC根找不到b.
		{
			byte[] b = new byte[6 * 1204 * 1024];
		}
		int a = 0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test4() {// GC无法回收b，因为a复用了b，但是b没有被复用。
		{
			int c = 0;
			byte[] b = new byte[6 * 1204 * 1024];
		}
		int a = 0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test5() {// GC可以回收b，因为d复用了b的字
		{
			int c = 0;
			byte[] b = new byte[6 * 1204 * 1024];
		}
		int a = 0;
		int d = 0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void main(String args[]) {
		test1();
		test2();
		test3();
		test4();
		test5();
		System.gc();
		System.out.println("second explict gc over");
	}

}