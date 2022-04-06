package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sun
 */
public class Demo {
    /*
     * Stream 使用一种类似 SQL 语句从数据库查询数据的方式提供对 Java 集合运算和表达的高阶抽象
     * 特性：
     * 1. 无存储。它只是某种数据源（数组，Java 容器，I/O channel 等）的一个视图
     * 2. 为函数式编程而生。对 Stream 的任何修改不会修改背后的数据源，而是会产生一个不包含被过滤元素的新 Stream
     * 3. 懒惰执行。在 Stream 上的操作不会立即执行，在真正需要结果的时候才会执行。
     * 4. 可消费性。Stream 只能被消费一次，一旦遍历过就会失效，就像容器迭代器一样，再次遍历必须重新生成。
     */

    public static void main(String[] args) {
        // 通过已有集合创建流
        List<String> strings = Arrays.asList("first", "second", "third", "fourth");
        Stream<String> streamOfStrings = strings.stream();
        Stream<String> parallelStreamOfStrings = strings.parallelStream();

        // 通过 Stream 创建流
        Stream<String> stream = Stream.of("first", "second", "third");
    }
}
