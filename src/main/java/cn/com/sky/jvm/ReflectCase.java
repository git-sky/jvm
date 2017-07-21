package cn.com.sky.jvm;

import java.lang.reflect.Method;

/**
 * <pre>
 * 
 * getDeclaredMethod()获取的是类自身声明的所有方法，包含public、protected和private方法。
 * 
 * 用getMethods方法输出的是自身的public方法和父类Object的public方法。
 * 调用getDeclaredMethods方法输出的是自身的public、protected、private方法。
 * 
 * </pre>
 * 
 */
public class ReflectCase {

	public static void main(String[] args) throws Exception {

		Reflect target = new Reflect();

		Method methodPublic = Reflect.class.getDeclaredMethod("runPublic");
		methodPublic.invoke(target);

		Method runDefault = Reflect.class.getDeclaredMethod("runDefault");
		runDefault.invoke(target);

		Method runProtected = Reflect.class.getDeclaredMethod("runProtected");
		runProtected.invoke(target);

		Method runPrivate = Reflect.class.getDeclaredMethod("runPrivate");
		runPrivate.setAccessible(true);// 设置为可访问
		runPrivate.invoke(target);
	}

	static class Reflect {
		public void runPublic() {
			System.out.println("runPublic ......");
		}

		void runDefault() {
			System.out.println("runDefault ......");
		}

		protected void runProtected() {
			System.out.println("runProtected ......");
		}

		private void runPrivate() {
			System.out.println("runPrivate ......");
		}
	}
}