package chapter3.labs.lab4;

import chapter1.examples.ex4.Operators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (MON, TUE, WED, THU, FRI, SAT, SUN): ");
        String input = scanner.nextLine();

        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        enum DayOfWeek {
            MON, TUE, WED, THU, FRI, SAT, SUN
        }
        switch (DayOfWeek.valueOf(input)) {
            case SAT:
            case SUN:
                System.out.println("주말입니다.");
                break;
            default:
                System.out.println("평일입니다.");



        }
        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();

        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        enum Season {
            SPRING(13, "flower"),
            SUMMER(30, "Swimming"),
            AUTUMN(18, "Reading"),
            WINTER(0, "Snowing");
            private  int avgTemperature;
            private  String feature;
        }
        Season whatSeason = switch (month) {
            case 1, 2, 12 -> Season.WINTER;
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            case 9, 10, 11 -> Season.AUTUMN;
            default -> null;
        };
        if (whatSeason == null) {
            System.out.println("입력 오류");
        }else{
            System.out.println("계절은 " + whatSeason);
            System.out.println("평균 기온은 " + whatSeason.getAvgTemperature() + "도");
            System.out.println("특징은 " + whatSeason.getFeature());

        }
        scanner.nextLine();
        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");

        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.
        enum TaskStatus{
            PENDING{
                @Override
                public TaskStatus nextStatus() {
                    return IN_PROGRESS;
                }
            },
            IN_PROGRESS{
                @Override
                public TaskStatus nextStatus() {
                    return COMPLETED;
                }
            },
            COMPLETED{
                @Override
                public TaskStatus nextStatus() {
                    return ARCHIVED;
                }
            },
            ARCHIVED{
                @Override
                public TaskStatus nextStatus() {
                    return PENDING;
                }
            };
            public abstract TaskStatus nextStatus();
        }
        TaskStatus status = TaskStatus.PENDING;
        while(true){
            System.out.println("now status : " + status);
            System.out.println("next Or exit??");
            String what = scanner.nextLine();
            if (what.equals("next")){
                status = status.nextStatus();
            } else if (what.equals("exit")) {
                break;
            }else{
                System.out.println("잘못된 입력");
            }
        }


        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기
        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.
        @AllArgsConstructor
        @Getter
        enum Operator{
            ADD("+"){
                @Override
                public double calculate(double num1, double num2){
                    return num1 + num2;
                }
            },
            SUBTRACT("-"){
                @Override
                public double calculate(double num1, double num2){
                    return num1 - num2;
                }
            },
            MULTIPLY("*"){
                @Override
                public double calculate(double num1, double num2){
                    return num1 * num2;
                }
            },
            DIVIDE("/"){
                @Override
                public double calculate(double num1, double num2){
                    return num1 / num2;
                }
            };

            private final String operator;
            
            public abstract double calculate(double num1, double num2);

            public static Operator fromSymbolToOp(String symbol) {
                for (Operator op : values()) {
                    if (op.getOperator().equals(symbol)) {
                        return op;
                    }
                }
                throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + symbol);
            }
        }
        for (Operator op : Operator.values()){
            System.out.println(op);
        }

        System.out.println("첫번째 수를 입력해 주세요 ");
        double a = scanner.nextDouble();
        System.out.println(a);
        System.out.println("두번째 수를 입력해 주세요 ");
        double b = scanner.nextDouble();
        scanner.nextLine();

        while (true){
            System.out.println("어떤 연산을 실행하시겠습니까?? (+,-,*,/)");
            String inputOP = scanner.nextLine();
            if (inputOP.length()!=1 && "+-*/".chars().noneMatch(c -> c == inputOP.charAt(0))) {
                System.out.println("4개 연산자중 하나를 정확히 입력해 주세요");
                continue;
            }
            System.out.println("입력하신 두수 : " + a + " // " + b);
            System.out.println("입력하신 연산 :" + inputOP);
            Operator operator = Operator.fromSymbolToOp(inputOP);
            System.out.println("최종 결과 : " + operator.calculate(a, b));
            break;
        }

        scanner.close();
    }
} 