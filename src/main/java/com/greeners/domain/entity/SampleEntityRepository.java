package com.greeners.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long>{

	Optional<SampleEntity> findById(Long sampleId);
	
}
