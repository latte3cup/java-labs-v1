package chapter5.labs.lab3;

import java.util.Random;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Book 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Book implements Buyable {
    Random random = new Random();

    // TODO: 책의 속성 정의 (예: 제목, 가격, 저자)
    private String title;
    private int prices;
    private String author;
    private final int pages = random.nextInt(100) + 300;  //300~400

    // TODO: 생성자 정의
    public Book(String title, int prices, String author) {
        this.title = title;
        this.prices = prices;
        this.author = author;
    }

    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public int getPrice() {
        return this.prices;
    }

    @Override
    public String getName() {
        return this.title;
    }

    @Override
    public void printInfo() {
        System.out.println("타이틀 : " + this.title);
        System.out.println("가격 : " + this.prices);
        System.out.println("저서 : " + this.author);
    }


    
    // TODO: 책만의 고유한 메소드 추가
    public void getPages() {
        System.out.println(this.pages);
    }
}