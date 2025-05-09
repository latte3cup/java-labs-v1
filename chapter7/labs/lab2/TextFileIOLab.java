package chapter7.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 텍스트 파일을 생성하고 처리하는 실습
 *
 * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
 * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
 */
public class TextFileIOLab {
    // 파일 경로 상수
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";

    public static void main(String[] args) {
        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.
        Scanner sc = new Scanner(System.in);

        // TODO: 프로그램 메인 루프를 구현하세요.
        // 1. showMenu() 메소드를 호출하여 메뉴 표시
        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
        //    - 1: createTextFile()
        //    - 2: readTextFile()
        //    - 3: searchTextInFile()
        //    - 4: replaceTextInFile()
        //    - 5: countFileStats()
        //    - 6: appendToFile()
        //    - 7: 프로그램 종료
        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력
        boolean running = true;
        while (running) {
            try {
                showMenu();
                System.out.print("메뉴를 선택하세요: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        createTextFile(sc);
                        break;
                    case 2:
                        readTextFile(sc);
                        break;
                    case 3:
                        searchTextInFile(sc);
                        break;
                    case 4:
                        replaceTextInFile(sc);
                        break;
                    case 5:
                        countFileStats(sc);
                        break;
                    case 6:
                        appendToFile(sc);
                        break;
                    case 0: // 종료
                        running = false;
                        System.out.println("프로그램을 종료합니다. 감사합니다!");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 메뉴 계속 표시를 위한 구분선
            System.out.println("\n----------------------------------------");
        }

    }

    /**
     * 메뉴 출력
     */
    private static void showMenu() {
        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
        // 1. 텍스트 파일 생성하기
        // 2. 텍스트 파일 읽기
        // 3. 텍스트 파일에서 검색하기
        // 4. 텍스트 파일에서 문자열 치환하기
        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
        // 6. 파일에 내용 추가하기
        // 7. 종료
        System.out.println("\n=== 은행 계좌 관리 시스템 ===");
        System.out.println("1. 텍스트 파일 생성하기");
        System.out.println("2. 텍스트 파일 읽기");
        System.out.println("3. 텍스트 파일에서 검색하기");
        System.out.println("4. 텍스트 파일에서 문자열 치환하기");
        System.out.println("5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)");
        System.out.println("6. 파일에 내용 추가하기");
        System.out.println("0. 종료");
    }

    /**
     * 사용자로부터 정수 입력 받기
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
        // 1. 사용자 입력을 정수로 변환 시도
        // 2. 입력값이 min과 max 사이의 값인지 확인
        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
        // 4. 유효한 입력을 받을 때까지 반복
        int input;
        do{
            System.out.println("정수를 입력해주세요");
            input = scanner.nextInt();
        }
        while (input < min || input > max);{
            System.out.println("범위 안의 숫자를 입력해 주세요");
            System.out.println("범위: " + min + "~"  + max);
            input = scanner.nextInt();
        }
        return input; // 구현 후 이 줄을 수정하세요.
    }

    /**
     * 텍스트 파일 생성
     */
    private static void createTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
        System.out.println("\n[텍스트 파일 생성하기]");


        // TODO: 파일이 이미 존재하는지 확인하세요.
        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
        // 3. 사용자가 'n'을 입력하면 메소드 종료
        if(checkFileExists(scanner)){
            System.out.print("파일이 이미 존재합니다. 덮어쓰시겠습니까? (y/n): ");
            String overwriteChoice = scanner.nextLine().toLowerCase();
            if (!overwriteChoice.equals("y")) {
                System.out.println("덮어쓰지 않으므로 돌아갑니다..");
                return;
            }
        };


        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        System.out.println("파일에 저장할 내용을 입력하세요. 빈 줄을 입력하면 종료됩니다.");
        List<String> lines = new ArrayList<>();
        int lineNumber = 1;
        while (true) {
            System.out.printf("%d: ", lineNumber++);
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }


        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter와 BufferedWriter 생성
        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
        // 4. 예외 처리 및 성공 메시지 출력
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("파일이 성공적으로 생성되었습니다: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("파일 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일 읽기
     */
    private static void readTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
        System.out.println("\n[텍스트 파일 읽기]");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        if(!checkFileExists(scanner)) return;

        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileReader와 BufferedReader 생성
        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
        // 4. 각 줄 앞에 줄 번호 붙여서 출력
        // 5. 예외 처리 및 완료 메시지 출력
        AtomicInteger lineNumber = new AtomicInteger(1);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            reader.lines().forEach(line -> {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber.getAndIncrement();
            });
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생하였습니다 : " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일에서 문자열 검색
     */
    private static void searchTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.
        System.out.println("\n[텍스트 파일에서 검색하기]");

        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.
        System.out.print("검색할 텍스트: ");
        String searchText = scanner.nextLine();

        System.out.print("대소문자를 구분하시겠습니까? (y/n): ");
        String caseSensitiveChoice = scanner.nextLine().toLowerCase();
        boolean caseSensitive = caseSensitiveChoice.equals("y");


        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
        // 1. try-with-resources 구문 사용
        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
        // 6. 예외 처리
        int matchCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            Pattern pattern;
            if (caseSensitive) {
                pattern = Pattern.compile(Pattern.quote(searchText));
            } else {
                pattern = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);
            }

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    matchCount++;
                    StringBuilder highlightedLine = new StringBuilder();
                    int lastEnd = 0;
                    matcher.reset(); // Matcher를 다시 처음부터 찾도록 초기화
                    while (matcher.find()) {
                        highlightedLine.append(line, lastEnd, matcher.start())
                                .append(matcher.group(0));
                        lastEnd = matcher.end();
                    }
                    highlightedLine.append(line, lastEnd, line.length());
                    System.out.println("찾았습니다: " + highlightedLine);
                }
            }

