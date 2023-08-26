package com.Service;

/** 
 * validate
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class validate {
	private final static String PATTEN_IMG = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

	/**
	 * Delete toàn bộ những giá trị trùng
	 * 
	 * @param String[] 
	 * @return List<String>
	 */
	public List<String> deleteTrung(String[] list) {
		List<String> listArr = new ArrayList<String>(Arrays.asList(list));
		Set<String> set = new LinkedHashSet<String>(listArr);
		List<String> listOutPut = new ArrayList<String>(set);
		return listOutPut;
	}
	/**
	 * So sánh ld1 và ld2
	 * 
	 * @param LocalDate ld1, LocalDate ld2 
	 * @return Boolean
	 */
	public Boolean validate_Formdate_ToDate(LocalDate ld1, LocalDate ld2) {
		try {
			return ld1.isAfter(ld2);
		} catch (Exception e) {
			return true;
		}

	}
	/**
	 * Phân item để hiển thị lên views
	 * 
	 * @param List<String>
	 * @return List<String[]>
	 */
	public List<String[]> phanItem1(List<String> list) {
		List<String[]> listString = new LinkedList<String[]>();
		String[] arr = null;
		if (list == null) {
			return null;
		}

		for (int i = 0; i < list.size(); i++) {
			if (i % 3 == 0) {
				arr = new String[3];
				listString.add(arr);
				arr[0] = list.get(i);
			} else if (i % 3 == 1) {
				arr[1] = list.get(i);
			} else {
				arr[2] = list.get(i);
			}
		}
		return listString;
	}
	/**
	 * Validate ngày đưa vào có đúng định dạng
	 * 
	 * @param String[] 
	 * @return Boolean
	 */
	public Boolean Format_Date(String search) {
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		dfm.setLenient(false);
		if (search == null) {
			return false;
		}
		try {
			dfm.parse(search);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * validate File đưa vào có phải là Image
	 * 
	 * @param String 
	 * @return Boolean
	 */
	public Boolean validateIMG(String img) {
		try {
			Pattern pattern = Pattern.compile(PATTEN_IMG);
			Matcher matcher = pattern.matcher(img);
			boolean matchFound = matcher.find();
			return !matchFound;
		} catch (Exception e) {
			return true;
		}
	}
	/**
	 * validate Length 
	 * 
	 * @param String[] 
	 * @return Boolean
	 */
	public Boolean validateScheduleANDtype(String[] arr) {
		try {
			return arr.length == 0;
		} catch (Exception e) {
			return true;
		}
	}

}
