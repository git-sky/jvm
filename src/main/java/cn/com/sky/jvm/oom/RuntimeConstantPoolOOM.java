package cn.com.sky.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 运行时常量池导致的内存溢出
 * 
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * JDK6会出现溢出。
 * JDK7之后不会出现问题。因为常量池被移出方法区。
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
