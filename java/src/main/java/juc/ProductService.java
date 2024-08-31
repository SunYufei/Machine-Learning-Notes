package juc;

import java.util.Collections;
import java.util.List;

public class ProductService {
    public List<?> search() {
        System.out.println("ProductService.search();");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }
}
