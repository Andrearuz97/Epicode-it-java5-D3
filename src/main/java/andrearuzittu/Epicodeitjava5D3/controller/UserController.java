package andrearuzittu.Epicodeitjava5D3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import andrearuzittu.Epicodeitjava5D3.model.Utente;
import andrearuzittu.Epicodeitjava5D3.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Page<Utente>> getAllUsers(@RequestParam(required = false, defaultValue = "10") int size,
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());
		Page<Utente> usersPage = userService.getAllUsers(pageRequest);
		return new ResponseEntity<>(usersPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Utente> getUserById(@PathVariable Long id) {
		Utente user = userService.getUserById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<Utente> createUser(@RequestBody Utente user) {
		Utente createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Utente> updateUser(@PathVariable Long id, @RequestBody Utente user) {
		Utente updatedUser = userService.updateUser(id, user);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
