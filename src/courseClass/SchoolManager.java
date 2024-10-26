package courseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        students.
                removeIf(student -> student.
                        getStuNo().
                        equalsIgnoreCase(stuNo));
    }

    public void printAllStudents() {
        students.
                forEach(student -> {
            student.
                    calcAverage(); // Ortalamayı güncelle
            student.
                    printInfo(); // Tüm bilgileri yazdır
        });
    }

    public void addCourse(String name, String code, String prefix, double examWeight, double verbalWeight) {
        courses.
                add(new Course(name, code, prefix, examWeight, verbalWeight));
        System.out.println("Course added : " + name);
    }

    public void removeCourse(String code) {
        courses.
                removeIf(course -> course.
                        getCode().
                        equalsIgnoreCase(code));
    }

    public void addTeacher(String name, String branch) {
        teachers.
                add(new Teacher(name, branch));
        System.out.println("Teacher added : " + name);
    }

    public void assignTeacherToCourse(String teacherName, String courseCode) {
        Teacher teacher = teachers.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teacherName))
                .findFirst()
                .orElse(null);
        Course course = courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(courseCode))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Teacher not found: " + teacherName);
            return;
        }

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        if (!teacher.getBranch().equalsIgnoreCase(course.getPrefix())) {
            System.out.println("Teacher's branch does not match course prefix.");
            return;
        }

        course.setTeacher(teacher);
        System.out.println("Teacher " + teacherName + " assigned to course " + course.getName());
    }

    public void printAllTeachers() {
        teachers.forEach(Teacher::printInfo);
    }

    public void printCoursesWithTeachers() {
        courses.forEach(course -> {
            System.out.println(course);
            if (course.getTeacher() != null) {
                System.out.println("Assigned Teacher: " + course.getTeacher().getName());
            } else {
                System.out.println("No teacher assigned.");
            }
        });
    }


    public void addNotesForStudent(String stuNo, int[] examNotes, int[] verbalNotes) {
        for (Student student : students) {
            if (student.getStuNo().equalsIgnoreCase(stuNo)) {
                student.addBulkExamNote(examNotes, verbalNotes);
                student.calcAverage(); // Ortalama hesapla
                student.checkPass(); // Geçme durumu kontrolü
                return;
            }
        }
        System.out.println("Student with number " + stuNo + " not found.");
    }

    public void startMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n <==> WELCOME TECHPRO SCHOOL <==>");
            System.out.println("\n ~~~ School Management System ~~~ ");
            System.out.println("\n1- Add Student");
            System.out.println("2- Remove Student");
            System.out.println("3- Print All Students");
            System.out.println("4- Add Course");
            System.out.println("5- Remove Course");
            System.out.println("6- Add Notes for Student");
            System.out.println("7- Add Teacher");
            System.out.println("8- Assign Teacher to Course");
            System.out.println("9- Print All Teachers");
            System.out.println("10- Print Courses with Teachers");
            System.out.println("0- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student number:");
                    String stuNo = scanner.nextLine();
                    addStudent(name, stuNo);
                    break;
                case 2:
                    System.out.println("Enter student number to remove:");
                    String stuNoRemove = scanner.nextLine();
                    removeStudent(stuNoRemove);
                    break;
                case 3:
                    printAllStudents();
                    break;
                case 4:
                    System.out.println("Enter course name:");
                    String courseName = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String courseCode = scanner.nextLine();
                    System.out.println("Enter course prefix:");
                    String prefix = scanner.nextLine();
                    System.out.println("Enter exam weight:");
                    double examWeight = scanner.nextDouble();
                    System.out.println("Enter verbal weight:");
                    double verbalWeight = scanner.nextDouble();
                    addCourse(courseName, courseCode, prefix, examWeight, verbalWeight);
                    break;
                case 5:
                    System.out.println("Enter course code to remove:");
                    String courseCodeRemove = scanner.nextLine();
                    removeCourse(courseCodeRemove);
                    break;
                case 6:
                    System.out.println("Enter student number:");
                    String studentNo = scanner.nextLine();
                    System.out.println("Enter exam notes (comma-separated):");
                    int[] examNotes = parseNotes(scanner.nextLine());
                    System.out.println("Enter verbal notes (comma-separated):");
                    int[] verbalNotes = parseNotes(scanner.nextLine());
                    addNotesForStudent(studentNo, examNotes, verbalNotes);
                    break;
                case 7:
                    System.out.println("Enter teacher name:");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter teacher branch:");
                    String branch = scanner.nextLine();
                    addTeacher(teacherName, branch);
                    break;
                case 8:
                    System.out.println("Enter teacher name:");
                    String teacherToAssign = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String courseToAssign = scanner.nextLine();
                    assignTeacherToCourse(teacherToAssign, courseToAssign);
                    break;
                case 9:
                    printAllTeachers();
                    break;
                case 10:
                    printCoursesWithTeachers();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private int[] parseNotes(String input) {
        String[] parts = input.split(",");
        int[] notes = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            notes[i] = Integer.parseInt(parts[i].trim());
        }
        return notes;
    }
}
