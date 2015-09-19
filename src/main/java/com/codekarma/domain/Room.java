package com.codekarma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Column
	private String name;
	@Column
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomItem", cascade = CascadeType.ALL)
	private List<Item> lstItemsInRoom;

	@NotNull
	@ManyToOne//(fetch=FetchType.EAGER)
	@JoinColumn(name = "Building_Id")
	private Building building;

	@Enumerated(EnumType.STRING)
	private ResourceStatus status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomMember", cascade = CascadeType.ALL)
	private List<Member> lstMemberInRoom;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomTanscation", cascade = CascadeType.ALL)
	private List<Transaction> lstTranscationRoom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Item> getLstItemsInRoom() {
		return lstItemsInRoom;
	}

	public void setLstItemsInRoom(List<Item> lstItemsInRoom) {
		this.lstItemsInRoom = lstItemsInRoom;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public ResourceStatus getStatus() {
		return status;
	}

	public void setStatus(ResourceStatus status) {
		this.status = status;
	}

	public List<Member> getLstMemberInRoom() {
		return lstMemberInRoom;
	}

	public void setLstMemberInRoom(List<Member> lstMemberInRoom) {
		this.lstMemberInRoom = lstMemberInRoom;
	}

	public List<Transaction> getLstTranscationRoom() {
		return lstTranscationRoom;
	}

	public void setLstTranscationRoom(List<Transaction> lstTranscationRoom) {
		this.lstTranscationRoom = lstTranscationRoom;
	}

//	@Override
//	public boolean equals(Object otherRoom) {
//		if (otherRoom instanceof Room) {
//			Room room2 = (Room) otherRoom;
//			if (this.name.equals(room2.name)
//					&& this.building.getName().equals(room2.building.getName())) {
//				return true;
//			}
//		}
//		return false;
//	}
	
//	@Override
//	public int hashCode() {
//		int result = this.name.hashCode();
//		result += 37 * result + this.building.getName().hashCode();
//		return result;
//	}

}
