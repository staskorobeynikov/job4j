package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void checkProfessionGetBirthday() {
        String expected = "1970-17-11";
        Profession teacher = new Profession("Clark", "Bailey", "High", "1970-17-11");
        String out = teacher.getBirthday();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkProfessionGetName() {
        String expected = "Clark";
        Profession teacher = new Profession("Clark", "Bailey", "High", "1970-17-11");
        String out = teacher.getName();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkProfessionGetSurName() {
        String expected = "Bailey";
        Profession teacher = new Profession("Clark", "Bailey", "High", "1970-17-11");
        String out = teacher.getSurname();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkProfessionGetEducation() {
        String expected = "High";
        Profession teacher = new Profession("Clark", "Bailey", "High", "1970-17-11");
        String out = teacher.getEducation();
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
    public void checkDoctorMethodFirst() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Doctor doctor = new Doctor("Clark", "Bailey", "High", "1970-17-11", "physician");
        doctor.treatPatient();

        String expect = String.format("treatPatient%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkDoctorMethodSecond() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Doctor doctor = new Doctor("Clark", "Bailey", "High", "1970-17-11", "physician");
        doctor.healDiagnose();

        String expect = String.format("healDiagnose%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkEngineer() {
        String expected = "2 category";
        Engineer engineer = new Engineer("Clark", "Bailey", "High", "1970-17-11", "2 category");
        String out = engineer.getCategory();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkEngineerTestFirstMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Engineer engineer = new Engineer("Clark", "Bailey", "High", "1970-17-11", "2 category");
        engineer.makeInvention();

        String expect = String.format("makeInvention%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkEngineerTestSecondMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Engineer engineer = new Engineer("Clark", "Bailey", "High", "1970-17-11", "2 category");
        engineer.optimize();

        String expect = String.format("optimize%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkSurgeon() {
        String expected = "Clark";
        Surgeon surgeon = new Surgeon("Clark", "Bailey", "High", "1970-17-11", "neurosurgeon");
        String out = surgeon.getName();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkSurgeonTestFirstMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Surgeon surgeon = new Surgeon("Clark", "Bailey", "High", "1970-17-11", "neurosurgeon");
        surgeon.doSurgery();

        String expect = String.format("doSurgery%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkSurgeonTestSecondMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Surgeon surgeon = new Surgeon("Clark", "Bailey", "High", "1970-17-11", "neurosurgeon");
        surgeon.makeIncision();

        String expect = String.format("makeIncision%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkDentist() {
        String expected = "High";
        Dentist dentist = new Dentist("Clark", "Bailey", "High", "1970-17-11", "prosthetist");
        String out = dentist.getEducation();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkDentistTestFirstMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Dentist dentist = new Dentist("Clark", "Bailey", "High", "1970-17-11", "prosthetist");
        dentist.pullTooth();

        String expect = String.format("pullTooth%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkDentistTestSecondMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Dentist dentist = new Dentist("Clark", "Bailey", "High", "1970-17-11", "prosthetist");
        dentist.putSeal();

        String expect = String.format("putSeal%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkProgrammer() {
        String[] expected = {"High", "Java", "1970-17-11"};
        Programmer programmer = new Programmer("Clark", "Bailey", "High", "1970-17-11", "QA engineer", "Java");
        String[] out = new String[3];
        out[0] = programmer.getEducation();
        out[1] = programmer.getLanguageprog();
        out[2] = programmer.getBirthday();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkProgrammerTestFirstMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Programmer programmer = new Programmer("Clark", "Bailey", "High", "1970-17-11", "QA engineer", "Java");
        programmer.testProgramm();

        String expect = String.format("testProgramm%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkProgrammerTestSecondMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Programmer programmer = new Programmer("Clark", "Bailey", "High", "1970-17-11", "QA engineer", "Java");
        programmer.installsSoftware();

        String expect = String.format("installsSoftware%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkBuilder() {
        String expected = "Clark";
        Builder builder = new Builder("Clark", "Bailey", "High", "1970-17-11", "3 category");
        String out = builder.getName();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkBuilderSurname() {
        String expected = "Bailey";
        Builder builder = new Builder("Clark", "Bailey", "High", "1970-17-11", "3 category");
        String out = builder.getSurname();
        Assert.assertEquals(expected, out);
    }

    @Test
    public void checkBuilderTestFirstMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Builder builder = new Builder("Clark", "Bailey", "High", "1970-17-11", "3 category");
        builder.readDrawing();

        String expect = String.format("readDrawing%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void checkBuilderTestSecondMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Builder builder = new Builder("Clark", "Bailey", "High", "1970-17-11", "3 category");
        builder.makeFoundation();

        String expect = String.format("makeFoundation%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
