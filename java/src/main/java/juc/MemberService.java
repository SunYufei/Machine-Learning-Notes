package juc;

import java.util.Collections;
import java.util.Map;

public class MemberService {
    public Map<?, ?> search() {
        System.out.println("MemberService.search();");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyMap();
    }
}
