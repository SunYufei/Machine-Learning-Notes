package classes;

/**
 * @author Sun
 */
public class Interface {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        service.doExecute();
    }

    private interface Service {
        /**
         * 1. 接口是一个完全抽象的类，不提供方法的实现
         * 2. 两种权限：public 和 default
         */
        void doExecute();
    }

    private static class ServiceImpl implements Service {

        @Override
        public void doExecute() {
            System.out.println("execute" + ServiceImpl.class);
        }
    }
}
