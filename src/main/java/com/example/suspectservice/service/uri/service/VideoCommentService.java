package com.example.suspectservice.service.uri.service;

import com.example.suspectservice.model.*;
import com.example.suspectservice.rest.client.YTClient;
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

@Service
public class VideoCommentService {

    @Autowired
    private YTClient ytClient;

    public List<VideoCommentsVO> processYTModel(VideoComments videoComments, List<VideoCommentsVO> voList,int totalComments){
        return convertToVO(videoComments,voList,totalComments);
    }
    protected List<VideoCommentsVO> convertToVO(VideoComments videoComments, List<VideoCommentsVO> voList,int totalComments){
        List<CommentItems> list = videoComments.getItems();

        for(CommentItems commentItem:list){
            VideoCommentsVO videoCommentsVO =new VideoCommentsVO();
            totalComments++;
            CommentSnippet commentSnippet = commentItem.getSnippet();
            videoCommentsVO.setTotalReplyCount(commentSnippet.getTotalReplyCount());
            TopLevelComment topLevelComment = commentSnippet.getTopLevelComment();
            CommentDetailsSnippet commentDetailsSnippet = topLevelComment.getSnippet();
            videoCommentsVO.setName(commentDetailsSnippet.getAuthorDisplayName());
            videoCommentsVO.setLikeCount(commentDetailsSnippet.getLikeCount());
            videoCommentsVO.setPublishedAt(commentDetailsSnippet.getPublishedAt());
            videoCommentsVO.setUpdatedAt(commentDetailsSnippet.getUpdatedAt());
            videoCommentsVO.setComment(commentDetailsSnippet.getTextDisplay());
            String parentCommentId = topLevelComment.getId();
            voList.add(videoCommentsVO);
            if(commentSnippet.getTotalReplyCount()>0){
                List<VideoCommentsVO> subComments= getChildComents(parentCommentId);
                totalComments+=subComments.size();
                videoCommentsVO.setVideoCommentsVOList(subComments);
            }
        }
        totalComments+=voList.size();
        System.out.println("Total Comments including sub comments " + totalComments);
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
        for(ChildCommentItems comment : items){
            CommentDetailsSnippet commentDetailsSnippet = comment.getSnippet();
            VideoCommentsVO videoCommentsVO =new VideoCommentsVO();
            videoCommentsVO.setName(commentDetailsSnippet.getAuthorDisplayName());
            videoCommentsVO.setLikeCount(commentDetailsSnippet.getLikeCount());
            videoCommentsVO.setPublishedAt(commentDetailsSnippet.getPublishedAt());
            videoCommentsVO.setUpdatedAt(commentDetailsSnippet.getUpdatedAt());
            videoCommentsVO.setComment(commentDetailsSnippet.getTextDisplay());
            list.add(videoCommentsVO);
        }
        return list;
    }
}
