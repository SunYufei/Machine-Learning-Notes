package classes;

/**
 * 抽象类的约束不像接口严格
 * 同样的，不可实例化
 *
 * @author Sun
 */
public abstract class AbstractClass {
    // 构造方法
    public AbstractClass() {
    }

    abstract void abstractMethod();

    private int num;

    public void method() {
    }

    private static int staticNum;

    public static void staticMethod() {
    }
}
