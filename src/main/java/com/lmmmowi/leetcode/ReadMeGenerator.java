package com.lmmmowi.leetcode;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: mowi
 * @Date: 2019-05-11
 * @Description:
 */
public class ReadMeGenerator {

    private static final Pattern pattern = Pattern.compile(".*(\\d+)\\.(.*)\\[(.*)\\]");

    public static void main(String[] args) {
        new ReadMeGenerator().run();
    }

    public void run() {
        URL classPathUrl = getClass().getResource("/");
        File projectDir = new File(classPathUrl.getFile().replace("target/classes/", ""));

        File srcDir = new File(projectDir, "src/main/java");
        String packagePath = getClass().getPackage().getName().replace(".", "/");
        File targetDir = new File(srcDir, packagePath);

        File[] dirs = targetDir.listFiles(f -> f.isDirectory());
        List<Item> items = Arrays.stream(dirs).map(d -> parsePracticeDir(d)).collect(Collectors.toList());
        String output = render(projectDir, items);

        File readmeFile = new File(projectDir, "README.md");
        try (PrintWriter printWriter = new PrintWriter(readmeFile)) {
            printWriter.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String render(File projectDir, List<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("# leetcode题目练习").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("| 题号 | 题目 | 解法 |").append("\n");
        stringBuilder.append("| --- |:----:| ----:|").append("\n");

        for (Item item : items) {
            String solutionUrl = String.format("https://github.com/lmmmowi/leetcode-practice/blob/master/src/main/java/com/lmmmowi/leetcode/p%d/Solution.java", item.num);
            stringBuilder.append("| ").append(item.num).append(" | [").append(item.name).append("](").append(item.url).append(") | [JAVA](").append(solutionUrl).append(") |");
        }

        return stringBuilder.toString();
    }

    private Item parsePracticeDir(File dir) {
        File file = new File(dir, "Solution.java");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    Item item = new Item();
                    item.num = Integer.valueOf(matcher.group(1));
                    item.name = matcher.group(2);
                    item.url = matcher.group(3);
                    return item;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private class Item {
        int num;
        String name;
        String url;
    }
}
