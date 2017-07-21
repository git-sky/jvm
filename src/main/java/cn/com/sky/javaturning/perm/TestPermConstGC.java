package cn.com.sky.javaturning.perm;

import org.junit.Test;

/**
 * -XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails
 */
public class TestPermConstGC {

	@Test
	public void permGenGC() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String t = String.valueOf(i).intern();
		}
	}

}