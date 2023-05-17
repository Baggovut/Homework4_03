package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    // Коллекция для имитации данных
    private List<Employee> employeeList;

    public EmployeeRepositoryImpl() {
        this.employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Катя", 90_000));
        employeeList.add(new Employee(2,"Дима", 102_000));
        employeeList.add(new Employee(3,"Олег", 80_000));
        employeeList.add(new Employee(4,"Вика", 165_000));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
