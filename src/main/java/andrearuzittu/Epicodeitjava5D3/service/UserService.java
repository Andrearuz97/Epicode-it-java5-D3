package andrearuzittu.Epicodeitjava5D3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import andrearuzittu.Epicodeitjava5D3.model.Utente;
import andrearuzittu.Epicodeitjava5D3.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Utente createUser(Utente user) {
		return userRepository.save(user);
	}

	public Page<Utente> getAllUsers(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest);
	}

	public Utente getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Utente updateUser(Long id, Utente user) {
		Utente existingUser = userRepository.findById(id).orElse(null);
		if (existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setFullName(user.getFullName());
			existingUser.setEmail(user.getEmail());

			return userRepository.save(existingUser);
		} else {
			return null;
		}
	}
}
