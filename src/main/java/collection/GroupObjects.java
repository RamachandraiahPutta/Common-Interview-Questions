package collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupObjects {
    public static void main(String[] args) {
        Student student1= new Student("Ram", "10","vivekananda", 563);
        Student student2 = new Student("Ravi", "10","oxford", 567);
        Student student3 = new Student("Nag", "10","vivekananda", 557);
        Student student4 = new Student("Vamsi", "10","oxford", 572);
        Student student5 = new Student("Srinu", "10","oxford", 577);
        Student student6 = new Student("Prasad", "10","vivekananda", 548);
        List<Student> students = Arrays.asList(student1,student2,student3, student4, student5, student6);
        Map<String, List<Student>> groupBySchool = students.stream().collect(Collectors.groupingBy(Student::getSchool));
        System.out.println(groupBySchool);

        Map<String, List<String>> studentsBySchool = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(studentsBySchool);


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private String name;
    private String section;
    private String school;
    private int marks;
}
