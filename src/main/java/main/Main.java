package main;

import member.controller.MemberController;
import trainer.controller.TrainerController;
import util.io.In;

public class Main {
    public static void main(String[] args) {

        System.out.println("╭╼|══════════════════════════════════════════════|╾╮");
        System.out.println("|      Welcome to LionGym Management System !      |");
        System.out.println("╰╼|══════════════════════════════════════════════|╾╯");

        while (true) {
            System.out.println("[1]회원관리 [2]트레이너관리 [0]종료");
            System.out.print("▶︎ 메뉴를 선택하세요: ");

            switch (Integer.parseInt(In.getString())) {
                case 1:
                    (new MemberController()).execute();
                    break;
                case 2:
                    (new TrainerController()).execute();
                    break;
                case 0:
                    System.out.println("╭╼|══════════════════════════════════════════════|╾╮");
                    System.out.println("|              Bye ! See You Next Time !           |");
                    System.out.println("╰╼|══════════════════════════════════════════════|╾╯");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 0~2 사이의 숫자를 입력해주세요.");
                    break;
            }
        }
    }
}
