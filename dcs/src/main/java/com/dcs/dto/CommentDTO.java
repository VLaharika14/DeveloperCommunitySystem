package com.dcs.dto;


import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	@NotNull
	private Integer commentId;
	@Min(10)
	@Max(20)
	private String text;
	private DeveloperDTO createdBy;
	@CreatedDate
	private LocalDate createdDate;
	private VoteDTO vote;
}
