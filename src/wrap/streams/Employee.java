package wrap.streams;

public class Employee {
    String firstName;
    int age;
    int salary;
    String gender;

    public static Employee EmployeeBuilder(){
        return new Employee();
    }
    public Employee setFirstName(String name){
        this.firstName = name;
        return this;
    }
    public Employee setAge(int age){
        this.age = age;
        return this;
    }

    public Employee setSalary(int salary){
        this.salary = salary;
        return this;
    }

    public Employee setGender(String gender){
        this.gender = gender;
        return this;
    }

    public Employee build(){
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
