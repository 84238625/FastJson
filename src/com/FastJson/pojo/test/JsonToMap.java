package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

public class JsonToMap {
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    @Test
    //Json格式字符串反序列化到Map集合
    public void testJsonToMap(){
        String jsonString="{\"student2\":{\"age\":22,\"birthday\":1653240312035,\"email\":\"ls@126.com\",\"id\":2,\"name\":\"李四\"}," +
                "\"student1\":{\"age\":20,\"birthday\":1653240312035,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}}";
        //JSON类的静态方法，parseObject
        //直接进行反序列化，Map集合没有泛型的，泛型没有是不安全的集合
        //转后的集合，必须有泛型，
        //调用parseObject，传递参数，TypeReference类型,在TypeReference类的泛型中，传递转后的Map集合
        Map<String,Student> map = JSON.parseObject(jsonString,new TypeReference<Map<String,Student>>(){});
        for(String key : map.keySet()){
            System.out.println(key+"::"+map.get(key));
        }
        //student2::Student(id=2, name=李四, age=22, email=ls@126.com, birthday=Mon May 23 01:25:12 CST 2022)
        //student1::Student(id=1, name=张三, age=20, email=zs@sina.com, birthday=Mon May 23 01:25:12 CST 2022)

    }
}
