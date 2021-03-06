package cn.com.sky.jvm.allocate;

/**
 * <pre>
 * 
 * VM参数：-verbose:gc -XX:+UseSerialGC  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 
 * 
 * Xmx20M：设置JVM最大可用内存为20M。
 * Xms20M：设置JVM初始内存为20M。
 * Xmn10M：设置年轻代大小为10M。
 * 
 * 
 * 整个JVM内存大小=年轻代大小 + 老年代大小 + 持久代大小。
 * 
 * 
 * DefNewGeneration是default new generation 
 * ParNewGeneration是parallel new generation 
 * 
 * DefNew：是使用-XX:+UseSerialGC（新生代，老年代都使用串行回收收集器）。
 * ParNew：是使用-XX:+UseParNewGC（新生代使用并行收集器，老年代使用串行回收收集器）
 *       -XX:+UseConcMarkSweepGC(新生代使用并行收集器，老年代使用CMS)。
 * 
 * PSYoungGen: -XX:+UseParallelGC（新生代使用并行回收收集器，老年代使用串行收集器）
 * -XX:+UseParallelOldGC（新生代，老年代都使用并行回收收集器）
 * 
 */
public class Allocate {
	private static final int _1MB = 1024 * 1024;

	public static void testAllocation() {

		byte[] allocation1, allocation2, allocation3, allocation4;

		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		System.gc();
		allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
		allocation1 = new byte[2 * _1MB];
		System.gc();
		allocation1 = new byte[2 * _1MB];
		allocation1 = new byte[2 * _1MB];
//		System.gc();
	}

	public static void main(String[] args) {

		Allocate a = new Allocate();
		a.testAllocation();

	}

}
