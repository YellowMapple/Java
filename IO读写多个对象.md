# Java

```ruby
垃圾代码：
package IOStreamDay1;

import java.io.*;

public class Day1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三","南京",18);
        Student s2 = new Student("车据","凉山",21);
        Student s3 = new Student("镜","资阳",18);
        //加密信息
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IDEA\\JAVA-Code\\YellowMaple\\1"));
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();
        //解读
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IDEA\\JAVA-Code\\YellowMaple\\1"));
        Student ns1 = (Student) ois.readObject();
        Student ns2 = (Student) ois.readObject();
        Student ns3 = (Student) ois.readObject();
        System.out.println(ns1);
        System.out.println(ns2);
        System.out.println(ns3);
        ois.close();
    }
}

```
为了确认要读取数据的个数，并且自己不能创建异常来终止读取，所以要优化
```ruby
要对多个对象进行封装，成为一个集合，方便统计
package IOStreamDay1;

import java.io.*;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三","南京",18);
        Student s2 = new Student("车据","凉山",21);
        Student s3 = new Student("镜","资阳",18);
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        //加密信息
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IDEA\\JAVA-Code\\YellowMaple\\1"));
        oos.writeObject(arr);

        oos.close();
        //解读
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IDEA\\JAVA-Code\\YellowMaple\\1"));
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
        for (Student student : list) {
            System.out.println(student);
        }
        ois.close();
    }
}
```
