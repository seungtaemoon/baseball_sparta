import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int com1 = 0, com2 = 0, com3 = 0;
        int user1 = 0, user2 = 0, user3 = 0;
        int S = 0; // 스트라이크 개수
        int B = 0;
        int challenge = 1;

        // 랜덤숫자생성
        while (true) {
            com1 = random.nextInt(9) + 1; // 1부터 9까지의 난수 생성
            com2 = random.nextInt(9) + 1;
            com3 = random.nextInt(9) + 1;

            if (!(com1 == com2 || com2 == com3 || com3 == com1)) {
                break;
            }
        }
        System.out.println(com1+""+com2+""+com3);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (S < 3) {
            // 사용자로부터 3개의 정수를 하나의 문자열로 입력받는다.
            System.out.println("각 자리의 숫자가 중복되지 않는 정수를 입력하세요");
            String userInput = scanner.nextLine();
            user1 = Character.getNumericValue(userInput.charAt(0));
            user2 = Character.getNumericValue(userInput.charAt(1));
            user3 = Character.getNumericValue(userInput.charAt(2));

            // 스트라이크 개수 계산
            S = 0;
            if (com1 == user1) {
                S++;
            }
            if (com2 == user2) {
                S++;
            }
            if (com3 == user3) {
                S++;
            }

            // 볼 개수 계산
            B = 0;
            if (com2 == user1 || com3 == user1) {
                B++;
            }
            if (com1 == user2 || com3 == user2) {
                B++;
            }
            if (com1 == user3 || com2 == user3) {
                B++;
            }


            if (S == 3) {
                System.out.println(S + "S");
                System.out.println("정답. 게임을 종료합니다");
                System.out.println("총 " + challenge + "번 만에 맞추셨습니다.");
                break;
            }

            System.out.println(S + "S" + B + "B");


            challenge++; // 시도 횟수 증가
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
