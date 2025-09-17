package member.controller;

import member.dao.MemberDAO;
import member.dao.MemberDAOImpl;
import member.dto.MemberDTO;
import trainer.dao.TrainerDAO;
import trainer.dao.TrainerDAOImpl;
import trainer.dto.TrainerDTO;
import util.io.In;

import java.util.List;

public class MemberController {
    public void execute() {
        MemberDAO memberDAO = new MemberDAOImpl();
        TrainerDAO trainerDAO = new TrainerDAOImpl();
        int result = 0;

        while (true) {
            System.out.println();
            System.out.println("===============[ 회원관리 ]===============");
            System.out.println("[1]회원목록 [2]신규등록 [3]회원수정 [4]회원삭제");
            System.out.println("[5]PT등록  [6]PT사용  [0]이전메뉴");
            System.out.println("========================================");
            System.out.print("▶︎ 메뉴를 선택하세요: ");

            switch (Integer.parseInt(In.getString())) {
                case 1:
                    List<MemberDTO> memberList = memberDAO.list();

                    System.out.println("==================[ 회원목록 ]==================");
                    System.out.println("ID  |  이름  |    연락처     | 담당트레이너 | 남은수업");

                    if ( memberList != null && !memberList.isEmpty() ) {
                        for (MemberDTO m : memberDAO.list()) {
                            String trainerNm = m.getTrainerNm() != null ? m.getTrainerNm() : "   -   ";
                            System.out.println(m.getId() + "  | "
                                    + m.getName() + " | "
                                    + m.getPhone() + " |  "
                                    + trainerNm + "  | "
                                    + m.getSession() + "회");
                        }
                    } else {
                        System.out.println("====== [ 등록된 회원이 없습니다. ] ======");
                    }

                    System.out.println();
                    break;
                case 2:
                    System.out.println("▶︎ 등록하실 회원의 정보를 입력 해 주세요.");
                    MemberDTO memberDTO = new MemberDTO();
                    System.out.print(" - 이름: ");
                    memberDTO.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000] 형식으로 입력]: ");
                    memberDTO.setPhone(In.getString());
                    result = memberDAO.insert(memberDTO);
                    if(result == 1) {
                        System.out.println("✅ " + memberDTO.getName() + "님이 회원으로 등록되었습니다.");
                    } else {
                        System.out.println("회원이 등록되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("ID  |  이름  |    연락처");
                    for (MemberDTO m : memberDAO.list()) {
                        System.out.println(m.getId() + "  | "
                                + m.getName() + " | "
                                + m.getPhone() + " | ");
                    }

                    System.out.println();
                    MemberDTO updateMember = new MemberDTO();
                    System.out.print("▶︎ 수정하실 회원의 ID를 선택 해 주세요: ");
                    updateMember.setId(Integer.parseInt(In.getString()));
                    System.out.print(" - 이름: ");
                    updateMember.setName(In.getString());
                    System.out.print(" - 연락처 [010-0000-0000 형식으로 입력]: ");
                    updateMember.setPhone(In.getString());
                    result = memberDAO.update(updateMember);
                    if ( result == 1 ) {
                        System.out.println("✅ " + updateMember.getName() + "님의 정보가 수정되었습니다..");
                    } else {
                        System.out.println("정보가 수정되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    break;
                case 4:
                    System.out.println("ID  |  이름  |    연락처");
                    for (MemberDTO m : memberDAO.list()) {
                        System.out.println(m.getId() + "  | "
                                + m.getName() + " | "
                                + m.getPhone() + " | ");
                    }
                    System.out.println();
                    MemberDTO deleteMember = new MemberDTO();
                    System.out.print("▶︎ 삭제하실 회원의 ID를 선택 해 주세요: ");
                    deleteMember.setId(Integer.parseInt(In.getString()));
                    result = memberDAO.delete(deleteMember);
                    if ( result == 1 ) {
                        System.out.println("✅ " + deleteMember.getId() + "번 회원님의 정보가 삭제되었습니다.");
                    } else {
                        System.out.println("정보가 삭제되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("ID  |  이름  |    연락처");
                    for (MemberDTO m : memberDAO.list()) {
                        System.out.println(m.getId() + "  | "
                                + m.getName() + " | "
                                + m.getPhone() + " | ");
                    }
                    System.out.println("▶︎ PT 등록 정보를 입력 해 주세요.");
                    MemberDTO ptMember = new MemberDTO();
                    System.out.print(" - 회원ID: ");
                    ptMember.setId(Integer.parseInt(In.getString()));
                    System.out.print(" - 트레이너ID: ");
                    ptMember.setTrainerId(Integer.parseInt(In.getString()));
                    System.out.print(" - 등록횟수: ");
                    ptMember.setSession(Integer.parseInt(In.getString()));
                    result = memberDAO.buyPt(ptMember);
                    if ( result == 1 ) {
                        System.out.println("✅ PT가 등록되었습니다.");
                    } else {
                        System.out.println("PT가 등록되지 않았습니다. 다시 시도 해 주세요.");
                    }
                    break;
                case 6:
                    System.out.println("ID  |  이름  |    연락처    | ");

                    for (MemberDTO m : memberDAO.list()) {
                        System.out.println(m.getId() + "  | "
                                + m.getName() + " | "
                                + m.getPhone() + " | ");
                    }

                    System.out.print("▶︎ 수업을 진행한 회원을 입력 해 주세요: ");
                    MemberDTO useMember = memberDAO.view(Integer.parseInt(In.getString()));

                    System.out.println("==========[ 회원정보 ]==========");
                    System.out.println(" - 회원 이름: " + useMember.getName());
                    System.out.println(" - 남은 PT 횟수: " + useMember.getSession());
                    System.out.println(" - 담당 트레이너: " + useMember.getTrainerNm());
                    System.out.print(" ▶︎ 사용횟수를 입력 하세요: ");

                    int orgSession = useMember.getSession();
                    int useSession = Integer.parseInt(In.getString());
                    useMember.setSession(orgSession - useSession);
                    result = memberDAO.usePt(useMember);

                    TrainerDTO useTrainer = trainerDAO.view(useMember.getTrainerId());
                    int orgLessons = useTrainer.getLessons();
                    useTrainer.setLessons(orgLessons + useSession);
                    result += trainerDAO.usePt(useTrainer);

                    if ( result > 0 ) {
                        System.out.println("✅ PT가 사용 되었습니다.");
                    } else {
                        System.out.println("PT가 사용되지 않았습니다. 다시 시도 해 주세요.");
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
