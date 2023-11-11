package com.dcs.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.dcs.util.VoteType;
@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="voteId")
	private Integer voteId;
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  @JoinColumn(name = "VoteType", referencedColumnName = "voteId")
	@Enumerated(EnumType.STRING)
	private VoteType voteType;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
	private Developer developerWhoVoted;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentId", referencedColumnName = "commentId")
	private Comment comment;
	@ManyToOne
	@JoinColumn(name="postId")
	private Post post;
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	@ManyToOne
@JoinColumn(name="respId")
	private Response response;
	
	public Vote(Integer voteId, VoteType voteType, Developer developerWhoVoted) {
		super();
		this.voteId = voteId;
		this.voteType = voteType;
		this.developerWhoVoted = developerWhoVoted;
	}
	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getVoteId() {
		return voteId;
	}
	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}
	public VoteType getVoteType() {
		return voteType;
	}
	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}
	public Developer getDeveloperWhoVoted() {
		return developerWhoVoted;
	}
	public void setDeveloperWhoVoted(Developer developerWhoVoted) {
		this.developerWhoVoted = developerWhoVoted;
	}
	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", voteType=" + voteType + ", developerWhoVoted=" + developerWhoVoted
				+ ", comment=" + comment + ", post=" + post + ", response=" + response + "]";
	}
	
	
}
