package ru.job4j.bank;

public class Account {

    private String requisites;

    private double value;

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (this.value >= amount) {
            this.setValue(this.value - amount);
            dest.setValue(dest.getValue() + amount);
            result = true;
        }
        return result;
    }
}
