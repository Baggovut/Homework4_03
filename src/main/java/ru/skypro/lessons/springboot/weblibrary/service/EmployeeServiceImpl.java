package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public int getSalarySum() {
        return employeeRepository.getAllEmployees()
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> getEmployeesWithHighSalary() {
        int averageSalary = getSalarySum()/employeeRepository.getAllEmployees().size();
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(e -> e.getSalary() >= averageSalary)
                .toList();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.getAllEmployees().add(employee);
    }

    @Override
    public void editEmployeeById(Integer id, Employee employee) {
        Employee findedEmployee = getEmployeeById(id);
        findedEmployee.setName(employee.getName());
        findedEmployee.setSalary(employee.getSalary());
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee findedEmployee;

        try {
            findedEmployee = employeeRepository.getAllEmployees()
                    .stream()
                    .filter(e -> Objects.equals(e.getId(), id))
                    .toList().get(0);
        }catch (ArrayIndexOutOfBoundsException exception){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        return findedEmployee;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Employee findedEmployee = getEmployeeById(id);
        employeeRepository.getAllEmployees().remove(findedEmployee);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(Integer salary) {
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(e -> e.getSalary() > salary)
                .toList();
    }

}
