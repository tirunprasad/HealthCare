package com.kenrigtechservices.service;

import java.util.List;

import com.kenrigtechservices.entity.Specialization;

public interface ISpecializationService {

	public Integer saveSpecialization(Specialization spec);
	public List<Specialization> getAllSpecializations();
	public void removeSpecialization(Integer id);
	public Specialization getOneSpecialization(Integer id);
	public void updateSpecialization(Specialization spec);
	
	
}
