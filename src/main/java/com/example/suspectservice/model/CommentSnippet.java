package com.example.suspectservice.model;

import java.util.Objects;
import com.example.suspectservice.model.TopLevelComment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * CommentSnippet
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-04T04:07:17.409-07:00")

public class CommentSnippet   {
  private String videoId = null;

  private Boolean canReply = null;

  private Integer totalReplyCount = null;

  private Boolean isPublic = null;

  private TopLevelComment topLevelComment = null;

  public CommentSnippet videoId(String videoId) {
    this.videoId = videoId;
    return this;
  }

   /**
   * video id
   * @return videoId
  **/
  @ApiModelProperty(value = "video id")
  public String getVideoId() {
    return videoId;
  }

  public void setVideoId(String videoId) {
    this.videoId = videoId;
  }

  public CommentSnippet canReply(Boolean canReply) {
    this.canReply = canReply;
    return this;
  }

   /**
   * can reply
   * @return canReply
  **/
  @ApiModelProperty(value = "can reply")
  public Boolean getCanReply() {
    return canReply;
  }

  public void setCanReply(Boolean canReply) {
    this.canReply = canReply;
  }

  public CommentSnippet totalReplyCount(Integer totalReplyCount) {
    this.totalReplyCount = totalReplyCount;
    return this;
  }

   /**
   * total reply count
   * @return totalReplyCount
  **/
  @ApiModelProperty(value = "total reply count")
  public Integer getTotalReplyCount() {
    return totalReplyCount;
  }

  public void setTotalReplyCount(Integer totalReplyCount) {
    this.totalReplyCount = totalReplyCount;
  }

  public CommentSnippet isPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

   /**
   * is public
   * @return isPublic
  **/
  @ApiModelProperty(value = "is public")
  public Boolean getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public CommentSnippet topLevelComment(TopLevelComment topLevelComment) {
    this.topLevelComment = topLevelComment;
    return this;
  }

   /**
   * Get topLevelComment
   * @return topLevelComment
  **/
  @ApiModelProperty(value = "")
  public TopLevelComment getTopLevelComment() {
    return topLevelComment;
  }

  public void setTopLevelComment(TopLevelComment topLevelComment) {
    this.topLevelComment = topLevelComment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentSnippet commentSnippet = (CommentSnippet) o;
    return Objects.equals(this.videoId, commentSnippet.videoId) &&
        Objects.equals(this.canReply, commentSnippet.canReply) &&
        Objects.equals(this.totalReplyCount, commentSnippet.totalReplyCount) &&
        Objects.equals(this.isPublic, commentSnippet.isPublic) &&
        Objects.equals(this.topLevelComment, commentSnippet.topLevelComment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(videoId, canReply, totalReplyCount, isPublic, topLevelComment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentSnippet {\n");
    
    sb.append("    videoId: ").append(toIndentedString(videoId)).append("\n");
    sb.append("    canReply: ").append(toIndentedString(canReply)).append("\n");
    sb.append("    totalReplyCount: ").append(toIndentedString(totalReplyCount)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
    sb.append("    topLevelComment: ").append(toIndentedString(topLevelComment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

