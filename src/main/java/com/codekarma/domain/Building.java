package com.codekarma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.engine.internal.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Building {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotEmpty(message="building name cannot be empty")
	private String name;

	@Column
	@NotEmpty(message="building desc cannot be empty")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="building",cascade=CascadeType.ALL)
	List<Room>lstRoomInBuilding;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Room> getLstRoomInBuilding() {
		return lstRoomInBuilding;
	}

	public void setLstRoomInBuilding(List<Room> lstRoomInBuilding) {
		this.lstRoomInBuilding = lstRoomInBuilding;
	}

}
