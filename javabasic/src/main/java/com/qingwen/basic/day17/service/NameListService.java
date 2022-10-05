package com.qingwen.basic.day17.service;

import com.qingwen.basic.day17.domain.*;

import static com.qingwen.basic.day17.service.Data.*;

public class NameListService {
    private Employee[] employees;

    public NameListService(){
        Employee employees[] = new Employee[EMPLOYEES.length];

        for(int i=0;i<employees.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);           //第一列：员工类型，员工/程序员/设计员/架构师
            int id = Integer.parseInt(EMPLOYEES[i][1]);             //第二列：编号
            String name = EMPLOYEES[i][2];                          //第三列：姓名
            int age = Integer.parseInt(EMPLOYEES[i][3]);            //第四列：年龄
            double salary = Double.parseDouble(EMPLOYEES[i][4]);    //第五列：薪水
                                                                    //第六列：状态，FREE/BUSY/VOCATION
            double bonus;                                           //第七列：奖金
                                                                    //第八列：股票
            Equipment equipment;                                    //第九列：设备

            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
            this.employees = employees;
        }
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        switch (type){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName, display);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new Notebook(modelOrName, price);
            case PRINTER:
                return new Printer(modelOrName, EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee getEmployee(int id) throws TeamException{
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到对应的员工---" + id);
    }
}
