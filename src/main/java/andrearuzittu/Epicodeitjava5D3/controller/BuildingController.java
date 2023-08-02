package andrearuzittu.Epicodeitjava5D3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andrearuzittu.Epicodeitjava5D3.model.Building;
import andrearuzittu.Epicodeitjava5D3.service.BuildingService;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public ResponseEntity<Page<Building>> getAllBuildings(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id,asc") String[] sort) {

		Sort.Direction direction = sort[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort[0]));

		Page<Building> buildingsPage = buildingService.getAllBuildings(pageRequest);
		return new ResponseEntity<>(buildingsPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {
		Building building = buildingService.getBuildingById(id);
		if (building != null) {
			return new ResponseEntity<>(building, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
		Building createdBuilding = buildingService.createBuilding(building);
		return new ResponseEntity<>(createdBuilding, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Building> updateBuilding(@PathVariable Long id, @RequestBody Building building) {
		Building updatedBuilding = buildingService.updateBuilding(id, building);
		if (updatedBuilding != null) {
			return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
		boolean deleted = buildingService.deleteBuilding(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
