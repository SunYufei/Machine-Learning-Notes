public class InitialSequence {
    // 1. 静态属性
    private static final String staticField = getStaticField();

    // 2. 静态方法块
    static {
        System.out.println(staticField);
        System.out.println("静态方法块初始化");
    }

    // 3. 普通属性
    private final String field = getField();

    // 4. 普通方法块
    {
        System.out.println(field);
    }

    // 5. 构造函数
    public InitialSequence() {
        System.out.println("构造函数初始化");
    }

    public static String getStaticField() {
        return "Static Field Initial";
    }

    public String getField() {
        return "Field Initial";
    }

    // 主函数
    public static void main(String[] argc) {
        new InitialSequence();
    }
}
