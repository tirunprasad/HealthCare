package com.kenrigtechservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.kenrigtechservices.entity.Specialization;
@Service
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
