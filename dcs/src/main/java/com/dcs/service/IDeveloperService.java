package com.dcs.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dto.DeveloperDTO;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Developer;
@Service
public interface IDeveloperService {

	DeveloperDTO addDeveloper(DeveloperDTO developer);

	

	List<DeveloperDTO> getDeveloperByStatus(String status);

	DeveloperDTO getDeveloperById(Integer devId);

	List<DeveloperDTO> getDeveloperByReputation(Integer reputation);

	Page<DeveloperDTO> getAllDevelopers(int page, int size);

	List<PostDTO> getPostsByDeveloper(Integer devId);

	List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts);

	DeveloperDTO getByMaxReputation();


	Page<PostDTO> getPostsByDeveloper(Integer devId, Pageable pageable);

	//Page<DeveloperDTO> getAllDevelopers(Pageable pageable);

	Page<DeveloperDTO> getDevelopersByStatus(String status, Pageable pageable);

//	Page<DeveloperDTO> getAllDevelopers(Pageable pageable);

	//Page<Developer> findAllWithPagination(int page, int size);

}
