package com.imooc.enums;

/**
 * @Author: lvrb
 * @Date: 2020/11/14 11:13
 * @Description:
 */
public enum Sex {
    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer type;
    public final String  value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(Sex.man.type);
    }
}
