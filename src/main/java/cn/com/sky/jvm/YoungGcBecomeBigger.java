package cn.com.sky.jvm;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * <pre>
 * 
 * YGC之后新生代变大的原因
 * 
 * 只有在出现 promotion failed 的情况下才会发生这样的情况，因为在这个情况下存在to里新增对象，而from和eden不会变化的情况.
 * 
 * 参考： http://www.tuicool.com/articles/ENZrEzJ
 * 
 * 
 * vm参数：-Xms60m -Xmx60m -Xmn50m -XX:SurvivorRatio=1 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 
 * 
 * -XX:NewRatio	
 * 年轻代(包括Eden和两个Survivor区)与年老代的比值(除去持久代)		
 * -XX:NewRatio=4表示年轻代与年老代所占比值为1:4,年轻代占整个堆栈的1/5,Xms=Xmx并且设置了Xmn的情况下，该参数不需要进行设置。
 * 
 * -XX:SurvivorRatio	
 * Eden区与Survivor区的大小比值		
 * -XX:SurvivorRatio=8,则两个Survivor区与一个Eden区的比值为2:8,一个Survivor区占整个年轻代的1/10
 * 
 * 
 * 输出： [GC[DefNew (promotion failed) : 32656K->33126K(34176K), 0.0419924 secs][Tenured:
 * 9712K->9712K(10240K), 0.0089743 secs] 32656K->32240K(44416K), [Perm : 2874K->2874K(21248K)],
 * 0.0510315 secs] [Times: user=0.01 sys=0.03, real=0.05 secs]
 * 
 * 
 */
public class YoungGcBecomeBigger {

	private static int _1M = 1024 * 1024;

	public static void main(String[] args) {

		new YoungGcBecomeBigger().show();
	}

	public void show() {

		List list = Lists.newArrayList();

		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			byte[] b = new byte[_1M];
			list.add(b);
		}
	}
}
