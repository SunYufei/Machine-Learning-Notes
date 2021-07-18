import java.util.ArrayList;
import java.util.List;

public class Boxing {
    public static void main(String[] args) {
        // auto boxing
        // Integer a = new Integer(10);
        Integer a = 10;
        // auto unboxing
        int b = a;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
            // list.add(Integer.valueOf(i));
        }
    }
}
