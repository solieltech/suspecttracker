package com.example.suspectservice.service;

import com.example.suspectservice.ExcelHelper;
import com.example.suspectservice.entity.ChannelStatsEntity;
import com.example.suspectservice.entity.UserInfo;
import com.example.suspectservice.model.ChannelStatistics;
import com.example.suspectservice.model.VideoComments;
import com.example.suspectservice.repository.ChannelStatsRepository;
import com.example.suspectservice.repository.UserInfoRepository;
import com.example.suspectservice.rest.client.YTClient;
import com.example.suspectservice.service.uri.service.VideoCommentService;
import com.example.suspectservice.vo.VideoCommentsVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Service
public class YTService {

    @Autowired
    private YTClient ytClient;
    @Autowired
    private ExcelHelper excelHelper;
    @Autowired
    private VideoCommentService videoCommentService;
    
    @Autowired
    private ChannelStatsRepository channelStatsRepository;

    public String channelStatistics(String id){
        String part="statistics";
        ChannelStatistics channelStatistics = (ChannelStatistics)ytClient.get("channels", ChannelStatistics.class,new String[]{part,id});
        saveChannelStats(channelStatistics, id);
        return new Gson().toJson(channelStatsRepository.findAllByChannelId(id));
    }
    public ResponseEntity<InputStreamResource> videoComments(String id){
        String part="snippet";
        String nextPageToken =null;
        int totalComments=0;
        List<VideoCommentsVO> voList =new LinkedList<>();
        do{
            VideoComments videoComments = (VideoComments)ytClient.getVideoComments("commentThreads", VideoComments.class,new String[]{part,id,nextPageToken});
            nextPageToken =  videoComments.getNextPageToken();
            videoCommentService.processYTModel(videoComments,voList,totalComments);
        }while (nextPageToken!=null && !nextPageToken.equals(""));
        System.out.println("Total Comments:: " +totalComments);
        try {
           return excelHelper.writeToExcel(voList);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public void saveChannelStats(ChannelStatistics channelStatistics,String id) {
    	ChannelStatsEntity channelStats = new ChannelStatsEntity();
    	channelStats.setChannelId(id);
    	channelStats.setSubscriberCount(channelStatistics.getItems().get(0).getStatistics().getSubscriberCount());
    	channelStats.setVideoCount(channelStatistics.getItems().get(0).getStatistics().getVideoCount());
    	channelStats.setViewCount(channelStatistics.getItems().get(0).getStatistics().getViewCount());
    	channelStats.setTimestamp(java.time.LocalDateTime.now());
    	channelStatsRepository.save(channelStats);
    }
}
