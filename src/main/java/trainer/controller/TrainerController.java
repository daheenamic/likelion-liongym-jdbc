package trainer.controller;

import member.dao.MemberDAO;
import member.dao.MemberDAOImpl;
import member.dto.MemberDTO;
import trainer.dao.TrainerDAO;
import trainer.dao.TrainerDAOImpl;
import trainer.dto.TrainerDTO;
import util.NumberFormatUtil;
import util.io.In;

import java.util.List;

public class TrainerController {
    public void execute() {
        MemberDAO memberDAO = new MemberDAOImpl();
        TrainerDAO trainerDAO = new TrainerDAOImpl();
        int result = 0;

        while (true) {
            System.out.println();
            System.out.println("===============[ 트레이너 관리 ]============");
            System.out.println("[1]트레이너목록 [2]트레이너등록 [3]트레이너수정 [4]트레이너삭제");
            System.out.println("[5]회원목록    [6]급여계산                 [0]이전메뉴");
            System.out.println("========================================");
            System.out.print("▶︎ 메뉴를 선택하세요: ");

            switch (Integer.parseInt(In.getString())) {
                case 1:
                    List<TrainerDTO> trainerList = trainerDAO.list();

                    System.out.println("ID  |   이름   |     연락처      | 수업횟수");
                    for (TrainerDTO t : trainerList) {
                        System.out.println(t.getId() + "  |  "
                                + t.getName() + "  | "
                                + t.getPhone() + " |  "
                                + t.getLessons() + "회");
                    }
                    break;
                case 2:
                    System.out.println("▶︎ 등록하실 트레이너의 정보를 입력 해 주세요.");
                    TrainerDTO newTrainer = new TrainerDTO();
                    System.out.print(" - 이름: ");
                    newTrainer.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000 형식으로 입력]: ");
                    newTrainer.setPhone(In.getString());
                    System.out.print(" - 기본급 [숫자만입력]: ");
                    newTrainer.setBaseSalary(Integer.parseInt(In.getString()));
                    System.out.print(" - 수업당 성과금 [숫자만입력]: ");
                    newTrainer.setBonus(Integer.parseInt(In.getString()));
                    result = trainerDAO.insert(newTrainer);
                    if (result == 1) {
                        System.out.println("✅ " + newTrainer.getName() + "님이 트레이너로 등록되었습니다.");
                    } else {
                        System.out.println("트레이너가 등록되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    break;
                case 3:
                    System.out.println("ID  |  이름  |    연락처     ");
                    for (TrainerDTO t : trainerDAO.list()) {
                        System.out.println(t.getId() + "  | "
                                + t.getName() + " | "
                                + t.getPhone() + " | ");
                    }
                    System.out.println();

                    TrainerDTO updateTrainer = new TrainerDTO();
                    System.out.print("▶︎ 수정하실 트레이너의의 ID를 선택 해 주세요: ");
                    updateTrainer.setId(Integer.parseInt(In.getString()));
                    System.out.print(" - 이름: ");
                    updateTrainer.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000 형식으로 입력]: ");
                    updateTrainer.setPhone(In.getString());
                    System.out.print(" - 기본급 [숫자만입력]: ");
                    updateTrainer.setBaseSalary(Integer.parseInt(In.getString()));
                    System.out.print(" - 수업당 성과금 [숫자만입력]: ");
                    updateTrainer.setBonus(Integer.parseInt(In.getString()));
                    result = trainerDAO.update(updateTrainer);

                    if ( result == 1 ) {
                        System.out.println("✅ " + updateTrainer.getName() + "님의 정보가 수정되었습니다.");
                    } else {
                        System.out.println("정보가 수정되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    break;
                case 4:
                    System.out.println("ID  |  이름  |    연락처     ");
                    for (TrainerDTO t : trainerDAO.list()) {
                        System.out.println(t.getId() + "  | "
                                + t.getName() + " | "
                                + t.getPhone() + " | ");
                    }
                    System.out.println();

                    TrainerDTO deleteTrainer = new TrainerDTO();
                    System.out.print("▶︎ 삭제하실 회원의 트레이너를 선택 해 주세요: ");
                    deleteTrainer.setId(Integer.parseInt(In.getString()));
                    result = trainerDAO.delete(deleteTrainer);

                    if ( result == 1 ) {
                        System.out.println("✅ " + deleteTrainer.getId() + "번 트레이너의 정보가 삭제되었습니다.");
                    } else {
                        System.out.println("정보가 삭제되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    break;
                case 5:
                    System.out.println("ID  |  이름  |    연락처     ");
                    for (TrainerDTO t : trainerDAO.list()) {
                        System.out.println(t.getId() + "  | "
                                + t.getName() + " | "
                                + t.getPhone() + " | ");
                    }
                    System.out.println();
                    System.out.print("▶︎ 회원목록을 표시할 트레이너를 선택 해 주세요: ");
                    List<MemberDTO> memberList = memberDAO.listByTrainerId(Integer.parseInt(In.getString()));

                    System.out.println("==================[ 회원목록 ]==================");
                    System.out.println("ID  |  이름  |    연락처     |  남은수업");

                    if ( memberList != null && !memberList.isEmpty() ) {
                        for (MemberDTO m : memberList) {
                            System.out.println(m.getId() + "  | "
                                    + m.getName() + " | "
                                    + m.getPhone() + " |  "
                                    + m.getSession() + "회");
                        }
                    } else {
                        System.out.println("====== [ 등록된 회원이 없습니다. ] ======");
                    }

                    break;
                case 6:
                    trainerList = trainerDAO.list();

                    System.out.println("ID  |   이름   |   기본급   | 수업당 성과급 | 수업횟수 | 예상급여");
                    for (TrainerDTO t : trainerList) {
                        System.out.println(t.getId() + "  |  "
                                + t.getName() + "  | "
                                + NumberFormatUtil.CurrencyFormat(t.getBaseSalary())+ " |  "
                                + NumberFormatUtil.CurrencyFormat(t.getBonus()) + "  |   "
                                + t.getLessons() + "회   | "
                                + NumberFormatUtil.CurrencyFormat(t.calculatePay()) + "원");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 0~6 사이의 숫자를 입력해주세요.");
                    break;
            }
        }
    }
}
