package courseClass;

public class Course implements CourseActions {

    private String name;
    private String code;
    private String prefix;
    private int examNote;
    private int verbalNote;
    private double examWeight;  // Sınav ağırlığı
    private double verbalWeight;  // Sözlü ağırlığı
    private Teacher teacher;

    public Course(String name, String code, String prefix, double examWeight, double verbalWeight) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.examWeight = examWeight;
        this.verbalWeight = verbalWeight;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExamNote() {
        return examNote;
    }

    public int getVerbalNote() {
        return verbalNote;
    }

    public double getExamWeight() {
        return examWeight;
    }

    public double getVerbalWeight() {
        return verbalWeight;
    }


    //Ogretmen eklemek icin

    public void addTeacher (Teacher teacher) {

        if (teacher.getBranch().equals(this.prefix)) {
            this.teacher = teacher;
            System.out.println("Teacher assigned successfully to " + this.name);
        } else {
            System.out.println("Teacher branch does not match the course.");
        }

    }

    //Notlari eklemek icin interface'den implementasyon yapiyoz


    @Override
    public void addNotes(int examNote, int verbalNote) {

        if (examNote < 0 || examNote > 100 || verbalNote < 0 || verbalNote > 100) {
            throw new IllegalArgumentException("Notes must be be between 0 and 100.");
        }
        this.examNote = examNote;
        this.verbalNote = verbalNote;

    }

    //Ortalamalari eklemek icin interface'den implementasyon yapiyoz
    @Override
    public double calculateCourseAverage() {

        return (this.examNote * this.examWeight) + (this.verbalNote * this.verbalWeight);

    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", prefix='" + prefix + '\'' +
                ", examNote=" + examNote +
                ", verbalNote=" + verbalNote +
                ", teacher=" + teacher +
                '}';
    }
}
