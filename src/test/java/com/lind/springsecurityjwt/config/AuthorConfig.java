package com.lind.springsecurityjwt.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "author")
public class AuthorConfig {
  private String name;
  private String gander;
  private String[] address;
  private List<String> jobs;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGander() {
    return gander;
  }

  public void setGander(String gander) {
    this.gander = gander;
  }

  public String[] getAddress() {
    return address;
  }

  public void setAddress(String[] address) {
    this.address = address;
  }

  public List<String> getJobs() {
    return jobs;
  }

  public void setJobs(List<String> jobs) {
    this.jobs = jobs;
  }

  @Override
  public String toString() {
    return "AuthorConfig{" +
        "name='" + name + '\'' +
        ", gander='" + gander + '\'' +
        ", address=" + Arrays.toString(address) +
        ", jobs=" + jobs +
        '}';
  }
}
