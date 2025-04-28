package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte b= 120;
        int i = b;
        System.out.println(i);

        int ii = 1242141;
        long l = ii;
        System.out.println(ii);

        long ll = 1451241241;
        float f = ll;
        System.out.println(f);

        float ff = 3.1241241F;
        double d = ff;
        System.out.println(d);

        
        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기

        double dd = 65.1412412412424124124124124124123125261424;
        System.out.println(dd);
        System.out.println((float)dd);
        System.out.println((long)dd);
        System.out.println((int)dd);
        System.out.println((char)dd);
        System.out.println((short)dd);
        System.out.println((byte)dd);



        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기
        int a = 266;
        System.out.println((byte)a);
        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기
        String s = "123";
        int iii = Integer.parseInt(s);
        System.out.println(iii);

        String s2 = "3.14";
        double dddd = Double.parseDouble(s2);
        System.out.println(s2);
        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기
        int i1 = 456;
        float f1 = 7.89f;
        String ss = i1 +"";
        String sss = f1 +"";
        
    }
} 