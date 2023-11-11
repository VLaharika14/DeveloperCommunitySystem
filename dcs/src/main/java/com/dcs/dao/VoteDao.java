package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Vote;
@Repository
public interface VoteDao extends JpaRepository<Vote, Integer>{
//	@Query("Select vote from Vote vote where vote.postId=:postId AND vote.voteType=:voteType")
//	List<Vote> getVotesForPostAndVoteType(Integer postId, String voteType);

}
