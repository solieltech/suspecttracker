package com.example.suspectservice.task;

import java.util.List;
import java.util.concurrent.Callable;

import com.example.suspectservice.model.CommentDetailsSnippet;
import com.example.suspectservice.model.CommentItems;
import com.example.suspectservice.model.CommentSnippet;
import com.example.suspectservice.model.TopLevelComment;
import com.example.suspectservice.vo.VideoCommentsVO;

import lombok.Data;

@Data
public class ProcessCommentTask implements Callable<VideoCommentsVO>{
	
	private  CommentItems commentItem;

	@Override
	public VideoCommentsVO call() throws Exception {
		VideoCommentsVO videoCommentsVO =new VideoCommentsVO();
       
        CommentSnippet commentSnippet = commentItem.getSnippet();
        videoCommentsVO.setTotalReplyCount(commentSnippet.getTotalReplyCount());
        TopLevelComment topLevelComment = commentSnippet.getTopLevelComment();
        CommentDetailsSnippet commentDetailsSnippet = topLevelComment.getSnippet();
        videoCommentsVO.setName(commentDetailsSnippet.getAuthorDisplayName());
        videoCommentsVO.setLikeCount(commentDetailsSnippet.getLikeCount());
        videoCommentsVO.setPublishedAt(commentDetailsSnippet.getPublishedAt());
        videoCommentsVO.setUpdatedAt(commentDetailsSnippet.getUpdatedAt());
        videoCommentsVO.setComment(commentDetailsSnippet.getTextDisplay());
        videoCommentsVO.setAuthorChannelUrl(commentDetailsSnippet.getAuthorChannelUrl());
        String parentCommentId = topLevelComment.getId();
        videoCommentsVO.setParentCommentId(parentCommentId);
        videoCommentsVO.setReplyCount(commentSnippet.getTotalReplyCount());
        return videoCommentsVO;
        
        /*if(commentSnippet.getTotalReplyCount()>0){
            List<VideoCommentsVO> subComments= getChildComents(parentCommentId);
            videoCommentsVO.setVideoCommentsVOList(subComments);
        }*/
	}

}
