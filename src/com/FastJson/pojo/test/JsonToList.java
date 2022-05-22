package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseArray;

public class JsonToList {
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    @Test
    //Json格式字符串反序列化回到List集合
    public void testjsonToList(){
        String jsonString="[{\"age\":20,\"birthday\":1653239928548,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}," +
                "{\"age\":22,\"birthday\":1653239928548,\"email\":\"ls@126.com\",\"id\":2,\"name\":\"李四\"}]";
        //JSON类的静态方法，parseArray
        //传递json格式字符串，传递转换后集合的泛型的class对象
      List<Student>  list = JSON.parseArray(jsonString,Student.class);
        for( Student student : list){
            System.out.println(student);
        }
    }

    //Student(id=1, name=张三, age=20, email=zs@sina.com, birthday=Mon May 23 01:18:48 CST 2022)
    //Student(id=2, name=李四, age=22, email=ls@126.com, birthday=Mon May 23 01:18:48 CST 2022)
}
