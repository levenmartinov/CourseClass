package courseClass;

public class Student extends Person {
    private String stuNo;
    private Course course1;
    private Course course2;
    private Course course3;
    private double average;
    private boolean isPass;

    // Constructor
    public Student(String name, String stuNo, Course course1, Course course2, Course course3) {
        super(name);  // Person'dan gelen name alanını kullanıyoruz
        this.stuNo = stuNo;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.isPass = false;
    }


    // Notları topluca ekler ve exception handling
    public void addBulkExamNote(int exam1, int verbal1, int exam2, int verbal2, int exam3, int verbal3) {
        try {
            this.course1.addNotes(exam1, verbal1);
            this.course2.addNotes(exam2, verbal2);
            this.course3.addNotes(exam3, verbal3);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid note entry: " + e.getMessage());
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
