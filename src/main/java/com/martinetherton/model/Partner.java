package com.martinetherton.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_PARTNER")
public class Partner implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long entityId;
		
	
	@Column(name="BSN")
	@NotNull
	@Size(min=1)
	private String bsn;	
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public Partner() {
		
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

}
