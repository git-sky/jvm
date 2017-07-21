import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 一个导致GC慢慢变长的JVM设计缺陷.
 * 
 * YGC 的时间越来越长，从 20ms 慢慢增加到100ms+，甚至还一直在涨。
 * 
 * -XX:+PrintReferenceGC 这个参数，这个参数会打印各种引用的处理时间。
 */
public class ScriptTest {
	private static final String SCRIPT = "var index=1;return 3";

	private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

	private static ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");

	public static void main(String[] args) {

		while (true) {
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("function test(url){");
				sb.append(SCRIPT);
				sb.append("}");
				scriptEngine.eval(sb.toString());
			} catch (ScriptException e) {
				e.printStackTrace();
			}

		}

	}

}
