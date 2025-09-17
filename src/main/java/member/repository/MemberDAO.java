package member.repository;

import member.dto.MemberDTO;

import java.util.List;

/**
 * 회원관리 DAO 인터페이스
 * @author dahee
 * @since 25.09.17
 */
public interface MemberDAO {

    List<MemberDTO> list();

    List<MemberDTO> listByTrainerId(int id);

    MemberDTO view(int id);

    Integer insert(MemberDTO memberDTO);

    Integer update(MemberDTO memberDTO);

    Integer delete(MemberDTO memberDTO);

    Integer buyPt(MemberDTO memberDTO);

    Integer usePt(MemberDTO memberDTO);
}
