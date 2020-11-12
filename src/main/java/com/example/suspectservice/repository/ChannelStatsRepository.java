package com.example.suspectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.suspectservice.entity.ChannelStatsEntity;

@Repository
public interface ChannelStatsRepository extends JpaRepository<ChannelStatsEntity, Long>{

}
