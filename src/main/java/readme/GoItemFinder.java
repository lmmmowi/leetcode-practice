package readme;

import java.io.File;

/**
 * @Author: 11102942
 * @Date: 2019/7/18
 * @Description:
 */
public class GoItemFinder extends ItemFinder {

    @Override
    protected String getLanguage() {
        return "go";
    }

    @Override
    protected String getPackagePath() {
        return "com/lmmmowi/leetcode/go";
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.go");
    }
}
