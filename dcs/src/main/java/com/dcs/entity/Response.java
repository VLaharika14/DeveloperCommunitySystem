package com.dcs.entity;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Response {
@Id
	private Integer respId;
	private String answer;
	private LocalDateTime respDateTime;
	@ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "postId")
	private Post post;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
	private Developer developer;
	@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "commentId", referencedColumnName = "commentId")
	private List<Comment> listOfComments;
	@OneToMany(mappedBy="response",cascade = CascadeType.ALL)
	//@JoinColumn(name = "voterId", referencedColumnName = "voterId")
	private List<Vote> vote;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(Integer respId, String answer, LocalDateTime respDateTime, Post post, Developer developer,
			List<Comment> listOfComments, List<Vote> vote) {
		super();
		this.respId = respId;
		this.answer = answer;
		this.respDateTime = respDateTime;
		this.post = post;
		this.developer = developer;
		this.listOfComments = listOfComments;
		this.vote = vote;
	}
	public Integer getRespId() {
		return respId;
	}
	public void setRespId(Integer respId) {
		this.respId = respId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public LocalDateTime getRespDateTime() {
		return respDateTime;
	}
	public void setRespDateTime(LocalDateTime respDateTime) {
		this.respDateTime = respDateTime;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public List<Comment> getListOfComments() {
		return listOfComments;
	}
	public void setListOfComments(List<Comment> listOfComments) {
		this.listOfComments = listOfComments;
	}
	public List<Vote> getVote() {
		return vote;
	}
	public void setVote(List<Vote> vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "Response [respId=" + respId + ", answer=" + answer + ", respDateTime=" + respDateTime + ", post=" + post
				+ ", developer=" + developer + ", listOfComments=" + listOfComments + ", vote=" + vote + "]";
	}

}


