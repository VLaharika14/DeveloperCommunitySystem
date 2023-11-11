package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Response;
@Repository
public interface ResponseDao extends JpaRepository<Response, Integer>{

	
//@Query("Select response from Response response where response.postId=:postId")
// 
//	List<ResponseEntity> findByPostId(Integer postId);
//@Query("Select response from Response response where response.voteType=:voteType AND  response.resId=:resId")
//Integer countByVoteTypeAndResId(String voteType, Integer resId);
//@Query("Select response from Response response where response.devId=:devId")
//List<Response> findByDevId(Integer devId);

	
 
}