package com.kenrigtechservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenrigtechservices.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
