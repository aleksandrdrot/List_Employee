package com.drot.listemployee.ListEmployee;

import com.drot.listemployee.ListEmployee.exceptions.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class ListEmployeeController {
    private final ListEmployeeService listService;

    public ListEmployeeController(ListEmployeeService listService) {
        this.listService = listService;
    }

    @GetMapping("add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        int index;
        try {
            index = listService.searchEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            Employee newEmployee = new Employee(firstName, lastName);
            listService.employee.add(newEmployee);
            return listService.employee.get(listService.employee.size() - 1) + " Добавлен";
        }
        return listService.employee.get(index) + " EmployeeAlreadyAddedException";
    }

    @GetMapping("remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        int index;
        try {
            index = listService.searchEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFoundException";
        }
        return listService.employee.remove(index) + " Delete";
    }

    @GetMapping("find")
    public String findEmployee(String firstName, String lastName) {
        int index;
        try {
            index = listService.searchEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFoundException";
        }
        return listService.employee.get(index).toString();
    }
}
