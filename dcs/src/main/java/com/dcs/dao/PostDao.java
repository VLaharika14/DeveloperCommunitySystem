package com.dcs.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Post;
@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
//	@Query("Select post from Post post where post.keyword=:keyword")
//	List<Post> findPostsByKeyword(String keyword);
//	@Query("Select post from Post post where post.date=:date")
//	List<Post> findPostsByDate(LocalDate date);


}
