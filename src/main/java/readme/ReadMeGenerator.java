package readme;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Map<String, List<SolutionItem>> itemMap = new HashMap<>();
        Stream.of(new JavaItemFinder(), new ScalaItemFinder(), new GoItemFinder(), new SqlItemFinder())
                .map(o -> o.findItems(projectDir))
                .forEach(l ->
                        l.forEach(item -> {
                            List<SolutionItem> items = itemMap.computeIfAbsent(item.getIdentifier(), o -> new ArrayList<>());
                            items.add(item);
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

    private String render(Map<String, List<SolutionItem>> itemMap) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("# leetcode题目练习").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-java-blue.svg)").append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-scala-red.svg)").append("\n");
        stringBuilder.append("![Language](https://img.shields.io/badge/language-go-9cf.svg)").append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("| 题号 | 题目 | 解法 |").append("\n");
        stringBuilder.append("| --- |:---:| :---:|").append("\n");

        List<String> keys = new ArrayList<>(itemMap.keySet());
        keys.sort((s1, s2) -> {
            SolutionItem item1 = itemMap.get(s1).get(0);
            SolutionItem item2 = itemMap.get(s2).get(0);
            return item1.compareTo(item2);
        });

        for (String key : keys) {
            List<SolutionItem> items = itemMap.get(key);
            SolutionItem item = items.get(0);

            String solutionUrl = items.stream()
                    .map(o -> String.format("[%s](%s)", o.language, o.solutionUrl))
                    .collect(Collectors.joining(","));
            stringBuilder.append("| ").append(item.getIdentifier()).append(" | [").append(item.name).append("](").append(item.url).append(") | ").append(solutionUrl).append(" |\n");
        }

        return stringBuilder.toString();
    }
}
