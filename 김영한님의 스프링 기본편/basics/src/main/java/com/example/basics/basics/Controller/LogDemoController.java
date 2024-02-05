package com.example.basics.basics.Controller;

import com.example.basics.basics.LogDemoService;
import com.example.basics.basics.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request){
    String requestURL = request.getRequestURI().toString();
    myLogger.setRequestURL(requestURL);
    myLogger.log("controller test");
    logDemoService.logic("testId");
    return "OK";
  }
}
