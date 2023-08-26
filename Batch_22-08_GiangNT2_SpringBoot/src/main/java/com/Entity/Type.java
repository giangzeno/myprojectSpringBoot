package com.Entity;
/** 
 * Entity
 * 
 * Version 0.0.1-SNAPSHOT
 * 
 * Date: 16-02-2023
 * 
 * Copyright 
 * 
 * Modification Logs:
 * 
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 16-02-2023            GiangNT2            Create
 *  
 * */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Type {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(columnDefinition = "int")
	private int Type_ID;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String Type_Name;

	
	
	public Type() {
		super();
	}

	public Type(int type_ID, String type_Name) {
		super();
		Type_ID = type_ID;
		Type_Name = type_Name;
	}

	public int getType_ID() {
		return Type_ID;
	}

	public void setType_ID(int type_ID) {
		Type_ID = type_ID;
	}

	public String getType_Name() {
		return Type_Name;
	}

	public void setType_Name(String type_Name) {
		Type_Name = type_Name;
	}
	
	
}
