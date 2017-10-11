package com.neo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.neo.controller.req.PageInfo;
import com.neo.mapper.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by 魏霖涛 on 2017/10/11 0011
 */
@RestController
public class MybatisController {
    @Autowired
    private CityDao cityDao;
    @RequestMapping("getAllCity")
    public Object getAllCity(){
        return cityDao.getAll();
    }

    @RequestMapping("getCityByPage")
    public Object getCityByPage(PageInfo pageInfo){
        Page page = new Page(pageInfo.getPageNum(),pageInfo.getPageSize());
        List list  = cityDao.selectPage(page,null);
        return list;
    }
}
