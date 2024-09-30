package clock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 高并发下的 System.currentMills()
 */
public final class SystemClock {
    private final AtomicLong now;

    public static long now() {
        return InstanceHolder.INSTANCE.now.get();
    }

    private static class InstanceHolder {
        private static final SystemClock INSTANCE = new SystemClock();
    }

    private SystemClock() {
        this.now = new AtomicLong(System.currentTimeMillis());
        Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }).scheduleAtFixedRate(() -> now.set(System.currentTimeMillis()), 1L, 1L, TimeUnit.MILLISECONDS);
    }
}
