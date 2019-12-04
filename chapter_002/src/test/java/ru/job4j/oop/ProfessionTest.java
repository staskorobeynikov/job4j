package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    @Test
    public void checkProfession() {
        String expected = "1970-17-11";
        Profession teacher = new Profession("Clark", "Bailey", "High", "1970-17-11");
        String out = teacher.getBirthday();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkDoctor() {
        String expected = "physician";
        Doctor doctor = new Doctor("Clark", "Bailey", "High", "1970-17-11", "physician");
        String out = doctor.getSpecialization();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkEngineer() {
        String expected = "2 category";
        Engineer engineer = new Engineer("Clark", "Bailey", "High", "1970-17-11", "2 category");
        String out = engineer.getCategory();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkSurgeon() {
        String expected = "Clark";
        Surgeon surgeon = new Surgeon("Clark", "Bailey", "High", "1970-17-11", "neurosurgeon");
        String out = surgeon.getName();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkDentist() {
        String expected = "High";
        Dentist dentist = new Dentist("Clark", "Bailey", "High", "1970-17-11", "prosthetist");
        String out = dentist.getEducation();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkProgrammer() {
        String[] expected = {"High", "Java", "1970-17-11"};
        Programmer programmer = new Programmer("Clark", "Bailey", "High", "1970-17-11", "QA engineer", "Java");
        String out[] = new String[3];
        out[0] = programmer.getEducation();
        out[1] = programmer.getLanguageprog();
        out[2] = programmer.getBirthday();
        Assert.assertEquals(expected, out);
    }
    @Test
    public void checkBuilder() {
        String expected = "Clark";
        Builder builder = new Builder("Clark", "Bailey", "High", "1970-17-11", "3 category");
        String out = builder.getName();
        Assert.assertEquals(expected, out);
    }
}
