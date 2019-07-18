package readme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: 11102942
 * @Date: 2019/7/18
 * @Description:
 */
public abstract class ItemFinder {

    private static final Pattern pattern = Pattern.compile(".* (\\d+)\\.(.*)\\[(.*)\\]");

    public List<SolutionItem> findScalaItems(File projectDir) {
        File srcDir = new File(projectDir, this.getSrcDirPath());
        File targetDir = new File(srcDir, this.getPackagePath());

        return Arrays.stream(targetDir.listFiles(File::isDirectory))
                .map(this::locateSolutionFile)
                .filter(File::exists)
                .map(file -> {
                    SolutionItem item = parseSolutionItem(file);
                    item.language = this.getLanguage();
                    item.solutionUrl = this.getGithubPageUrl(projectDir, file);
                    return item;
                })
                .collect(Collectors.toList());
    }

    protected SolutionItem parseSolutionItem(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    SolutionItem item = new SolutionItem();
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

    protected String getGithubPageUrl(File projectDir, File solutionFile) {
        String githubBase = "https://github.com/lmmmowi/leetcode-practice/blob/master/";
        String relativeFilePath = solutionFile.getAbsolutePath().substring(projectDir.getAbsolutePath().length());
        relativeFilePath = relativeFilePath.replace("\\", "/");
        return githubBase + relativeFilePath;
    }

    protected String getSrcDirPath() {
        return String.format("src/main/%s/", getLanguage());
    }

    protected abstract String getPackagePath();

    protected abstract File locateSolutionFile(File solutionDir);

    protected abstract String getLanguage();

}
