package com.example.suspectservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * CommentDetailsSnippet
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-04T04:07:17.409-07:00")

public class CommentDetailsSnippet   {
  private String textDisplay = null;

  private String authorDisplayName = null;

  private Integer likeCount = null;

  private String publishedAt = null;

  private String updatedAt = null;
  
  private String authorChannelUrl = null;

  public String getAuthorChannelUrl() {
	return authorChannelUrl;
}

public void setAuthorChannelUrl(String authorChannelUrl) {
	this.authorChannelUrl = authorChannelUrl;
}

public CommentDetailsSnippet textDisplay(String textDisplay) {
    this.textDisplay = textDisplay;
    return this;
  }

   /**
   * text Display
   * @return textDisplay
  **/
  @ApiModelProperty(value = "text Display")
  public String getTextDisplay() {
    return textDisplay;
  }

  public void setTextDisplay(String textDisplay) {
    this.textDisplay = textDisplay;
  }

  public CommentDetailsSnippet authorDisplayName(String authorDisplayName) {
    this.authorDisplayName = authorDisplayName;
    return this;
  }

   /**
   * authorDisplayName
   * @return authorDisplayName
  **/
  @ApiModelProperty(value = "authorDisplayName")
  public String getAuthorDisplayName() {
    return authorDisplayName;
  }

  public void setAuthorDisplayName(String authorDisplayName) {
    this.authorDisplayName = authorDisplayName;
  }

  public CommentDetailsSnippet likeCount(Integer likeCount) {
    this.likeCount = likeCount;
    return this;
  }

   /**
   * likeCount
   * @return likeCount
  **/
  @ApiModelProperty(value = "likeCount")
  public Integer getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(Integer likeCount) {
    this.likeCount = likeCount;
  }

  public CommentDetailsSnippet publishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
    return this;
  }

   /**
   * Get publishedAt
   * @return publishedAt
  **/
  @ApiModelProperty(value = "")
  public String getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
  }

  public CommentDetailsSnippet updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentDetailsSnippet commentDetailsSnippet = (CommentDetailsSnippet) o;
    return Objects.equals(this.textDisplay, commentDetailsSnippet.textDisplay) &&
        Objects.equals(this.authorDisplayName, commentDetailsSnippet.authorDisplayName) &&
        Objects.equals(this.likeCount, commentDetailsSnippet.likeCount) &&
        Objects.equals(this.publishedAt, commentDetailsSnippet.publishedAt) &&
        Objects.equals(this.updatedAt, commentDetailsSnippet.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textDisplay, authorDisplayName, likeCount, publishedAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentDetailsSnippet {\n");
    
    sb.append("    textDisplay: ").append(toIndentedString(textDisplay)).append("\n");
    sb.append("    authorDisplayName: ").append(toIndentedString(authorDisplayName)).append("\n");
    sb.append("    likeCount: ").append(toIndentedString(likeCount)).append("\n");
    sb.append("    publishedAt: ").append(toIndentedString(publishedAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

