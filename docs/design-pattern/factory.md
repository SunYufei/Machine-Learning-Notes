# 工厂模式

定义一个创建对象的接口，让子类决定实例化哪个类

## 简单工厂模式

又称静态工厂方法模式

根据参数不同返回不同类实例

定义一个类负责创建其他类实例，被创建的类通常拥有共同的父类

优点：创建和使用分离

缺点：不够灵活，新增一个产品类就要修改工厂的判断逻辑

<<< design-pattern/src/factory/simple/Product.java

<<< design-pattern/src/factory/simple/ProductA.java

<<< design-pattern/src/factory/simple/ProductB.java

<<< design-pattern/src/factory/simple/SimpleFactory.java

## 抽象工厂模式

<<< design-pattern/src/factory/abs/AbstractFactory.java

<<< design-pattern/src/factory/abs/Phone.java

<<< design-pattern/src/factory/abs/Huawei.java

<<< design-pattern/src/factory/abs/Apple.java

<<< design-pattern/src/factory/abs/Factory.java

<<< design-pattern/src/factory/abs/HuaweiFactory.java

<<< design-pattern/src/factory/abs/AppleFactory.java
