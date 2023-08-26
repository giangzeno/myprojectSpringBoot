package com.DTO;

/** 
 * DTO
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
import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Please fill in this field!")
	private String Movie_ID;
	@NotBlank(message = "Please fill in this field!")
	private String Actor;
	private int Cinema_Room_Id;
	@NotBlank(message = "Please fill in this field!")
	private String Content;
	@NotBlank(message = "Please fill in this field!")
	private String Director;
	@Min(value = 1,message = "Please enter the correct value!")
	private Integer Duration;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate From_Date;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate To_Date;
	@NotBlank(message = "Please fill in this field!")
	private String Movie_Production_Company;
	@NotBlank(message = "Please fill in this field!")
	private String Version;
	@NotBlank(message = "Please fill in this field!")
	private String Movie_Name_ENG;
	@NotBlank(message = "Please fill in this field!")
	private String Movie_Name_VN;

	private MultipartFile IMG;

	private String[] Type_Name = null;
	private String[] Schedule_Time = null;

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

	public MultipartFile getIMG() {
		return IMG;
	}

	public void setIMG(MultipartFile iMG) {
		IMG = iMG;
	}

	public String[] getType_Name() {
		return Type_Name;
	}

	public void setType_Name(String[] type_Name) {
		Type_Name = type_Name;
	}

	public String[] getSchedule_Time() {
		return Schedule_Time;
	}

	public void setSchedule_Time(String[] schedule_Time) {
		Schedule_Time = schedule_Time;
	}

	public DTO(@NotBlank(message = "Please fill in this field!") String movie_ID,
			@NotBlank(message = "Please fill in this field!") String actor, int cinema_Room_Id,
			@NotBlank(message = "Please fill in this field!") String content,
			@NotBlank(message = "Please fill in this field!") String director, int duration, LocalDate from_Date,
			@NotBlank(message = "Please fill in this field!") String movie_Production_Company, LocalDate to_Date,
			@NotBlank(message = "Please fill in this field!") String version,
			@NotBlank(message = "Please fill in this field!") String movie_Name_ENG,
			@NotBlank(message = "Please fill in this field!") String movie_Name_VN, MultipartFile iMG,
			String[] type_Name, String[] schedule_Time) {
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
		IMG = iMG;
		Type_Name = type_Name;
		Schedule_Time = schedule_Time;
	}

	public DTO() {
		super();
	}

}
