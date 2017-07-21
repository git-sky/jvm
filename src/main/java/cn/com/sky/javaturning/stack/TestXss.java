package cn.com.sky.javaturning.stack;

/**
 * -Xss10M -Xmx3000M -Xms3000M
 * 
 * count thread is 31637
 * 
 * java.lang.OutOfMemoryError: unable to create new native thread
 */
public class TestXss {

	public static class MyThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		int i = 0;
		try {
			for (i = 0; i < 100000; i++) {
				new MyThread().start();
			}
		} catch (OutOfMemoryError e) {
			System.out.println("count thread is " + i);
			e.printStackTrace();
		}
	}

}