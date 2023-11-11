package com.dcs.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.dto.ResponseDTO;
@Service
public interface IResponseService {

	ResponseDTO  addResponse(ResponseDTO  response);

	ResponseDTO  updateResponse(ResponseDTO  response);

	ResponseDTO  removeResponse(Integer respId);

	List<ResponseDTO > getResponseByPost(Integer postId);

	Integer getNoOfVotesOnResponseByVoteType(String  voteType, Integer resId);

	List<ResponseDTO > getResponseByDeveloper(Integer devId);

}

