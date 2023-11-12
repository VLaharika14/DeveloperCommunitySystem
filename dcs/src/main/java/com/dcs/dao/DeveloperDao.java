package com.dcs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Developer;
@Repository

public interface DeveloperDao extends JpaRepository<Developer, Integer> {

	Page<Developer> findByStatus(String status, Pageable pageable);
//	@Query("Select developer from Developer developer where developer.status=:status")
//	List<Developer> findByStatus(String status);
//	@Query("Select developer from Developer developer where developer.reputation=:reputation")
//	List<Developer> findByReputationGreaterThanEqual(Integer reputation);
//	@Query("Select developer from Developer developer where developer.noOfPosts=:noOfPosts")
//	List<Developer> findByNoOfPosts(Integer noOfPosts);

}
