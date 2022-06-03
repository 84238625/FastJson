# FastJson

## Json数据格式（2种）

### Json数组格式

```json
var jsonArray = ["元素1","元素 2","元素3"];    //定义数组格式json
console.log(jsonArray[0]);  //访问json数组元素 
for(var i = 0 ; i < jsonArray.length ;  i++){
    console.log(jsonArray[i]); //便利数组，访问每个元素
}
```

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        /**
         * 定义json的数组格式
         * 中括号包裹，数组的元素的数据类型没有限制
         */
        var jsonArray = ["k1","k2",100,9.9,true];
        //访问数组元素，通过索引访问
        console.log(jsonArray[1]);
        //遍历数组，取出数组中的元素
        for(var i = 0 ; i < jsonArray.length ; i++){
            console.log(jsonArray[i]);
        }
    </script>

</head>
<body>

</body>
</html>
```

输出：
k2
k1
k2
100
9.9
true

### Json对象 格式

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <script type="text/javascript">
      /**
       * 定义json的对象格式
       * 大括号包裹 {}，定义键值对，键必须是字符串类型，值的数据类型不限则
       * 键值对之间，冒号分开
       * 每个键值对之间，逗号分开
       */
      var jsonObject = {"k1":"v1","k2":"v2","k3":100,"k4":9.9,"k5":true}
      //取出键值对，键找值的方式
      console.log(jsonObject.k1);
      console.log(jsonObject.k2);
      console.log(jsonObject.k3);
      console.log(jsonObject.k4);
      console.log(jsonObject.k5);
  </script>
</head>
<body>

</body>
</html>
```

输出：

v1
v2
100
9.9
true



## Json数据的嵌套

### json数组嵌套 对象

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>json数据的嵌套</title>
</head>
<body>
        <script type="text/javascript">
            /**
             * json数组的元素是对象
             * 数组定义两个元素，每个元素是对象
             * 对象是键值对形式
             */
            var jsonArray=[
                {"name":"张三","age":20},
                {"name":"李四","age":22}
            ];

            //取出需要的数据，李四 22
            console.log(jsonArray[1].name+"=="+jsonArray[1].age);

            //便利数组，取出数组中的元素
            for(var i = 0 ; i < jsonArray.length ; i++){
                console.log(jsonArray[i].name+"=="+jsonArray[i].age);
            }
        </script>
</body>
</html>
```

输出 ：
李四==22
张三==20
李四==22

### json对象 嵌套数组

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>json数据的嵌套</title>
</head>
<body>
 <script type="text/javascript">
     /**
      * json数据是对象，对象值是数组
      */
     var jsonObject = {
         "k1":["北京","天津","上海"],
         "k2":["中国","美国","英国"]
     };
     //取出上海
     console.log(jsonObject.k1[2]);
     //分别取出k1和k2键的数组并遍历
     for(var i = 0 ; i < jsonObject.k1.length ; i++){
         console.log(jsonObject.k1[i]);
     }
     console.log("***===============")
     for(var i = 0 ; i < jsonObject.k2.length ; i++){
        console.log(jsonObject.k2[i]);
     }

 </script>
</body>
</html>
```

输出：
上海
北京
天津
上海
***=========
中国
美国
英国

### json相互嵌套

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>json数据的嵌套</title>
</head>
<body>
  <script type="text/javascript">
      /**
       * json的数据本质上是对象
       * 对象的键是字符串，对象的值是数组
       * 数组的元素是对象
       */

      var json = {
          //键是k1，值是数组，数组的元素是对象
        "k1":[
            {"name":"张三","age":20},
            {"name":"李四","age":22}
        ],
          "k2":[
              {"name":"王五","age":24},
              {"name":"赵六","age":26}
          ]
      };

      //取出数据李四 22
      console.log(json.k1[1].name+"=="+json.k1[1].age);

      //遍历k2键对应的数组
      for(var i = 0 ; i < json.k2.length ; i++){
          console.log(json.k2[i].name+"=="+json.k2[i].age);
      }
  </script>

</body>
</html>
```

输出：

李四==22
王五==24
赵六==26



## FastJson介绍

FastJson是阿里巴巴的开源JSON解析库,它可以解析JSON格式的字符串 ，支持将JavaBean 序列化为JSON字符串，也可以从JSON字符串反序列化到JavaBean。

支持泛型，支持流处理超大文本，支持枚举，支持序列化和反序列化扩展。

#### Student pojo

```java
package com.FastJson.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date birthday;

}

```



### 序列化

#### Java对象转为json字符串

pojo：

@Data为lambok的内容，注解在类，生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。

```java
package com.FastJson.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date birthday;

}

```

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import java.util.Date;

public class TestFastJson {
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    @Test 
    //@Test为junit4的内容，不需要main方法就可运行该方法
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
    }
}

```

输出：
{"age":20,"birthday":1653239203647,"email":"zs@sina.com","id":1,"name":"张三"}



#### List集合转Json字符串

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestFastJson {
    public Date getDate(){
        Date date = new Date();
        return date;
    }
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
        //转后的结果是数组，数组的元素是对象
        //[{"age":20,"birthday":1653239928548,"email":"zs@sina.com","id":1,"name":"张三"},
        // {"age":22,"birthday":1653239928548,"email":"ls@126.com","id":2,"name":"李四"}]
    }

}

