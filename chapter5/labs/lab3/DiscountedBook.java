package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * DiscountedBook 클래스를 정의하세요.
 * 이 클래스는 Book 클래스를 상속받고 Discountable 인터페이스를 구현합니다.
 */
public class DiscountedBook extends Book implements Discountable {
    // TODO: 할인 관련 속성 추가 (예: 할인율)
    private int discountPercentage;
    
    // TODO: 생성자 정의

    public DiscountedBook(String title, int prices, String author, int discountPercentage) {
        super(title, prices, author);
        this.discountPercentage = discountPercentage;
    }


    // TODO: Discountable 인터페이스의 메소드 구현

    @Override
    public int getDiscountedPrice() {
        return getPrice() * discountPercentage / 100;
    }

    @Override
    public int getDiscountPercent() {
        return this.discountPercentage;
    }

    @Override
    public void printDiscountInfo() {
        System.out.println("할인된 책 정보는....");
        super.printInfo();
        System.out.println("Discount percentage: " + getDiscountPercent());
        System.out.println("Final Price is " + getDiscountedPrice());
    }


    // TODO: 필요한 경우 부모 클래스의 메소드 오버라이딩
    //None
} 