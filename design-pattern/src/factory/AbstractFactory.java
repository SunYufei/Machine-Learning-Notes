package factory;

/**
 * @author SunYufei
 * @date 2021/9/16
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory huaweiFactory = new HuaweiFactory();
        Factory iPhoneFactory = new IPhoneFactory();
        Phone huawei = huaweiFactory.createPhone();
        Phone iPhone = iPhoneFactory.createPhone();
        huawei.print();
        iPhone.print();
    }
}

interface Phone {
    void print();
}

class Huawei implements Phone {
    @Override
    public void print() {
        System.out.println("Huawei");
    }
}

class IPhone implements Phone {
    @Override
    public void print() {
        System.out.println("iPhone");
    }
}

interface Factory {
    Phone createPhone();
}

class IPhoneFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

class HuaweiFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Huawei();
    }
}
