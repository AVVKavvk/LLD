package Builder;

public class User {
    private final String name;
    private final int age;

    private User(UserBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class UserBuilder{
        private String name;
        private int age;

        public UserBuilder(String name){
            this.name = name;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
    public void printInfo() { System.out.println("User: " + name + ", Age: " + age); }
}
