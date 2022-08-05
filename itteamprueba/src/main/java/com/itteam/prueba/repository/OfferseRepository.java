package com.itteam.prueba.repository;

import com.itteam.prueba.entity.Offerse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferseRepository extends JpaRepository<Offerse, Integer>{
	 Optional<Offerse> findByName(String name);
	    boolean existsByName(String name);
}
