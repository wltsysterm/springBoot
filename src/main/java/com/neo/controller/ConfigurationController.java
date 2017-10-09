package com.neo.controller;

import com.neo.domain.ConfiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
@RestController
public class ConfigurationController {
    @Autowired
    private ConfiProperties confiProperties;
    @RequestMapping("/nowConfiguration")
    public String nowConfiguration(){
        return confiProperties.getName();
    }
}
