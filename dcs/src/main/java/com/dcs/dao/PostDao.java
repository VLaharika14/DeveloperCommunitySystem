package com.dcs.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Post;
@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

	List<Post> findPostsByTopic(String topic);

	//List<Post> findPostsByDate(LocalDateTime postDateTime);

	Page<Post> getPostsByTopic(String topic, Pageable pageable);

	//Page<Post> findPostsByKeyword(String keyword, PageRequest of);
//	@Query("Select post from Post post where post.keyword=:keyword")
//	List<Post> findPostsByKeyword(String keyword);
//	@Query("Select post from Post post where post.date=:date")
//	List<Post> findPostsByDate(LocalDate date);


}
