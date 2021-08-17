package factory;


/**
 * 简单工厂模式
 * 优点：创建和使用分离
 * 缺点：不够灵活，新增一个产品类就要修改工厂类的判断逻辑
 * @author Sun
 */
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

abstract class Product {
    public abstract void print();
}

class ProductA extends Product {
    @Override
    public void print() {
        System.out.println("Product A");
    }
}

class ProductB extends Product {
    @Override
    public void print() {
        System.out.println("Product B");
    }
}
