package courseClass;

public class Runner {

    public static void main(String[] args) {

        Teacher t1 = new Teacher("Prof. Dr. Ahmet", "MAT");
        Teacher t2 = new Teacher("Prof. Dr. Mehmet", "FZK");
        Teacher t3 = new Teacher("Doç. Dr. Ayşe", "KMY");

        Course math = new Course("Matematik", "MAT101", "MAT", 0.80, 0.20);
        Course physics = new Course("Fizik", "FZK101", "FZK", 0.70, 0.30);
        Course chemistry = new Course("Kimya", "KMY101", "KMY", 0.85, 0.15);

        math.addTeacher(t1);
        physics.addTeacher(t2);
        chemistry.addTeacher(t3);

        Student student1 = new Student("Ali Veli", "123", math, physics, chemistry);

        student1.addBulkExamNote(60, 90, 50, 80, 70, 60);

        student1.calcAverage();
        System.out.println(student1);
        student1.checkPass();

        student1.addBulkExamNote(150, 90, 50, 80, 70, 60); // B

    }

}
