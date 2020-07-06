package com.example.suspectservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Statistics
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-04T02:40:01.320-07:00")

public class Statistics   {
  private String viewCount = null;

  private Boolean hiddenSubscriberCount = null;

  private String commentCount = null;

  private String subscriberCount = null;

  private String videoCount = null;

  public Statistics viewCount(String viewCount) {
    this.viewCount = viewCount;
    return this;
  }

   /**
   * view count
   * @return viewCount
  **/
  @ApiModelProperty(value = "view count")
  public String getViewCount() {
    return viewCount;
  }

  public void setViewCount(String viewCount) {
    this.viewCount = viewCount;
  }

  public Statistics hiddenSubscriberCount(Boolean hiddenSubscriberCount) {
    this.hiddenSubscriberCount = hiddenSubscriberCount;
    return this;
  }

   /**
   * hiddenSubscriberCount
   * @return hiddenSubscriberCount
  **/
  @ApiModelProperty(value = "hiddenSubscriberCount")
  public Boolean getHiddenSubscriberCount() {
    return hiddenSubscriberCount;
  }

  public void setHiddenSubscriberCount(Boolean hiddenSubscriberCount) {
    this.hiddenSubscriberCount = hiddenSubscriberCount;
  }

  public Statistics commentCount(String commentCount) {
    this.commentCount = commentCount;
    return this;
  }

   /**
   * commentCount
   * @return commentCount
  **/
  @ApiModelProperty(value = "commentCount")
  public String getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(String commentCount) {
    this.commentCount = commentCount;
  }

  public Statistics subscriberCount(String subscriberCount) {
    this.subscriberCount = subscriberCount;
    return this;
  }

   /**
   * view count
   * @return subscriberCount
  **/
  @ApiModelProperty(value = "view count")
  public String getSubscriberCount() {
    return subscriberCount;
  }

  public void setSubscriberCount(String subscriberCount) {
    this.subscriberCount = subscriberCount;
  }

  public Statistics videoCount(String videoCount) {
    this.videoCount = videoCount;
    return this;
  }

   /**
   * videoCount
   * @return videoCount
  **/
  @ApiModelProperty(value = "videoCount")
  public String getVideoCount() {
    return videoCount;
  }

  public void setVideoCount(String videoCount) {
    this.videoCount = videoCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics statistics = (Statistics) o;
    return Objects.equals(this.viewCount, statistics.viewCount) &&
        Objects.equals(this.hiddenSubscriberCount, statistics.hiddenSubscriberCount) &&
        Objects.equals(this.commentCount, statistics.commentCount) &&
        Objects.equals(this.subscriberCount, statistics.subscriberCount) &&
        Objects.equals(this.videoCount, statistics.videoCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(viewCount, hiddenSubscriberCount, commentCount, subscriberCount, videoCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Statistics {\n");
    
    sb.append("    viewCount: ").append(toIndentedString(viewCount)).append("\n");
    sb.append("    hiddenSubscriberCount: ").append(toIndentedString(hiddenSubscriberCount)).append("\n");
    sb.append("    commentCount: ").append(toIndentedString(commentCount)).append("\n");
    sb.append("    subscriberCount: ").append(toIndentedString(subscriberCount)).append("\n");
    sb.append("    videoCount: ").append(toIndentedString(videoCount)).append("\n");
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

