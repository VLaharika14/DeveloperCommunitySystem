package com.dcs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.PostDTO;
import com.dcs.exception.DeveloperCommunitySystemException;
import com.dcs.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	IPostService postService;
	
	@PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO post )throws DeveloperCommunitySystemException{
		PostDTO post3=postService.addPost(post);
		if(post3==null) {
			throw new DeveloperCommunitySystemException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PostDTO>(post3,HttpStatus.OK);
	}
	@PutMapping(path="update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> editPost(@RequestBody PostDTO post)throws DeveloperCommunitySystemException{
		PostDTO post1=postService.updatePost(post);
		if(post1==null) {
			throw new DeveloperCommunitySystemException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PostDTO>(post1,HttpStatus.OK);
	}
	@DeleteMapping(path="remove/{name}")
	public ResponseEntity<String> removePost(@PathVariable Integer postId)
	{
	PostDTO isDelete=postService.removePost(postId);
	if(isDelete==null) {
		return new ResponseEntity<String>("Response not deleted",HttpStatus.OK);
	}
	return new ResponseEntity<String>("Response deleted",HttpStatus.OK);
}
	@GetMapping("get/votes")    
	public Integer getNoOfVotesOnPostByVoteType(@PathVariable String voteType, @PathVariable Integer postId) throws DeveloperCommunitySystemException {   
		if(postId==null) {
			throw new DeveloperCommunitySystemException("Invalid Post Id");
		}
		return postService.getNoOfVotesOnPostByVoteType(voteType, postId);    
		}
	@GetMapping("get/{postId}")    
	public PostDTO getPostById(@PathVariable Integer postId) throws DeveloperCommunitySystemException {   
		if(postId==null) {
			throw new DeveloperCommunitySystemException("Invalid Post Id");
		}
		return postService.getPostById(postId);     
		}
	
	
	
	@GetMapping("/search/topic/{topic}")
	public ResponseEntity<List<PostDTO>> getPostsByTopic(
	    @PathVariable String topic,
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "10") int pageSize
	) throws DeveloperCommunitySystemException {
	    if (topic == null) {
	        throw new DeveloperCommunitySystemException("Topic not Found");
	    }
 
	    List<PostDTO> response = postService.getPostsByTopic(topic, page, pageSize);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
//	@GetMapping("/search/date/{date}")
//		public ResponseEntity<List<PostDTO>> getPostsByDate(
//		    @PathVariable String date,
//		    @RequestParam(defaultValue = "0") int page,
//		    @RequestParam(defaultValue = "10") int pageSize
//		) {
//		    List<PostDTO> response = postService.getPostsByDate(LocalDateTime.parse(date), page, pageSize);
//		    return new ResponseEntity<>(response, HttpStatus.OK);
//		}
}
