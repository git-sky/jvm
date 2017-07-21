package cn.com.sky.javaturning;

import java.util.HashMap;

/**
 * <pre>
 * 
 *  -Xmx512M -Xms512M -XX:+UseParNewGC -Xloggc:gc.log -XX:+PrintGCDetails
 *  3203
 *  355
 *  
 *  -Xmx512M -Xms512M -XX:+UseParallelOldGC -XX:ParallelGCThreads=8 -Xloggc:gc.log -XX:+PrintGCDetails
 *  338
 *  
 *  3593
 *  
 *  -Xmx512M -Xms512M -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails
 *  427
 *  3360
 *  
 *  
 *  -Xmx512M -Xms512M -XX:+UseConcMarkSweepGC -Xloggc:gc.log -XX:+PrintGCDetails
 * 350
 *  2516
 *  
 *  -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC
 * 1156
 * 
 */
public class GCTimeTest {

	static HashMap map = new HashMap();

	public static void main(String args[]) {
		long begintime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			if (map.size() * 512 / 1024 / 1024 >= 400) {
				map.clear();
				System.out.println("clean map");
			}
			byte[] b1;
			for (int j = 0; j < 100; j++) {
				b1 = new byte[512];
				map.put(System.nanoTime(), b1);
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - begintime);
	}

}