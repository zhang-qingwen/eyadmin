package com.qingwen.basic.day17.service;

import com.qingwen.basic.day17.domain.*;

public class TeamService {
    private static int counter = 1;

    private static final int MAX_MEMBER = 5;

    private Programmer[] team = new Programmer[MAX_MEMBER];

    private int total; //开发团队实际人数

    public TeamService(){
        super();
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for(int i=0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException{
        if(total > MAX_MEMBER){
            throw new TeamException("超出团队总人数...");
        }

        if(!(e instanceof Programmer)){
            throw new TeamException("不能添加非程序员...");
        }

        if(isExist(e)){
            throw new TeamException("不能添加已有程序员..." + e.getName());
        }

        Programmer programmer = (Programmer) e;

        if("BUSY".equals(programmer.getStatus().getNAME())){
            throw new TeamException(programmer.getName() + "已经起其他团队成员...");
        }

        if("VOCATION".equals(programmer.getStatus().getNAME())){
            throw new TeamException(programmer.getName() + "正在休假...");
        }

        //团队中至多只能有一个架构师
        //团队中至多只能有两个设计师
        //团队中至多只能有三名程序员
        int numOfArchitect = 0, numOfDesigner = 0, numOfProgrammer = 0;
        for(int i=0;i<total;i++){
            if(team[i] instanceof Architect){
                numOfArchitect++;
            }else if(team[i] instanceof Designer){
                numOfDesigner++;
            }else{
                numOfProgrammer++;
            }
        }

        if(programmer instanceof Programmer){
            if(numOfArchitect>=1) {
                throw new TeamException("团队中至多只能有一个架构师");
            }
        }else if(programmer instanceof Designer){
                if(numOfDesigner>=2) {
                    throw new TeamException("团队中至多只能有一个设计师");
                }
        }else if(programmer instanceof Programmer){
            if(numOfProgrammer>=3) {
                throw new TeamException("团队中至多只能有一个程序员");
            }
        }

        //将Programmer加到Team
        team[total++] = programmer;
        programmer.setStatus(Status.BUSY);
        programmer.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for(int i=0;i<total;i++){
            if(e.getId() == team[i].getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException{
        int i=0;
        for(i=0;i<total;i++){
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if(i==total){
            throw new TeamException("找不到指定Member ID的员工，删除失败！");
        }

        for(int j=i+1;j<total;j++){
            team[j-1] = team[j];
        }

        team[--total] = null;
//        throw new TeamException("团队中至多只能有一个程序员");
    }
}
