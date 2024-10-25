package courseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class SchoolManager {

    private List<Student> students;
    private List<Course> courses;
    private List<Teacher> teachers;

    public SchoolManager() {

        students = new ArrayList<>();
        courses = new ArrayList<>();
        teachers = new ArrayList<>();

    }

    public void addStudent(String name, String stuNo) {
        students.add(new Student(name, stuNo));
        System.out.println("Student added : " + name);
    }

    public void removeStudent(String stuNo) {
        students.removeIf(student -> student.getStuNo().equalsIgnoreCase(stuNo));
    }

    public void printAllstudents() {
        students.forEach(Student::printInfo);
    }

    public void addCourse(String name, String code, String prefix, double examWeight, double verbalWeight) {
        courses.add(new Course(name, code, prefix, examWeight, verbalWeight));
        System.out.println("Course added : " + name);
    }

    public void removeCourse(String code) {
        courses.removeIf(course -> course.getCode().equalsIgnoreCase(code));
    }

    public void startMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(" <==> WELCOME TECHPRO SCHOOL <==>");
            System.out.println(" ~~~ School Management System ~~~ ");
            System.out.println("1- Add Student");
            System.out.println("2- Remove Student");
            System.out.println("3- Print All Students");
            System.out.println("4- Add Course");
            System.out.println("5- Remove Course");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter student number : ");
                    String stuNo = scanner.nextLine();
                    addStudent(name, stuNo);
                    break;
                case 2:
                    System.out.println("Enter student number to remove : ");
                    String stuNoRemove = scanner.nextLine();
                    removeStudent(stuNoRemove);
                    break;
                case 3:
                    printAllstudents();
                    break;
                case 4:
                    System.out.println("Enter course name : ");
                    String courseName = scanner.nextLine();
                    System.out.println("Enter course code : ");
                    String courseCode = scanner.nextLine();
                    System.out.println("Enter course prefix : ");
                    String prefix = scanner.nextLine();
                    System.out.println("Enter exam weight : ");
                    double examWeight = scanner.nextDouble();
                    System.out.println("Enter verbal weight : ");
                    double verbalWeight = scanner.nextDouble();
                    addCourse(courseName, courseCode, prefix, examWeight, verbalWeight);
                    break;
                case 5:
                    System.out.println("Enter course code to remove : ");
                    String courseCodeRemove = scanner.nextLine();
                    removeCourse(courseCodeRemove);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");

            }

        }

    }

}
