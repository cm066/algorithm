package multithreading.jvm;

public class Person {
    private String name = "Jack";
    private int age;
    private final double salary = 100;
    private static String address;
    private final static String hobby = "Programming";
    private static Object obj = new Object();

    public void say() {
        System.out.println("person say...");
    }

    public static int calc(int op1, int op2) {
        op1 = 3;
        int result = op1 + op2;
        Object o = obj;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calc(1, 2));
    }
}
