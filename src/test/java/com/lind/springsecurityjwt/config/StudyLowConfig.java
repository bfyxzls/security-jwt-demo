package com.lind.springsecurityjwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:study.yml")
@ConfigurationProperties(prefix = "low")
public class StudyLowConfig {
  private Double math;
  private Double chinese;
  private Double english;

  @Override
  public String toString() {
    return "StudyLowConfig{" +
        "math=" + math +
        ", chinese=" + chinese +
        ", english=" + english +
        '}';
  }

  public Double getMath() {
    return math;
  }

  public void setMath(Double math) {
    this.math = math;
  }

  public Double getChinese() {
    return chinese;
  }

  public void setChinese(Double chinese) {
    this.chinese = chinese;
  }

  public Double getEnglish() {
    return english;
  }

  public void setEnglish(Double english) {
    this.english = english;
  }
}
