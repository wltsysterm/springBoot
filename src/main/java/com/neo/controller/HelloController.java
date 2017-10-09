package com.neo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
   // 从 application.properties 中读取配置，如取不到默认值为defalut value
   @Value("${application.hello:defalut value}")
    private String hello;

   @RequestMapping("/getApplicationProperties")
   @ResponseBody
   public String getApplicationProperties(Map<String,Object> map){
      System.out.println("HelloController.helloJsp().hello="+hello);
      //请求级别的参数，通过页面的el表达式可以获取到
      map.put("hello",hello);
      return "";
   }
   @RequestMapping("/springbootJsp")
   public String index(Map<String,Object> map){
          return "springBootJsp";
   }
}