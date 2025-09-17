package member.dao;

import member.dto.MemberDTO;
import util.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public List<MemberDTO> list() {
        List<MemberDTO> memberList = new ArrayList<>();

        String sql = " SELECT M.ID, M.NAME, M.PHONE, M.TRAINER_ID, T.NAME AS TRAINER_NM, M.SESSION, M.REG_DATE  "
                   + " FROM MEMBERS M "
                   + " LEFT OUTER JOIN TRAINERS T "
                   + " ON M.TRAINER_ID = T.ID "
                   + " ORDER BY M.ID ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(rs.getInt("ID"));
                memberDTO.setName(rs.getString("NAME"));
                memberDTO.setPhone(rs.getString("PHONE"));
                memberDTO.setTrainerId(rs.getInt("TRAINER_ID"));
                memberDTO.setTrainerNm(rs.getString("TRAINER_NM"));
                memberDTO.setSession(rs.getInt("SESSION"));
                memberDTO.setRegDate(rs.getDate("REG_DATE"));
                memberList.add(memberDTO);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }

    @Override
    public MemberDTO view(int id) {
        MemberDTO memberDTO = new MemberDTO();

        String sql = " SELECT M.ID, M.NAME, M.PHONE, M.TRAINER_ID, T.NAME AS TRAINER_NM, M.SESSION, M.REG_DATE  "
                   + " FROM MEMBERS M "
                   + " LEFT OUTER JOIN TRAINERS T "
                   + " ON M.TRAINER_ID = T.ID "
                   + " WHERE M.ID = ? ";

        ResultSet rs = null;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                memberDTO.setId(rs.getInt("ID"));
                memberDTO.setName(rs.getString("NAME"));
                memberDTO.setPhone(rs.getString("PHONE"));
                memberDTO.setTrainerId(rs.getInt("TRAINER_ID"));
                memberDTO.setTrainerNm(rs.getString("TRAINER_NM"));
                memberDTO.setSession(rs.getInt("SESSION"));
                memberDTO.setRegDate(rs.getDate("REG_DATE"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(rs);
        }

        return memberDTO;
    }

    @Override
    public Integer insert(MemberDTO memberDTO) {
        int result = 0;
        String sql = " INSERT INTO MEMBERS(NAME, PHONE) VALUES(?, ?) ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getPhone());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer update(MemberDTO memberDTO) {
        int result = 0;
        String sql = " UPDATE MEMBERS SET NAME = ?, PHONE = ? "
                   + " WHERE ID = ? " ;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getPhone());
            ps.setInt(3, memberDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer delete(MemberDTO memberDTO) {
        int result = 0;
        String sql = " DELETE FROM MEMBERS WHERE ID = ? ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, memberDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer buyPt(MemberDTO memberDTO) {
        int result = 0;
        String sql = " UPDATE MEMBERS SET TRAINER_ID = ?, SESSION = ? "
                   + " WHERE ID = ? " ;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setInt(1, memberDTO.getTrainerId());
            ps.setInt(2, memberDTO.getSession());
            ps.setInt(3, memberDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer usePt(MemberDTO memberDTO) {
        int result = 0;
        String sql = " UPDATE MEMBERS SET SESSION = ? "
                   + " WHERE ID = ? " ;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setInt(1, memberDTO.getSession());
            ps.setInt(2, memberDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
