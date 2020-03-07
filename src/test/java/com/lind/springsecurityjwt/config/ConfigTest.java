package com.lind.springsecurityjwt.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import( {ImportSource.class})
public class ConfigTest {
  @Autowired
  AuthorConfig authorConfig;
  @Autowired
  WorkTeacherConfig workTeacherConfig;
  @Autowired
  StudyLowConfig studyLowConfig;
  @Autowired
  ImportSource importSource;

  @Test
  public void testConfigProperty() {
    System.out.println(authorConfig.toString());
  }

  @Test
  public void testWork() {
    System.out.println(workTeacherConfig.toString());
  }

  @Test
  public void testStudyLow() {
    System.out.println(studyLowConfig.toString());
  }

  @Test
  public void testImport() {
    importSource.print();
  }
}
