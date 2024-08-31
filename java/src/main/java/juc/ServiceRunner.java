package juc;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ServiceRunner {
    private static final MemberService MEMBER_SERVICE = new MemberService();
    private static final OrderService ORDER_SERVICE = new OrderService();
    private static final ProductService PRODUCT_SERVICE = new ProductService();

    public static void sequence() {
        MEMBER_SERVICE.search();
        ORDER_SERVICE.search();
        PRODUCT_SERVICE.search();
    }

    public static void parallel() {
        CompletableFuture<?> member = CompletableFuture.supplyAsync(MEMBER_SERVICE::search);
        CompletableFuture<?> order = CompletableFuture.supplyAsync(ORDER_SERVICE::search);
        CompletableFuture<?> product = CompletableFuture.supplyAsync(PRODUCT_SERVICE::search);
        CompletableFuture.allOf(member, order, product).join();
        try {
            member.get();
            order.get();
            product.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * member
     * / \
     * order product
     */
    public static void preorder() {
        CompletableFuture.completedFuture(MEMBER_SERVICE.search()).join();
        //
        CompletableFuture<?> order = CompletableFuture.supplyAsync(ORDER_SERVICE::search);
        CompletableFuture<?> product = CompletableFuture.supplyAsync(PRODUCT_SERVICE::search);
        CompletableFuture.allOf(order, product).join();
    }

    /**
     * member
     * product - order
     */
    public static void event() {
        CompletableFuture<?> member = CompletableFuture.supplyAsync(MEMBER_SERVICE::search);
        CompletableFuture<?> product = CompletableFuture.supplyAsync(PRODUCT_SERVICE::search);
        CompletableFuture<?> order = product.thenApply((products) -> ORDER_SERVICE.search());
        CompletableFuture.allOf(member, order).join();
    }
}
