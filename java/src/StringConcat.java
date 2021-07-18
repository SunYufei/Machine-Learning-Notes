public class StringConcat {
    public static void main(String[] args) {
        // s -> "abcd" in heap
        String s1 = "abcd";
        // s2 and s -> "abcd" in heap
        String s2 = s1;
        // concat, s -> "abcdef" in heap (new)
        s1 = s1.concat("ef");

        // 编译器会进行常量折叠
        String s = "a" + "b";
        // 对于能够优化的 String s = "a" + 变量
        // 用 StringBuilder 的 append() 方法替代
        // 最后调用 toString() 方法
        // 底层是一个 new String()

        // StringBuffer

    }
}
