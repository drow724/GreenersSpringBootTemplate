package com.greeners.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SampleEntity {

	  @Id
	  private Long sampleId;

	  @Column(name = "sampleName")
	  private String sampleName;
	
}
