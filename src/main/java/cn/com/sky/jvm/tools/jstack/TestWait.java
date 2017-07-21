package cn.com.sky.jvm.tools.jstack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait()
 */
public class TestWait {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService ex = Executors.newFixedThreadPool(1);
		ex.execute(new Task());

	}
}

class Task implements Runnable {
	@Override
	public void run() {

		synchronized (this) {
			try {
				// 等待被唤醒
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
