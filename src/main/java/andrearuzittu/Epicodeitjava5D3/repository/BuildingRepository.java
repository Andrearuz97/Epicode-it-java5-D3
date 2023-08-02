package andrearuzittu.Epicodeitjava5D3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrearuzittu.Epicodeitjava5D3.model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
