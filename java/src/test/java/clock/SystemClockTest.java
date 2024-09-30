package clock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SystemClockTest {
    @Test
    public void sequence() throws InterruptedException {
        long first = SystemClock.now();
        Thread.sleep(100);
        long second = SystemClock.now();
        long diff = second - first;
        System.out.println("first: " + first + " second: " + second + " diff: " + diff);
        Assertions.assertTrue(diff >= 100);
    }

    @Test
    public void parallel() throws InterruptedException {
        int threads = 50;
        CyclicBarrier barrier = new CyclicBarrier(threads);
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        try (ExecutorService executor = Executors.newFixedThreadPool(threads)) {
            for (int i = 0; i < threads; i++) {
                executor.submit(() -> {
                    try {
                        barrier.await();
                        //
                        System.out.println(SystemClock.now());
                        //
                        countDownLatch.countDown();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            countDownLatch.await();
        }
    }
}
