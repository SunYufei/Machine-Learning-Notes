package classes;

/**
 * @author Sun
 */
public class Constructor {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3, 4);
        System.out.println(rectangle.area());
    }

    private static class Rectangle {
        private double width;
        private double height;

        public Rectangle() {
            this.width = 0.0;
            this.height = 0.0;
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double area() {
            return this.width * this.height;
        }
    }
}
