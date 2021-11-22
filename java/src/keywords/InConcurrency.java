package keywords;

/**
 * @author Sun
 */
public class InConcurrency {
    /*
     * 可见性：
     * 多个线程访问同一个变量，
     * 一个线程修改了变量的值，
     * 其他线程能够立即看到修改的值
     *
     * 有序性：
     * 程序执行的顺序按照代码的先后顺序执行
     *
     * 原子性：
     * 一个操作不可中断，要么全部执行完成，要么都不执行
     * JVM 通过字节码指令 monitorenter 和 monitorexit
     * synchronized 与这两个指令有关
     * volatile 与这两个指令无关
     */

    /*
     * 缓存一致性协议：
     * 每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，
     * 当处理器发现自己缓存行对应的内存地址被修改，
     * 就会将当前处理器的缓存行设置成无效状态，
     * 当处理器要对这个数据进行修改操作的时候，
     * 会强制重新从系统内存里把数据读到处理器缓存里。
     */

    /*
     * volatile
     * volatile 修饰可能被多线程同时访问的变量
     * 当 volatile 变量数据发生变化时，
     * JVM 向处理器发送 lock 前缀的指令，
     * 变量值会被强制刷入主存；
     * 其他处理器缓存由于遵守缓存一致性协议，
     * 也会把这个变量的值从主存加载到自己的缓存中
     *
     * 总结：
     * 被修饰的变量修改后立即同步到主内存
     * 每次使用前从主内存刷新
     * volatile 禁止指令重排
     */

    /**
     * synchronized
     * 解决并发情况下数据同步访问
     * 被修饰的代码块及方法，在同一时间内只能被单个线程访问
     * <p>
     * 用法：
     * 修饰方法或代码块，
     * 对类或者对象加锁
     */
    public synchronized void doSth() {
        System.out.println("同步方法");
    }

    public void doOtherThings() {
        synchronized (InConcurrency.class) {
            System.out.println("同步代码块");
        }
    }

    /*
     * synchronized 保证原子性、有序性和可见性
     * volatile 只能保证有序性和可见性
     */
}
