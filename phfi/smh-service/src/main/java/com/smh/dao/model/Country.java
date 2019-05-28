package com.smh.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6760716146924115950L;

  @Id
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  @Fetch(FetchMode.SELECT)
  private List<State> state;

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

  public List<State> getState() {
    return state;
  }

  public void setState(List<State> state) {
    this.state = state;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer("Country{");
    sb.append("[id:" + id + "],");
    sb.append("[name:" + name + "],");

    sb.append("[state:" + state.toString() + "],");

    sb.append("}");
    return sb.toString();
  }

}
