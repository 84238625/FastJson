package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

public class JsonToObject {
    public Date getDate(){
        Date date = new Date();
        return date;
    }


    @Test
    //Json格式字符串，反序列化回到Java对象
    public void testJsonToObject(){
        String jsonString="{\"age\":20,\"birthday\":1653239203647,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}";
        //JSON类的静态方法 parseObject
        //传递要反序列化的Json字符串，传递Java对象的class对象
        Student student = JSON.parseObject(jsonString, Student.class);
        System.out.println(student);
        //Student(id=1, name=张三, age=20, email=zs@sina.com, birthday=Mon May 23 01:06:43 CST 2022)
    }
}
