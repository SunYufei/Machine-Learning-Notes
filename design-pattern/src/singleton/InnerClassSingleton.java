package singleton;

public class InnerClassSingleton {
    public static Resource getInstance() {
        return InnerSingleton.INSTANCE;
    }

    private static class InnerSingleton {
        private static final Resource INSTANCE = new Resource("inner class");
    }

    private InnerClassSingleton() {
    }
}
