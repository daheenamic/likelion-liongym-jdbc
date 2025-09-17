package trainer.repository;

import trainer.dto.TrainerDTO;

import java.util.List;

/**
 * 트레이너관리 DAO 인터페이스
 * @author dahee
 * @since 25.09.17
 */
public interface TrainerDAO {
    List<TrainerDTO> list();

    TrainerDTO view(int id);

    Integer insert(TrainerDTO trainerDTO);

    Integer update(TrainerDTO trainerDTO);

    Integer delete(TrainerDTO trainerDTO);

    Integer usePt(TrainerDTO trainerDTO);

}
