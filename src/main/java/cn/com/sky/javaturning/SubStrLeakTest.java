package cn.com.sky.javaturning;

import java.util.ArrayList;
import java.util.List;

/**
 * String的 substring 会有内存泄漏的风险。
 */
public class SubStrLeakTest {

	public static void main(String args[]) {
		List<String> handler = new ArrayList<String>();

		for (int i = 0; i < 100000; i++) {
			// HugeStr h = new HugeStr();
			ImprovedHugeStr h = new ImprovedHugeStr();
			handler.add(h.getSubString(1, 5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[100000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	static class ImprovedHugeStr {
		private String str = new String(new char[100000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}

}