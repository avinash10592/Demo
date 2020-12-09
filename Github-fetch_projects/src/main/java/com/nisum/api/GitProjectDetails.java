package com.nisum.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GitProjectDetails {
	private List<?> tree;

	public List<?> getTree() {
		return tree;
	}

	public void setTree(List<?> tree) {
		this.tree = tree;
	}

	
	

}
