package com.example.suspectservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name ="channel_stats" )
public class ChannelStatsEntity {
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String channelId;
	private String viewCount;
	private String subscriberCount;
	private String videoCount;
	private String timestamp;
}