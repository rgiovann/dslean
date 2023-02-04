package com.devsuperior.dslearnbds.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDto;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository deliverRepository;
	
    @Autowired
    private ModelMapper modelMapper;
    
	
	@PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDto dto) {
	
		Deliver deliver = deliverRepository.getOne(id);
				
		modelMapper.map(dto, deliver);
 
		deliverRepository.save(deliver);
	}

}
