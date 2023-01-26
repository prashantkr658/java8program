package org.prashant.java8code;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = createEmployeeList();
        List<Employee> filteredEmployeeByAge = filterEmployeeByAge(employees);
        List<Employee> filterEmployeeStream = filterEmployeeByAgeWithStream(employees);
        System.out.println("Filtered list of employees using conventional way:");
        for (Employee empName : filteredEmployeeByAge){
            System.out.println(empName);
        }
        System.out.println("Filtered list of employees using conventional way:");
        for (Employee emp : filterEmployeeStream){
            System.out.println(emp);
        }
    }

    private static List<Employee> filterEmployeeByAge(List<Employee> employeeList){
        //Using conventional way
        List<Employee> filteredEmployeeList = new ArrayList<>();
        for(Employee e : employeeList){
            if(e.getEmpAge() > 20){
                filteredEmployeeList.add(e);
            }
        }
        return filteredEmployeeList;
    }

    private static List<Employee> filterEmployeeByAgeWithStream(List<Employee> employeeList){
        //USing Java 8 Stream
        List<Employee> filteredEmployeeList = employeeList.stream().filter(e -> e.getEmpAge() > 30)
                //.map(Employee :: getEmpName)
                .collect(Collectors.toList());
        return filteredEmployeeList;
    }
    private static List<Employee> createEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(101, "Sohan", 24);
        Employee e2 = new Employee(102, "Rohan", 34);
        Employee e3 = new Employee(103, "Mohan", 26);
        Employee e4 = new Employee(104, "Shan", 29);
        Employee e5 = new Employee(105, "Sham", 21);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        return employees;
    }
}
