package cn.com.sky.jvm.allocate;

/**
 * <pre>
 * 长期存活对象进入老年代
 * 
 *  VM参数：
 *  
 *  -verbose:gc  -XX:+UseSerialGC  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * 
 * -XX:MaxTenuringThreshold
 * 在新生代中对象存活次数(经过Minor GC的次数)后仍然存活，就会晋升到旧生代。默认值15.
 *
 *
 */
public class MaxTenuringThreshold {

	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		testTenuringThreshold();
	}
}
