package com.dcs.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.PostDTO;
import com.dcs.exception.DeveloperCommunitySystemException;
import com.dcs.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	IPostService postService;
	
	@PostMapping(path="/getall",consumes = MediaType.APPLICATION_JSON_VALUE)
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
	@GetMapping("/votes")    
	public Integer getNoOfVotesOnPostByVoteType(@PathVariable String voteType, @PathVariable Integer postId) throws DeveloperCommunitySystemException {   
		if(postId==null) {
			throw new DeveloperCommunitySystemException("Invalid Post Id");
		}
		return postService.getNoOfVotesOnPostByVoteType(voteType, postId);    
		}
	@GetMapping("/{postId}")    
	public PostDTO getPostById(@PathVariable Integer postId) throws DeveloperCommunitySystemException {   
		if(postId==null) {
			throw new DeveloperCommunitySystemException("Invalid Post Id");
		}
		return postService.getPostById(postId);     
		}
	@GetMapping("/search/keyword/{keyword}")    
	public List<PostDTO> getPostsByKeyword(@PathVariable String keyword) throws DeveloperCommunitySystemException 
	{ 
		if(keyword==null) {
			throw new DeveloperCommunitySystemException("Keyword not Found");
		}
		return postService.getPostsByKeyword(keyword);     
	}
	@GetMapping("/search/topic/{topic}")    
	public List<PostDTO> getPostsByTopic(@PathVariable String topic) throws DeveloperCommunitySystemException 
	{         
		if(topic==null) {
			throw new DeveloperCommunitySystemException("topic not Found");
		}
		return postService.getPostsByTopic(topic);     
		}
	@GetMapping("/search/date/{date}")    
	public List<PostDTO> getPostsByDate(@PathVariable String date) {       
		return postService.getPostsByDate(LocalDate.parse(date));     
	}
}
