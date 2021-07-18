public class Overload {

}

class Dog {
    public void bark() {
        System.out.println("woof");
    }

    // overloading
    public void bark(int num) {
        for (int i = 0; i < num; i++) {
            bark();
        }
    }
}
