package com.qingwen.basic.day17.domain;

public class Architect extends Designer{
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect() {
        super();
    }

    public Architect(int stock) {
        this.stock = stock;
    }

    public Architect(double bonus, int stock) {
        super(bonus);
        this.stock = stock;
    }

    public Architect(int memberId, Status status, Equipment equipment, double bonus, int stock) {
        super(memberId, status, equipment, bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() +
                "\t架构师\t" +
                getStatus() +
                "\t" + getBonus() + "\t\t" + stock + "\t" + getEquipment().getDescription();

    }

    public String getDetailsforTeam(){
        return getMemberId() + "\\" + getId() + "\t\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t\t" + "架构师\t\t" + getBonus() + '\t' + getStock();
    }
}
