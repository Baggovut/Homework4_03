package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    int getSalarySum();
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    List<Employee> getEmployeesWithHighSalary();
    void addEmployee(Employee employee);
    void editEmployeeById(Integer id, Employee employee);
    Employee getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
    List<Employee> getEmployeesWithSalaryHigherThan(Integer salary);
}
