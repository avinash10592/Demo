package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.api.GitProjectDetails;
import com.nisum.service.GitRepoService;

@RestController
@RequestMapping("/projects")
public class GitRepoController {
	@Autowired
	private GitRepoService gitService;

//	@RequestMapping(value = "/repo", method = RequestMethod.GET)
//	public ResponseEntity<List<GitProjectDetails>> getAllProjects() {
//		gitService.getAllProjects();
//		return getAllProjects().;
		
		
		@RequestMapping(value = "/branch", method = RequestMethod.GET)
		public ResponseEntity<?> get(@RequestParam(value = "repo-url", required = true) String repositoryUrl) {
			try {
				List<String> refs = gitService.getAllBranches(repositoryUrl);
				if (CollectionUtils.isEmpty(refs)) {
					return new ResponseEntity<String>("Branches not found. might be invalid URL passed as input",
							HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<List<String>>(refs, HttpStatus.OK);
				}
			} catch (Exception e) {
				return new ResponseEntity<String>("falure", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}