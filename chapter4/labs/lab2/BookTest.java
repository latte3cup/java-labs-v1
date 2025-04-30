package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");
        
        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b1 = new Book();
        b1.info();

        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b2 = new Book("Harry Potter");
        b2.info();
        
        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b3 = new Book("Harry Potter","J.K. Rowling");
        b3.info();
        
        
        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b4 = new Book("Harry Potter","J.K. Rowling",30000 );
        b4.info();
        
        
        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b5 = new Book("Harry Potter","J.K. Rowling",30000 ,"U.K publisher");
        b5.info();
        
        
        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        Book b6 = new Book("test","testName",20000,"ME");
        b6.info();
        b6.setPrice(100000000);
        b6.info();
        
    }
} 