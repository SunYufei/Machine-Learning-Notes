public class Constructor {
    public static void main(String[] args) {

    }
}

class Rectangle {
    public Rectangle() {
        this.width = 0.0;
        this.height = 0.0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return this.width * this.height;
    }

    private double width;
    private double height;
}