```



#### Map集合转成Json字符串

```java
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
    //{"student2":{"age":22,"birthday":1653240312035,"email":"ls@126.com","id":2,"name":"李四"},
    // "student1":{"age":20,"birthday":1653240312035,"email":"zs@sina.com","id":1,"name":"张三"}}
}

```



### 反序列化

#### Json字符串转Java对象

```java
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

```

#### Json字符串转List集合

```java
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
        //JSON类的静态方法，parseAarray
        //传递json格式字符串，传递转换后集合的泛型的class对象
      List<Student>  list = JSON.parseArray(jsonString,Student.class);
        for( Student student : list){
            System.out.println(student);
        }
    }

    //Student(id=1, name=张三, age=20, email=zs@sina.com, birthday=Mon May 23 01:18:48 CST 2022)
    //Student(id=2, name=李四, age=22, email=ls@126.com, birthday=Mon May 23 01:18:48 CST 2022)
}

```



#### Json字符串转Map集合

```java
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
        Map<String,Student> map = JSON.parseObject(jsonString,new TypeReference<Map<String,Student>>(){});  //匿名内部类知识点
        for(String key : map.keySet()){
            System.out.println(key+"::"+map.get(key));
        }
        //student2::Student(id=2, name=李四, age=22, email=ls@126.com, birthday=Mon May 23 01:25:12 CST 2022)
        //student1::Student(id=1, name=张三, age=20, email=zs@sina.com, birthday=Mon May 23 01:25:12 CST 2022)

    }
}
```



## SerializerFeature枚举

SerializerFeature枚举：进行序列化时，可以自己定义特殊需求

JSON静态方法：toJSONString（）

方法的参数：第一个是要序列化的对象，第二个参数是SerializerFeature枚举类型的可变参数

SerializerFeature枚举的常量，做序列化的个性需求

### 

### WriteMapNullValue

```
枚举中的常量，序列化为null值的字段
```

```
若对象属性不赋值，（为空），则默认序列化时不会显示空的key。代码如下
```

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

public class TestFastJson2 {
    @Test
    //WriteMapNullValue 枚举中的常量，序列化null值的字段
    public void testWriteMapNullValue(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        //student.setEmail();
        //方法的参数上，添加枚举类型
       String jsonString =  JSON.toJSONString(student);
        System.out.println(jsonString);
        }
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    }

输出：{"age":20,"birthday":1654195880811,"id":1,"name":"张三"}
```

```
若加了SerializerFeature，则会显示null的属性，代码如下
```

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Date;

public class TestFastJson2 {
    @Test
    //WriteMapNullValue 枚举中的常量，序列化null值的字段
    public void testWriteMapNullValue(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        //student.setEmail();
        //方法的参数上，添加枚举类型
       String jsonString =  JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonString);
        }
    public Date getDate(){
        Date date = new Date();
        return date;
    }
    }

输出：{"age":20,"birthday":1654195993943,"email":null,"id":1,"name":"张三"}
```



### WriteNullStringAsEmpty

枚举的常量，序列化为null的字段，值序列化为" "

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Date;



public class TestFastJson2 {
    @Test
    //序列化为null的字段，值序列化为" "
    public void testWriteNullStringAsEmpty() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        //student.setEmail();
        //方法参数上，添加枚举类型
        String jsonString = JSON.toJSONString(student, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(jsonString);
    }


    public Date getDate(){
        Date date = new Date();
        return date;
    }
  }

输出：{"age":20,"birthday":1654196534481,"email":"","id":1,"name":"张三"}

```



### WriteNullNumberAsZero

枚举的常量，序列化为null的字段，值序列化为 0

```java
package com.FastJson.pojo.test;

import com.FastJson.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Date;



public class TestFastJson2 {

    @Test
    //WriteNullNumberAsZero 枚举的常量，序列化自动值为null，序列化为0
    public void tetsWriteNullNumberAsZero(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
       // student.setAge(20);
        student.setBirthday(getDate());
        student.setEmail("zs@sina.com");
        //方法参数上，加上枚举类型
        String jsonString =  JSON.toJSONString(student,SerializerFeature.WriteNullNumberAsZero);
        System.out.println(jsonString);
    }

    public Date getDate(){
        Date date = new Date();
        return date;
    }
    }

输出：{"age":0,"birthday":1654197005501,"email":"zs@sina.com","id":1,"name":"张三"}

```



### WriteNullBooleanAsFalse

枚举常量WriteNullBooleanAsFalse 字段为null输出false



### WriteNullUseDateFormat

枚举常量，序列化，日期的格式化



### PrettyFormat

枚举常量，序列化，格式化（json格式化，纵向输出）



## JSonField注解

该注解作用于方法上，字段上和参数上，可在序列化和反序列化时进行特性功能定制

- 注解属性：name 序列化后的名字

  ```java
  @JSONField(name = "studentName" , ordinal =1)
  privcate String name;
  ```

- 注解属性：ordinal 序列化后的顺序

- 注解属性：format 序列化后的格式

  ```java
  @JSONField(format = false)
  private String email;
  ```

- 注解属性：serialize是否序列化该字段

  ```java
  @JSONField(serialize = false)
  private String email;
  //不序列化该字段（序列化不显示该字段）
  ```



- 注解属性：deserialize是否反序列化该字段

- 注解属性：serialzeFeatures序列化时的特性定义

## JSONType注解

该注解作用在类上，对该类的字段进行序列化和反序列化时的特性功能定制





