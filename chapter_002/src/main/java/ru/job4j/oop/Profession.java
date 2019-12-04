package ru.job4j.oop;

public class Profession {
    public String name;
    public String surname;
    public String education;
    public String birthday;
    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEducation() {
        return education;
    }
    public String getBirthday() {
        return birthday;
    }
}
