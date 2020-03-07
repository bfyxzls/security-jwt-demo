package com.lind.springsecurityjwt.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<EmailEvent> {
  @Override
  public void onApplicationEvent(EmailEvent emailEvent) {
    System.out.println("email send:" + emailEvent.getEmailAddress());
  }
}
