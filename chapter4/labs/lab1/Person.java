package chapter4.labs.lab1;

import lombok.AllArgsConstructor;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스 정의하기
 */

@AllArgsConstructor
public class Person {
    // TODO: 이름, 나이, 성별을 저장할 수 있는 필드를 정의하세요.
    private  String name;
    private  int age;
    private  boolean gender; // 1: 남 // 0:여
    
    
    // TODO: 객체 정보를 출력하는 메소드를 작성하세요.
    public void info(){
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("------------------------");

    }
    
    
    // TODO: 생일이 지났을 때 나이를 한 살 증가시키는 메소드를 작성하세요.
    public void addAge(){
        this.age += 1;
    }
    
} 