package com.example.suspectservice.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * PageInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-07-04T02:40:01.320-07:00")

public class PageInfo {
  private Integer totalResults = null;

  private Integer resultsPerPage = null;

  public PageInfo totalResults(Integer totalResults) {
    this.totalResults = totalResults;
    return this;
  }

   /**
   * total Results
   * @return totalResults
  **/
  @ApiModelProperty(value = "total Results")
  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public PageInfo resultsPerPage(Integer resultsPerPage) {
    this.resultsPerPage = resultsPerPage;
    return this;
  }

   /**
   * results Per Page
   * @return resultsPerPage
  **/
  @ApiModelProperty(value = "results Per Page")
  public Integer getResultsPerPage() {
    return resultsPerPage;
  }

  public void setResultsPerPage(Integer resultsPerPage) {
    this.resultsPerPage = resultsPerPage;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageInfo pageInfo = (PageInfo) o;
    return Objects.equals(this.totalResults, pageInfo.totalResults) &&
        Objects.equals(this.resultsPerPage, pageInfo.resultsPerPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalResults, resultsPerPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageInfo {\n");
    
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
    sb.append("    resultsPerPage: ").append(toIndentedString(resultsPerPage)).append("\n");
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

