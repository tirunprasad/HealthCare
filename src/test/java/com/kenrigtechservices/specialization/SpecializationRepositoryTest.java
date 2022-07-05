package com.kenrigtechservices.specialization;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.kenrigtechservices.entity.Specialization;
import com.kenrigtechservices.repo.SpecializationRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepositoryTest {
	@Autowired
	private SpecializationRepository repo;
	@Test
	@Order(1)
	//@Disabled
	public void testSpecCreate() {
		Specialization spec = new Specialization(null, "CRDLS","Cardiologist","They are expert on heart and blood");
		spec = repo.save(spec);
		assertNotNull(spec.getId(),"Spec is not created");
		}
	
	@Test
	@Order(2)
	public void testSpecFetchAll() {
	List<Specialization> list =	repo.findAll();
	assertNotNull(list);
	if(list.isEmpty()) {
		fail("No data exist in Database");
	}
	}

}
