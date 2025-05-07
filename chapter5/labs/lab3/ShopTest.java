package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Book b1 = new Book("해리 포터", 20000,"J.K Rolling");
        
        // TODO: Electronics 객체 생성
        Electronics e1 = new Electronics("마우스",15000,"로지텍");
        
        // TODO: DiscountedBook 객체 생성
        DiscountedBook db1 = new DiscountedBook("반지의 제왕 전권 세트",100000,"누구지",50);
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart cart = new ShoppingCart();
        


        // TODO: 장바구니에 상품 추가하기
        cart.addProduct(b1);
        cart.addProduct(e1);
        cart.addProduct(db1);


        // TODO: 장바구니 내용과 총액 출력하기
        cart.getProductsList();
        cart.getAllPrices();

        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        for (Buyable p : cart.getCart() ){
            if(p!=null) p.printInfo();
        }
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        for (Buyable p : cart.getCart()){
            if (p instanceof Discountable){
                ((Discountable) p).printDiscountInfo();
            }
        }
    }
} 