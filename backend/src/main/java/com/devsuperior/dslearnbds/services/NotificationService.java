package com.devsuperior.dslearnbds.services;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private AuthService authService;
	
    @Autowired
    private ModelMapper modelMapper;
	
    @Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable){
		User user = authService.authenticated();
		Page<Notification> page = notificationRepository.find(user,unreadOnly, pageable);
		return page.map(p -> entityToDto(p));
		
 	}
	
	private NotificationDTO entityToDto(Notification notification) {
		NotificationDTO notificantionDTO = modelMapper.map(notification, NotificationDTO.class);
		notificantionDTO.setUserId(notification.getUser().getId());
		return notificantionDTO;
		 
	}

}
