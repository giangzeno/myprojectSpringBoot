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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table
public class Movie {
	@Id
	@Column(columnDefinition = "nvarchar(10)")
	private String Movie_ID;
	@Column(columnDefinition = "nvarchar(255)")
	private String Actor;
	@Column(columnDefinition = "int")
	private Integer Cinema_Room_Id;
	@Column(columnDefinition = "nvarchar(1000)")
	private String Content;
	@Column(columnDefinition = "nvarchar(255)")
	private String Director;
	@Column(columnDefinition = "int")
	private Integer Duration;
	@Column(columnDefinition = "date")
	private LocalDate From_Date;
	@Column(columnDefinition = "nvarchar(255)")
	private String Movie_Production_Company;
	@Column(columnDefinition = "date")
	
	private LocalDate To_Date;
	@Column(columnDefinition = "nvarchar(255)")
	private String Version;
	@Column(columnDefinition = "nvarchar(255)")
	private String Movie_Name_ENG;
	@Column(columnDefinition = "nvarchar(255)")
	private String Movie_Name_VN;
	@Column(columnDefinition = "nvarchar(255)")
	private String Large_Image;
	@Column(columnDefinition = "nvarchar(255)")
	private String Small_Image;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movie_Schedule", 
    joinColumns = { @JoinColumn(name = "Movie_ID") }, 
    inverseJoinColumns = {@JoinColumn(name = "Schedule_ID") })
	private Set<Schedule> Schedule_ID = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Movie_Type", 
    joinColumns = { @JoinColumn(name = "Movie_ID") }, 
    inverseJoinColumns = {@JoinColumn(name = "Type_ID") })
	private Set<Type> Type_ID = new HashSet<>();

	
	

	public Movie(String movie_ID, String actor, int cinema_Room_Id, String content, String director, int duration,
			LocalDate from_Date, String movie_Production_Company, LocalDate to_Date, String version,
			String movie_Name_ENG, String movie_Name_VN, String large_Image, String small_Image,
			Set<Schedule> schedule_ID, Set<Type> type_ID) {
		super();
		Movie_ID = movie_ID;
		Actor = actor;
		Cinema_Room_Id = cinema_Room_Id;
		Content = content;
		Director = director;
		Duration = duration;
		From_Date = from_Date;
		Movie_Production_Company = movie_Production_Company;
		To_Date = to_Date;
		Version = version;
		Movie_Name_ENG = movie_Name_ENG;
		Movie_Name_VN = movie_Name_VN;
		Large_Image = large_Image;
		Small_Image = small_Image;
		Schedule_ID = schedule_ID;
		Type_ID = type_ID;
	}

	public Movie() {
		super();
	}

	
	public Set<Schedule> getSchedule_ID() {
		return Schedule_ID;
	}

	public void setSchedule_ID(Set<Schedule> schedule_ID) {
		Schedule_ID = schedule_ID;
	}

	public Set<Type> getType_ID() {
		return Type_ID;
	}

	public void setType_ID(Set<Type> type_ID) {
		Type_ID = type_ID;
	}

	public String getMovie_ID() {
		return Movie_ID;
	}

	public void setMovie_ID(String movie_ID) {
		Movie_ID = movie_ID;
	}

	public String getActor() {
		return Actor;
	}

	public void setActor(String actor) {
		Actor = actor;
	}

	public int getCinema_Room_Id() {
		return Cinema_Room_Id;
	}

	public void setCinema_Room_Id(int cinema_Room_Id) {
		Cinema_Room_Id = cinema_Room_Id;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public LocalDate getFrom_Date() {
		return From_Date;
	}

	public void setFrom_Date(LocalDate from_Date) {
		From_Date = from_Date;
	}

	public String getMovie_Production_Company() {
		return Movie_Production_Company;
	}

	public void setMovie_Production_Company(String movie_Production_Company) {
		Movie_Production_Company = movie_Production_Company;
	}

	public LocalDate getTo_Date() {
		return To_Date;
	}

	public void setTo_Date(LocalDate to_Date) {
		To_Date = to_Date;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getMovie_Name_ENG() {
		return Movie_Name_ENG;
	}

	public void setMovie_Name_ENG(String movie_Name_ENG) {
		Movie_Name_ENG = movie_Name_ENG;
	}

	public String getMovie_Name_VN() {
		return Movie_Name_VN;
	}

	public void setMovie_Name_VN(String movie_Name_VN) {
		Movie_Name_VN = movie_Name_VN;
	}

	public String getLarge_Image() {
		return Large_Image;
	}

	public void setLarge_Image(String large_Image) {
		Large_Image = large_Image;
	}

	public String getSmall_Image() {
		return Small_Image;
	}

	public void setSmall_Image(String small_Image) {
		Small_Image = small_Image;
	}
	
	public static void main(String[] args) {
		Movie mv = new Movie();
		mv.setSchedule_ID(null);
		System.out.println(mv.getDuration());
	}

}
