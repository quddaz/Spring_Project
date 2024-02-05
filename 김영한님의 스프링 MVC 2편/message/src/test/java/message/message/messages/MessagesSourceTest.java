package message.message.messages;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@SpringBootTest
public class MessagesSourceTest {

  @Autowired
  MessageSource messagesSource;

  @Test
  @DisplayName("메시지 국제화 테스트")
  void MessagesTest(){
    String result = messagesSource.getMessage("hello", null, null);
    Assertions.assertThat(result).isEqualTo("hello");
  }
  @Test
  @DisplayName("메시지 국제화 테스트")
  void MessagesTest2() {
    String result = messagesSource.getMessage("hello.name", new Object[]{"John"}, Locale.getDefault());
    Assertions.assertThat(result).isEqualTo("안녕 John");
  }
}
