package com.example.suspectservice.service;

import com.example.suspectservice.ExcelHelper;
import com.example.suspectservice.model.ChannelStatistics;
import com.example.suspectservice.model.VideoComments;
import com.example.suspectservice.rest.client.YTClient;
import com.example.suspectservice.service.uri.service.VideoCommentService;
import com.example.suspectservice.vo.VideoCommentsVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public String channelStatistics(String id){
        String part="statistics";
        ChannelStatistics channelStatistics = (ChannelStatistics)ytClient.get("channels", ChannelStatistics.class,new String[]{part,id});
        return new Gson().toJson(channelStatistics);
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
        //return  new Gson().toJson(voList);
    }
}
