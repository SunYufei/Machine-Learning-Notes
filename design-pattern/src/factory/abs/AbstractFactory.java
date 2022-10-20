package factory.abs;

class AbstractFactory {
    public static void main(String[] args) {
        Factory huaweiFactory = new HuaweiFactory();
        Factory iPhoneFactory = new AppleFactory();
        Phone huawei = huaweiFactory.createPhone();
        Phone iPhone = iPhoneFactory.createPhone();
        huawei.print();
        iPhone.print();
    }
}

