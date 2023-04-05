package com.drot.listemployee.ListEmployee;

import com.drot.listemployee.ListEmployee.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ListEmployeeService {
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Александр", "Пушкин"),
            new Employee("Александр", "Гришин"),
            new Employee("Максим", "Пупков"),
            new Employee("Дима", "Перов")));

    public int searchEmployee(String firstName, String lastName) {
        int index = 0;
        for (; index < employee.size(); ) {
            if (employee.get(index).getFirstName().equals(firstName)) {
                if (employee.get(index).getLastName().equals(lastName)) {
                    break;
                }
            }
            index++;
            if (index == employee.size()) {
                throw new EmployeeNotFoundException();
            }
        }
        return index;
    }
}

