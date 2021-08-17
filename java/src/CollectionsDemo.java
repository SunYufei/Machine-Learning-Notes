import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Collection 集合接口
 * Collections 包装类
 */
public class CollectionsDemo {
    /**
     * fast-fail 机制
     * Collection 中一种错误检测机制
     * 当迭代集合的过程中该集合在结构上发生改变的时候
     * 可能会发生 fast-fail，
     * 即抛出 ConcruuentModificationException 异常
     */

    public void list() {
        // ArrayList, LinkedList, Vector
        // 都实现了 List 接口，实现方式不同
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        /*
         * LinkedList 双链表
         * 添加和删除元素时具有比 ArrayList 更好的性能
         * get 和 set 方面弱于 ArrayList
         * 实现了 Queue 接口
         */

        /*
         * ArrayList vs Vector
         * Vector 与 ArrayList 类似，但属于强同步类，所有方法实现了同步
         * 若程序线程安全，使用 ArrayList 是更好的选择
         * Vector 每次请求双倍空间，ArrayList 每次 size 增长 50%
         */

        // SynchronizedList vs Vector
        // 都是线程安全的
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        Vector<String> vector = new Vector<>();
        /*
         * 同步区别：
         * Vector 使用同步方法实现
         * SynchronizedList 使用同步代码块实现
         * 同步代码块锁定范围小，范围大小与性能成反比
         * 同步代码块可以精确控制锁区域
         */

        /*
         * 数据增长区别：
         * SynchronizedList add 调用 list.add()
         * Vector add 调用自身 add，每次增大一倍
         * 保存大量数据使用 Vector 有优势，因为可以设置初始化大小避免不必要资源开销
         */

        /*
         * 1. SynchronizedList 有很好的扩展和兼容功能，
         * 可以将所有的 List 子类转成线程安全的类
         * 2. 使用 SynchronizedList 的时候，
         * 进行遍历时要手动进行同步处理
         * 3. SynchronizedList 可以指定锁定的对象
         */
    }

    public void set() {
        /*
         * TreeSet 二叉树实现，数据自动排好序，不允许放入 null
         * HashSet 哈希表实现，数据无序，只允许放入一个 null
         */

        /*
         * HaseSet 底层由 HashMap 实现，
         * 添加元素时首先计算 hashCode 值，
         * 通过扰动计算和按位与的方式计算出这个元素的存储位置，
         * 如果位置为空，则将元素添加；
         * 若元素不为空，则用 equals 方法比较元素是否相等，不相等则找一个空位添加
         */

        /*
         * TreeSet 底层是 TreeMap 的 keySet()
         * TreeMap 基于红黑树实现，红黑树是一个平衡二叉树
         * TreeMap 按 key 排序，插入时调用 compareTo() 方法，
         * TreeSet 元素需要实现 Comparable 接口
         */
    }

    public void map() {
        /*
         * HashMap vs HashTable
         *
         * 1. 线程安全
         * HashTable 方法同步，HashMap 默认非同步
         * 多线程并发时可直接使用 HashTable，
         * 使用 HashMap 需要增加同步处理
         *
         * 2. 继承关系
         * HashTable 继承 Dictionary
         * HashMap 继承抽象类 AbstractMap
         *
         * 3. null 值
         * HashTable 中 KV 均不能出现 null，否则抛出 NullPointerException 异常
         * HashMap 中只能有一个 null-key，可以有多个 null-value
         *
         * 4. 初始容量和扩容机制
         * HashTable 初始大小 11，增加方式 old*2+1
         * HashMap 默认大小 16，且为 2 的倍数
         *
         * 5. hash 值使用不同
         * HashTable 直接使用对象 hashCode
         * HashMap 重新计算 hash 值
         *
         * 6. 遍历方式
         * HashTable：Iterator，支持 fast-fail；Enumeration 不支持 fast-fail
         * HashMap：Iterator，支持 fast-fail
         */

        /*
         * HashMap vs ConcurrentHashMap
         * ConcurrentHashMap 对桶数组实现了分段，HashMap 没有
         * ConcurrentHashMap 在每一个分段上都用锁进行保护，线程安全
         * HashMap 线程不安全
         */

        Hashtable<String, String> hashTable = new Hashtable<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    }

    private class MyHashMap {
        // Map 中 KV 对的个数
        private transient int size;

        // 装载因子，衡量 HashMap 满的程度
        private float loadFactor = DEFAULT_LOAD_FACTOR;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;

        // 临界值，实际 KV 个数超过 threshold 时，HashMap 扩容
        // threshold = 容量 * 装载因子
        private int threshold;

        // 容量，不指定时默认为 16
        // 通过构造函数指定时，会选择大于该数字的第一个 2 的幂作容量
        // 当已知 map 中存放元素个数时，应制定其大小
        private int capacity = DEFAULT_INITIAL_CAPACITY;
        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16


        // hash 方法
        final int hash(Object key) {
            // 高 16 位与低 16 位的异或
            int h;
            return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        // hashCode -> 数组下标，Java 7
        int indexFor(int hash, int length) {
            return hash & (length - 1);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Map<Integer, Integer> map = new HashMap<>();

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size: " + size.get(map));
    }
}
