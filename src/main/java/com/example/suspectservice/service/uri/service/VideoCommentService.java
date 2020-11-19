package com.example.suspectservice.service.uri.service;

import com.example.suspectservice.model.*;
import com.example.suspectservice.rest.client.YTClient;
import com.example.suspectservice.task.ChildCommentTask;
import com.example.suspectservice.task.ProcessCommentTask;
import com.example.suspectservice.vo.VideoCommentsVO;
import com.example.suspectservice.yt.core.YTCore;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Comment;
import com.google.api.services.youtube.model.CommentListResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class VideoCommentService {

    @Autowired
    private YTClient ytClient;

    public List<VideoCommentsVO> processYTModel(VideoComments videoComments, List<VideoCommentsVO> voList,int totalComments){
        return convertToVO(videoComments,voList,totalComments);
    }
    protected List<VideoCommentsVO> convertToVO(VideoComments videoComments, List<VideoCommentsVO> voList,int totalComments){
        List<CommentItems> list = videoComments.getItems();
        ExecutorService executor = Executors.newFixedThreadPool(30);
        try {
        for(CommentItems commentItem:list){
        	ProcessCommentTask processCommentTask = new ProcessCommentTask();
        	processCommentTask.setCommentItem(commentItem);
         Future<VideoCommentsVO> processCommentFuture = executor.submit(processCommentTask);
            
         VideoCommentsVO videoCommentVO = processCommentFuture.get();
         System.out.println("Comment ::::"+videoCommentVO.getComment());
         voList.add(videoCommentVO);
         
         
            if(videoCommentVO.getTotalReplyCount()>0){
                List<VideoCommentsVO> subComments= getChildComents(videoCommentVO.getParentCommentId());
                totalComments+=subComments.size();
                //videoCommentVO.setVideoCommentsVOList(subComments);
                voList.addAll(subComments);
            }
        }
        totalComments+=voList.size();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        //System.out.println("Total Comments including sub comments " + totalComments);
        return voList;
    }
    protected List<VideoCommentsVO> getChildComents(String parentCommentId){

        String part = "snippet";
        ChildComments commentListResponse = (ChildComments)ytClient.getChildComments("comments", ChildComments.class,new String[]{part,parentCommentId});

        return convertToVO(commentListResponse);
        /*YouTube youtubeService=null;
        try {
            youtubeService = YTCore.getService();
            List<String> part =  new ArrayList<>();
            part.add("snippet");
            CommentListResponse commentList = youtubeService.comments().list(part).setMaxResults(100l).setParentId(parentCommentId).execute();
            return convertToVO(commentList);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }*/
    }
    protected  List<VideoCommentsVO> convertToVO(ChildComments commentList){
       List<ChildCommentItems> items =  commentList.getItems();
        List<VideoCommentsVO> list = new LinkedList<>();
        ExecutorService executor = Executors.newFixedThreadPool(30);
        
        
        try {
        for(ChildCommentItems comment : items){
        	
        	ChildCommentTask childCommentTask = new ChildCommentTask();
        	childCommentTask.setChildComment(comment);
        	
        	Future<VideoCommentsVO> videoCommentVO = executor.submit(childCommentTask);
            list.add(videoCommentVO.get());
        }
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        return list;
    }
}
