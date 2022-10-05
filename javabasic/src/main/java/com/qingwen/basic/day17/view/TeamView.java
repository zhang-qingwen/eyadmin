package com.qingwen.basic.day17.view;

import com.qingwen.basic.day17.domain.Employee;
import com.qingwen.basic.day17.domain.Programmer;
import com.qingwen.basic.day17.service.NameListService;
import com.qingwen.basic.day17.service.TeamException;
import com.qingwen.basic.day17.service.TeamService;
import com.qingwen.basic.day17.util.TSUtility;

import java.util.Arrays;

public class TeamView {
    private NameListService nameListService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu(){

        boolean loopFlag = true;
        char menu = 0;
        while(loopFlag) {
            //显示所有员工信息
            if(menu != '1') {
                listAllEmployees();
            }
//            System.out.println();
            System.out.println("1--团员列表 2--添加团员 3--删除团队成员 4--退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N)?");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void listAllEmployees(){
        Employee[] employees = nameListService.getAllEmployees();

        if(employees == null || employees.length == 0){
            System.out.println("团队没有任何员工信息....");
        }else {
            System.out.println("------------------------------开发团队调度软件------------------------------");
            System.out.println("ID" +
                    '\t' + "姓名" +
                    '\t' + '\t' + "年龄" +
                    '\t' + "工资" +
                    '\t' + '\t' + "职位" +
                    '\t' + '\t' + "状态" +
                    '\t' + '\t' + "奖金" +
                    '\t' + '\t' + '\t' + "股票" +
                    '\t' + '\t' + "设备");
            for(int i=0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    private void getTeam(){
//        listAllEmployees();
        System.out.println("------------------------------团队成员列表------------------------------");
        Programmer[] team = teamService.getTeam();
        if(team == null || team.length == 0){
            System.out.println("团队目前还没有成员....");
        }else{
            System.out.println("ID/TID\t\t姓名\t\t\t年龄\t\t工资\t\t\t职位\t\t\t奖金\t\t股票");
            for(int i=0;i<team.length;i++){
                System.out.println(team[i].getDetailsforTeam());
            }
        }
        System.out.println("----------------------------------------------------------------------");

    }

    private void addMember() {
        System.out.println("------------------------------添加成员------------------------------");
        System.out.println("请输入要添加员工ID: ");
        int id = TSUtility.readInt();

        try {
            Employee employee = nameListService.getEmployee(id);
            teamService.addMember(employee);
            System.out.println("添加成功");
            TSUtility.readReturn();
        }catch (TeamException e){
            System.out.println(e.toString());
        }
    }

    private void deleteMember(){
        System.out.println("删除开发团队成员。。。。");
    }

    public static void main(String[] args){
        TeamView teamView = new TeamView();

        teamView.enterMainMenu();
    }
}
