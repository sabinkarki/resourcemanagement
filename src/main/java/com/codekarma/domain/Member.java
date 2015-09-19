package com.codekarma.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name")
	@NotEmpty(message = "{fullname.sk}")
	private String name;

	@NotEmpty(message = "Enter {0}")
	@Size(min = 5, max = 8)
	@Column(name = "Username")
	private String username;

	@NotEmpty(message = "Enter {0}")
	// @Size(min=5, max=8)
	@Column(name = "Password")
	private String password;

	@Transient
	private String retype;

	@Column
	@NotEmpty(message = "Select {0}")
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Email
	@NotEmpty
	@Column(name = "Email")
	private String email;

	@Column
	private String imageUrl;
	@Transient
	private MultipartFile image;

	@NotNull(message = "Valid date dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column
	@NotEmpty(message = "Enter {0}")
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRetype() {
		return retype;
	}

	public void setRetype(String retype) {
		this.retype = retype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Item> getLstMemberItems() {
		return lstMemberItems;
	}

	public void setLstMemberItems(List<Item> lstMemberItems) {
		this.lstMemberItems = lstMemberItems;
	}

	public Room getRoomMember() {
		return roomMember;
	}

	public void setRoomMember(Room roomMember) {
		this.roomMember = roomMember;
	}

	public List<Transaction> getLstTranscationMember() {
		return lstTranscationMember;
	}

	public void setLstTranscationMember(List<Transaction> lstTranscationMember) {
		this.lstTranscationMember = lstTranscationMember;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	// private List<Role>lstRoleMember;
	@OneToOne(fetch = FetchType.EAGER)
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberItem", cascade = CascadeType.ALL)
	private List<Item> lstMemberItems;
	@ManyToOne
	@JoinColumn(name = "Room_Id_Member")
	private Room roomMember;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberTranscation", cascade = CascadeType.ALL)
	private List<Transaction> lstTranscationMember;

	@Transient
	private String enablePasswordChange;

	public String getEnablePasswordChange() {
		return enablePasswordChange;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public void setEnablePasswordChange(String enablePasswordChange) {
		this.enablePasswordChange = enablePasswordChange;
	}

}
