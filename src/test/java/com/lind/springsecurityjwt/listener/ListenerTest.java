package com.lind.springsecurityjwt.listener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ListenerTest {
  @Autowired
  ApplicationContext context;

  @Test
  public void sendEmail() {
    context.publishEvent(new EmailEvent("hello", "zzl@sina.com", "hello"));
  }
}
