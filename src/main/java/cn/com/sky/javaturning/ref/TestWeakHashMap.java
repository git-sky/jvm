package cn.com.sky.javaturning.ref;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * -Xmx5M
 */
public class TestWeakHashMap {

	Map map;

	@Test
	public void testWeakHashMap() {
		map = new WeakHashMap();
		List l = new ArrayList();
		for (int i = 0; i < 10000; i++) {
			Integer ii = new Integer(i);
			map.put(ii, new byte[i]);
		}
	}

	@Test
	public void testWeakHashMap2() {
		map = new WeakHashMap();
		List l = new ArrayList();
		for (int i = 0; i < 10000; i++) {
			Integer ii = new Integer(i);
			l.add(ii);
			map.put(ii, new byte[i]);
		}
	}

	@Test
	public void testHashMap() {
		map = new HashMap();
		for (int i = 0; i < 10000; i++) {
			Integer ii = new Integer(i);
			map.put(ii, new byte[i]);
		}
	}

}