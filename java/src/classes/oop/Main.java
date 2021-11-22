package classes.oop;

/**
 * @author Sun
 */
public class Main {
    public static void main(String[] args) {
        Parent son = new Son();
        Parent daughter = new Daughter();
        son.call();
        daughter.call();
    }
}
