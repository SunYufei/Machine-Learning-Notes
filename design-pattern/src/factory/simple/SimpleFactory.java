package factory.simple;

public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.print();
    }
}
