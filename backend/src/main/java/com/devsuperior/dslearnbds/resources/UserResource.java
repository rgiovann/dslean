package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.UserService;

// Rest Controller (API)
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

//	@GetMapping
//	public ResponseEntity<Page<UserDTO>> findAll( Pageable pageable) {
//	     // http request direction is String, Direction is an enumeration type (so the need of valueOf)
// 		
//		Page<UserDTO> list = service.findAllPaged(pageable);
//		return ResponseEntity.ok().body(list);
//
//	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO userDTO = service.findById(id);
		return ResponseEntity.ok().body(userDTO);

	}
	
//	@PostMapping
//	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertUpdateDTO userInsertUpdateDTO){
//		UserDTO userDTO = service.insert(userInsertUpdateDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(userDTO.getId()).toUri();
//		return ResponseEntity.created(uri).body(userDTO);
//		
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<UserDTO> update(@PathVariable Long id,@Valid @RequestBody UserInsertUpdateDTO userInserUpdatetDTO){
//		UserDTO userDTO = service.update(id, userInserUpdatetDTO);
//		return ResponseEntity.ok().body(userDTO);
//		
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<UserDTO> delete(@PathVariable Long id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//		
//	}
	
 
}
