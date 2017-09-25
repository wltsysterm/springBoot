package com.neo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *类描述：
 *@author: 魏霖涛
 *@date： 日期：2017-3-31 时间：上午10:42:08
 *@version 1.0
 */
@RestController
/**
 * 备注：@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
 * @author wlt
 *
 */
public class HelloWorldController {
    @RequestMapping("/hello/{id}/{name}")
    public String index(@PathVariable String id,@PathVariable String name) {
    	System.out.println(id);
    	System.out.println(name);
        return "Hello World";
    }
}
