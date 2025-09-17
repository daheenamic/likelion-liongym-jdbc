package trainer.dao;

import trainer.dto.TrainerDTO;
import util.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 트레이너관리 DAO 구현체
 * @author dahee
 * @since 25.09.17
 */
public class TrainerDAOImpl implements TrainerDAO{
    @Override
    public List<TrainerDTO> list() {
        List<TrainerDTO> trainerList = new ArrayList<>();

        String sql = " SELECT ID, NAME, PHONE, BASE_SALARY, BONUS, LESSONS, REG_DATE "
                + " FROM TRAINERS "
                + " ORDER BY ID ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()) {
                TrainerDTO trainerDTO = new TrainerDTO();
                trainerDTO.setId(rs.getInt("ID"));
                trainerDTO.setName(rs.getString("NAME"));
                trainerDTO.setPhone(rs.getString("PHONE"));
                trainerDTO.setBaseSalary(rs.getInt("BASE_SALARY"));
                trainerDTO.setBonus(rs.getInt("BONUS"));
                trainerDTO.setLessons(rs.getInt("LESSONS"));
                trainerDTO.setRegDate(rs.getDate("REG_DATE"));
                trainerList.add(trainerDTO);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return trainerList;
    }

    @Override
    public TrainerDTO view(int id) {
        TrainerDTO trainerDTO = new TrainerDTO();

        String sql = " SELECT ID, NAME, PHONE, BASE_SALARY, BONUS, LESSONS, REG_DATE "
                   + " FROM TRAINERS "
                   + " WHERE ID = ? ";

        ResultSet rs = null;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                trainerDTO.setId(rs.getInt("ID"));
                trainerDTO.setName(rs.getString("NAME"));
                trainerDTO.setPhone(rs.getString("PHONE"));
                trainerDTO.setBaseSalary(rs.getInt("BASE_SALARY"));
                trainerDTO.setBonus(rs.getInt("BONUS"));
                trainerDTO.setLessons(rs.getInt("LESSONS"));
                trainerDTO.setRegDate(rs.getDate("REG_DATE"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(rs);
        }

        return trainerDTO;
    }

    @Override
    public Integer insert(TrainerDTO trainerDTO) {
        int result = 0;
        String sql = " INSERT INTO TRAINERS(NAME, PHONE, BASE_SALARY, BONUS) "
                   + " VALUES (?, ?, ?, ?) ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, trainerDTO.getName());
            ps.setString(2, trainerDTO.getPhone());
            ps.setInt(3, trainerDTO.getBaseSalary());
            ps.setInt(4, trainerDTO.getBonus());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer update(TrainerDTO trainerDTO) {
        int result = 0;
        String sql = " UPDATE TRAINERS SET "
                   + " NAME = ?, "
                   + " PHONE = ?, "
                   + " BASE_SALARY = ?, "
                   + " BONUS = ? "
                   + " WHERE ID = ? ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, trainerDTO.getName());
            ps.setString(2, trainerDTO.getPhone());
            ps.setInt(3, trainerDTO.getBaseSalary());
            ps.setInt(4, trainerDTO.getBonus());
            ps.setInt(5, trainerDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer delete(TrainerDTO trainerDTO) {
        int result = 0;
        String sql = " DELETE FROM TRAINERS WHERE ID = ? ";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, trainerDTO.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Integer usePt(TrainerDTO trainerDTO) {
        int result = 0;
        String sql = " UPDATE TRAINERS SET LESSONS = ? "
                   + " WHERE ID = ? " ;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setInt(1, trainerDTO.getLessons());
            ps.setInt(2, trainerDTO.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
