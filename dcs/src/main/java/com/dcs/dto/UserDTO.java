package com.dcs.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	 @NotNull
	private Integer userId;
	 @NotNull
	private String userName;
	 @Min(5)
	 @Max(10)
	private String userPassword;
	private String userRole;	
}
 