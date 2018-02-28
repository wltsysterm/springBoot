package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 魏霖涛
 * @since 2018/2/28 0028
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @RequestMapping("/test")
    public String test(){
        return "template";
    }
}
