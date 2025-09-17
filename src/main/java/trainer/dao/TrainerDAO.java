package trainer.dao;

import trainer.dto.TrainerDTO;

import java.util.List;

public interface TrainerDAO {
    public List<TrainerDTO> list();

    public TrainerDTO view(int id);

    public Integer insert(TrainerDTO trainerDTO);

    public Integer update(TrainerDTO trainerDTO);

    public Integer delete(TrainerDTO trainerDTO);

    public Integer usePt(TrainerDTO trainerDTO);

}
