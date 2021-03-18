package readme;

import java.io.File;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/14
 * @Description:
 */
public class SqlItemFinder extends ItemFinder {

    @Override
    protected String[] getPackagePath() {
        return new String[]{"com/lmmmowi/leetcode/sql"};
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
