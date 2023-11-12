package com.dcs.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dao.CommentDao;
import com.dcs.dto.CommentDTO;
import com.dcs.entity.Comment;

//import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
 
@Service
public class CommentServiceImpl implements ICommentService {
 
    @Autowired
    private CommentDao commentDao; // Assuming you have a repository for comments
    @Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO addComment(CommentDTO comment) {
	
		Comment entity1=modelMapper.map(comment, Comment.class);
		entity1= commentDao.save(entity1);
		return modelMapper.map(entity1, CommentDTO.class);
	
	}

	@Override
	public CommentDTO updateComment(CommentDTO comment) {
		
		Comment entity1=modelMapper.map(comment, Comment.class);
		entity1= commentDao.save(entity1);
		return modelMapper.map(entity1, CommentDTO.class);
		}
		

	@Override
	public CommentDTO removeComment(Integer respId) {
		
		Comment existingResponseEntity = commentDao.findById(respId).orElseThrow(() -> new EntityNotFoundException("Response not found"));        

		commentDao.deleteById(respId);
		

		 return modelMapper.map(existingResponseEntity, CommentDTO.class);
	}
		
//	@Override
//	public Integer getNoOfVotesOnCommentByVoteType(String voteType, Integer commentId) {
//		return commentDao.getNoOfVotesOnCommentByVoteType(voteType, commentId);
//
//	}

//	@Override
//	public CommentDTO getByCommentId(Integer commentId) {
//		Comment comment = commentDao.getCommentById(commentId);
//
//	    if (comment != null) {
//	       CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
//
//	        return commentDTO;
//	    } else {
//	  
//	        return null;
//	    }
	//}

//	@Override
//	public List<CommentDTO> getCommentsByPostId(Integer postId) {
//		List<Comment> comments = commentDao.getCommentsByPostId(postId);         
//		List<CommentDTO>commentDTO= comments.stream().map(entity -> modelMapper.map(entity, CommentDTO.class)).collect(Collectors.toList()); 
//		return commentDTO;
//	}
//
//	@Override
//	public List<CommentDTO> getCommentsByResponseId(Integer resId) {
//		List<Comment> comments = commentDao.getCommentsByResponseId(resId);        
//		return comments.stream().map(entity -> modelMapper.map(entity, CommentDTO.class)).collect(Collectors.toList());
//	}

	@Override
	public Integer getNoOfVotesOnCommentByVoteType(String voteType, Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDTO getByCommentId(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDTO> getCommentsByPostId(Integer postId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDTO> getCommentsByResponseId(Integer resId, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	
//	@Override
//	public List<CommentDTO> getCommentsByPostId(Integer postId, int page, int pageSize) {
//	    // Assuming commentDao supports pagination, you may need to check its documentation
//	    Page<Comment> commentPage = commentDao.getCommentsByPostId(postId, PageRequest.of(page, pageSize));
//	 
//	    List<CommentDTO> commentDTO = commentPage.getContent().stream()
//	            .map(entity -> modelMapper.map(entity, CommentDTO.class))
//	            .collect(Collectors.toList());
//	 
//	    return commentDTO;
//	}
//	@Override
//	public List<CommentDTO> getCommentsByResponseId(Integer resId, int pageNumber, int pageSize) {
//	    Pageable pageable = PageRequest.of(pageNumber, pageSize); // You can change the sorting criteria as per your requirements
//
//	    Page<Comment> commentPage = commentDao.getCommentsByResponseId(resId, pageable);
//
//	    List<CommentDTO> commentDTOs = commentPage.getContent()
//	            .stream()
//	            .map(entity -> modelMapper.map(entity, CommentDTO.class))
//	            .collect(Collectors.toList());
//
//	   
//
//	    return commentDTOs;
//	}

    
}
