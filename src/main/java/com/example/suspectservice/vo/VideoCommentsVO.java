package com.example.suspectservice.vo;

import lombok.Data;

import java.util.List;

@Data
public class VideoCommentsVO {

    private String name;
    private String comment;
    private long likeCount;
    private Integer totalReplyCount;
    private String publishedAt;
    private String updatedAt;
    private List<VideoCommentsVO> videoCommentsVOList;
    private String parentCommentId;
    private Integer replyCount;
    private String authorChannelUrl;

}