            System.out.printf("\n총 %d개의 일치하는 항목을 찾았습니다.\n", matchCount);

        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일에서 문자열 치환
     */
    private static void replaceTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.
        System.out.println("\n[텍스트 파일에서 문자열 치환하기]");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        if (!checkFileExists(scanner)) return;

        // TODO: 사용자로부터 다음 정보를 입력받으세요:
        // 1. 찾을 텍스트
        // 2. 변경할 텍스트
        // 3. 대소문자 구분 여부 (y/n)
        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)
        System.out.println("찾을 텍스트를 입력해주세요");
        String findText = scanner.nextLine();
        System.out.println("변경할 텍스트를 입력해주세요");
        String replaceText = scanner.nextLine();
        System.out.print("대소문자를 구분하시겠습니까? (y/n):");
        String caseSensitiveChoice = scanner.nextLine().toLowerCase();
        boolean caseSensitive = caseSensitiveChoice.equals("y");
        System.out.println("모든 항목을 변경하시겠습니까?(y) // 첫 항목만 변경하시겠습니까?(n)");
        String allReplaceChoice = scanner.nextLine().toLowerCase();
        boolean allReplace = allReplaceChoice.equals("y");

        // TODO: 파일 내용을 List<String>으로 읽어오세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            reader.lines().forEach(lines::add);
        }catch (Exception e) {
            e.printStackTrace();
        }
        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
        //    - String.replace() 또는 String.replaceAll()
        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
        // 2. 몇 개의 라인이 변경되었는지 카운트
        List<String> modifiedLines = new ArrayList<>();
        int linesChangedCount = 0;
        for (String line : lines) {
            String modifiedLine = line;
            if (caseSensitive) {
                if (allReplace) {
                    modifiedLine = modifiedLine.replace(findText, replaceText);
                } else {
                    modifiedLine = modifiedLine.replaceFirst(Pattern.quote(findText), replaceText);
                }
            } else {
                Pattern pattern = Pattern.compile(Pattern.quote(findText), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(modifiedLine);
                if (allReplace) {
                    modifiedLine = matcher.replaceAll(replaceText);
                } else {
                    modifiedLine = matcher.replaceFirst(replaceText);
                }
            }
            if (!modifiedLine.equals(line)) {
                linesChangedCount++;
            }
            modifiedLines.add(modifiedLine);
        }


        // TODO: 변경된 내용을 파일에 다시 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
        // 3. 변경된 라인 수 출력
        // 4. 예외 처리
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : modifiedLines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("파일 내용 치환 완료.");
            System.out.println("총 " + linesChangedCount + "개의 라인이 변경되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
     */
    private static void countFileStats(Scanner scanner) {
        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.
        System.out.println("\n[파일 통계 계산하기]");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        if(!checkFileExists(scanner)) return;

        // TODO: 파일 통계를 계산하세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 파일 읽기
        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
        // 5. 문자 수 계산 (각 라인의 길이 합산)

        int lineCount = 0;
        int wordCount = 0;
        long charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+"); // 공백을 기준으로 단어 분리
                for (String word : words) {
                    if (!word.isEmpty()) { // 빈 문자열은 단어로 세지 않음
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
            return;
        }

        // TODO: 계산된 통계 정보를 출력하세요.
        // 1. 라인 수
        // 2. 단어 수
        // 3. 문자 수
        // 4. 예외 처리
        System.out.println("\n[파일 통계]");
        System.out.println("총 라인 수: " + lineCount);
        System.out.println("총 단어 수: " + wordCount);
        System.out.println("총 문자 수: " + charCount);
    }

    /**
     * 파일에 내용 추가
     */
    private static void appendToFile(Scanner scanner) {
        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.
        System.out.println("\n[파일에 내용 추가하기]");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        if(!checkFileExists(scanner)) return;

        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        System.out.println("파일에 추가할 내용을 입력하세요. 빈 줄을 입력하면 종료됩니다.");
        List<String> linesToAppend = new ArrayList<>();
        int lineNumber = 1;
        while (true) {
            System.out.printf("%d: ", lineNumber++);
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            linesToAppend.add(line);
        }

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
        // 3. 구분선("--- 추가된 내용 ---") 추가
        // 4. 리스트의 각 줄을 파일에 추가
        // 5. 예외 처리 및 성공 메시지 출력
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.newLine();
            writer.write("--- 추가된 내용 ---");
            writer.newLine();
            for (String line : linesToAppend) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("파일에 내용이 성공적으로 추가되었습니다: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("파일 추가 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static boolean checkFileExists(Scanner sc) {
        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        System.out.print("검색할 파일 경로 및 이름: ");
        String filePath = sc.nextLine();
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("오류: 해당 파일이 존재하지 않습니다.");
            return false;
        }
        return true;
    }
}