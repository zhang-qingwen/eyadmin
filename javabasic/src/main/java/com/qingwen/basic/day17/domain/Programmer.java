package com.qingwen.basic.day17.domain;

public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }


    public Programmer() {
        super();
    }

    public Programmer(int memberId, Status status, Equipment equipment) {
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, int memberId, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() +
                "\t程序员\t" + status +
                "\t\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsforTeam(){
        return memberId + "\\" + getId() + "\t\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "程序员";
    }

}
