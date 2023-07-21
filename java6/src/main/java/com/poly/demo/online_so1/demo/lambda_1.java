package com.poly.demo.online_so1.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.poly.demo.online_so1.bean.Student;

public class lambda_1 {

    static List<Student> list = Arrays.asList(
            new Student("Phùng tự hiếu",false,7.5),
            new Student("Nguyễn nhựt đông",true,1.5),
            new Student("Nguyễn hoàng dinh",false,4.5),
            new Student("Nguyễn minh khôi",true,5.5),
            new Student("Trần tấn khanh",false,8.5)
        );
    public static void main(String[] args) {
       // demo1();
       // demo2();
       // demo3();
       demo4();
    }

    private static void demo1(){
        List<Integer> list = Arrays.asList(1,3,6,4,8,4);
        list.forEach(i -> System.out.println(i));

    }
    private static void demo2(){
        
        list.forEach(sv ->
            {
                System.out.println(">> Name: "+sv.getName());
                System.out.println(">> Marks: "+sv.getMarks());
                System.out.println();
            }
        );
    }
    private static void demo3(){
        Collections.sort(list,(sv1,sv2) -> - sv1.getMarks().compareTo(sv2.getMarks()));

        list.forEach(sv ->
            {
                System.out.println(">> Name: "+sv.getName());
                System.out.println(">> Marks: "+sv.getMarks());
                System.out.println();
            }
        );
    }
    private static void demo4(){
        demo4Inter o = (x) -> System.out.println(x);
        o.m1(2023);
    }
}

@FunctionalInterface
interface demo4Inter{
        void m1(int x);
        default void m2(){}
        public static void m3(){}
}
