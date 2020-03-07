package com.lind.springsecurityjwt.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 订阅ContextRefreshedEvent类型的事件.
 */
@Component
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    System.out.println(contextRefreshedEvent);
    System.out.println("TestApplicationListener............................");
  }
}
