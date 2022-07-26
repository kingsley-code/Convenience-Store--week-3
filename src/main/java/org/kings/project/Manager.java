package org.kings.project;

import java.util.ArrayList;

public class Manager extends Staff {
    private int id;
    private String name;
    private ArrayList<Cashier> cashier;

    public Manager(int id, String Name) {
        this.id = id;
        this.name = name;
        cashier = new ArrayList<>();
    }

    public Cashier hireCashier(Cashier cashierAdd) {
        cashier.add(cashierAdd);

        return cashierAdd;


    }

    public void add(Cashier cash) {
        cashier.add(cash);

        System.out.println("Thank you for shopping with XYZ Store!");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cashier=" + cashier +
                '}';
    }
}
