package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplace {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello, 正则表达式 Hello");
        // replaceAll 替换符合正则的所有文字
        System.out.println(matcher.replaceAll("Java"));
        // replaceFirst 替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));

        // 去除 html 标记
        pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        System.out.println(matcher.replaceAll(""));

        // 替换指定 {} 中文字
        String str = "Java目前的发展史是由{0}年-{1}年";
        String[][] object = {
                new String[]{
                        "\\{0\\}",
                        "1995"
                },
                new String[]{
                        "\\{1\\}",
                        "2011"
                }
        };
        // 自定义 replace 函数
        System.out.println(replace(str, object));

        // replace() 替换字符串
        System.out.println("abac".replace("a", "\\a"));
    }

    private static String replace(final String sourceString, Object[] object) {
        String temp = sourceString;
        for (Object obj : object) {
            String[] result = (String[]) obj;
            Pattern pattern = Pattern.compile(result[0]);
            Matcher matcher = pattern.matcher(temp);
            temp = matcher.replaceAll(result[1]);
        }
        return temp;
    }
}
