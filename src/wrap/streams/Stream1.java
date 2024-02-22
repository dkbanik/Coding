package wrap.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Stream1 {

    public static void main(String[] args) {
        findSumOfEvenNums();
        sortByNameBySalary();
        sortByGenderFilterByAge();
    }

    // Find even numbers from ArrayList and find the sum of all numbers using Java 8 stream API
    public static void findSumOfEvenNums(){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,6,7,8);
        int sum = nums.stream()
                .filter(num -> num %2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    public static void sortByNameBySalary(){
        List<Employee> employees = new ArrayList<>();

        Employee e1 = Employee.EmployeeBuilder().setFirstName("Ajay").setAge(35).setSalary(20000).build();
        Employee e2 = Employee.EmployeeBuilder().setFirstName("Vijay").setAge(5).setSalary(20000).build();
        Employee e3 = Employee.EmployeeBuilder().setFirstName("Zack").setAge(30).setSalary(100000).build();
        Employee e4 = Employee.EmployeeBuilder().setFirstName("David").setAge(51).setSalary(50000).build();
        employees.add(e1);employees.add(e2);employees.add(e3);employees.add(e4);

        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(e -> e.getFirstName()))
                .sorted(Comparator.comparing(e -> e.getSalary()))
                .collect(Collectors.toList());
        System.out.println(result);

    }

    public static void sortByGenderFilterByAge(){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = Employee.EmployeeBuilder().setFirstName("Ajay").setAge(35).setGender("M").build();
        Employee e2 = Employee.EmployeeBuilder().setFirstName("Vijay").setAge(5).setGender("F").build();
        Employee e3 = Employee.EmployeeBuilder().setFirstName("Zack").setAge(30).setGender("M").build();
        Employee e4 = Employee.EmployeeBuilder().setFirstName("David").setAge(51).setGender("F").build();
        employees.add(e1);employees.add(e2);employees.add(e3);employees.add(e4);

        List<Employee> result = employees.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(e -> e.getGender()))
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
