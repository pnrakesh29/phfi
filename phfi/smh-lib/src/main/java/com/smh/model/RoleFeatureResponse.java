package com.smh.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleFeatureResponse extends Response {
  /**
   * 
   */
  private static final long serialVersionUID = 6650878003348604663L;

  public List<PHFIFeatureRequest> featureList;

  /**
   * @return the featureList
   */
  public List<PHFIFeatureRequest> getFeatureList() {
    return featureList;
  }

  /**
   * @param featureList
   *          the featureList to set
   */
  public void setFeatureList(List<PHFIFeatureRequest> featureList) {
    this.featureList = featureList;
  }

}
