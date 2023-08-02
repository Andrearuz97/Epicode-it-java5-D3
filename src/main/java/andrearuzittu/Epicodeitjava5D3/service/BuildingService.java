package andrearuzittu.Epicodeitjava5D3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import andrearuzittu.Epicodeitjava5D3.model.Building;
import andrearuzittu.Epicodeitjava5D3.repository.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	public Building createBuilding(Building building) {
		return buildingRepository.save(building);
	}

	public Page<Building> getAllBuildings(Pageable pageable) {
		return buildingRepository.findAll(pageable);
	}

	public Building getBuildingById(Long id) {
		return buildingRepository.findById(id).orElse(null);
	}

	public Building updateBuilding(Long id, Building building) {
		Building existingBuilding = buildingRepository.findById(id).orElse(null);
		if (existingBuilding != null) {
			existingBuilding.setName(building.getName());
			existingBuilding.setAddress(building.getAddress());

			return buildingRepository.save(existingBuilding);
		} else {
			return null;
		}
	}

	public boolean deleteBuilding(Long id) {
		if (buildingRepository.existsById(id)) {
			buildingRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
