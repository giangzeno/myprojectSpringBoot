package com.Controler;

/** 
 * Controller
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
 * 20/02/2023              GiangNT2            Create
 *  
 * */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DTO.DTO;
import com.Data.Data;

@Controller
@RequestMapping("Movie")
public class Controler {

	@Autowired(required = true)
	private Data data;
	@Autowired
	private com.Service.Service Service;

	@GetMapping("/Add")
	public String addGet(Model model) {
		model.addAttribute("listType", Service.getlisttypeJSP());
		model.addAttribute("listSchedule", Service.getlistScheduleJSP());
		model.addAttribute("MovieVlue", new DTO());
		return "Movie/addMovie";
	}

	@PostMapping("/Add")
	public String addPost(Model model, @Valid @ModelAttribute(name = "MovieVlue") DTO obj, BindingResult resust) {
		model.addAttribute("listType", Service.getlisttypeJSP());
		model.addAttribute("listSchedule", Service.getlistScheduleJSP());
		if (Service.validate_Add(obj, model, resust)) {
			model.addAttribute("listMovie", Service.getAllMovie());
			return "Movie/listMovie";
		}
		return Service.validate_Add(obj, model, resust) ? "Movie/listMovie" : "Movie/addMovie";
	}

	@GetMapping("/List")
	public String listMovieGet(Model model) {
		model.addAttribute("listMovie", Service.getAllMovie());
		return "Movie/listMovie";
	}

	@PostMapping("/List")
	public String listMoviePost(Model model, @RequestParam(name = "search") String seaarch) {
		data.setSearch(seaarch);
		model.addAttribute("listMovie", Service.getAllListMovie(data.getSearch()));
		model.addAttribute("valueSearch", seaarch);
		return "Movie/listMovie";
	}

	@RequestMapping({ "List/Delete/", "List/Delete/{Movie_ID}" })
	public String delete(Model model, @PathVariable(name = "Movie_ID", required = false) String Movie_ID) {
		if (data.getSearch() == null) {
			Service.deleteMovie(Movie_ID, model);
			model.addAttribute("listMovie", Service.getAllMovie());
			return "Movie/listMovie";
		}
		Service.deleteMovie(Movie_ID, model);
		model.addAttribute("valueSearch", data.getSearch());
		model.addAttribute("listMovie", Service.getAllListMovie(data.getSearch()));
		return "Movie/listMovie";
	}

	@RequestMapping({ "List/Detail/", "List/Detail/{Movie_ID}" })
	public String Detail(Model model, @PathVariable(name = "Movie_ID", required = false) String Movie_ID) {
		if (Service.Detail(Movie_ID) == null) {
			model.addAttribute("errorMsg", "No data exists!");
			model.addAttribute("errorCode", "5555");
			return "error/error-page";
		}
		DTO movie = Service.Detail(Movie_ID);
		model.addAttribute("nameENG", movie.getMovie_Name_ENG());
		model.addAttribute("MovieVlue", movie);
		model.addAttribute("listType", Service.getlisttypeJSP());
		model.addAttribute("listSchedule", Service.getlistScheduleJSP());
		model.addAttribute("IMG", Service.urlIMG);
		return "Movie/addMovie";
	}

	@RequestMapping("SampleData")
	public String Sampledata(@Valid @ModelAttribute(name = "MovieVlue") DTO obj, BindingResult resust,Model model) {
		Service.sampledata();
		model.addAttribute("listType", Service.getlisttypeJSP());
		model.addAttribute("listSchedule", Service.getlistScheduleJSP());
		model.addAttribute("MovieVlue", new DTO());
		return "Movie/addMovie";
	}

}
