package cn.com.sky;

import org.junit.Test;

/**
 * java语言的静态分派属于多分派类型。
 * <p>
 * java语言的动态分派属于单分派。
 */
public class Dispatch {

    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    @Test
    public void test() {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new QQ());
        son.hardChoice(new QQ());
    }
}