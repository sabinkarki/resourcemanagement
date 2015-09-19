package com.codekarma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer attr;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="categoryItem",cascade=CascadeType.ALL)
	private List<Item>lstCategoryItems;

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

	public Integer getAttr() {
		return attr;
	}

	public void setAttr(Integer attr) {
		this.attr = attr;
	}

	public List<Item> getLstCategoryItems() {
		return lstCategoryItems;
	}

	public void setLstCategoryItems(List<Item> lstCategoryItems) {
		this.lstCategoryItems = lstCategoryItems;
	}
}
