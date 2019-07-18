package readme;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: mowi
 * @Date: 2019-05-11
 * @Description:
 */
public class ReadMeGenerator {


    public static void main(String[] args) {
        new ReadMeGenerator().run();
    }

    public void run() {
        URL classPathUrl = getClass().getResource("/");
        File projectDir = new File(classPathUrl.getFile().replace("target/classes/", ""));

        Map<Integer, List<SolutionItem>> itemMap = new HashMap<>();
        Stream.of(new JavaItemFinder(), new ScalaItemFinder(), new GoItemFinder())
                .map(o -> o.findScalaItems(projectDir))
                .forEach(l ->
                        l.forEach(item -> {
                            itemMap.computeIfAbsent(item.num, items -> itemMap.put(item.num, new ArrayList<>()));
                            itemMap.get(item.num).add(item);
                        })
                );

        String output = render(itemMap);

        File readmeFile = new File(projectDir, "README.md");
        try (PrintWriter printWriter = new PrintWriter(readmeFile)) {
            printWriter.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String render(Map<Integer, List<SolutionItem>> itemMap) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("# leetcode题目练习").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-java-blue.svg)").append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-scala-red.svg)").append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-go-9cf.svg)").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("| 题号 | 题目 | 解法 |").append("\n");
        stringBuilder.append("| --- |:---:| :---:|").append("\n");

        List<Integer> keys = new ArrayList<>(itemMap.keySet());
        Collections.sort(keys);

        for (Integer key : keys) {
            List<SolutionItem> items = itemMap.get(key);
            SolutionItem item = items.get(0);

            String solutionUrl = String.join(",", items
                    .stream()
                    .map(o -> String.format("[%s](%s)", o.language, o.solutionUrl))
                    .collect(Collectors.toList())
            );
            stringBuilder.append("| ").append(item.num).append(" | [").append(item.name).append("](").append(item.url).append(") | ").append(solutionUrl).append(" |\n");
        }

        return stringBuilder.toString();
    }
}
