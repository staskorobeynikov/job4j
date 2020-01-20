package ru.job4j.oop;

public class Doctor extends Profession {

    public String specialization;

    public Doctor(String n, String sn, String e, String y, String sp) {
        super(n, sn, e, y);
        this.specialization = sp;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void treatPatient() {
        System.out.println("treatPatient");
    }
    public void healDiagnose() {
        System.out.println("healDiagnose");
    }
}
