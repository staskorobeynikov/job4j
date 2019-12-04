package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        TextReport report1 = new TextReport();
        JSONReport report2 = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        String text1 = report1.generate("Report's name", "Report's body");
        System.out.println(text1);
        System.out.println();
        String text2 = report2.generate("Report's name", "Report's body");
        System.out.println(text2);
    }
}
