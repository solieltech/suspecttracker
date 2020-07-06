package com.example.suspectservice.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * VideoComments
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-04T04:07:17.409-07:00")

public class VideoComments   {
  private String kind = null;

  private String etag = null;

  private PageInfo pageInfo = null;

  private String nextPageToken = null;

  private List<CommentItems> items = new ArrayList<CommentItems>();

  public VideoComments kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * kind
   * @return kind
  **/
  @ApiModelProperty(value = "kind")
  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public VideoComments etag(String etag) {
    this.etag = etag;
    return this;
  }

   /**
   * Etag
   * @return etag
  **/
  @ApiModelProperty(value = "Etag")
  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }

  public VideoComments pageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
    return this;
  }

   /**
   * Get pageInfo
   * @return pageInfo
  **/
  @ApiModelProperty(value = "")
  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  public VideoComments nextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    return this;
  }

   /**
   * next PageToken
   * @return nextPageToken
  **/
  @ApiModelProperty(value = "next PageToken")
  public String getNextPageToken() {
    return nextPageToken;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }

  public VideoComments items(List<CommentItems> items) {
    this.items = items;
    return this;
  }

  public VideoComments addItemsItem(CommentItems itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")
  public List<CommentItems> getItems() {
    return items;
  }

  public void setItems(List<CommentItems> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoComments videoComments = (VideoComments) o;
    return Objects.equals(this.kind, videoComments.kind) &&
        Objects.equals(this.etag, videoComments.etag) &&
        Objects.equals(this.pageInfo, videoComments.pageInfo) &&
        Objects.equals(this.nextPageToken, videoComments.nextPageToken) &&
        Objects.equals(this.items, videoComments.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, etag, pageInfo, nextPageToken, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VideoComments {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

