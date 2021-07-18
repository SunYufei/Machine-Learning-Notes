public class Polymorphism {
    public static void main(String[] args) {
        Parent son = new Son();
        Parent daughter = new Daughter();
        son.call();
        daughter.call();
    }
}

class Parent {
    public void call() {
        System.out.println("Parent");
    }
}

class Son extends Parent {
    @Override
    public void call() {
        System.out.println("Son");
    }
}

class Daughter extends Parent {
    @Override
    public void call() {
        System.out.println("Daughter");
    }
}
