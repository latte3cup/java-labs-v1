package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * Calculator 클래스 정의하기
 */
public class Calculator {
    // TODO: PI 값을 나타내는 static final 상수를 정의하세요.
    static final double PI = 3.14159265358979323846;

    // TODO: 인스턴스 변수를 정의하세요. (계산기 모델명, 계산 횟수 등)
    private final String model = "MK01";
    private int tryNum = 0;




    // TODO: 계산기 객체의 총 개수를 나타내는 static 변수를 정의하세요.
    private static int totalCalculatorCount = 0;


    // TODO: 생성자를 정의하고, 객체가 생성될 때마다 계산기 개수를 증가시키세요.
    public Calculator() {
        totalCalculatorCount++;
    }
    
    // TODO: 원의 면적을 계산하는 static 메소드를 정의하세요.
    public static double circleSize(double radius){
        return radius * radius * PI;
    }
    
    // TODO: 원의 둘레를 계산하는 static 메소드를 정의하세요.
    public static double circleLength(double radius){
        return 2 * radius * PI;
    }
    
    // TODO: 사각형의 면적을 계산하는 static 메소드를 정의하세요.
    public static double squareArea(double width, double height){
        return width * height;
    }

    // TODO: 인스턴스 메소드를 정의하고, 해당 메소드가 호출될 때마다 계산 횟수를 증가시키세요.
    public void addCount(){
        this.tryNum++;
    }

    
    // TODO: 계산기의 정보를 출력하는 메소드를 정의하세요.
    public void info(){
        System.out.println("=============================");
        System.out.println("Model: " + this.model);
        System.out.println("Try: " + this.tryNum);
        System.out.println("=============================");
    }
    
    // TODO: 현재까지 생성된 계산기의 총 개수를 반환하는 static 메소드를 정의하세요.
    public static void printTotalCalCount(){
        System.out.println(totalCalculatorCount);
    }
    
} 