package com.lind.springsecurityjwt.model;

public class Permission {
  private String url;
  private String name;
  private String title;

  public Permission(String url, String name) {
    this.url = url;
    this.name = name;
  }

  public Permission(String url, String name, String title) {
    this.url = url;
    this.name = name;
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
