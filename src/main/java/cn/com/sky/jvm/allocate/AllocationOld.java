package cn.com.sky.jvm.allocate;

/**
 * <pre>
 * 
 * 直接分配在老年代中
 * 
 * VM参数：-verbose:gc -XX:+UseSerialGC  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 
 * 直接分配到老年代的对象的大小，大于这个参数的对象直接在老年代分配。
 *  -XX:PretenureSizeThreshold=3145728
 * 
 * 使用Serial + Serial Old 收集器
 * -XX:+UseSerialGC 
 * 
 */
public class AllocationOld {

	private static final int _1MB = 1024 * 1024;

	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB]; // 直接分配在老年代中
	}

	public static void main(String[] args) {

		AllocationOld a = new AllocationOld();
		a.testPretenureSizeThreshold();

	}

}
