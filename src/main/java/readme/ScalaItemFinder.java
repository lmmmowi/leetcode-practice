package readme;

import java.io.File;

/**
 * @Author: 11102942
 * @Date: 2019/7/18
 * @Description:
 */
public class ScalaItemFinder extends ItemFinder {

    @Override
    protected String getLanguage() {
        return "scala";
    }

    @Override
    protected String getPackagePath() {
        return "com/lmmmowi/leetcode/scala";
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.scala");
    }
}
