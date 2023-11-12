package com.dcs.dto;


import javax.validation.constraints.NotNull;

import com.dcs.util.VoteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO {
	@NotNull
	private Integer voteId;
	private VoteType voteType;
	private DeveloperDTO developerWhoVoted;
	
}
