package com.nisum.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.api.Git;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nisum.api.GitProjectDetails;

@Service
public class GitRepoService  {

	@Autowired
	public RestTemplate restTemplate;
	
//	public List<GitProjectDetails> getAllProjects() {
//		// TODO Auto-generated method stub
//		GitProjectDetails git=restTemplate.getForObject(
//		"https://api.github.com/repos/avinash10592/SpringBoot/git/trees/1faed8a192486039d0ce37f4ad11a502a6403452",
//		GitProjectDetails.class);
//		System.out.println(git);
//		return git;
//	}

	public List<String> getAllBranches(String repositoryUrl) throws Exception {
			Collection<Ref> refs = new ArrayList<Ref>();
			refs = Git.lsRemoteRepository()
					.setHeads(true)
					.setRemote(repositoryUrl)
					.call();
			List<String> projectNames = refs.stream()
											.map(e -> e.getName())
											.collect(toList());
			System.out.println(projectNames);
			return projectNames;
		
	}
}

	
	
	

