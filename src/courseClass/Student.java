package courseClass;

import java.util.ArrayList;
import java.util.List;

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
                mapToDouble(Course::calculateCourseAverage).
                average().
                orElse(0);
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













    // Ortalama hesaplar
    public void calcAverage() {
        double average1 = this.course1.calculateCourseAverage();
        double average2 = this.course2.calculateCourseAverage();
        double average3 = this.course3.calculateCourseAverage();
        this.average = (average1 + average2 + average3) / 3.0;
    }

    // Geçip geçmediğini kontrol eder
    public void checkPass() {
        calcAverage();
        if (this.average >= 55) {
            System.out.println(this.getName() + " has passed.");
            this.isPass = true;
        } else {
            System.out.println(this.getName() + " has failed.");
            this.isPass = false;
        }
    }

    // Person abstract class'ındaki printInfo() metodunu override etme
    @Override
    public void printInfo() {
        System.out.println("Student Name: " + this.getName());
        System.out.println("Student Number: " + this.stuNo);
        System.out.println("Average: " + this.average);
        System.out.println("Pass Status: " + (this.isPass ? "Passed" : "Failed"));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", average=" + average +
                ", isPass=" + isPass +
                '}';
    }
}
