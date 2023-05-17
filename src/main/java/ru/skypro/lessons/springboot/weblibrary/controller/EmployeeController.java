package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/salary/sum")
    public int getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/employee/salary/max")
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/employee/high-salary")
    public List<Employee> getEmployeesWithHighSalary() {
        return employeeService.getEmployeesWithHighSalary();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public void editEmployeeById(@PathVariable(name = "id") Integer id,@RequestBody Employee employee){
        employeeService.editEmployeeById(id,employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable(name = "id") Integer id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employees/salaryHigherThan")
    public List<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer salary){
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }
}
