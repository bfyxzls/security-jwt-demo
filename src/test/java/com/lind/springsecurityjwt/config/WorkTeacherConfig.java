package com.lind.springsecurityjwt.config;

import java.util.Arrays;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:work.yml")
@ConfigurationProperties(prefix = "teacher")
public class WorkTeacherConfig {
  private String gander;
  private String year;
  private String[] salary;

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String[] getSalary() {
    return salary;
  }

  public void setSalary(String[] salary) {
    this.salary = salary;
  }

  public String getGander() {
    return gander;
  }

  public void setGander(String gander) {
    this.gander = gander;
  }

  @Override
  public String toString() {
    return "WorkConfig{" +
        "gander='" + gander + '\'' +
        ", year='" + year + '\'' +
        ", salary=" + Arrays.toString(salary) +
        '}';
  }
}
