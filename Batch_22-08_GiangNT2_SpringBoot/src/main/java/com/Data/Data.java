package com.Data;

import org.springframework.stereotype.Component;

@Component
public class Data {
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
