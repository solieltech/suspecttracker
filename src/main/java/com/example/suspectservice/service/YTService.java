package com.example.suspectservice.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.suspectservice.ExcelHelper;
import com.example.suspectservice.entity.ChannelStatsEntity;
import com.example.suspectservice.model.ChannelStatistics;
import com.example.suspectservice.model.VideoComments;
import com.example.suspectservice.repository.ChannelStatsRepository;
import com.example.suspectservice.rest.client.YTClient;
import com.example.suspectservice.service.uri.service.VideoCommentService;
import com.example.suspectservice.vo.VideoCommentsVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    public String videoComments(String id){
        String part="snippet";
        String nextPageToken =null;
        int totalComments=0;
        List<VideoCommentsVO> voList =new LinkedList<>();
        
        
      //Executor service instance
        ExecutorService executor = Executors.newFixedThreadPool(50);
        try {
        
        do{
        	CommentsTask commentTask = new CommentsTask();
        	commentTask.setId(id);
        	commentTask.setPart(part);
        	commentTask.setNextPageToken(nextPageToken);
        	commentTask.setYtClient(ytClient);
        	
        	Future<VideoComments >videoCommentsFuture = executor.submit(commentTask);
        	VideoComments videoCommentsNew = videoCommentsFuture.get();
            //VideoComments videoComments = (VideoComments)ytClient.getVideoComments("commentThreads", VideoComments.class,new String[]{part,id,nextPageToken});
            nextPageToken =  videoCommentsNew.getNextPageToken();
            videoCommentService.processYTModel(videoCommentsNew,voList,totalComments);
        }while (nextPageToken!=null && !nextPageToken.equals(""));
        System.out.println("Total Comments:: " +voList.size());
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        
       // List<VideoCommentsVO> flat = voList.stream().flatMap(List::stream).collect(Collectors.toList());
        
		/*
		 * List<VideoCommentsVO> flat = voList.stream().map(x->{
		 * if(x.getVideoCommentsVOList().size()>0) { return x.getVideoCommentsVOList();
		 * } return null; }).flatMap(x->x.stream()).collect(Collectors.toList());
		 */
        Gson gson = new GsonBuilder().setLenient().disableHtmlEscaping().create();
        
        JSONObject jsonObject = new JSONObject();
        String jsonData = gson.toJson(voList);
        System.out.println(jsonData);
        
        return jsonData;
       // return voList;
        
        /*try {
           return excelHelper.writeToExcel(voList);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }*/
    }
    public void saveChannelStats(ChannelStatistics channelStatistics,String id) {
    	ChannelStatsEntity channelStats = new ChannelStatsEntity();
    	channelStats.setChannelId(id);
    	channelStats.setSubscriberCount(channelStatistics.getItems().get(0).getStatistics().getSubscriberCount());
    	channelStats.setVideoCount(channelStatistics.getItems().get(0).getStatistics().getVideoCount());
    	channelStats.setViewCount(channelStatistics.getItems().get(0).getStatistics().getViewCount());
    	Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
	    String strDate = formatter.format(date); 
    	channelStats.setTimestamp(strDate);
    	channelStatsRepository.save(channelStats);
    }
}
