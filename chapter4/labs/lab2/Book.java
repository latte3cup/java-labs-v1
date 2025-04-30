package chapter4.labs.lab2;

import lombok.Setter;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스 정의하기
 */
@Setter
public class Book {
    // TODO: 제목, 저자, 가격, 출판연도를 저장할 수 있는 필드를 정의하세요.
    private String title;
    private String author;
    private int price;
    private String publisher;

    
    // TODO: 기본 생성자를 정의하세요.
    public Book(){};
    
    
    // TODO: 제목만 인자로 받는 생성자를 정의하세요. (this() 사용)
    public Book(String title){
        this(title,"",0,"");
    }
    
    
    // TODO: 제목과 저자를 인자로 받는 생성자를 정의하세요. (this() 사용)
    public Book(String title,String author){
        this(title,author,0,"");
    }
    
    
    // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 정의하세요. (this() 사용)
    public Book(String title,String author,int price){
        this(title,author,price,"");
    }
    
    
    // TODO: 모든 필드를 인자로 받는 생성자를 정의하세요.
    public Book(String title,String author,int price,String publisher){
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
    }
    
    
    // TODO: 책의 정보를 출력하는 메소드를 정의하세요.
    public void info(){
        System.out.println("==================================================");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("Publisher: " + this.publisher);
        System.out.println("==================================================");

    }
    
} 