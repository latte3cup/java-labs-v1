package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 * 
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte b = 23;
        short s = 32;
        int i = 42;
        long l = 42L;
        
        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float f = 42.0f;
        double d = 42.0;
        
        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char c = 'k';

        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean bool = false;
        
        
        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println(b+" "+s+" "+i+" "+l+" "+f+" "+d+" "+c+" "+bool);
        
        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        System.out.println(70 / Math.pow(1.67,2));
    }
} 