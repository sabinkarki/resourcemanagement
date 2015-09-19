package com.codekarma.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date assignDate;
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Item getItemTranscation() {
		return itemTranscation;
	}

	public void setItemTranscation(Item itemTranscation) {
		this.itemTranscation = itemTranscation;
	}

	public TranscationStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TranscationStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Member getMemberTranscation() {
		return memberTranscation;
	}

	public void setMemberTranscation(Member memberTranscation) {
		this.memberTranscation = memberTranscation;
	}

	public Room getRoomTanscation() {
		return roomTanscation;
	}

	public void setRoomTanscation(Room roomTanscation) {
		this.roomTanscation = roomTanscation;
	}

	@Column
	private int status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "Item_Id_Transcation")
	private Item itemTranscation;

	@Enumerated(EnumType.STRING)
	private TranscationStatus transactionStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Member_Id_Transcation")
	private Member memberTranscation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Room_Id_Transcation")
	private Room roomTanscation;
   
}
