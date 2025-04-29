package chapter1._livecode;
// JVM이 자바를 실행하는 규칙
public class Live {
    public static void main(String[] args) {
        a();
        b();
    }

    public static void a() {
        System.out.println("A method called");
    }

    public static void b() {
        System.out.println("B method called");

        long age = 129;
        double salary = 10000.2;
        int salary2 = (int) salary;

        System.out.println(salary2);


    }
}
