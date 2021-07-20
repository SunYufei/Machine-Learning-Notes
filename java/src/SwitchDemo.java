public class SwitchDemo {
    public static void main(String[] args) {
        // switch 支持 byte short int char String
        switchInt(0);
        switchChar('a');
        switchString("abc");
    }

    private static void switchInt(int i) {
        switch (i) {
            case 1:
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    private static void switchChar(char c) {
        // char 类型的 switch 转换为 ASCII 数值进行整数比较
        switch (c) {
            case 'a':
                break;
            case 'b':
                break;
            default:
                break;
        }
    }

    private static void switchString(String str) {
        switch (str) {
            case "abc":
                break;
            case "def":
                break;
            default:
                break;
        }
        // 上述代码反编译
        // String s;
        // switch ((s = str).hashCode()) {
        //     default:
        //         break;
        //     case 99162322:
        //         if (s.equals("abc")) {
        //         }
        //         break;
        //     case 12312433:
        //         if (s.equals("def")) {
        //         }
        //         break;
        // }
    }
}
