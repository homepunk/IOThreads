package homework.io.files.comparison;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileComparison {
    private static List<String> firstList = new ArrayList<>();
    private static List<String> secondList = new ArrayList<>();
    private static List<String> result = new ArrayList<>();

    public static void setFList(List<String> firstList) {
        FileComparison.firstList = firstList;
    }

    public static void setSList(List<String> secondList) {
        FileComparison.secondList = secondList;
    }

    public static List<String> getFList() {
        return firstList;
    }

    public static List<String> getSList() {
        return secondList;
    }

    public static int getLarger() {
        return firstList.size() > secondList.size() ? firstList.size() : secondList.size();
    }

    public static List<String> compareFiles(List<String> firstList, List<String> secondList) {
        for (int i = 0; i < getLarger() - 1; i++) {
            if (!firstList.get(i).equals(secondList.get(i)))
                result.add("line: '" + secondList.get(i) + "'");
        }
        return result;
    }

    public List<String> readFile(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s.replace("  ", ""));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null)
                reader.close();
        }

        return list;
    }

    public void showResult(List<String> list) {
        Iterator iterator = list.iterator();
        System.out.println("The difference between two files is in ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
