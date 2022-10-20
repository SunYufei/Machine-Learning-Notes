package factory.abs;

class AppleFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Apple();
    }
}
