import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * <pre>
 * 
 * -Xmx300M -Xms300M  -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -XX:+PrintReferenceGC
 * 
 * JDK 6 是不存在这个问题的，因为 invokedynamic 指令以及 nashorn 是在 JDK 6 里不存在的。
 * 
 */
public class MHTest {
	static MethodHandles.Lookup lookup = MethodHandles.lookup();

	public static void main(String[] args) {

		while (true) {
			MethodType type = MethodType.methodType(double.class, double.class);

			try {
				MethodHandle mh = lookup.findStatic(Math.class, "log", type);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}
}
