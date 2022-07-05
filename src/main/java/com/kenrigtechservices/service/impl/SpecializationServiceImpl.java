package com.kenrigtechservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenrigtechservices.entity.Specialization;
import com.kenrigtechservices.repo.SpecializationRepository;
import com.kenrigtechservices.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {
 
	@Autowired
	private SpecializationRepository repo;
	
	@Override
	public Integer saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	@Override
	public List<Specialization> getAllSpecializations() {
		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Integer id) {
		 repo.deleteById(id);
	}

	@Override
	public Specialization getOneSpecialization(Integer id) {
		Optional<Specialization> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
		return null;
		}
	}

	@Override
	public void updateSpecialization(Specialization spec) {
				repo.save(spec);
	}

}
