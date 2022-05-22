package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

public class TestFastJson {
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    @Test
    //Java中的集合Map，序列化为Json格式字符串
    public void testMapJson(){
        //创建Map集合，键为字符串类型，值是Student对象
        Map<String,Student> map = new HashMap<String,Student>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");
        student1.setAge(20);
        student1.setEmail("zs@sina.com");
        student1.setBirthday(getDate());

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("李四");
        student2.setAge(22);
        student2.setEmail("ls@126.com");
        student2.setBirthday(getDate());
        //Map集合存储Student对象
        map.put("student1",student1);
        map.put("student2",student2);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
    }
    //json格式字符串是对象，对象中有2个键，键对应的值是Student对象
    //{"student2":{"age":22,"birthday":1653240312035,"email":"ls@126.com","id":2,"name":"李四"},"student1":{"age":20,"birthday":1653240312035,"email":"zs@sina.com","id":1,"name":"张三"}}


    @Test
    //Java中的集合List,序列化为Json格式字符串
    public void testListToJson(){
        //集合List,存储Student对象
        List<Student> list = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");
        student1.setAge(20);
        student1.setEmail("zs@sina.com");
        student1.setBirthday(getDate());

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("李四");
        student2.setAge(22);
        student2.setEmail("ls@126.com");
        student2.setBirthday(getDate());

        //Student对象存储到List集合中
        list.add(student1);
        list.add(student2);

        //List集合序列化为Json格式的字符串
        String jsonString=JSON.toJSONString(list);
        System.out.println(jsonString);

        //[{"age":20,"birthday":1653239928548,"email":"zs@sina.com","id":1,"name":"张三"},{"age":22,"birthday":1653239928548,"email":"ls@126.com","id":2,"name":"李四"}]
    }

    @Test
    //Java中的对象，Student对象，序列化为Json格式字符串
    public void testObjectToJson(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setEmail("zs@sina.com");
        student.setBirthday(getDate());
        //student对象转到JSON格式字符串
        //调用静态方法，传递要转换的对象
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
        //{"age":20,"birthday":1653239203647,"email":"zs@sina.com","id":1,"name":"张三"}
    }

}
