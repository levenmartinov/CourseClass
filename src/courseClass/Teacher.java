package courseClass;

public class Teacher extends Person{

    private String branch;

    public Teacher(String name, String branch) {
        super(name);
        this.branch = branch;
    }


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    @Override
    public void printInfo() {
        System.out.println("Teacher name : " + getName());
        System.out.println("Branch : " + branch);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
