import java.util.HashMap;

/*
 *模拟HashMap循环现象 
 *
 */
public class HashMapInfiniteLoop {
	private HashMap hash = new HashMap();

	public HashMapInfiniteLoop() {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 50000; i++) {
					hash.put(new Integer(i), Integer.valueOf(i));
				}
				System.out.println("t1 over");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 50000; i++) {
					hash.put(new Integer(i), Integer.valueOf(i));
				}
				System.out.println("t2 over");
			}
		};
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			new HashMapInfiniteLoop();
		}
	}
}