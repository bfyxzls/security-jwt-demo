package com.lind.springsecurityjwt.defaultInterface;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendMessageTest {
  @Test
  public void testDefault() {
    SendMessage sendMessage = message -> System.out.println(message);
    sendMessage.send("hello world!");
  }
}
