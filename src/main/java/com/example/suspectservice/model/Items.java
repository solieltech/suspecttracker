package com.example.suspectservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Items
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-20T12:37:59.661+05:30")

public class Items   {
  @JsonProperty("kind")
  private String kind = null;

  @JsonProperty("etag")
  private String etag = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("snippet")
  private Snippet snippet = null;

  @JsonProperty("statistics")
  private Statistics statistics = null;

  public Items kind(String kind) {
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

  public Items etag(String etag) {
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

  public Items id(String id) {
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

  public Items snippet(Snippet snippet) {
    this.snippet = snippet;
    return this;
  }

   /**
   * Get snippet
   * @return snippet
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Snippet getSnippet() {
    return snippet;
  }

  public void setSnippet(Snippet snippet) {
    this.snippet = snippet;
  }

  public Items statistics(Statistics statistics) {
    this.statistics = statistics;
    return this;
  }

   /**
   * Get statistics
   * @return statistics
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Statistics getStatistics() {
    return statistics;
  }

  public void setStatistics(Statistics statistics) {
    this.statistics = statistics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Items items = (Items) o;
    return Objects.equals(this.kind, items.kind) &&
        Objects.equals(this.etag, items.etag) &&
        Objects.equals(this.id, items.id) &&
        Objects.equals(this.snippet, items.snippet) &&
        Objects.equals(this.statistics, items.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, etag, id, snippet, statistics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Items {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    snippet: ").append(toIndentedString(snippet)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

