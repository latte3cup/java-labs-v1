package chapter5.labs.lab2;

import java.security.PublicKey;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * Bird 클래스를 정의하세요.
 * 이 클래스는 Animal 추상 클래스를 상속받아야 합니다.
 */
public class Bird extends Animal {
    // TODO: 새의 추가 속성 정의 (예: 날개 길이, 종류)
    private double wingLength;
    private String type;
    // TODO: 생성자 정의

    public Bird(String name, int age, double wingLength, String type) {
        super(name, age);
        this.wingLength = wingLength;
        this.type = type;
    }


    // TODO: 추상 메소드 sound() 구현
    @Override
    public void sound(){
        System.out.println("쨱쨱");
    }
    
    // TODO: 필요한 경우 부모 클래스의 메소드 오버라이딩
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("새의 날개 길이 : " + this.wingLength);
        System.out.println("새의 종류 : " + this.type);
    }
    
    // TODO: 새만의 고유한 메소드 추가 (예: fly)
    public void fly(){
        System.out.println("하늘을 난다");
    }
} 