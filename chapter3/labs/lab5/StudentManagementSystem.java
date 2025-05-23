package chapter3.labs.lab5;

import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.
    public enum Grade {
        A, B, C, D, F;

        public static Grade getGradeFromScore(int score){
            if (score>=90){
                return Grade.A;
            } else if (score>=80) {
                return Grade.B;
            }else if (score>=70) {
                return Grade.C;
            }else if (score>=60) {
                return Grade.D;
            }else{
                return Grade.F;
            }
        };
    }
    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다
                    System.out.println("이름을 입력해주세요 :");
                    String studentName = scanner.nextLine();
                    int score = 0;
                    while (true){
                        System.out.println("성적을 입력해 주세요 (0~100):");
                        score = scanner.nextInt();
                        if (score < 0 || score > 100) {
                            System.out.println("성적을 제대로 입력해주세요.");
                            System.out.println();
                            continue;
                        }
                        break;
                    }
                    names[studentCount] = studentName;
                    scores[studentCount] = score;
                    studentCount++;
                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    System.out.println("수정할 학생의 이름을 입력해주세요. ");
                    String StudentName = scanner.nextLine();
                    for (int i = 0; i < MAX_STUDENTS; i++) {
                        if (names[i].equals(StudentName)) {
                            System.out.println("현재 점수 : " + scores[i]);
                            System.out.println("수정할 점수를 입력해 주세요. (0~100");
                            int itsScore = scanner.nextInt();
                            if (itsScore < 0 || itsScore > 100) {
                                System.out.println("성적을 제대로 입력해주세요.");
                                System.out.println();
                                continue;
                            }
                            scores[i] = itsScore;
                            break;
                        }
                    }
                    break;
                case 3:
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    // TODO: 성적 조회 기능을 구현하세요.
                    int sum = 0;
                    int min = 100;
                    int max = 0;
                    for (int i = 0; i < MAX_STUDENTS; i++) {
                        System.out.println("이름 : " + names[i] +" // " + "성적 : " + scores[i] + " // " + "등급 : " + Grade.getGradeFromScore(scores[i]));
                        sum += scores[i];
                        if (scores[i] < min) {
                            min = scores[i];
                        }
                        if (scores[i] > max) {
                            max = scores[i];
                        }
                    };
                    System.out.println("--------------------------------");
                    System.out.println("합계 : " + sum +" // " + "평균 : " + sum/100);
                    System.out.println("최고 성적 : " + max +" // " + "최저 성적 : " + min);

                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    System.out.println("검색할 학생의 이름을 입력해주세요");
                    String name = scanner.nextLine();
                    for(int i = 0; i < MAX_STUDENTS; i++) {
                        if (names[i].equals(name)){
                            System.out.println(name + "의 점수 : " + scores[i]);
                            break;
                        }
                    }
                    
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    int[] gradeNums = new int[]{0,0,0,0,0};
                    for (int i = 0; i < MAX_STUDENTS; i++) {
                        Grade grade = Grade.getGradeFromScore(scores[i]);
                        if(grade==Grade.A){ gradeNums[0]++;}
                        else if (grade==Grade.B) {gradeNums[1]++;}
                        else if (grade==Grade.C) {gradeNums[2]++;}
                        else if (grade==Grade.D) {gradeNums[3]++;}
                        else if (grade==Grade.F) {gradeNums[4]++;}

                    }
                    for (int g:gradeNums){
                        System.out.println("등급 A의 수 :" + gradeNums[0] + "// 비율 : " +gradeNums[0] +"%");
                        System.out.println("등급 B의 수 :" + gradeNums[1] + "// 비율 : " +gradeNums[1] +"%");
                        System.out.println("등급 C의 수 :" + gradeNums[2] + "// 비율 : " +gradeNums[2] +"%");
                        System.out.println("등급 D의 수 :" + gradeNums[3] + "// 비율 : " +gradeNums[3] +"%");
                        System.out.println("등급 F의 수 :" + gradeNums[4] + "// 비율 : " +gradeNums[4] +"%");

                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.
    // NOTE: ENUM에 포함시켜서 구현하였습니다.
    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    // NOTE: 메인 로직에 포함함
    
    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    // NOTE: 메인 로직에 포함함
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    // NOTE: 메인 로직에 포함함
    
    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    // NOTE: 메인 로직에 포함함
    
    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    // NOTE: 메인 로직에 포함함
    public int getIndexForName(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
} 