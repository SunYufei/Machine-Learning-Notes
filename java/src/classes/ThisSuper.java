package classes;

/**
 * @author Sun
 */
public class ThisSuper {
    public static void main(String[] args) {
        Apple apple = new Apple(1);
        apple.eat().eat();
    }

    private static class Apple {
        // 默认继承 Object 类

        private int num;
        private String color;

        public Apple(int num) {
            // this() 方法必须放到构造方法第一行
            this(num, "");
        }

        public Apple(String color) {
            this(1, color);
        }

        public Apple(int num, String color) {
            this.num = num;
            this.color = color;
        }

        public Apple eat() {
            this.num--;
            return this;
        }
    }

    private static class Fruit extends Apple {

        public Fruit(int num) {
            super(num);
        }

        @Override
        public Apple eat() {
            return this;
        }
    }
}
