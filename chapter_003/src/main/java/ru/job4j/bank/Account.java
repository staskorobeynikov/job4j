package ru.job4j.bank;

public class Account {
    private String requisites;
    private double value;

    public String getRequisites() {
        return requisites;
    }
    public boolean withdraw(double amount) {
        double currentValue = getValue();
        boolean result = false;
        if (currentValue >= amount) {
           currentValue -= amount;
            result = true;
        }
        return result;
    }
    public void depositToAccount(double amount) {
        double currentValue = getValue();
        currentValue += amount;
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
}
