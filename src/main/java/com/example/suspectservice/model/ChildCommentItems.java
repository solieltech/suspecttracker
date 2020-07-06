package com.example.suspectservice.model;

import java.util.Objects;
import com.example.suspectservice.model.CommentDetailsSnippet;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * ChildCommentItems
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-05T05:47:30.890-07:00")

public class ChildCommentItems   {
  private String kind = null;

  private String etag = null;

  private String id = null;

  private CommentDetailsSnippet snippet = null;

  public ChildCommentItems kind(String kind) {
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

  public ChildCommentItems etag(String etag) {
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

  public ChildCommentItems id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id
   * @return id
  **/
  @ApiModelProperty(value = "id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChildCommentItems snippet(CommentDetailsSnippet snippet) {
    this.snippet = snippet;
    return this;
  }

   /**
   * Get snippet
   * @return snippet
  **/
  @ApiModelProperty(value = "")
  public CommentDetailsSnippet getSnippet() {
    return snippet;
  }

  public void setSnippet(CommentDetailsSnippet snippet) {
    this.snippet = snippet;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildCommentItems childCommentItems = (ChildCommentItems) o;
    return Objects.equals(this.kind, childCommentItems.kind) &&
        Objects.equals(this.etag, childCommentItems.etag) &&
        Objects.equals(this.id, childCommentItems.id) &&
        Objects.equals(this.snippet, childCommentItems.snippet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, etag, id, snippet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildCommentItems {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    snippet: ").append(toIndentedString(snippet)).append("\n");
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

