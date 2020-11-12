package com.example.suspectservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {
	
	  @Id  
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  private Long id;  
	  private String name;  
	  private String email;

}
