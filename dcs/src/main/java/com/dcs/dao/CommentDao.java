package com.dcs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Comment;
@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

//	Page<Comment> getCommentsByPostId(Integer postId, PageRequest of);
//
//	Page<Comment> getCommentsByResponseId(Integer respId, Pageable pageable);

//	@Query("Select comment from Comment comment where comment.voteType=:voteType AND comment.commentId=:commentId")
//	Integer getNoOfVotesOnCommentByVoteType(String voteType, Integer commentId);
//	@Query("Select comment from Comment comment where comment.commentId=:commentId")
//	Comment getCommentById(Integer commentId);
//	@Query("Select comment from Comment comment where comment.postId=:postId")
//	List<Comment> getCommentsByPostId(Integer postId);
//	@Query("Select comment from Comment comment where comment.respId=:respId")
//	List<Comment> getCommentsByResponseId(Integer respId);

}
