package chapter8.labs.lab1;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 *
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");
        
        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> p1 = new Pair<>();
        p1.setKey(14123);
        p1.setValue("test");
        System.out.println(p1.toString());  // 임의 표현 (Overriding 됨)


        // Double과 Double 타입의 Pair
        Pair<Double,Double> p2 = new Pair<>();
        p2.setKey(14123.0);
        p2.setValue(2.0); 
        System.out.println(p2.toString());
        // 사용자 정의 클래스를 사용한 Pair

        Pair<Integer,Integer> p4 = new Pair<>();
        p4.setKey(1412322);
        p4.setValue(222);
        
        
        System.out.println("\n=== PairUtils 클래스 테스트 ===");
        
        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // of 메소드 테스트
        Pair<?,?> p3= PairUtils.createPair(p1,p2);
        System.out.println(p3.toString());
        // swap 메소드 테스트
        System.out.println(PairUtils.swap(p3));

        // 숫자 타입의 sum 메소드 테스트
        System.out.println(PairUtils.sum(p2));
        
        // 타입 제한 테스트 (Number 하위 클래스만 가능)
        System.out.println(PairUtils.sum(p4));  /// 가능
        // System.out.println(PairUtils.sum(p1));  /// 불가능 Number 상속 안한 String이 있으므로
        // 와일드카드 메소드 테스트
        PairUtils.printPair(p3);
        PairUtils.printPair(p2);
    }
} 