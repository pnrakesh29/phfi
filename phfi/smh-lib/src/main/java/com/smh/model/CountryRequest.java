package com.smh.model;


public class CountryRequest extends SearchRequest {

  /**
   * 
   */
  private static final long serialVersionUID = -6363270637213026496L;

  private Long id;

  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer("CountryRequest{");
    sb.append("[id:" + id + "],");
    sb.append("[name:" + name + "]");

    sb.append("}");
    return sb.toString();
  }
}
