package collections;

class MyHashMap {
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
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public MyHashMap(int capacity) {
        // 找到传入指定值大的第一个 2 的幂
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        this.capacity = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

        // 初始化时最好指定一个值
        // 值大小为 (int) ((float) expectedSize / 0.75f + 1.0f);
        // 当 HashMap 内部维护哈希表的容量达到 75% 时，会触发 rehash，而 rehash 过程比较耗时
        // 初始化为上述值有效减少冲突，也可减小误差
    }

    // hash 方法
    final int hash(Object key) {
        // 高 16 位与低 16 位的异或
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // ConcurrentHashMap hash 算法
    static int spread(int h) {
        int HASH_BITS = 0x7fffffff;
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    // hashCode -> 数组下标，Java 7
    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }
}
