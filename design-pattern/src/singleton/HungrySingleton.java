package singleton;

public class HungrySingleton {
    private static final Resource INSTANCE = new Resource("Hungry");

    public static Resource getInstance() {
        return INSTANCE;
    }

    private HungrySingleton() {
    }
}
