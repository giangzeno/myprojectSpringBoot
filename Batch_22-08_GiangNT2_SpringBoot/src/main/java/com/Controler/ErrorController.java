package com.Controler;

/** 
 * ErrorController
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
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	/** Error page. */
	private static final String ERROR_PAGE = "error/error-page";

	@Autowired
	private DataSource dataSource;

	/** Error page. */
	@RequestMapping(value = "/errors", method = RequestMethod.GET)
	public String renderErrorPage(HttpServletRequest httpRequest, Model model) {

		String errorCode = "";
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400:
			errorCode = "400";
			errorMsg = "Bad Request.";
			break;

		case 401:
			errorCode = "401";
			errorMsg = "Unauthorized.";
			break;

		case 403:
			errorCode = "403";
			errorMsg = "Access is denied.";
			break;

		case 404:
			errorCode = "404";
			errorMsg = "Page not found.";
			break;

		case 405:
			errorCode = "405";
			errorMsg = "Method not allowed.";
			break;

		case 500:
			errorCode = "500";
			errorMsg = "Internal Server Error.";
			break;

		default:
			try {
				if (dataSource.getConnection() != null) {
					errorCode = ":(";
					errorMsg = "Database Connection Successfully Established.";

				} else {
					errorCode = ":(";
					errorMsg = "Failed to connect database.";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				errorCode = ":(";
				errorMsg = "Failed to connect database.";
			}
			break;
		}
		model.addAttribute("errorMsg", errorMsg);
		model.addAttribute("errorCode", errorCode);
		return ERROR_PAGE;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

	
	
}