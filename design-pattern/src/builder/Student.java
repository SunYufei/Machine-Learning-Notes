package builder;

public class Student {
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
        return String.format("Student{name=\"%s\", age=%d}", getName(), getAge());
    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder {
        private final Student student;

        public Builder() {
            this.student = new Student();
        }

        public Builder name(String name) {
            this.student.setName(name);
            return this;
        }

        public Builder age(Integer age) {
            this.student.setAge(age);
            return this;
        }

        public Student build() {
            return student;
        }
    }

    public static void main(String[] args) {
        Student student = Student.builder().name("ZhangSan").age(10).build();
        System.out.println(student);
    }
}
