package buider;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Builder<T> {
    // 构造方法
    private final Supplier<T> constructor;
    // 初始化类属性
    private Consumer<T> headConsumer = t -> {
    };

    private Builder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> Builder<T> of(Supplier<T> constructor) {
        return new Builder<>(constructor);
    }

    public static void main(String[] args) {
        Student student = Builder.of(Student::new)
                .with(Student::setName, "zhangsan")
                .with(Student::setAge, 10)
                .build();
        System.out.println(student);
        Builder.of(Student::new)
                .with(Student::setName, ":", name -> !name.contains(":"))
                .with(Student::setAge, 20)
                .build();
    }

    // setter 方法
    public <U> Builder<T> with(BiConsumer<T, U> setter, U value) {
        headConsumer = headConsumer.andThen(instance -> setter.accept(instance, value));
        return this;
    }

    // 带参数校验的 setter 方法
    public <U> Builder<T> with(BiConsumer<T, U> setter, U value, Predicate<U> predictor) {
        if (!predictor.test(value)) {
            throw new IllegalArgumentException(String.format("%s is invalid", value));
        }
        return with(setter, value);
    }

    public T build() {
        // 调用 supplier 生成类实例
        T instance = constructor.get();
        // 调用 setter 构造实例
        headConsumer.accept(instance);
        // 返回构造好的实例
        return instance;
    }

    private static class Student {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("Student{name=\"%s\", age=%d}", name, age);
        }
    }
}
