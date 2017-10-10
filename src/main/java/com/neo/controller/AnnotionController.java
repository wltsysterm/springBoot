package com.neo.controller;

import com.neo.annotation.Test;
import com.neo.annotation.WltAnnotionValide;
import com.neo.annotation.WltLength;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by 魏霖涛 on 2017/10/10 0010
 */
@RestController
public class AnnotionController {
    @RequestMapping("annotionValide")
    public Object annotionValide(String name){
        Test test = new Test();
        test.setName(name);
//    public Object annotionValide(@RequestBody Test test){
        return WltAnnotionValide.validate(test);
    }
}
