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
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	@Column
	private String itemCode;
	@Column
	@NotBlank
	private String name;
	@Column
	private String description;
	
	@Transient
	@JsonIgnore
	private MultipartFile image;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Category_Id_Item")
	@Valid
	private Category categoryItem;
	
	@Enumerated(EnumType.STRING)
	private ResourceStatus status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Room_Id_Item")
    private Room roomItem;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Member_Id_Item")
	private Member memberItem;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="itemTranscation")
	private List<Transaction>lstTranscationItem;
	
	public Long getId() {
		return id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public void setId(Long id) {
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

	public String getImageUrl() {
		return  (this.itemCode + "_" + this.name).replace(" ", "") + ".png";
	}

	@XmlTransient
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Category getCategoryItem() {
		return categoryItem;
	}

	public void setCategoryItem(Category categoryItem) {
		this.categoryItem = categoryItem;
	}

	public ResourceStatus getStatus() {
		return status;
	}

	public void setStatus(ResourceStatus status) {
		this.status = status;
	}

	public Room getRoomItem() {
		return roomItem;
	}

	public void setRoomItem(Room roomItem) {
		this.roomItem = roomItem;
	}

	public Member getMemberItem() {
		return memberItem;
	}

	public void setMemberItem(Member memberItem) {
		this.memberItem = memberItem;
	}

	public List<Transaction> getLstTranscationItem() {
		return lstTranscationItem;
	}

	public void setLstTranscationItem(List<Transaction> lstTranscationItem) {
		this.lstTranscationItem = lstTranscationItem;
	}
}
