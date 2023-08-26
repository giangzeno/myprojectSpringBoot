package com.Service;

/** 
 * Service
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
 * 20/02/2023               GiangNT2            Create
 *  
 * */
import java.io.File;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.DTO;
import com.Entity.Movie;
import com.Entity.Schedule;
import com.Entity.Type;
import com.Repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	// Phải sửa đường dẫn thư mục
	public static final String PATH_FILE_2 = "F:\\Begin-Java22-06\\SaverWebProject\\Movie_Mock\\src\\main\\webapp\\assets\\img";
	public static final String PATH_FILE_1 = "F:/SaverWebProject/Files";
	public String urlIMG;

	@Autowired(required = true)
	private validate validate;

	@Autowired
	private Repository Repository;

	/**
	 * Chuyển từ đối Movie qua đối tượng DTO để đưa lên view
	 * 
	 * @param Movie    Movie
	 * @param String[] list Type name
	 * @param String[] List Schedule time
	 * 
	 * @return Object DTO
	 */
	public DTO getDTO(Movie movie, String[] Movie_Type, String[] Movie_Schedule) {
		return new DTO(movie.getMovie_ID(), movie.getActor(), movie.getCinema_Room_Id(), movie.getContent(),
				movie.getDirector(), movie.getDuration(), movie.getFrom_Date(), movie.getMovie_Production_Company(),
				movie.getTo_Date(), movie.getVersion(), movie.getMovie_Name_ENG(), movie.getMovie_Name_VN(), null,
				Movie_Type, Movie_Schedule);
	}

	/**
	 * Chuyển từ đối tượng DTO Qua đối tượng Movie để add xuống data base
	 * 
	 * @param DTO    obj
	 * @param String Name_img
	 * @return Có add được xuống data base ko(true/false)
	 */
	public Boolean add(DTO obj, String path_URL) {
		Movie movie = new Movie(obj.getMovie_ID(), obj.getActor(), obj.getCinema_Room_Id(), obj.getContent(),
				obj.getDirector(), obj.getDuration(), obj.getFrom_Date(), obj.getMovie_Production_Company(),
				obj.getTo_Date(), obj.getVersion(), obj.getMovie_Name_ENG(), obj.getMovie_Name_VN(), path_URL, path_URL,
				this.listSchedule(obj.getSchedule_Time()), this.listType(obj.getType_Name()));
		return Repository.add(movie);
	}

	/**
	 * Get toàn bộ Schedule dưới database để đưa lên add database
	 * 
	 * @param String[] Schedule_time
	 * @return List<Schedule> sau khi search được
	 */
	public Set<Schedule> listSchedule(String[] schedule_time) {
		if (schedule_time == null) {
			return null;
		}
		return Repository.listSchedule(validate.deleteTrung(schedule_time));
	}

	/**
	 * Get toàn bộ Type name dưới database để đưa lên add database
	 * 
	 * @param String[] type_name
	 * @return List<Type> sau khi search được
	 */
	public Set<Type> listType(String[] type_name) {
		if (type_name == null) {
			return null;
		}
		return Repository.listType(validate.deleteTrung(type_name));
	}

	/**
	 * Get toàn bộ Type name dưới database để đưa lên view
	 * 
	 * @return List<String[]> sau khi search được
	 */
	public List<String[]> getlisttypeJSP() {
		List<String> listBase = Repository.listType();
		return validate.phanItem1(listBase);
	}

	/**
	 * Get toàn bộ Schedule time dưới database để đưa lên view
	 * 
	 * @return List<String[]> sau khi search được
	 */
	public List<String[]> getlistScheduleJSP() {
		List<String> listBase = Repository.listSchedule();
		return validate.phanItem1(listBase);
	}

	/**
	 * Kiểm tra ID có tồn tại trong DataBase
	 * 
	 * @param String Movie_Id
	 * 
	 * @return Kết quả validate được(true/false)
	 */
	public Boolean validateMovieID(String Movie_ID) {
		return Repository.validateID(Movie_ID);
	}

	public List<Movie> getListMovie(String shear) {
		return Repository.getListMovie(shear);
	}

	public List<Movie> getListMovieNodate(String search) {
		return Repository.getListMovieNoDate(search);
	}

	/**
	 * Tìm Kiếm Movie Theo Movie_Name_ENG, From Date, Version
	 * 
	 * @param String search
	 * 
	 * @return List<Movie> sau khi search được
	 */
	public List<Movie> getAllListMovie(String search) {
		return validate.Format_Date(search) ? Repository.getListMovieNoDate(search) : Repository.getListMovie(search);
	}

	/**
	 * Validate IMG
	 * 
	 * @param MultipartFile myFile
	 * @param String        nameFile(Movie_ID) để tên Img ko trùng
	 * @return String NameIMG
	 */
	public String uploadFile(MultipartFile myFile, String nameFile) {
		String Path_File = null;
		try {
			String fileName = myFile.getOriginalFilename();
			if (validate.validateIMG(fileName)) {
				return Path_File;
			}
			File file = new File(PATH_FILE_2, nameFile.concat(fileName));
			myFile.transferTo(file);
			return file.getName();
		} catch (Exception e) {
			e.printStackTrace();
			return Path_File;
		}
	}

	/**
	 * Validate IMG
	 * 
	 * @param Name File
	 * 
	 * @return Kết quả Validate (true/false)
	 */
	public Boolean validate_IMG(String img) {
		return validate.validateIMG(img);
	}

	public Boolean validate_Formdate_ToDate(LocalDate d1, LocalDate d2) {
		return validate.validate_Formdate_ToDate(d1, d2);
	}

	/**
	 * Validate Khi Add New Movie
	 * 
	 * @param BindingResult resust
	 * @param Model         model
	 * @param DTO           model
	 * 
	 * @return Kết quả Validate (true/false)
	 */
	public Boolean validate_Add(DTO obj, Model model, BindingResult resust) {
		String path_URL = null;
		String nulls = "";
		List<Boolean> check = new LinkedList<Boolean>();
		if (validate_Formdate_ToDate(obj.getFrom_Date(), obj.getTo_Date())) {
			model.addAttribute("err_Date", "To Date Must Be Greater Than Form Date!");
			check.add(true);
		} else {
			model.addAttribute("err_IMG", nulls);
			check.add(false);
		}
		if (validateMovieID(obj.getMovie_ID())) {
			model.addAttribute("errMovieID", "Movie ID Already Exists!");
			check.add(true);
		} else {
			path_URL = uploadFile(obj.getIMG(), obj.getMovie_ID());
			model.addAttribute("errMovieID", nulls);
			check.add(false);
		}

		if (validate_IMG(path_URL)) {
			model.addAttribute("err_IMG", "Incorrect Photo!");
			check.add(true);
		} else {
			model.addAttribute("err_IMG", nulls);
			check.add(false);
		}

		if (validate.validateScheduleANDtype(obj.getSchedule_Time())) {
			model.addAttribute("errSchedule", "Please fill in this field!");
			check.add(true);
		} else {
			model.addAttribute("errSchedule", nulls);
			check.add(false);
		}
		if (validate.validateScheduleANDtype(obj.getType_Name())) {
			model.addAttribute("errtype", "Please fill in this field!");
			check.add(true);
		} else {
			model.addAttribute("errtype", nulls);
			check.add(false);
		}

		if (resust.hasErrors()) {
			check.add(true);
		} else {
			model.addAttribute("feebackerr", nulls);
			check.add(false);
		}

		if (check.contains(true)) {
			model.addAttribute("feebackeADD", nulls);
			return false;
		} else {

			if (add(obj, path_URL)) {
				model.addAttribute("MovieVlue", new DTO());
				model.addAttribute("feebackeADD", "Add Movie Succsess");
			} else {
				model.addAttribute("feebackeADD", "");
			}
			return true;
		}
	}

	/**
	 * Xóa Movie
	 * 
	 * @param String Moive Id
	 * @param String Model model
	 */
	public void deleteMovie(String Movie_Id, Model model) {
		if (Movie_Id == null) {
			Movie_Id = "";
		}
		if (Repository.deleteMovie(Movie_Id)) {
			model.addAttribute("feedback_Delete", "Delete Successfully");
		} else {
			model.addAttribute("feedback_Delete", "Delete Failed");
		}
	}

	/**
	 * Get Movie dưới DataBase để hiển thị Detail trên trang Add Movie
	 * 
	 * @param String Moive Id
	 * 
	 * @return A object DTO
	 */
	public DTO Detail(String Movie_ID) {
		if (Movie_ID == null) {
			Movie movie = Repository.Detail("");
			if (movie == null) {
				return null;
			} else {
				String[] Movie_Type = Repository.Movie_Type(Movie_ID);
				String[] Movie_Schedule = Repository.Movie_Schedule(Movie_ID);
				this.urlIMG = movie.getLarge_Image();
				return getDTO(movie, Movie_Type, Movie_Schedule);
			}
		} else {
			Movie movie = Repository.Detail(Movie_ID);
			if (movie == null) {
				return null;
			} else {
				String[] Movie_Type = Repository.Movie_Type(Movie_ID);
				String[] Movie_Schedule = Repository.Movie_Schedule(Movie_ID);
				this.urlIMG = movie.getLarge_Image();
				return getDTO(movie, Movie_Type, Movie_Schedule);
			}
		}
	}

	/**
	 * Get toàn bộ List Movie
	 * 
	 * @return Full List<Movie>
	 */
	public List<Movie> getAllMovie() {
		return Repository.getAllMovie();
	}
	
	public void sampledata() {
		Repository.Sampledata();
	}

}
