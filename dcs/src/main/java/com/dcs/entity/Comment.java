package com.dcs.entity;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Comment {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="commentId")
	private Integer commentId;
	
	@Column(nullable = false)
	private String text;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userId")
	private Developer createdBy;
//	@ManyToOne
//	@JoinColumn(name="post_Id")
//	private Post post;
//	@OneToMany(mappedBy="comment_Id",cascade=CascadeType.ALL)
//private Comment comment;
	private LocalDate createdDate;
	
	@OneToMany(mappedBy = "comment")
	private List<Vote> vote;
	
	
	
	public Comment(Integer commentId, String text, Developer createdBy, LocalDate createdDate, List<Vote> vote) {
		super();
		this.commentId = commentId;
		this.text = text;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.vote = vote;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Developer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Developer createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public List<Vote> getVote() {
		return vote;
	}
	public void setVote(List<Vote> vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", text=" + text + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", vote=" + vote + "]";
	}
	
}
