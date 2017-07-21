package cn.com.sky.jvm.oom;

/**
 * 栈溢出
 * 
 * -Xss128k
 */
public class StackOverFlow {

	public int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		StackOverFlow sof = new StackOverFlow();
		try {
			sof.stackLeak();
		} catch (Throwable e) {
			System.out.println(sof.stackLength);
			throw e;
		}

	}
}
