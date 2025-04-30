package chapter4.labs.lab3;


/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    private final int x = 4123123;
    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    private final int y;

    
    // TODO: 생성자를 정의하세요.
    public FinalExample(int y) {
        // final 변수 초기화
        this.y = y;
    }
    
    // TODO: final 메소드를 정의하세요.
    public final void finalMethod() {
        System.out.println("final x : " + x);
        System.out.println("final y : " + y);
    }
    
    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    public void processValue(final int value) {
        System.out.println("값 : " + value); // 변경 불가
    }
    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample fe = new FinalExample(123);
        
        // TODO: 객체의 메소드를 호출하세요.
        fe.finalMethod();
        
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        finalClass fc = new finalClass();
        fc.print();
        
        // TODO: final 지역 변수를 선언하고 사용하세요.
        final String message = "final 변수입니다.";
        System.out.println(message);
        // message = "새로운 값";  (컴파일 에러 발생)
        
    }
}

// TODO: final 클래스를 정의하세요.
final class finalClass{
    public void print(){
        System.out.println("hi im finalClass");
    }
}
// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
class ParentClass{
    public final void method(){
        System.out.println("한 번 오버라이딩 해 봐.");
    }
}
class childClass extends  ParentClass{
    // Note: 컴파일러 오류
//    @Override
//    public void method(){
//        System.out.println("오버라이딩 함");
//    }
}