package com.example.suspectservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.suspectservice.entity.ChannelStatsEntity;
import com.google.gson.JsonElement;

@Repository
public interface ChannelStatsRepository extends JpaRepository<ChannelStatsEntity, Long>{

	List<ChannelStatsEntity> findAllByChannelId(String id);

}
