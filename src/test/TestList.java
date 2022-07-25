package test;

import org.junit.Test;
import List.ListByArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/4/1 14:22
 */
public class TestList {

    @Test
    public void testListByArray() {
        ListByArray list = new ListByArray(10);

        list.addToHead(1);
        list.add(0, 2);
        list.add(1, 3);
        list.add(2, 4);
        list.add(3, 5);
        list.add(4, 6);
        list.remove(2);

        list.add(2, 7);


        System.out.println(list);
    }

    @Test
    public void testMod() {
        System.out.println(-10 % 3);
    }

    @Test
    public void testListRef() {

        Students students = new Students();

        List<Student> list = students.getStus();

        for (Student s : list) {
            System.out.println(s.age);
        }

        System.out.println();

        for (Student s : list) {
            s.setAge(31);
        }

        for (Student sss : students.getStus()) {
            System.out.println(sss.age);
        }


    }
}

class Student {

    public String name;
    public int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Students {
    List<Student> stus = new ArrayList<>();

    public Students() {
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 21);

        stus.add(s1);
        stus.add(s2);
    }

    public List<Student> getStus() {
        return stus;
    }
}