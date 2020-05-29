package com.mouse.baidudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.jar.JarEntry;

@SpringBootApplication
public class BaiduDemoApplication {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("nou");
        newPerson(person);
        System.out.println(person.getName());

        int j= 10;
        newPerson(j);
        System.out.println(j);

        Integer a = 1;
        newPerson(a);
        System.out.println(a);


        String str = "1";
        newPerson(str);
        System.out.println(str);
    }

    static class Person{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static void  newPerson(String i){
        i = "new Integer(3";
    }

    private static void  newPerson(Integer i){
        i = new Integer(3);
    }

    private static void  newPerson(int i){
        i = 3;
    }

    private static void  newPerson(Person person){
        person.setName("hao");
    }

}
