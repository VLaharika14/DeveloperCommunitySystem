package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.DeveloperDTO;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Developer;
import com.dcs.exception.DeveloperCommunitySystemException;
import com.dcs.service.IDeveloperService;


@RestController
@RequestMapping("/developer")
public class DeveloperController {
@Autowired
IDeveloperService developerService;
//@GetMapping(path="/getall",produces = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<List<DeveloperDTO>> getAllDevelopers(){
//	
//	List<DeveloperDTO> developer=developerService.getAllDevelopers();
//	
//	return new ResponseEntity<List<DeveloperDTO>>(developer,HttpStatus.OK);
//}
	
@GetMapping(path="get/{devId}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<DeveloperDTO> getDevelopers(@PathVariable Integer devId)throws DeveloperCommunitySystemException{
	if((Integer)devId==null) {
		throw new DeveloperCommunitySystemException("Invalid Developer ID");
	}
	DeveloperDTO developer1=developerService.getDeveloperById(devId);
	return new ResponseEntity<DeveloperDTO>(developer1,HttpStatus.OK);
}
	

@PostMapping(path="add/",consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<DeveloperDTO> saveDeveloper(@RequestBody DeveloperDTO developer)throws DeveloperCommunitySystemException{
	DeveloperDTO newDeveloper=developerService.addDeveloper(developer);
	if(newDeveloper==null) {
		throw new DeveloperCommunitySystemException(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<DeveloperDTO>(newDeveloper,HttpStatus.OK);
}


//==========================================
@GetMapping(path="get1/{devId}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<PostDTO>> getAllPostsByDeveloper(@PathVariable Integer devId)throws DeveloperCommunitySystemException{
	if((Integer)devId==null) {
		throw new DeveloperCommunitySystemException("Invalid Developer ID");
	}
	List<PostDTO> developer5=developerService.getPostsByDeveloper(devId);
	return new ResponseEntity<List<PostDTO>>(developer5,HttpStatus.OK);
	
}

@GetMapping(path="get3/{reputation}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<DeveloperDTO>> getDevelopersByReputation(@PathVariable Integer reputation){
	List<DeveloperDTO>developer7=developerService.getDeveloperByReputation(reputation);
	return new ResponseEntity<List<DeveloperDTO>>(developer7,HttpStatus.OK);
}
@GetMapping(path="get4/{noOfPosts}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<DeveloperDTO>> getByNoOfPosts(@PathVariable Integer noOfPosts){
	List<DeveloperDTO>developer7=developerService.getDeveloperByReputation(noOfPosts);
	return new ResponseEntity<List<DeveloperDTO>>(developer7,HttpStatus.OK);
}



//@GetMapping
//public ResponseEntity<Page<Developer>> getPaginatedData(
//    @RequestParam(name = "page", defaultValue = "0") int page,
//    @RequestParam(name = "size", defaultValue = "10") int size
//) {
//    Page<Developer> result = developerService.findAllWithPagination(page, size);
//    return ResponseEntity.ok(result);
//}
@GetMapping("get/all")
public ResponseEntity<Page<DeveloperDTO>> getAllDevelopers(@RequestParam(name = "page", defaultValue = "0") int page,
	    @RequestParam(name = "size", defaultValue = "10") int size) {
	
    Page<DeveloperDTO> entities = developerService.getAllDevelopers(page,size);
    return new ResponseEntity<Page<DeveloperDTO>>(entities, HttpStatus.OK);
	}
@GetMapping("get/alld")
public ResponseEntity<Page<PostDTO>> getAllPosts(Pageable pageable,@PathVariable Integer devId) {
	
    Page<PostDTO> entities = developerService.getPostsByDeveloper(devId,pageable);
    return new ResponseEntity<>(entities, HttpStatus.OK);
	}
@GetMapping(path = "get22/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Page<DeveloperDTO>> getDevelopersByStatus(
    @PathVariable String status,Pageable pageable
   
) {
    Page<DeveloperDTO> developerPage = developerService.getDevelopersByStatus(status, pageable);
    return ResponseEntity.ok(developerPage);
}
	











}