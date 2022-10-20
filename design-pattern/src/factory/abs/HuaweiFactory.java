package factory.abs;

class HuaweiFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Huawei();
    }
}
