package com.dcs.service;
import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;
 
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.ResponseDao;
import com.dcs.dto.ResponseDTO;
import com.dcs.entity.Response;
@Service
public class ResponseServiceImpl implements IResponseService {

@Autowired

ResponseDao responseDao;
@Autowired
	private ModelMapper modelMapper;

	@Override

	public ResponseDTO addResponse(ResponseDTO response) {	
		Response entity1=modelMapper.map(response, Response.class);
		entity1= responseDao.save(entity1);
		return modelMapper.map(entity1, ResponseDTO.class);

	}
 
	@Override

	public ResponseDTO updateResponse(ResponseDTO response) {
		Response entity1=modelMapper.map(response, Response.class);
		entity1= responseDao.save(entity1);
		return modelMapper.map(entity1, ResponseDTO.class);
		

	}
 
	@Override

	public ResponseDTO removeResponse(Integer respId) {

		Response existingResponseEntity = responseDao.findById(respId).orElseThrow(() -> new EntityNotFoundException("Response not found"));        

		responseDao.deleteById(respId);         

		 return modelMapper.map(existingResponseEntity, ResponseDTO.class);

	}
 
//	@Override
//
//	public List<ResponseDTO> getResponseByPost(Integer postId) {
//
//		// TODO Auto-generated method stub
//
//		List<Response> responses = responseDao.findByDevId(postId);
//
//		List<Response> responseEntity = new ArrayList<>();
//
//        for (Response response : responses) {
//
//            responseEntity.add(response);
//
//	}
//        List<ResponseDTO>responseDTO= responseEntity.stream().map(entity -> modelMapper.map(entity, ResponseDTO.class)).collect(Collectors.toList());
//return responseDTO;
//	}

	@Override
	public Integer getNoOfVotesOnResponseByVoteType(String voteType, Integer resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseDTO> getResponseByDeveloper(Integer devId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseDTO> getResponseByPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}
	
 
//	@Override
//
//	public Integer getNoOfVotesOnResponseByVoteType(String voteType, Integer resId) {
//
//		Integer number=responseDao.countByVoteTypeAndResId(voteType, resId);
//		return number;
//
//	}
 
//	@Override
//
//	public List<ResponseDTO> getResponseByDeveloper(Integer devId) {
//
//		List<Response> entity1=responseDao.findByDevId(devId);
//		List<ResponseDTO>responseDTO= entity1.stream().map(entity -> modelMapper.map(entity, ResponseDTO.class)).collect(Collectors.toList());
//		return responseDTO;
//
//	}
 
	

}

	