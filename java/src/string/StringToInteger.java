package string;

public class StringToInteger {
    public static void main(String[] args) {
        int i = 5;
        // String i1 = (new StringBuilder()).append(i).toString(i);
        String i1 = "" + i;
        // i2, i3 相同，String.valueOf 调用 Integer.toString 实现
        String i2 = String.valueOf(i);
        String i3 = Integer.toString(i);
    }
}
