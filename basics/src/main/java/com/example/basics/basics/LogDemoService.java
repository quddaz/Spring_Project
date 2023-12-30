package com.example.basics.basics;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
  private final MyLogger myLogger;

  public void logic(String id){
    myLogger.log("serviceid = " + id);
  }
}
