import Builder.User;

void main() {
    User user = new User.UserBuilder("Vipin").age(22).build();
    user.printInfo();
}