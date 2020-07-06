package com.example.suspectservice.model;

import java.util.Objects;
import com.example.suspectservice.model.ChildCommentItems;
import com.example.suspectservice.model.PageInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * ChildComments
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-05T05:50:22.033-07:00")

public class ChildComments   {
  private String kind = null;

  private String etag = null;

  private PageInfo pageInfo = null;

  private List<ChildCommentItems> items = new ArrayList<ChildCommentItems>();

  public ChildComments kind(String kind) {
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

  public ChildComments etag(String etag) {
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

  public ChildComments pageInfo(PageInfo pageInfo) {
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

  public ChildComments items(List<ChildCommentItems> items) {
    this.items = items;
    return this;
  }

  public ChildComments addItemsItem(ChildCommentItems itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")
  public List<ChildCommentItems> getItems() {
    return items;
  }

  public void setItems(List<ChildCommentItems> items) {
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
    ChildComments childComments = (ChildComments) o;
    return Objects.equals(this.kind, childComments.kind) &&
        Objects.equals(this.etag, childComments.etag) &&
        Objects.equals(this.pageInfo, childComments.pageInfo) &&
        Objects.equals(this.items, childComments.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, etag, pageInfo, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildComments {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
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

