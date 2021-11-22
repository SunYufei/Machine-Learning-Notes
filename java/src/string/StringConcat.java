package string;

/**
 * @author Sun
 */
public class StringConcat {
    public static void main(String[] args) {
        // String 是 Java 中一个不可变的类，一旦实例化就无法被修改

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

        // StringBuffer 线程安全，并发场景使用
        StringBuffer buffer = new StringBuffer("Hollis");
        String introduce = "introduce";
        buffer = buffer.append(",").append(introduce);

        // StringBuilder 线程不安全，效率最高
        StringBuilder builder = new StringBuilder("Hollis");
        builder = builder.append(",").append(introduce);

        // string.StringUtils.join (apache.commons)
        // string.StringUtils.join("wechat", ",", introduce);

        String[] list = {"Hollis", "introduce"};
        // String result = string.StringUtils.join(list, ",");

        // String.join (JDK8)
        String result = String.join(",", list);

        // string concat in JDK
        // public String concat(String str) {
        //      int otherLen = str.length();
        //      if (otherLen == 0) {
        //          return this;
        //      }
        //      int len = value.length;
        //      char[] buf = Arrays.copyOf(value, len + otherLen);
        //      str.getChars(buf, len);
        //      return new String(buf, true);
        // }
    }
}

//class AbstractStringBuilder {
//    private int count;
//    private char[] value;
//
//    public AbstractStringBuilder append(String str) {
//        if (str == null) {
//            return appendNull();
//        }
//        int len = str.length();
//        ensureCapacityInternal(count + len);
//        str.getChars(0, len, value, count);
//        count += len;
//        return this;
//    }
//}

//class StringBuilder extends AbstractStringBuilder {
//    @Override
//    public StringBuilder append(String str) {
//        super.append(str);
//        return this;
//    }
//}

//class StringBuffer extends AbstractStringBuilder {
//    // TODO check this
//    private String toStringCache;
//
//    @Override
//    public synchronized StringBuffer append(String str) {
//        toStringCache = null;
//        super.append(str);
//        return this;
//    }
//}

