package com.devsuperior.dslearn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearn.dtos.DeliverRevisionDTO;
import com.devsuperior.dslearn.entities.Deliver;
import com.devsuperior.dslearn.repositories.DeliveryRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliveryRepository deliverRepository;
	
	public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO) {
		Optional<Deliver> deliverOptional = deliverRepository.findById(id);
		Deliver deliver = deliverOptional.get();
		deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
		deliver.setFeedback(deliverRevisionDTO.getFeedback());
		deliver.setStatus(deliverRevisionDTO.getStatus());
		deliverRepository.save(deliver);
	}

}
