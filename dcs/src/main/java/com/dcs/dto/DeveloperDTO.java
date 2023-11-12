package com.dcs.dto;


import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDTO extends UserDTO {
	//@NotNull
	private String devName;
	private String devSkill;
	private LocalDate memberSince;
	// If no. of Upvote on Post is 5, then reputation value is 1
	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
	private Integer reputation;
	// Block or Unblock
	private String status;
	private List<PostDTO> listOfPosts;
	

}