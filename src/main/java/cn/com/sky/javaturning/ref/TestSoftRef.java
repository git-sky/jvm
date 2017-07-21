package cn.com.sky.javaturning.ref;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * 
 * 软引用
 * 
 * 
 * -Xmx5M
 */
public class TestSoftRef {

	ReferenceQueue<MyObject> softQueue = null;

	public class CheckRefQueue extends Thread {
		@Override
		public void run() {
			while (true) {
				if (softQueue != null) {
					Reference<MyObject> obj = null;
					try {
						obj = (Reference<MyObject>) softQueue.remove();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (obj != null)
						System.out.println("Object for SoftReference is " + obj.get());
				}
			}
		}
	}

	public class MemConsumer extends Thread {
		HashMap map = new HashMap();

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				map.put(i, new StringBuffer().append(i));
			}
		}
	}

	@Test
	public void test() throws InterruptedException {
		MyObject obj = new MyObject();
		softQueue = new ReferenceQueue<MyObject>();
		SoftReference<MyObject> softRef = new SoftReference<MyObject>(obj, softQueue);

		new CheckRefQueue().start();
		obj = null;
		System.gc();
		System.out.println("After GC:Soft Get= " + softRef.get());
		System.out.println("分配大块内存");
		byte[] b = new byte[5 * 1024 * 900];
		System.out.println("After new byte[]:Soft Get= " + softRef.get());
	}

	@Test
	public void testSimple() throws InterruptedException {
		MyObject obj = new MyObject();

		SoftReference<MyObject> softRef = new SoftReference<MyObject>(obj);
		obj = null;
		System.out.println("Soft Get: " + softRef.get());
		System.gc();
		System.out.println("Soft Get: " + softRef.get());
		byte[] b = new byte[5 * 1024 * 880];
		System.out.println("Soft Get: " + softRef.get());
	}

}