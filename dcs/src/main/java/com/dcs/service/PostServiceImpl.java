package com.dcs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.PostDao;
import com.dcs.dao.VoteDao;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Post;
import com.dcs.entity.Vote;
@Service
public class PostServiceImpl implements IPostService {
	@Autowired
	PostDao postDao;
	@Autowired
	VoteDao voteDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	
	public PostDTO addPost(PostDTO post) {
		Post entity1=modelMapper.map(post, Post.class);
		entity1=postDao.save(entity1);
		PostDTO entity=modelMapper.map(entity1,PostDTO.class);
		return entity;
	}

	@Override
	public PostDTO updatePost(PostDTO post) {
		Post entity1=modelMapper.map(post, Post.class);
		entity1=postDao.save(entity1);
		PostDTO entity=modelMapper.map(entity1,PostDTO.class);
		return entity;
	}

//	@Override
//	public Integer getNoOfVotesOnPostByVoteType(String voteType, Integer postId) {
//		List<Vote> votes = voteDao.getVotesForPostAndVoteType(postId, voteType);
//		int voteCount = votes.size();          
//		return voteCount;
//		
//	}

	@Override
	public PostDTO getPostById(Integer postId) {
		Post entity=postDao.findById(postId).orElse(null);
		PostDTO entity1=modelMapper.map(entity,PostDTO.class);
		return entity1;
		
		
	}

	@Override
	public PostDTO removePost(Integer postId) {
		Post post = postDao.findById(postId).orElse(null);
        if (post != null) {
            postDao.delete(post);
            PostDTO entity1=modelMapper.map(post,PostDTO.class);
            return entity1;
        }
        return modelMapper.map(post,PostDTO.class);
	}

//	@Override
//	public List<PostDTO> getPostsByKeyword(String keyword) {
//		List<Post> matchingPosts = postDao.findPostsByKeyword(keyword);      
//		List<PostDTO>postDTO= matchingPosts.stream().map(entity -> modelMapper.map(entity, PostDTO.class)).collect(Collectors.toList());
//		return postDTO;
//		
//	}

//	@Override
//	public List<PostDTO> getPostsByTopic(String topic) {
//		List<Post> matchingPosts = postDao.findPostsByKeyword(topic); 
//		List<PostDTO>commentDTO= matchingPosts.stream().map(entity -> modelMapper.map(entity, PostDTO.class)).collect(Collectors.toList());
//		return commentDTO;
//		
//	}

//	@Override
//	public List<PostDTO> getPostsByDate(LocalDate date) {
//		List<Post> matchingPosts = postDao.findPostsByDate(date); 
//		List<PostDTO>postDTO= matchingPosts.stream().map(entity -> modelMapper.map(entity, PostDTO.class)).collect(Collectors.toList());
//		return postDTO;
//		
//	}

	@Override
	public Integer getNoOfVotesOnPostByVoteType(String voteType, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsByTopic(String topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
