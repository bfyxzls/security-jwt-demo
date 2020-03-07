package com.lind.springsecurityjwt.listener;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
  private String emailAddress;
  private String message;

  public EmailEvent(Object source, String emailAddress, String message) {
    super(source);
    this.message = message;
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getMessage() {
    return message;
  }
}
