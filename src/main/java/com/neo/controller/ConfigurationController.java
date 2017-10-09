package com.neo.controller;

import com.neo.domain.NowConfiguration;
import com.neo.domain.SelfConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
@RestController
@RequestMapping("configure")
public class ConfigurationController {
    @Autowired
    private NowConfiguration nowConfiguration;
    @Autowired
    private SelfConfiguration selfConfiguration;
    @RequestMapping("/nowConfiguration")
    public String nowConfiguration(){
        return nowConfiguration.getName();
    }

    @RequestMapping("/selfConfiguration")
    public String selfConfiguration(){
        return selfConfiguration.getName();
    }
}
