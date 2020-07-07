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
import java.util.concurrent.*;

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

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            long startTime = System.currentTimeMillis();
        do{
            VideoComments videoComments = (VideoComments)ytClient.getVideoComments("commentThreads", VideoComments.class,new String[]{part,id,nextPageToken});
            /*ApiCall apiCall =new ApiCall(ytClient,part,nextPageToken,id);
            Future<VideoComments> videoCommentsFuture =  executorService.submit(apiCall);
            VideoComments videoComments = videoCommentsFuture.get();*/
            nextPageToken =  videoComments.getNextPageToken();
            videoCommentService.processYTModel(videoComments,voList,totalComments);
        }while (nextPageToken!=null && !nextPageToken.equals(""));
            long endTime = System.currentTimeMillis();
            System.out.println("Start time :: " +startTime);
            System.out.println("End time :: " +endTime);
            long totalMilliSeconds  = endTime-startTime;
            System.out.println("totalMilliSeconds  :: " +totalMilliSeconds);
            long seconds = (totalMilliSeconds / 1000);
            //long minutes = TimeUnit.MILLISECONDS.toMinutes(totalMilliSeconds);
            if(seconds>60){
                System.out.println(seconds/60 + " minutes for api call");
            }else{
                System.out.println(seconds + " seconds for api call");
            }

           return excelHelper.writeToExcel(voList);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        //return  new Gson().toJson(voList);
    }
}

class ApiCall implements Callable<VideoComments>{
    String part=null;
    String nextPageToken =null;
    String id=null;
    YTClient ytClient=null;
    ApiCall(YTClient ytClient,String part,String nextPageToken,String id){
        this.part=part;
        this.nextPageToken=nextPageToken;
        this.id=id;
        this.ytClient=ytClient;
    }

   @Override
    public VideoComments call(){
       VideoComments videoComments = (VideoComments)ytClient.getVideoComments("commentThreads", VideoComments.class,new String[]{part,id,nextPageToken});
        return videoComments;

    }
}
