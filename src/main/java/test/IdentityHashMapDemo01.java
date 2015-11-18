package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Person {
    // 定义Person类
    private String name;
    // 定义name属性
    private int age;

    // 定义age属性
    public Person(String name, int age) {
// 通过构造方法为属性赋值  
        this.name = name;
// 为name属性赋值  
        this.age = age;
// 为age属性赋值  
    }

    public boolean equals(Object obj) {
// 覆写equals()方法  
        if (this == obj) {
// 判断地址是否相等  
            return true;
// 返回true表示同一对象  
        }
        if (!(obj instanceof Person)) {
// 传递进来的不是本类的对象  
            return false;
// 返回false表示不是同一对象  
        }
        Person p = (Person) obj;
// 进行向下转型  
        if (this.name.equals(p.name) &&
                this.age == p.age) {
            return true;
// 属性依次比较，相等返回true  
        } else {
            return false;
// 属性内容不相等，返回false  
        }
    }

    public int hashCode() {
// 覆写hashCode()方法  
        return this.name.hashCode() * this.age;
// 计算公式  
    }

    public String toString() {
// 覆写toString()方法  
        return "姓名：" + this.name + "；年龄："
                + this.age;   // 返回信息
    }
}

public class IdentityHashMapDemo01 {
    public static void main(String[] args) {
        Map<Person, String> map = null;
// 声明Map对象，指定  
//泛型类型
        map = new HashMap<Person, String>();
// 实例化Map对象  
        map.put(new Person("张三", 30), "zhangsan_1");
// 增加内容  
        map.put(new Person("张三", 30), "zhangsan_2");
// 增加内容，key重复  
        map.put(new Person("李四", 31), "lisi");
// 增加内容  
        Set<Map.Entry<Person, String>> allSet = null;
// 声明一个Set集合  
        allSet = map.entrySet();
// 将Map接口实例变为  
//Set接口实例
        Iterator<Map.Entry<Person, String>>
                iter = null;    // 声明Iterator
//对象
        iter = allSet.iterator();
// 实例化Iterator  
//对象
        while (iter.hasNext()) {
// 迭代输出  
            Map.Entry<Person, String> me =
                    iter.next();// 每个对象都是Map.
//Entry实例
            System.out.println(me.getKey()
                    + " --> " + me.getValue());
// 输出key和value  
        }
    }
} 