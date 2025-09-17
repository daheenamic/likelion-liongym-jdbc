package member.dao;

import member.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {

    public List<MemberDTO> list();

    public List<MemberDTO> listByTrainerId(int id);

    public MemberDTO view(int id);

    public Integer insert(MemberDTO memberDTO);

    public Integer update(MemberDTO memberDTO);

    public Integer delete(MemberDTO memberDTO);

    public Integer buyPt(MemberDTO memberDTO);

    public Integer usePt(MemberDTO memberDTO);
}
