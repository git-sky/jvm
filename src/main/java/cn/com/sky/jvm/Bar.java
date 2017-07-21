package cn.com.sky.jvm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bar {

	int a = 1;
	volatile int b = 2;

	final int c = 3;

	Lock lock = new ReentrantLock();

	public void sum() {
		synchronized (this) {
			a = 4;
		}
	}

	public void read() {
		a++;
		b++;

	}

	public void write() {
		a = 7;
		b = 8;
	}

	public void get() {
		int x = c;
		System.out.println(x);
	}

	public static void main(String[] args) {

		new Bar().write();
		new Bar().read();
		new Bar().sum();
		new Bar().get();

	}

}