package cn.com.sky;

import org.junit.Test;

/**
 * 静态分派
 * <p>
 * 虚拟机（编译器）在确定重载函数版本时是通过参数的静态类型而不是实际类型作为判定依据。
 * <p>
 * 因此，在编译阶段，编译器就可以根据静态类型确定使用哪个重载的版本。
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    @Test
    public void test() {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
//        sr.sayHello(man);
//        sr.sayHello(woman);

        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);

    }


    public void sayHello(Human guy) {
        System.out.println("Hello guy");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello man");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello woman");
    }
}