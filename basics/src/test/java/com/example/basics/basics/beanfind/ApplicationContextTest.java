package com.example.basics.basics.beanfind;

import com.example.basics.basics.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean(){
    String[] beanlist = ac.getBeanDefinitionNames();
    for(String beans : beanlist){
      Object bean = ac.getBean(beans);
      System.out.println("name = " + beans + " object = "+bean);

    }
  }
  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean(){
    String[] beanlist = ac.getBeanDefinitionNames();
    for(String beans : beanlist){
      BeanDefinition beanDefinition = ac.getBeanDefinition(beans);

      //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
      //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
      if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
        Object bean = ac.getBean(beans);
        System.out.println("name = " + beans + " object = "+bean);
      }
    }
  }
}
