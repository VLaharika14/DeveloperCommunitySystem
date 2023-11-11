package com.dcs.service;


import java.time.LocalDate;
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

	List<PostDTO> getPostsByKeyword(String keyword);

	List<PostDTO> getPostsByTopic(String topic);

	List<PostDTO> getPostsByDate(LocalDate date);

}
