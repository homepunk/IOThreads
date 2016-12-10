package homework.io.files.example;


import homework.io.files.comparison.FileComparison;

import java.io.IOException;

public class ComparisonExample {
    public static final String FIRSTFILE = "C://Users/Nikita/IdeaProjects/HomeworkFiles/src/homework/io/files/files/FirstFile.java";
    public static final String SECONDFILE = "C://Users/Nikita/IdeaProjects/HomeworkFiles/src/homework/io/files/files/SecondFile.java";

    public static void main(String[] args) {
        FileComparison files = new FileComparison();
        try {
            files.setFList(files.readFile(FIRSTFILE));
            files.setSList(files.readFile(SECONDFILE));
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND");
        }
        files.showResult(FileComparison.compareFiles(files.getFList(), files.getSList()));
    }
}
