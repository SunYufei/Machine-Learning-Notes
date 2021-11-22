package keywords;

/**
 * 双重校验锁单例模式
 *
 * @author Sun
 */
public class Singleton {
    // volatile 修饰可能被多个线程同时访问的 singleton
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
