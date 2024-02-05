package com.example.basics.basics.beanfind;

import com.example.basics.basics.AppConfig;
import com.example.basics.basics.discount.DiscountPolicy;
import com.example.basics.basics.discount.FixDiscountPolicy;
import com.example.basics.basics.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class ApplicationContextExtendsFindTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
  @Test
  @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면, 중복 오류 발생 ")
  void findBeanByParentTypeDuplicate(){
    DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()-> ac.getBean(DiscountPolicy.class));
  }
  @Test
  @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
  void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",
        DiscountPolicy.class);
  }
  @Test
  @DisplayName("특정 하위 타입으로 조회")
  void findBeanBySubType() {
    RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
  }
  @Configuration
  static class TestConfig {
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }
    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
  }
}
