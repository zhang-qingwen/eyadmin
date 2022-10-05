package com.qingwen.basic.day17.domain;

public class Designer extends Programmer{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Designer(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int memberId, Status status, Equipment equipment, double bonus) {
        super(memberId, status, equipment);
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() +
                "\t设计师\t" +
                getStatus() +
                "\t" + bonus + "\t\t\t\t"
                + getEquipment().getDescription();
    }

    public String getDetailsforTeam(){
        return getMemberId() + "\\" + getId() + "\t\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "设计师\t\t" + getBonus();
    }
}
