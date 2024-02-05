package hello.servlet.web;

import hello.servlet.web.frontController.MyHandlerAdapter;
import hello.servlet.web.frontController.v3.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.MemberListControllerV3;
import hello.servlet.web.frontController.v3.MemberSaveControllerV3;
import hello.servlet.web.frontController.v4.MemberFormControllerV4;
import hello.servlet.web.frontController.v4.MemberListControllerV4;
import hello.servlet.web.frontController.v4.MemberSaveControllerV4;
import hello.servlet.web.frontController.v5.Adapter.ControllerV3HandlerAdapter;
import hello.servlet.web.frontController.v5.Adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

  @Bean
  public Map<String, Object> handlerMappingMap(){
    Map<String, Object> handlerMappingMap = new HashMap<>();
    handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
    handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
    handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
    handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
    handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    return  handlerMappingMap;
  }
  @Bean
  public List<MyHandlerAdapter> handlerAdapters(){
    return Arrays.asList(new ControllerV3HandlerAdapter(), new ControllerV4HandlerAdapter());
  }
}
