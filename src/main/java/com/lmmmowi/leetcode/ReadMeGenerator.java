package com.lmmmowi.leetcode;

import java.io.*;
import java.net.URL;
import java.util.*;
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

        List<Item> javaItems = findJavaItems(projectDir);
        List<Item> scalaItems = findScalaItems(projectDir);
        Map<Integer, List<Item>> itemMap = buildItemMap(javaItems, scalaItems);

        String output = render(itemMap);

        File readmeFile = new File(projectDir, "README.md");
        try (PrintWriter printWriter = new PrintWriter(readmeFile)) {
            printWriter.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String render(Map<Integer, List<Item>> itemMap) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("# leetcode题目练习").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("![Travis](https://img.shields.io/badge/language-java-blue.svg)").append("\n");
        stringBuilder.append("![Travis](https://img.shields.io/badge/language-scala-red.svg)").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("| 题号 | 题目 | 解法 |").append("\n");
        stringBuilder.append("| --- |:---:| :---:|").append("\n");

        List<Integer> keys = new ArrayList<>(itemMap.keySet());
        Collections.sort(keys);

        for (Integer key : keys) {
            List<Item> items = itemMap.get(key);
            Item item = items.get(0);

            String solutionUrl = String.join(",", items
                    .stream()
                    .map(o -> String.format("[%s](%s)", o.language, o.solutionUrl))
                    .collect(Collectors.toList())
            );
            stringBuilder.append("| ").append(item.num).append(" | [").append(item.name).append("](").append(item.url).append(") | ").append(solutionUrl).append(" |\n");
        }

        return stringBuilder.toString();
    }

    private Map<Integer, List<Item>> buildItemMap(List<Item>... lists) {
        Map<Integer, List<Item>> itemMap = new HashMap<>();

        Arrays.stream(lists).forEach(l ->
                l.forEach(item -> {
                    itemMap.computeIfAbsent(item.num, items -> itemMap.put(item.num, new ArrayList<>()));
                    itemMap.get(item.num).add(item);
                })
        );
        return itemMap;
    }

    private List<Item> findJavaItems(File projectDir) {
        File srcDir = new File(projectDir, "src/main/java");
        String packagePath = getClass().getPackage().getName().replace(".", "/");
        File targetDir = new File(srcDir, packagePath);

        File[] dirs = targetDir.listFiles(f -> f.isDirectory());
        return Arrays.stream(dirs)
                .map(dir -> {
                    File file = new File(dir, "Solution.java");
                    Item item = parsePracticeItem(file);
                    item.language = "java";
                    item.solutionUrl = String.format("https://github.com/lmmmowi/leetcode-practice/blob/master/src/main/java/com/lmmmowi/leetcode/p%d/Solution.java", item.num);
                    return item;
                })
                .collect(Collectors.toList());
    }

    private List<Item> findScalaItems(File projectDir) {
        File srcDir = new File(projectDir, "src/main/scala");
        String packagePath = getClass().getPackage().getName().replace(".", "/") + "/scala";
        File targetDir = new File(srcDir, packagePath);

        File[] dirs = targetDir.listFiles(f -> f.isDirectory());
        return Arrays.stream(dirs)
                .map(dir -> {
                    File file = new File(dir, "Solution.scala");
                    Item item = parsePracticeItem(file);
                    item.language = "scala";
                    item.solutionUrl = String.format("https://github.com/lmmmowi/leetcode-practice/blob/master/src/main/scala/com/lmmmowi/leetcode/scala/p%d/Solution.scala", item.num);
                    return item;
                })
                .collect(Collectors.toList());
    }

    private Item parsePracticeItem(File file) {
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
        String language;
        String solutionUrl;
    }
}
