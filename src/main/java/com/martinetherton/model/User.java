package com.martinetherton.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_USER")
public class User {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long entityId;
	
	@Column(name="FIRST_NAME")
	@NotNull
	@Size(min=1)
	private String firstName;
	
	@Column(name="BSN")
	@NotNull
	@Size(min=1)
	private String bsn;
	
	@Column(name="SURNAME")
	@NotNull
	@Size(min=1)
	private String surname;	
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

//	@Column(name="PARTNER_ID")
//	private Long partnerId;	
	
	
//	public Long getPartnerId() {
//		return partnerId;
//	}
//
//	public void setPartnerId(Long partnerId) {
//		this.partnerId = partnerId;
//	}

	@OneToOne(cascade = CascadeType.ALL, optional=true)
	@JoinColumn(name="PARTNER_ID")
	private Partner partner;	
	
    public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		this.partner = partner;
	}

}
