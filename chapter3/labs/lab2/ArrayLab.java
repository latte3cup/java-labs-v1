package chapter3.labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 활용하기 실습
 */
public class ArrayLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 정수형 배열 활용
        System.out.println("===== 정수형 배열 활용 =====");

        // TODO: 5개의 정수를 입력받아 배열에 저장하고, 합계와 평균을 계산하여 출력하세요.
        // 힌트: Scanner를 이용하여 사용자로부터 입력을 받으세요.
        int[] numbers = new int[5];
        int sum = 0;
        System.out.println("5개의 정수를 입력하세요:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("합: " + sum);
        System.out.println("평균: " + average);


        // 2. 문자열 배열 활용
        System.out.println("\n===== 문자열 배열 활용 =====");

        // TODO: 5개의 이름을 입력받아 배열에 저장하고, 특정 문자(예: 'A')로 시작하는 이름을 검색하여 출력하세요.
        // 힌트: String 클래스의 startsWith() 또는 charAt() 메소드를 활용하세요.
        String[] names = new String[5];
        System.out.println("5개의 이름을 입력하세요:");
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }
        System.out.println("'A'로 시작하는 이름:");
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }


        // 3. 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");

        // TODO: 사용자로부터 5개의 정수를 입력받아 배열에 저장한 후, 오름차순으로 정렬하여 출력하세요.
        // 힌트: 이중 반복문을 사용하여 버블 정렬 알고리즘을 구현하거나, Arrays.sort()를 활용하세요.
        int[] sortNumbers = new int[5];
        System.out.println("정렬할 5개의 정수를 입력하세요:");
        for (int i = 0; i < sortNumbers.length; i++) {
            sortNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(sortNumbers);
        System.out.println("정렬된 배열 (오름차순): " + Arrays.toString(sortNumbers));


        // 4. 2차원 배열을 이용한 행렬 덧셈
        System.out.println("\n===== 2차원 배열을 이용한 행렬 덧셈 =====");

        // TODO: 두 개의 2x3 행렬을 입력받아 행렬 덧셈을 수행하고 결과를 출력하세요.
        // 힌트: 중첩 반복문을 사용하세요.
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][3];
        int[][] sumMatrix = new int[2][3];

        System.out.println("첫 번째 2x3 행렬의 요소를 입력하세요:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("두 번째 2x3 행렬의 요소를 입력하세요:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sumMatrix[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("행렬 덧셈 결과:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }


        // 5. 배열을 이용한 간단한 데이터 분석
        System.out.println("\n===== 배열을 이용한 데이터 분석 =====");

        // TODO: 10개의 정수를 입력받아 배열에 저장한 후, 최댓값, 최솟값, 중앙값(또는 평균)을 계산하여 출력하세요.
        // 힌트: 정렬을 활용하면 중앙값을 쉽게 찾을 수 있습니다.
        int[] data = new int[10];
        System.out.println("10개의 정수를 입력하세요:");
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);
        int min = data[0];
        int max = data[data.length - 1];
        double median;
        if (data.length % 2 == 0) {
            median = (double) (data[data.length / 2 - 1] + data[data.length / 2]) / 2;
        } else {
            median = data[data.length / 2];
        }

        System.out.println("최솟값: " + min);
        System.out.println("최댓값: " + max);
        System.out.println("중앙값: " + median);


        scanner.close();
    }
}