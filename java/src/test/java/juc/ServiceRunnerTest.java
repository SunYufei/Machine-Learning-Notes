package juc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceRunnerTest {
    @Test
    public void test() {
        Assertions.assertEquals(12, run("sequence", ServiceRunner::sequence) / 100);
        Assertions.assertEquals(5, run("parallel", ServiceRunner::parallel) / 100);
        Assertions.assertEquals(8, run("preorder", ServiceRunner::preorder) / 100);
        Assertions.assertEquals(9, run("event", ServiceRunner::event) / 100);
    }

    public long run(String name, Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(name + " total time: " + duration + "ms\n");
        return duration;
    }
}
