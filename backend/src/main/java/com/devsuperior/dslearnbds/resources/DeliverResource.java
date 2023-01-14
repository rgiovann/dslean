package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDto;
import com.devsuperior.dslearnbds.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

	@Autowired
	private DeliverService deliverService;

	@PutMapping(value = "/{id}")
	public ResponseEntity<DeliverRevisionDto> update(@PathVariable Long id, @RequestBody DeliverRevisionDto deliverRevisionDto){
		deliverService.saveRevision(id, deliverRevisionDto);
		return ResponseEntity.noContent().build();
		
	}

}
