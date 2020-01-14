package readme;

import java.io.File;

/**
 * @Author: 11102942
 * @Date: 2020/1/14
 * @Description:
 */
public class SqlItemFinder extends ItemFinder {

    @Override
    protected String getPackagePath() {
        return "com/lmmmowi/leetcode/sql";
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.sql");
    }

    @Override
    protected String getLanguage() {
        return "sql";
    }
}
