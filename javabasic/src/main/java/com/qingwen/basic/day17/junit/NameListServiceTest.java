package com.qingwen.basic.day17.junit;

import com.qingwen.basic.day17.domain.Employee;
import com.qingwen.basic.day17.service.NameListService;
import com.qingwen.basic.day17.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();

        try {
            Employee employee = service.getEmployee(211);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

