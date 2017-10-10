package com.neo.annotation;

/**
 * created by 魏霖涛 on 2017/10/10 0010
 */
public class Test {
    @WltLength(max = 5,min = 1,isEmpty = false)
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
