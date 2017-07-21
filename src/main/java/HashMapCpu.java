import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OOM
 */
public class HashMapCpu {

	private static Map<Long, Set<Integer>> setMap = new ConcurrentHashMap<Long, Set<Integer>>();

	public static void main(String[] args) {
		final long key = 1L;
		setMap.put(key, new HashSet<Integer>());

		for (int i = 0; i < 100; i++) {
			setMap.get(key).add(i);
		}

		Thread a = new Thread(new Runnable() {
			public void run() {
				for (int j = 100; j < 200000; j++) {
					setMap.get(key).add(j);
				}
			}
		});

		Thread b = new Thread(new Runnable() {
			public void run() {
				for (int j = 200000; j < 200000 + 200000; j++) {
					setMap.get(key).add(j);
				}
			}
		});

		a.start();
		b.start();

		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(setMap.toString());
	}
}
