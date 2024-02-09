package hello.typeconverter.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
  @Test
  @DisplayName("문자->숫자")
  void stringToInteger(){
    StringToIntegerConverter converter = new StringToIntegerConverter();
    Integer result = converter.convert("10");
    Assertions.assertThat(result).isEqualTo(10);
  }
  @Test
  @DisplayName("숫자->문자")
  void integerToString() {
    IntegerToStringConverter converter = new IntegerToStringConverter();
    String result = converter.convert(10);
    Assertions.assertThat(result).isEqualTo("10");
  }
  @Test
  @DisplayName("문자->IP")
  void stringToIpPort() {
    StringToIpPortConverter converter = new StringToIpPortConverter();
    String source = "127.0.0.1:8080";
    IpPort result = converter.convert(source);
    Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
  }
  @Test
  @DisplayName("IP->문자")
  void ipPortToString() {
    IpPortToStringConverter converter = new IpPortToStringConverter();
    IpPort source = new IpPort("127.0.0.1", 8080);
    String result = converter.convert(source);
    Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
  }
}
