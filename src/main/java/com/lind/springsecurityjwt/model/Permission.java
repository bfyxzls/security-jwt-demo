package com.lind.springsecurityjwt.model;

import org.springframework.security.core.GrantedAuthority;

public class Permission {
  private String url;
  private String name;

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

  public Permission(String url, String name) {
    this.url = url;
    this.name = name;
  }
}
