package company.A4A.dto;

public class Buyer {
    private String name;
    private int salary;
    private String refNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public Buyer(String name, int salary, String refNum) {
        this.name = name;
        this.salary = salary;
        this.refNum = refNum;
    }
}
