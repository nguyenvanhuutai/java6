package com.poly.demo.online_so1.demo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.poly.demo.online_so1.bean.Student;

public class StreamAPI_2 {
    static List<Student> list = Arrays.asList(
            new Student("Phùng tự hiếu",false,7.5),
            new Student("Nguyễn nhựt đông",true,1.5),
            new Student("Nguyễn hoàng dinh",false,4.5),
            new Student("Nguyễn minh khôi",true,8.5),
            new Student("Trần tấn khanh",false,8.5)
        );
    
    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
        demo4();
    }

    private static void demo1(){
        //cach 1 tối ưu
        Stream<Integer> stream1 = Stream.of(1,4,7,2,3,9);
        stream1.forEach(
            System.out::println
        );

        //cach 2
        List<Integer> list = Arrays.asList(1,4,7,2,3,9);
        list.stream().forEach(
             System.out::println
        );
    }


    private static void demo2(){
        List<Integer> list = Arrays.asList(1,4,7,2,5,9);
        List<Double> result = list.stream()
                                    .filter(n -> n % 2 == 0)
                                    .map(n -> Math.sqrt(n))
                                    .peek(System.out::println)
                                    .collect(Collectors.toList());
    }

    private static void demo3(){
        List<Student> result = list.stream()
                                    .filter(sv -> sv.getMarks() >= 7)
                                    .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                                    .collect(Collectors.toList());
        result.forEach(sv ->
            {
                System.out.println(">> Name: "+sv.getName());
                System.out.println(">> Marks: "+sv.getMarks());
                System.out.println();
            }
        );                            
    }

    private static void demo4(){
        // tính điểm trung bình all
        double average = list.stream().mapToDouble(sv -> sv.getMarks()).average().getAsDouble();
        System.out.println("average: "+average);
        // tính tổng điểm all
        double sum = list.stream().mapToDouble(sv -> sv.getMarks()).sum();
        System.out.println("sum: "+sum);
        // tìm điểm thấp nhất
        double min_marks = list.stream().mapToDouble(sv -> sv.getMarks()).min().getAsDouble();
        System.out.println("min_marks: "+min_marks);
        // kiểm điểm xem tất cả có lớn hơn >= 5 không?
        boolean all_passed =list.stream().allMatch(sv->sv.getMarks()>=5);
        System.out.println("all_passed: "+all_passed);
        // tìm sv có điểm số thấp nhất
        // Student min_sv = list.stream().reduce(list.get(list.size()-1), (min,sv) -> sv.getMarks() > min.getMarks() ? sv : min);
        // System.out.println("min_sv: "+min_sv.getName());
        
        OptionalDouble maxMarks = list.stream()
        .mapToDouble(Student::getMarks)
        .max();

        if (maxMarks.isPresent()) {
            List<Student> topStudents = list.stream()
                    .filter(student -> student.getMarks() == maxMarks.getAsDouble())
                    .collect(Collectors.toList());

            System.out.println("Students with the highest marks: ");
            topStudents.forEach(sv-> System.out.println(sv.getName()));
        } else {
            System.out.println("No students found.");
        }


            }

}
