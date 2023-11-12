package com.dcs.entity;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="postId")

	private Integer postId;
	private String query;
	private LocalDateTime postDateTime;
	private String topic;
	@ManyToOne
	@JoinColumn(name="userId")
	private Developer developer;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL) // Many posts are associated with one developer
	private List<Response> listOfResponse;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER) // Many posts are associated with one developer
    @JoinColumn(name = "comment")
	private List<Comment> listOfComment;
	private Integer noOfViews;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)// Many posts are associated with one developer
	private List<Vote> vote;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Integer postId, String query, LocalDateTime postDateTime, String topic, Developer developer,
			List<Response> listOfResponse, List<Comment> listOfComment, Integer noOfViews, List<Vote> vote) {
		super();
		this.postId = postId;
		this.query = query;
		this.postDateTime = postDateTime;
		this.topic = topic;
		this.developer = developer;
		this.listOfResponse = listOfResponse;
		this.listOfComment = listOfComment;
		this.noOfViews = noOfViews;
		this.vote = vote;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDateTime getPostDateTime() {
		return postDateTime;
	}
	public void setPostDateTime(LocalDateTime postDateTime) {
		this.postDateTime = postDateTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public List<Response> getListOfResponse() {
		return listOfResponse;
	}
	public void setListOfResponse(List<Response> listOfResponse) {
		this.listOfResponse = listOfResponse;
	}
	public List<Comment> getListOfComment() {
		return listOfComment;
	}
	public void setListOfComment(List<Comment> listOfComment) {
		this.listOfComment = listOfComment;
	}
	public Integer getNoOfViews() {
		return noOfViews;
	}
	public void setNoOfViews(Integer noOfViews) {
		this.noOfViews = noOfViews;
	}
	public List<Vote> getVote() {
		return vote;
	}
	public void setVote(List<Vote> vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", query=" + query + ", postDateTime=" + postDateTime + ", topic=" + topic
				+ ", developer=" + developer + ", listOfResponse=" + listOfResponse + ", listOfComment=" + listOfComment
				+ ", noOfViews=" + noOfViews + ", vote=" + vote + "]";
	}
	
}



