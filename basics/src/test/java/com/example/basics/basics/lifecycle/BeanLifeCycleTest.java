package com.example.basics.basics.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NetWorkClient client = ac.getBean(NetWorkClient.class);
  }

  @Configuration
  static class LifeCycleConfig {
    //@Bean(initMethod = "init", destroyMethod = "close")
    @Bean
    public NetWorkClient netWorkClient(){
      NetWorkClient netWorkClient = new NetWorkClient();
      netWorkClient.setUrl("asdas");
      return  netWorkClient;
    }
  }
}
