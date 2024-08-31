package juc;

import java.util.Collections;
import java.util.List;

public class OrderService {
    public List<?> search() {
        System.out.println("OrderService.search();");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }
}
