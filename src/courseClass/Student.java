package courseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person {

    private String stuNo;
    private List<Course> courses; //Dinamik ders listesi
    private double average;
    private boolean isPass;


    // Constructor
    public Student(String name, String stuNo) {
        super(name);
        this.stuNo = stuNo;
        this.courses = new ArrayList<>();
        this.isPass = false;
    }


    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getAverage() {
        return average;
    }

    public boolean isPass() {
        return isPass;
    }



    public void addCourse(Course course) {
        courses.add(course);
    }


    public void removeCourse(String courseCode) {
        courses.removeIf(course -> course.getCode().equalsIgnoreCase(courseCode));
    }


    public void addBulkExamNote (int[] examNotes, int[] verbalNotes) {

        if (examNotes.length != courses.size() || verbalNotes.length != courses.size()) {
            throw new IllegalArgumentException("The number of exam and verbal notes must match the number of courses.");
        }

        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).addNotes(examNotes[i], verbalNotes[i]);
        }

    }


    public void calcAverage() {
        average = courses.stream().
                mapToDouble(Course::calculateCourseAverage). //Buradaki :: işareti, Java'da bir metod referansı
                average().                                   // oluşturmanın bir yoludur. Yani, Course sınıfındaki bir
                orElse(0);                             //metodu doğrudan çağırmadan, onun referansını kullanarak akışın her elemanında uygulamak anlamına gelir.

    }


    public void checkPass() {
        calcAverage();
        if (average >= 55) {
            System.out.println(this.getName() + " has passed.");
            isPass = true;
        } else {
            System.out.println(this.getName() + " has failed.");
            isPass =false;
        }
    }


    @Override
    public void printInfo() {

        System.out.println("Student name : " + getName());
        System.out.println("Student number : " + getStuNo());
        System.out.println("Courses : " + courses.stream().map(Course :: getName).collect(Collectors.joining(", "))); //Collectors.joining(", ") kısmı, akıştaki elemanları birleştiren bir toplayıcıdır. Bu toplayıcı, akıştaki her bir elemanı birleştirirken, elemanlar arasına belirtilen ayırıcıyı (bu örnekte virgül ve boşluk) ekler.
        System.out.println("Average : " + average);
        System.out.println("Pass Status : " + (isPass ? "Passed" : "Failed"));

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                "stuNo='" + stuNo + '\'' +
                ", average=" + average +
                ", isPass=" + isPass +
                '}';
    }
}
