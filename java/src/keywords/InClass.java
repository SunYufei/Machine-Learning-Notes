package keywords;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Sun
 */
public class InClass {
    /**
     * transient 修饰的成员变量
     * 在序列化时，其值会被忽略
     * 在反序列化后，变量值设为初始值
     *
     * elementData in ArrayList
     */
    private transient Object[] elementData;

    /**
     * instanceof 测试左边对象是否是右边类的实例
     * 返回 boolean
     */
    public static void displayObjectClass(Object o) {
        if (o instanceof Vector) {
            System.out.println("java.util.Vector");
        } else if (o instanceof ArrayList) {
            System.out.println("java.util.ArrayList");
        } else {
            System.out.println(o.getClass());
        }
    }

    /**
     * final 变量，无法改变值
     */
    private final String name = "Zhang San";

    /**
     * final 方法，不能覆盖
     * final 类，不能继承
     */
    final void getName() {

    }

    /**
     * 静态变量，不属于类的对象或实例
     * 静态变量与所有对象实例共享
     * 线程不安全
     */
    private static int count;
    // 使用方法 类名.变量名
    public static String str;

    /**
     * 静态方法
     * 只能使用静态变量和调用静态方法
     * 静态方法用于给其他类使用而不需要创建实例
     */
    public static void setCount(int count) {
        if (count < 0) {
            InClass.count = count;
        }
    }

    public static int addNums(int pre, int... nums) {
        int sum = pre;
        for (int x : nums) {
            sum += x;
        }
        return sum;
    }

    /*
     * 静态块
     * 初始化类静态变量
     * 类装载时创建静态资源
     * 静态块中不允许使用非静态变量
     */
    static {
        str = "Test";
        setCount(0);
    }
}
