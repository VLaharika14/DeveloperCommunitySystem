package com.dcs.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dao.DeveloperDao;
import com.dcs.dto.DeveloperDTO;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Developer;
import com.dcs.entity.Post;
@Service
public class DeveloperServiceImpl implements IDeveloperService {
	@Autowired
	DeveloperDao developerDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DeveloperDTO addDeveloper(DeveloperDTO developer) {
		Developer entity1=modelMapper.map(developer, Developer.class);
		entity1= developerDao.save(entity1);
		return modelMapper.map(entity1, DeveloperDTO.class);
		
	
		
	}

	

//	@Override
//	public List<DeveloperDTO> getDeveloperByStatus(String status) {	
//		List<Developer> entity3=developerDao.findByStatus(status);
//		  List<DeveloperDTO> developerDTOs = entity3.stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());         
//		  return developerDTOs;     
//	}

	@Override
	public DeveloperDTO getDeveloperById(Integer devId) {
		Developer entity3= developerDao.findById(devId).get();
		return modelMapper.map(entity3, DeveloperDTO.class);
		
	}

//	@Override
//	public List<DeveloperDTO> getDeveloperByReputation(Integer reputation) {
//		List<Developer>entity4= developerDao.findByReputationGreaterThanEqual(reputation);
//		List<DeveloperDTO> developerDTOs = entity4.stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());
//		return developerDTOs;
//	}

	@Override
	public List<DeveloperDTO> getAllDevelopers() {
		List<Developer>entity5= developerDao.findAll();
		List<DeveloperDTO> developerDTOs = entity5.stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());
	return developerDTOs;
	}

	@Override
	public List<PostDTO> getPostsByDeveloper(Integer devId) {
		Developer developer = developerDao.findById(devId).orElse(null);
		 if (developer != null) {
			 List<Post> entity6=developer.getListOfPosts();
			 List<PostDTO> developerDTOs = entity6.stream().map(entity -> modelMapper.map(entity, PostDTO.class)).collect(Collectors.toList());
			 return developerDTOs;
	        } else {
	            return Collections.emptyList();
	        }
		 }
		
	

//	@Override
//	public List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts) {
//		List<Developer>entity7=developerDao.findByNoOfPosts(noOfPosts);
//		List<DeveloperDTO> developerDTOs = entity7.stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());
//		return developerDTOs;
//		
//		
//	}

	@Override
	public DeveloperDTO getByMaxReputation() {
		 List<Developer> developers = developerDao.findAll();

	        // Find the developer with the maximum reputation
	        Developer developerWithMaxReputation = developers.stream()
	                .max(Comparator.comparingInt(Developer::getReputation)).get();

	        return modelMapper.map(developerWithMaxReputation, DeveloperDTO.class);
	}

	@Override
	public List<DeveloperDTO> getDeveloperByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeveloperDTO> getDeveloperByReputation(Integer reputation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts) {
		// TODO Auto-generated method stub
		return null;
	}
//	public Page<Developer> findAllWithPagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return developerDao.findAll(pageable);
//    }
	

	   
	    @Override 
		public Page<PostDTO> getPostsByDeveloper(Integer devId, Pageable pageable) {     
	    Developer developer = developerDao.findById(devId).orElse(null);     
	    if (developer != null) {         
	    List<Post> entity6 = developer.getListOfPosts();         
	    int pageSize = pageable.getPageSize();         
	    int currentPage = pageable.getPageNumber();         
	    int startItem = currentPage * pageSize;         
	    List<Post> pagedEntityList;         
	    if (startItem < entity6.size()) 
	    {             
	    	int endItem = Math.min(startItem + pageSize, entity6.size());            
	    	pagedEntityList = entity6.subList(startItem, endItem);         
	    	} 
	    else 
	    {             
	    	pagedEntityList = Collections.emptyList();         
	    	}         
	    List<PostDTO> developerDTOs = pagedEntityList.stream().map(entity -> modelMapper.map(entity, PostDTO.class)).collect(Collectors.toList());         
	    return new PageImpl<>(developerDTOs, PageRequest.of(currentPage, pageSize), entity6.size());     
	    } else
	    {         return new PageImpl<>(Collections.emptyList());     
	    } 
	    }
	    @Override
	    public Page<DeveloperDTO> getAllDevelopers(Pageable pageable) {     
	    	Page<Developer> developersPage = developerDao.findAll(pageable);     
	    	List<DeveloperDTO> developerDTOs = developersPage.getContent().stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());     
	    return new PageImpl<>(developerDTOs, developersPage.getPageable(), developersPage.getTotalElements()); }

		@Override
		public Page<DeveloperDTO>getDevelopersByStatus(String status, Pageable pageable) {
			Page<Developer> developersPage = developerDao.findByStatus(status, pageable);
			List<DeveloperDTO> developerDTOs = developersPage.getContent().stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());     
		    return new PageImpl<>(developerDTOs, developersPage.getPageable(), developersPage.getTotalElements());
			
		}

		
	}


