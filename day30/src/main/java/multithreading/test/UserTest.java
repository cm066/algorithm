package multithreading.test;

class User{
    String name;
}
public class UserTest {

    public static void main(String[] args) {
        User user = new User();
        user.name = "aaa";
        System.out.println(user);
        User test = test(user);
        System.out.println(test.name);
        System.out.println(user.name);
    }

    public static User test(User user){

        User user1 = user;
        user1.name = "bbbb";

        return user1;
    }
}
