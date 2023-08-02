package andrearuzittu.Epicodeitjava5D3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrearuzittu.Epicodeitjava5D3.model.Workstation;
import andrearuzittu.Epicodeitjava5D3.model.WorkstationType;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
	List<Workstation> findByTypeAndBuilding_City(WorkstationType type, String city);
}
