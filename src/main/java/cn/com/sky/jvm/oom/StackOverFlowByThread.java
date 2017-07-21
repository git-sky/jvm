package cn.com.sky.jvm.oom;

/**
 * 
 * 创建线程导致内存溢出
 * 
 * 
 * -Xss128k
 * 
 * Xss128k：设置每个线程的堆栈大小。
 * 
 * 注意：容易导致操作系统无响应！！！！
 */
public class StackOverFlowByThread {

	private void loop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					loop();
				}
			});
			t.start();
		}
	}

	public static void main(String[] args) {
		StackOverFlowByThread sof = new StackOverFlowByThread();
		try {
			sof.stackLeakByThread();
		} catch (Throwable e) {
			throw e;
		}

	}
}
