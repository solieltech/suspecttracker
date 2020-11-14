package com.example.suspectservice.task;

import java.util.concurrent.Callable;

import com.example.suspectservice.model.ChildCommentItems;
import com.example.suspectservice.model.CommentDetailsSnippet;
import com.example.suspectservice.vo.VideoCommentsVO;

import lombok.Data;

@Data
public class ChildCommentTask implements Callable<VideoCommentsVO>{
private ChildCommentItems childComment;

@Override
public VideoCommentsVO call() throws Exception {
	 CommentDetailsSnippet commentDetailsSnippet = childComment.getSnippet();
     VideoCommentsVO videoCommentsVO =new VideoCommentsVO();
     videoCommentsVO.setName(commentDetailsSnippet.getAuthorDisplayName());
     videoCommentsVO.setLikeCount(commentDetailsSnippet.getLikeCount());
     videoCommentsVO.setPublishedAt(commentDetailsSnippet.getPublishedAt());
     videoCommentsVO.setUpdatedAt(commentDetailsSnippet.getUpdatedAt());
     videoCommentsVO.setComment(commentDetailsSnippet.getTextDisplay());
     videoCommentsVO.setAuthorChannelUrl(commentDetailsSnippet.getAuthorChannelUrl());
     return videoCommentsVO;
} 
}
