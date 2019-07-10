package com.amp.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caizy on 2019/6/5.
 */
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String index(){
    return "hello";
  }
}
