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

import andrearuzittu.Epicodeitjava5D3.model.Workstation;
import andrearuzittu.Epicodeitjava5D3.service.WorkstationService;

@RestController
@RequestMapping("/workstations")
public class WorkstationController {

	@Autowired
	private WorkstationService workstationService;

	@GetMapping
	public ResponseEntity<Page<Workstation>> getAllWorkstations(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id,asc") String[] sort) {

		Sort.Direction direction = sort[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort[0]));

		Page<Workstation> workstationsPage = workstationService.getAllWorkstations(pageRequest);
		return new ResponseEntity<>(workstationsPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Workstation> getWorkstationById(@PathVariable Long id) {
		Workstation workstation = workstationService.getWorkstationById(id);
		if (workstation != null) {
			return new ResponseEntity<>(workstation, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Workstation> createWorkstation(@RequestBody Workstation workstation) {
		Workstation createdWorkstation = workstationService.createWorkstation(workstation);
		return new ResponseEntity<>(createdWorkstation, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Workstation> updateWorkstation(@PathVariable Long id, @RequestBody Workstation workstation) {
		Workstation updatedWorkstation = workstationService.updateWorkstation(id, workstation);
		if (updatedWorkstation != null) {
			return new ResponseEntity<>(updatedWorkstation, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWorkstation(@PathVariable Long id) {
		boolean deleted = workstationService.deleteWorkstation(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
