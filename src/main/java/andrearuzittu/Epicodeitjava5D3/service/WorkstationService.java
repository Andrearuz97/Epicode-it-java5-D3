package andrearuzittu.Epicodeitjava5D3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import andrearuzittu.Epicodeitjava5D3.model.Workstation;
import andrearuzittu.Epicodeitjava5D3.repository.WorkstationRepository;

@Service
public class WorkstationService {

	@Autowired
	private WorkstationRepository workstationRepository;

	public Workstation createWorkstation(Workstation workstation) {
		return workstationRepository.save(workstation);
	}

	public Page<Workstation> getAllWorkstations(Pageable pageable) {
		return workstationRepository.findAll(pageable);
	}

	public Workstation getWorkstationById(Long id) {
		return workstationRepository.findById(id).orElse(null);
	}

	public Workstation updateWorkstation(Long id, Workstation workstation) {
		Workstation existingWorkstation = workstationRepository.findById(id).orElse(null);
		if (existingWorkstation != null) {
			existingWorkstation.setCode(workstation.getCode()); // Correzione qui: Utilizza getCode() invece di
																// getName()
			existingWorkstation.setDescription(workstation.getDescription());

			return workstationRepository.save(existingWorkstation);
		} else {
			return null;
		}
	}

	public boolean deleteWorkstation(Long id) {
		if (workstationRepository.existsById(id)) {
			workstationRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
