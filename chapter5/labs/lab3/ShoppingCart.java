package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    private Buyable[] cart;
    private static  int index = 0;
    // TODO: 생성자 정의

    public ShoppingCart() {
        this.cart =  new Buyable[10];
    }


    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addProduct(Buyable product){
        this.cart[index] = product;
        index++;
    }
    
    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeProduct(){ // 스택 형식으로 구현
        this.cart[index] = null;
        index--;
    }
    
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public void getAllPrices(){
        int sum = 0;
        for (Buyable product : this.cart) {
            if(product!=null) sum += product.getPrice();
        }
        System.out.println("총 합 :" + sum);
    }
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void getProductsList(){
        for (Buyable product : this.cart) {
            if(product!=null) System.out.println(product.getName());
        }
    }
    public Buyable[] getCart() {
        return this.cart;
    }
} 