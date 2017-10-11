package com.neo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.neo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by LF on 2017/4/18.
 */
@Mapper
public interface CityDao extends BaseMapper<City>{
    @Select("select * from  city")
    List<City> getAll();
}