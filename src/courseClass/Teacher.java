package courseClass;

public class Teacher extends Person{

    String branch;

    public Teacher(String name, String branch) {
        super(name);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public void printInfo() {
        System.out.println("Teacher: " + this.name + ", Baranch: " + this.branch);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
