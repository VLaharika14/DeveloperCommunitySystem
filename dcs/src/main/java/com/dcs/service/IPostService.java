package com.dcs.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.dto.PostDTO;
@Service
public interface IPostService {

	PostDTO addPost(PostDTO post);

	PostDTO updatePost(PostDTO post);

	Integer getNoOfVotesOnPostByVoteType(String voteType, Integer postId);

	PostDTO getPostById(Integer postId);

	PostDTO removePost(Integer postId);

	

	List<PostDTO> getPostsByTopic(String topic);

	//List<PostDTO> getPostsByDate(LocalDate date);

	

	List<PostDTO> getPostsByTopic(String topic, int page, int pageSize);

	//List<PostDTO> getPostsByDate(LocalDateTime localDateTime, int page, int pageSize);

	//List<PostDTO> getPostsByDate(LocalDateTime date);

}
