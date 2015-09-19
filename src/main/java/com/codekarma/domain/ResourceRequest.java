package com.codekarma.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class ResourceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	Room room;
	
	@OneToOne(fetch=FetchType.EAGER)
	Item item;
	
	@OneToOne(fetch=FetchType.EAGER)
	Member member;
	
	Date requestdate;
	
	Date completiondate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member memebr) {
		this.member = memebr;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	public Date getCompletiondate() {
		return completiondate;
	}

	public void setCompletiondate(Date completiondate) {
		this.completiondate = completiondate;
	}
}
